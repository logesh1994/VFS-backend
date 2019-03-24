package com.cognizant.outreach.vfs.batch.service;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.config.AppConfig;
import com.cognizant.outreach.vfs.service.AdminDataUpdateService;
import com.cognizant.outreach.vfs.service.EmailService;
import com.cognizant.outreach.vfs.util.AdminTableUtils;
import com.cognizant.outreach.vfs.util.Constants;
import com.cognizant.outreach.vfs.util.FileUtil;

@Service
public class FileWatcher {

	@Autowired
	protected AppConfig appConfig;
	
	@Autowired
	private AdminDataUpdateService adminDataUpdateService;
	
	@Autowired
	private EmailService emailService;

	private static final Logger logger = LogManager.getLogger(FileWatcher.class.getName());
	private Map<String, String> modified_file_list = new HashMap();

	@PostConstruct
	public void watchService() throws Exception {
		
		emailService.sendFeedbackMail("512641@cognizant.com", "KL Raja", "Thank you for your participation in the Outreach Event \"Be a Teacher\" on \"15/03/2019\"");
		
		String last_modified_time = null;
		boolean filePatternMatch = false;
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Path path = Paths.get(appConfig.getValueOfKey(Constants.FILE_PATH));
		logger.debug("PATH: " + path);
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
		WatchKey key;
		while ((key = watchService.take()) != null) {
			
			for (WatchEvent<?> event : key.pollEvents()) {
				logger.debug("Event kind:" + event.kind() + ". File affected: " + event.context());
				
				Path filename = (Path) event.context();
				for (String fileNamePattern : AdminTableUtils.ADMIN_TABLE_COLUMN_MAP.keySet()) {
					System.out.println(fileNamePattern);
					filePatternMatch = filename.getFileName().toString().equals(fileNamePattern + Constants.EXCEL_EXTENSION);
					if (filePatternMatch) break;
				}
				
				if (filePatternMatch) {
						File file = new File(appConfig.getValueOfKey(Constants.FILE_PATH)+appConfig.getValueOfKey(Constants.FILE_NAME));	
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
						last_modified_time = modified_file_list.get(filename.toString());
						logger.debug("Last Modified: " + sdf.format(file.lastModified()));
						if(last_modified_time != null && last_modified_time.equals(sdf.format(file.lastModified()))) {
							continue;
						} else {
							modified_file_list.put(filename.toString(), sdf.format(file.lastModified()));
						}
						FileUtils.copyFile(FileUtils.getFile(appConfig.getValueOfKey(Constants.FILE_PATH)+filename),
								FileUtils.getFile(appConfig.getValueOfKey(Constants.INPROGRESS_FILEPATH)+filename));
						
						adminDataUpdateService.updateAdminData(filename.toString().replace(Constants.EXCEL_EXTENSION, ""), 
						FileUtil.parseExcelToJson(appConfig.getValueOfKey(Constants.INPROGRESS_FILEPATH)+filename), "ADD");
						FileUtils.moveFile(FileUtils.getFile(appConfig.getValueOfKey(Constants.INPROGRESS_FILEPATH)+filename),
								FileUtils.getFile(appConfig.getValueOfKey(Constants.COMPLETED_FILEPATH)+filename.toString().replace(Constants.EXCEL_EXTENSION, "")
										+"_"+System.currentTimeMillis()+Constants.EXCEL_EXTENSION));
				}
				filePatternMatch = false;
			}
			key.reset();
		}
		watchService.close();
	}

}
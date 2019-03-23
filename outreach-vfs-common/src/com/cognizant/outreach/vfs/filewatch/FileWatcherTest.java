package com.cognizant.outreach.vfs.filewatch;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.outreach.vfs.config.AppConfig;
import com.cognizant.outreach.vfs.util.Constants;
import com.cognizant.outreach.vfs.util.FileUtil;

@Service
public class FileWatcherTest {
	
	@Autowired
	protected AppConfig appConfig;
	
	private static final Logger logger = LogManager.getLogger(FileWatcherTest.class.getName());

	//@PostConstruct
	public void watchService() throws IOException, InterruptedException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Path path = Paths.get(appConfig.getValueOfKey(Constants.FILE_PATH));
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		WatchKey key;
		while ((key = watchService.take()) != null) {
			for (WatchEvent<?> event : key.pollEvents()) {
				logger.debug("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
				
				Path filename = (Path) event.context();
				if (appConfig.getValueOfKey(Constants.FILE_NAME).startsWith(filename.getFileName().toString())) {
					FileUtil.readExceldatafromURL(appConfig.getValueOfKey(Constants.FILE_PATH)+appConfig.getValueOfKey(Constants.FILE_NAME));
					//To-DO Save in DB
				}
			}
			key.reset();
		}
		watchService.close();
	}
	
}
package com.cognizant.outreach.vfs.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.outreach.vfs.domain.ExcelData;

public class FileUtil {

	private static final Logger logger = LogManager.getLogger(FileUtil.class.getName());

	public static List<ExcelData> readExceldatafromURL(String url) throws IOException {
		URL excelData = new URL(url);
		InputStream inputStream = excelData.openStream();
		return readExcelData(inputStream);
	}

	public static List<ExcelData> readExceldatafromUpload(MultipartFile reapExcelDataFile) throws IOException {

		return readExcelData(reapExcelDataFile.getInputStream());
	}

	private static List<ExcelData> readExcelData(InputStream excelData) {
		List<ExcelData> dataList = new ArrayList<ExcelData>();
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(excelData);
			XSSFSheet worksheet = workbook.getSheetAt(0);

			for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
				ExcelData tempdata = new ExcelData();

				XSSFRow row = worksheet.getRow(i);

				tempdata.setEventName(row.getCell(0).getStringCellValue());
				tempdata.setEventLocation(row.getCell(1).getStringCellValue());
				dataList.add(tempdata);
			}
		} catch (IOException exp) {
			logger.error("Error in Excel processing", exp);
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException exp) {
					logger.error("Error in closing excel file", exp);
				}
			}
		}
		return dataList;
	}

	public static void readExcelData(String filepath) throws Exception {
		Workbook workbook = WorkbookFactory.create(FileUtils.getFile(filepath));
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
		System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
		workbook.forEach(sheet -> {
			System.out.println("=> " + sheet.getSheetName());
		});

		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();

		System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
		sheet.forEach(row -> {
			row.forEach(cell -> {
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.print(cellValue + "\t");
			});
			System.out.println();
		});

		// Closing the workbook
		workbook.close();
	}

	public static ArrayList<Map<String, String>> parseExcelToJson(String filepath) throws Exception {
		List<String> keys = new ArrayList<>();
		Map<String, String> tempObj = null;
		ArrayList<Map<String, String>> finalList = new ArrayList();
		Workbook workbook = WorkbookFactory.create(FileUtils.getFile(filepath));
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		workbook.forEach(sheet -> {
			System.out.println("=> " + sheet.getSheetName());
		});

		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		  FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		  dataFormatter.addFormat("mm/dd/yy", new java.text.SimpleDateFormat("yyyy-MM-dd"));
		  dataFormatter.addFormat("m/d/yy", new java.text.SimpleDateFormat("yyyy-MM-dd"));
		int i = 0;		
		for (int rowNum = sheet.getFirstRowNum(); rowNum < sheet.getLastRowNum(); rowNum++) {
			   Row row = sheet.getRow(rowNum);
			   if (row == null) {
			      continue;
			   }
			   i = 0;
				tempObj = new HashMap<>();
			   for (int cn = 0; cn < row.getLastCellNum(); cn++) {
			      Cell cell = row.getCell(cn, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			      if (cell == null) {
			    	  tempObj.put(keys.get(i), null);
			      } else {
						String cellValue = dataFormatter.formatCellValue(cell, evaluator);
						if (row.getRowNum() == 0) {
							keys.add(cellValue);
						} else {
							tempObj.put(keys.get(i), cellValue);
						}	
			      }
			      i++;
			   }
			   finalList.add(tempObj);
			   
			}

		workbook.close();
		return finalList;
	}
}

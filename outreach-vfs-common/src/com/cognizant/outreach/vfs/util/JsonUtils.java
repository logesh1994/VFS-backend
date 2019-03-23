package com.cognizant.outreach.vfs.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

	public static List<Object> parseObjectDataList(Class<?> type, ArrayList<?> data) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Object tmpObj = type.getConstructor().newInstance();
		List<Object> dataList = new ArrayList<>();
		for(Object object: data) {
			tmpObj= objectMapper.convertValue(object, type);
			dataList.add(tmpObj);
		}
		return dataList;
	}
	
	public static Object parseObjectData(Class<?> type, Object data) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Object tmpObj= objectMapper.convertValue(data, type);
		return tmpObj;
	}
}

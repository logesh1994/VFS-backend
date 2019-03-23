package com.cognizant.outreach.vfs.util;

import com.cognizant.outreach.vfs.api.response.StatusResponse;
import com.cognizant.outreach.vfs.exception.ApplicationException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Setting up some stuff using for all API
 *
 */
public abstract class APIUtil {

	public StatusResponse<?> statusResponse = null;
	public final static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
				.setSerializationInclusion(JsonInclude.Include.ALWAYS)
				.setDateFormat(new SimpleDateFormat(Constants.API_FORMAT_DATE));
	}

	public final static Logger logger = LogManager.getLogger(APIUtil.class.getName());

	protected String writeObjectToJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException ex) {
			throw new ApplicationException(ex.getCause());
		}
	}

	protected String writeObjectToJsonRemoveNullProperty(Object obj) throws ApplicationException {
		try {
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			String result = mapper.writeValueAsString(obj);
			mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
			return result;
		} catch (JsonProcessingException ex) {
			throw new ApplicationException(ex.getCause());
		}
	}
}

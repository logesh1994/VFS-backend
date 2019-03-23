package com.cognizant.outreach.vfs.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.joda.time.LocalDate;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    final static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    static {
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(df.format(value.toDate()));
		
	}
}
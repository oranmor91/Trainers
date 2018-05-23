package com.trainer.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {

	public static String objectToJson(Object obj) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	public static <T> T jsonToObject(String data, Class<T> clazz) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(data, clazz);
	}
}

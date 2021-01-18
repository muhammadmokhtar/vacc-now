package com.digitalfactory.vaccnow.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.lang.reflect.Modifier;

public class JsonUtil {

	public static String toJson(Object dto) throws IOException {
		Gson gson = new GsonBuilder()
				.excludeFieldsWithModifiers(Modifier.TRANSIENT)
				.setPrettyPrinting().create();
		return gson.toJson(dto);
	}
}

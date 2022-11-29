package com.automation.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {
	static RequestSpecification reqSpec = RestAssured.given();
	static Response res;
	static String endPoint;

	public static void setEndPoint(String endPointFromUser) {
		endPoint = endPointFromUser;
	}

	public static void setBody(String body) {
		reqSpec = reqSpec.body(body);
	}

	public static void setHeader(String key, String value) {
		reqSpec = reqSpec.header(key, value);
	}

	public static void setQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public static void post() {
		res = reqSpec.post(endPoint);
	}

	public static void get() {
		res = reqSpec.get(endPoint);
	}

	public static void delete() {
		res = reqSpec.delete(endPoint);
	}

	public static void put() {
		res = reqSpec.put(endPoint);
	}

	public static int getResponseCode() {
		return res.getStatusCode();
	}

	public static String getResponseBody() {
		return res.asString();
	}

}
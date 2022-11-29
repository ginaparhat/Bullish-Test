package com.automation.stepdef;

import com.automation.utils.DriverUtils;
import com.automation.utils.PropertyReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {

	/**
	 * This method will be executed before each scenario
	 * 
	 * @author Guligeinap
	 */
	@Before("@ui")
	public void setUpUI() {
		PropertyReader.initProperty();
		DriverUtils.createDriver();
	}

	@Before("@api")
	public void setUpAPI() {
		PropertyReader.initProperty();
		RestAssured.baseURI = PropertyReader.getProperty("api.baseurl");
	}

	/**
	 * This method will be executed after each scenario and we're cleaning up
	 * driver(browser)
	 * 
	 * @author Guligeinap
	 */
	@After("@ui")
	public void cleanUp() {
		DriverUtils.getDriver().quit();
	}

}

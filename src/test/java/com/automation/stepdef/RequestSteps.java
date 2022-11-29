package com.automation.stepdef;

import java.io.File;

import org.junit.Assert;

import com.automation.utils.CommonMethods;
import com.automation.utils.PropertyReader;
import com.automation.utils.RestAssuredUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestSteps {

	@Given("user wants to call post request to add student")
	public void user_wants_to_call_post_request_to_add_student() {
		RestAssuredUtils.setEndPoint(PropertyReader.getProperty("add.student.endpoint"));
		String body = CommonMethods.readDataFromFile(new File("src//test//resources//data//add_student_body.json"));
		RestAssuredUtils.setBody(body);
	}

	@Given("user wants to call get request to retrieve the student")
	public void user_wants_to_call_get_request_to_retrieve_the_student() {
		RestAssuredUtils.setEndPoint(PropertyReader.getProperty("fetch.student.endpoint"));
	}

	@Given("user wants to call put update the student information")
	public void user_wants_to_call_put_update_the_student_information() {
		RestAssuredUtils.setEndPoint(PropertyReader.getProperty("update.student.endpoint"));
		String body = CommonMethods.readDataFromFile(new File("src//test//resources//data//update_student_body.json"));
		RestAssuredUtils.setBody(body);
	}

	@Given("user wants to call delete request to delete student")
	public void user_wants_to_call_delete_request_to_delete_student() {
		RestAssuredUtils.setEndPoint(PropertyReader.getProperty("delete.student.endpoint"));
		String body = CommonMethods.readDataFromFile(new File("src//test//resources//data//delete_student_body.json"));
		RestAssuredUtils.setBody(body);
	}

	@When("user call post request")
	public void user_call_post_request() {
		RestAssuredUtils.post();
	}

	@When("set header {string} to {string}")
	public void setHeader(String key, String value) {
		RestAssuredUtils.setHeader(key, value);
	}

	@When("set query parameter {string} to {string}")
	public void setQueryParam(String key, String value) {
		RestAssuredUtils.setQueryParam(key, value);
	}

	@Then("verify status code is {int}")
	public void verify_status_code_is(Integer int1) {
		System.out.println(RestAssuredUtils.getResponseBody());
		Assert.assertTrue("Reponse code is not 200 but it is " + RestAssuredUtils.getResponseCode(),
				RestAssuredUtils.getResponseCode() == 200);
	}

	@When("user call delete request")
	public void user_call_delete_request() {
		RestAssuredUtils.delete();
	}

	@When("user call get request")
	public void user_call_get_request() {
		RestAssuredUtils.get();
	}

	@When("user call put request")
	public void user_call_put_request() {
		RestAssuredUtils.put();
	}
}

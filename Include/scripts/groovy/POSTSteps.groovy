import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords


class POSTSteps {
	@Given("I want to create a new user")
	def givenCreateNewUser() {
	}

	@When("I send a POST request to reqres.in")
	def whenSendPostRequest() {
    def requestBody = [:]
    requestBody["name"] = "Iqbal Fachrian"
    requestBody["job"] = "SR. QA Engineer"

    def postUser = findTestObject('Object Repository/postUser')

    if (postUser != null) {
        postUser.setRestRequestMethod('POST')
        postUser.setRestRequestBody(JsonOutput.toJson(requestBody))

        def response = WS.sendRequest(postUser)

        GlobalVariable.response = response
    } else {
        println "Object 'postUser' not found in Object Repository."
    }
}

		@Then("the response status code should be ok")
    	def thenVerifyPostStatusCode() {
			def response = GlobalVariable.response
			assert response.getStatusCode() == 200
    }
}



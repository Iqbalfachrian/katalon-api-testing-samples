import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import groovy.json.JsonSlurper

// Mendapatkan objek Test Object "GetUserRequest" dari Object Repository
def getUser = findTestObject('Object Repository/getUser')

// Mengirim permintaan GET untuk mendapatkan pengguna
def response = WS.sendRequest(getUser)

// Memeriksa status code response
WS.verifyResponseStatusCode(response, 200)

//// Parsing respons JSON
def jsonResponse = new JsonSlurper().parseText(response.getResponseText())


// Memeriksa response body
assert jsonResponse.data.id == 10
assert jsonResponse.data.email == 'byron.fields@reqres.in'
assert jsonResponse.data.first_name == 'Byron'
assert jsonResponse.data.last_name == 'Fields'
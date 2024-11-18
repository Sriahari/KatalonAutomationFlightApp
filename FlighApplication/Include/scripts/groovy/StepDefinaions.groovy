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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class StepDefinaions {
	@Given("Open Browser")
	def open_Browser() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.ApplUrl)
		//		WebUI.navigateToUrl("https://www.radarbox.com/")
		WebUI.maximizeWindow()
	}

	@When("Verify the Mandatory fields")
	def verify_Mandatory_fields() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/FilghtObjects/verify_mobile_menu'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/FilghtObjects/Logo'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/FilghtObjects/Subscriptions'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/FilghtObjects/verify_Solutions'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/FilghtObjects/Login'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/FilghtObjects/Try free for 7 days'), 10)
	}

	@Then("Verify the dropdown values of Soultions")
	def verify_Solution_dropdown_values() {
		WebUI.delay(2)
		WebUI.waitForElementClickable(findTestObject('Object Repository/FilghtObjects/verify_Solutions'), 10)
		WebUI.mouseOver(findTestObject('Object Repository/FilghtObjects/verify_Solutions'))
	}

	@When("Click on Solutions Tab")
	def click_soulution_tab() {
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/FilghtObjects/verify_Solutions'))
	}

	@Then("Verify the Shop Now Field on Solutions Tab")
	def solution_tab_Shop_now() {
		WebUI.delay(3)
		//		WebUI.click(findTestObject('Object Repository/FilghtObjects/verify_Solutions'))
		WebUI.click(findTestObject('Object Repository/SolutionsTab/Store'))
		WebUI.click(findTestObject('Object Repository/SolutionsTab/Shop Now'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/SolutionsTab/RADARBOX STORE'), 10)
		WebUI.scrollToPosition(0, 250)
		WebUI.scrollToElement(findTestObject('Object Repository/SolutionsTab/AMAZON STORE'), 10)
		WebUI.click(findTestObject('Object Repository/SolutionsTab/buy-now'))
	}

	@When("Verify the Contact Us Section")
	def verify_Flight_Field_Section() {
		WebUI.delay(1)
		WebUI.switchToFrame(findTestObject('Object Repository/FlightFeed/iframe_Advertisement'), 0)
		WebUI.click(findTestObject('Object Repository/FlightFeed/Contact_Us'))
	}

	@Then("Navigate back")
	def navigate_back() {
		WebUI.delay(2)
		WebUI.back()
	}

	@Then("Verify the Flight Feed Section")
	def flight_field_section() {
		WebUI.delay(2)
		WebUI.switchToDefaultContent()
		WebUI.click(findTestObject('Object Repository/FlightFeed/Flight Feed'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/FlightFeed/Most Viewed'), 10)
	}

	@Then("Navigate to ")
	def createTestObject(String xpath) {
		TestObject dynamicObject = new TestObject()
		dynamicObject.addProperty("xpath", ConditionType.EQUALS, xpath)
		return dynamicObject
	}
}
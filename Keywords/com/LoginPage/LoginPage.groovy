package com.LoginPage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

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


class LoginPage {
	@Keyword
	def Login() {
		WebUI.openBrowser('')

		WebUI.navigateToUrl(findTestData('LoginPage/LoginPage').getValue('URL', 1))

		WebUI.maximizeWindow()

		WebUI.delay(2)

		WebUI.setText(findTestObject('Page_LoginPage/Page_ApplicantMockScreen/input_NRIC'), findTestData('LoginPage/LoginPage').getValue(
				'NRIC', 1))

		WebUI.setText(findTestObject('Page_LoginPage/Page_ApplicantMockScreen/input_SOURCE'), findTestData('LoginPage/LoginPage').getValue(
				'SOURCE', 1))

		WebUI.click(findTestObject('Page_LoginPage/Page_ApplicantMockScreen/button_login'))

		WebUI.delay(5)

		System.out.println(WebUI.getWindowTitle())

		WebUI.verifyMatch('SkillsFuture Qualification Award', 'SkillsFuture Qualification Award', false, FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyTextPresent('SkillsFuture Qualification Award', false, FailureHandling.STOP_ON_FAILURE)
	}
}
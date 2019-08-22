package com.AdminPage

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class AdminPage {


	@Keyword
	public static void Login(String username) {

		//	WebUI.openBrowser('')

		//	WebUI.navigateToUrl(findTestData('LoginPage/LoginPage').getValue('URL', 1))

		//	WebUI.maximizeWindow()

		//	WebUI.delay(2)
		WebUI.click(findTestObject('Page_AdminMockLogin/input_INTRA2 AD SSO Login'))

		WebUI.delay(10)

		WebUI.setText(findTestObject('Object Repository/Page_AdminMockLogin/input_INTRA2 AD Username'),username)

	}
}

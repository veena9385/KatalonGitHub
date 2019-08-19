import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(findTestData('LoginPage/LoginPage').getValue('URL', 1))

WebUI.maximizeWindow()

WebUI.delay(2)

not_run: WebUI.setText(findTestObject('Page_LoginPage/Page_ApplicantMockScreen/input_NRIC'), findTestData('LoginPage/LoginPage').getValue(
        'NRIC', 1))

not_run: WebUI.setText(findTestObject('Page_LoginPage/Page_ApplicantMockScreen/input_SOURCE'), findTestData('LoginPage/LoginPage').getValue(
        'SOURCE', 1))

CustomKeywords.'com.LoginPage.LoginPage.Login'(findTestData('LoginPage/LoginPage').getValue('NRIC', 1), findTestData('LoginPage/LoginPage').getValue(
        'SOURCE', 1))

WebUI.verifyMatch('SFQA', 'SFQA', false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_LoginPage/Page_ApplicantMockScreen/button_login'))

WebUI.delay(5)

System.out.println(WebUI.getWindowTitle())

WebUI.verifyMatch('SkillsFuture Qualification Award', 'SkillsFuture Qualification Award', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('SkillsFuture Qualification Award', false, FailureHandling.STOP_ON_FAILURE)


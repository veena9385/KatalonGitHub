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

WebUI.delay(5)

WebUI.click(findTestObject('Page_LoginPage/Page_SingPass Login/link_Login'))

WebUI.delay(5)

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Page_SingPass Login/div_QR CODE HASEXPIRED'), 4))
{

	System.out.println("scan QR code")
	WebUI.click(findTestObject('Object Repository/Page_LoginPage/Link_SingPass'))

	WebUI.delay(2)

	CustomKeywords.'com.LoginPage.LoginPage.Login'(findTestData('LoginPage/LoginPage').getValue('SingPassID', 1), findTestData(
			'LoginPage/LoginPage').getValue('Password', 1))


	WebUI.click(findTestObject('Page_LoginPage/Page_SingPass Login/button_LoginSingPassID'))

	WebUI.delay(5)

	System.out.println(WebUI.getWindowTitle())
}
else
{
	CustomKeywords.'com.LoginPage.LoginPage.Login'(findTestData('LoginPage/LoginPage').getValue('SingPassID', 1), findTestData(
			'LoginPage/LoginPage').getValue('Password', 1))


	WebUI.click(findTestObject('Page_LoginPage/Page_SingPass Login/button_LoginSingPassID'))

	WebUI.delay(5)

	System.out.println(WebUI.getWindowTitle())
}

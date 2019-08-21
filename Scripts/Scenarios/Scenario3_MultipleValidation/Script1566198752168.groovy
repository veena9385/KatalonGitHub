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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Scenarios/Scenario1_LoginValidUser'), [:], FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'com.LoginPage.LoginPage.Login'(findTestData('LoginPage/LoginPage').getValue('SingPassID', 1), findTestData(
//        'LoginPage/LoginPage').getValue('Password', 1))

WebUI.click(findTestObject('Page_MySkillsFuturePage/Page_SkillsFuture Qualification AwardsApplication/input_click here to apply'))

WebUI.delay(8)

//Count row
WebDriver driver = DriverFactory.getWebDriver()

WebElement table = driver.findElement(By.xpath('//table/tbody'))

List<WebElement> Rows = table.findElements(By.tagName('tr'))

int row_count = Rows.size()
if (row_count == 1) {
	System.out.println('Contains one row',FailureHandling.STOP_ON_FAILURE)
	//WebUI.delay(2,FailureHandling.STOP_ON_FAILURE)
} else {
//System.out.println('No of rows are:' + row_count)
System.out.println(('Contains' + row_count) + 'row')

System.out.println('Contains valid single row')

WebUI.check(findTestObject('MultipleRadioButtons/Page_SkillsFuture Qualification AwardsApplication/radiobutton_row1_NO'))

WebUI.check(findTestObject('MultipleRadioButtons/Page_SkillsFuture Qualification AwardsApplication/radiobutton_row2_NO'))

WebUI.check(findTestObject('MultipleRadioButtons/Page_SkillsFuture Qualification AwardsApplication/radiobutton_row3_YES'))

WebUI.check(findTestObject('MultipleRadioButtons/Page_SkillsFuture Qualification AwardsApplication/radiobutton_row4_NO'))

WebUI.delay(5)

WebUI.scrollToElement(findTestObject('Page_SkillsFuture Qualification AwardsApplication/Page_SkillsFuture Qualification AwardsApplication/span_Total Award Amount'), 
    2)

//Check if amount is displayed when No is selected
TestObject verifyAmount = findTestObject('Object Repository/Page_SkillsFuture Qualification AwardsApplication/Page_SkillsFuture Qualification AwardsApplication/span_Total Award Amount')

def ActualAmount = WebUI.getText(verifyAmount)

System.out.println('The actual amount is:' + ActualAmount)

if (ActualAmount != '$0') {
    //if (WebUI.verifyMatch(ActualAmount, AwardAmount, false)) {
    System.out.println('Congrats!!Value is changed!!!!!!!!!')
} else {
    System.out.println('Value is not changed')
}

WebUI.click(findTestObject('Page_SkillsFuture Qualification AwardsApplication/Page_SkillsFuture Qualification AwardsApplication/checkbox_Acknowledment'))

WebUI.delay(3)

not_run: WebUI.scrollToElement(findTestObject('Page_SkillsFuture Qualification AwardsApplication/Page_SkillsFuture Qualification AwardsApplication/input_Email Address'), 
    0)

not_run: WebUI.switchToFrame(findTestObject('Page_SkillsFuture Qualification AwardsApplication/iframe'), 3)

//WebUI.click(a)
not_run: WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Page_SkillsFuture Qualification AwardsApplication/Page_SkillsFuture Qualification AwardsApplication/button_TermsNcondition_YES'), 
    2)

WebUI.click(findTestObject('Page_SkillsFuture Qualification AwardsApplication/Page_SkillsFuture Qualification AwardsApplication/button_TermsNcondition_YES'))

WebUI.delay(3, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_SkillsFuture Qualification AwardsApplication/Page_SkillsFuture Qualification AwardsApplication/button_Submit'))

WebUI.delay(4)

WebUI.verifyTextPresent('Your Application is Submitted!', false, FailureHandling.STOP_ON_FAILURE)

System.out.println('Your Application is Submitted!')

WebUI.click(findTestObject('Page_Application Confirmation/button_viewApplication'))

TestObject status = findTestObject('Object Repository/Page_SkillsFuture Qualification AwardsApplication/Page_SkillsFuture Awards Applications/span_Pending Payment')

def paymentstatus = WebUI.getText(status, FailureHandling.STOP_ON_FAILURE)

System.out.println('Payment status is:' + paymentstatus)

WebUI.takeScreenshot()

}

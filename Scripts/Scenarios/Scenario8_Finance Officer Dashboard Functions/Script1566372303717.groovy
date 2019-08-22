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

/*
 Scenario_8:Finance Officer Dashboard Functions (Edit Profile, Application Listing, Export to Excel, Download PDF)
Access G2C Administrator Dashboard
Navigate Application Listing Page
Edit Profile
Click on Export to Excel
Click on Download as PDF
 */
WebUI.openBrowser('')

WebUI.navigateToUrl(findTestData('AdminPage/AdminPage').getValue('url', 1))

WebUI.maximizeWindow()

WebUI.delay(3)

CustomKeywords.'com.AdminPage.AdminPage.Login'(findTestData('AdminPage/AdminPage').getValue('username', 1))



not_run: WebUI.setText(findTestObject('Page_AdminMockLogin/input_INTRA2 AD Username'), 'SSGACTABCDE')

WebUI.click(findTestObject('Page_AdminMockLogin/input_AdminLogin'))

WebUI.delay(2)

WebUI.click(findTestObject('Page_Admin-SelectRole/button_FinanceOfficer'))

WebUI.click(findTestObject('Page_Admin-Dashboard/dropdown_span_(Finance Officer)'))

WebUI.click(findTestObject('Page_Admin-Dashboard/Link_Profile'))

WebUI.click(findTestObject('Page_Admin-Dashboard/span_Edit'))

WebDriver driver = DriverFactory.getWebDriver()

if (driver.findElement(By.xpath('(.//*[normalize-space(text()) and normalize-space(.)=\'Company Name :\'])[1]/preceding::input[3]')).isEnabled()) {
    //TestObject ab=WebUI.click(findTestObject('Page_Admin-Dashboard/input__CountryCode'))
    System.out.println('Country code is editable')
} else {
    System.out.println('Not editable', FailureHandling.STOP_ON_FAILURE)
}

if (driver.findElement(By.xpath('(.//*[normalize-space(text()) and normalize-space(.)=\'Organisation\'])[1]/preceding::input[1]')).isEnabled()) {
    System.out.println('Mobile no is editable')
} else {
    System.out.println('Not editable', FailureHandling.STOP_ON_FAILURE)
}

WebUI.delay(2)

WebUI.click(findTestObject('Page_Admin-Dashboard/Link_HomePage'))

WebUI.click(findTestObject('Page_Admin-Dashboard/a_Export to Excel'))

WebElement table = driver.findElement(By.xpath('//table/tbody'))

List<WebElement> Rows = table.findElements(By.tagName('tr'))

int row_count = Rows.size()

System.out.println('No of rows are:' + row_count)

if ((row_count == 1) || (row_count > 1)) {
    WebUI.click(findTestObject('Page_Admin-Dashboard/span_Application'))

    WebUI.click(findTestObject('Page_Admin-Dashboard/link_DownloadPDF'))
} else {
    System.out.println('There are no application in the list', FailureHandling.STOP_ON_FAILURE)
}


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.helper.KeywordHelper
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import mypackage.VerifyKeywords

import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

def changed_github_url = GlobalVariable.github_url

changed_github_url = (changed_github_url + '/repositories')

WebUI.navigateToUrl(changed_github_url)

WebUI.click(findTestObject('Object Repository/Page_The worlds leading software developmen_e309d9/a_Signin'))

WebUI.setText(findTestObject('Object Repository/Page_Sign in to GitHub  GitHub/input_Username or email address_login'), 
    username)

WebUI.setText(findTestObject('Object Repository/Page_Sign in to GitHub  GitHub/input_Forgot password_password'), password)

WebUI.click(findTestObject('Object Repository/Page_Sign in to GitHub  GitHub/input_Forgot password_commit'))

if(CustomKeywords.'mypackage.VerifyKeywords.checkElementPresent'(findTestObject("Object Repository/Page_Sign in to GitHub  GitHub/div_Incorrect username or password"))) {
	// Fail the test case
	KeywordUtil.markFailedAndStop("Test Case fails due to incorrect credentials");
}

WebUI.closeBrowser()


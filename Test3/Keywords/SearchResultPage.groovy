import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class SearchResultPage{

	@Keyword
	def isSearchHeaderText(){
		return WebUI.waitForElementVisible(findTestObject('Object Repository/SearchResultPage/lblSearchHeader'), 5);
	}

	@Keyword
	def getErorrMessageText(){
		return WebUI.getText(findTestObject('Object Repository/SearchResultPage/lblErrorMessage'));
	}

	@Keyword
	def getPageNameText(){
		return WebUI.getText(findTestObject('Object Repository/SearchResultPage/lblPageName'));
	}

	@Keyword
	def getPageViewText(){
		return WebUI.getText(findTestObject('Object Repository/SearchResultPage/lblPageView'));
	}

	@Keyword
	def getPageResultText(){
		return WebUI.getText(findTestObject('Object Repository/SearchResultPage/txtResultPage'));
	}

	@Keyword
	def getSearchResultText(){
		return WebUI.getText(findTestObject('Object Repository/SearchResultPage/txtSearchResult'));
	}


	@Keyword
	def getErrorMessageText(){
		return WebUI.getText(findTestObject('Object Repository/SearchResultPage/lblErrorMessage'));
	}


	@Keyword
	def checkSearchMatch(inpPageName, inpPageView, inpPageResult, inpSearchResult, outPageName, outPageView, outPageResult, outSearchResult){

		WebUI.verifyMatch(inpPageName, outPageName, false);
		WebUI.verifyMatch(inpPageView, outPageView, false);
		WebUI.verifyMatch(inpPageResult, outPageResult, false);
		WebUI.verifyMatch(inpSearchResult, outSearchResult, false);
	}

	@Keyword
	def checkErrorMessageMatch(inpErrorMessage,outErrorMessage){
		WebUI.verifyMatch(inpErrorMessage, outErrorMessage, false);
	}
}

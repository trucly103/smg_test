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




TestData SearchData = findTestData('SearchData')



for (def i : (1..SearchData.getRowNumbers())) 
{
	
	//Read Data files
	 String  inpPageName     		 = SearchData.getObjectValue('PageName', i).toString();
	 String  inpPageView   	 		 = SearchData.getObjectValue('PageView', i).toString();
	 String  inpPageResult 	 		 = SearchData.getObjectValue('PageResult', i).toString();
	 String  inpSearchResult 		 = SearchData.getObjectValue('SearchResult', i).toString();
	 String  inpErrorMessage     	 = SearchData.getObjectValue('ErrorMessage', i).toString();
	
	 
	 WebUI.openBrowser(GlobalVariable.Url);
	
	 WebUI.maximizeWindow();
	
	 WebUI.waitForPageLoad(1000);
	 
	 CustomKeywords.'MainPage.inputSearchText'(SearchData.getObjectValue('SearchKeyword', i).toString());
	 CustomKeywords.'MainPage.clickSearchButton'();
	 
	 //If search return error
	 if (inpErrorMessage)
	 {
		 CustomKeywords.'SearchResultPage.isSearchHeaderText'();
		 outErrorMessage = CustomKeywords.'SearchResultPage.getErrorMessageText'();
		 CustomKeywords.'SearchResultPage.checkErrorMessageMatch'(inpErrorMessage,outErrorMessage);
		 WebUI.closeBrowser();
		 

	 }
	 else
	 {			
		 
		 String outPageName   	 	= CustomKeywords.'SearchResultPage.getPageNameText'();
		 String outPageView   	 	= CustomKeywords.'SearchResultPage.getPageViewText'();
		 String outPageResult 	 	= CustomKeywords.'SearchResultPage.getPageResultText'()
		 String outSearchResult  	= CustomKeywords.'SearchResultPage.getSearchResultText'();
		 
		 //Verify matching data
		 CustomKeywords.'SearchResultPage.isSearchHeaderText'();
		 CustomKeywords.'SearchResultPage.checkSearchMatch'(inpPageName, inpPageView, inpPageResult, inpSearchResult, outPageName, outPageView, outPageResult, outSearchResult);
		 WebUI.closeBrowser();
					 
	 }	
	 
}


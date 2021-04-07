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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

String ExpectedRequisitionA = ('VoixSortantimei (' + GlobalVariable.imeiATraiterA) + ')'

String ExpectedRequisitionB = ('VoixSortantimei (' + GlobalVariable.imeiATraiterB) + ')'

String ActualRequisitionA = ''

String ActualRequisitionB = ''

'Cliquer sur le menu Historique'
WebUI.click(findTestObject('Menu/Menu Historique'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le sous menu Requisition'
WebUI.click(findTestObject('Menu/Sous menu Historique/Menu Requisition'), FailureHandling.CONTINUE_ON_FAILURE)

'Afficher tous les elements'
WebUI.click(findTestObject('Historique traitement appel/Requisition appel/Option Afficher les elements'))

WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Option Afficher tous les elements'), 3)

WebUI.click(findTestObject('Historique traitement appel/Option Afficher tous les elements'))

WebUI.click(findTestObject('Titre header eRequisition'))

List<WebElement> ColonneOperation = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition appel/Colonne Operation'), 
    5)

List<WebElement> ColonneSensTraffic = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition appel/Colonne sens traffic'), 
    5)

List<WebElement> ColonneInfoEntree = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition appel/Colonne information entree'), 
    5)

'Recuperer les infos relatif au requisition du premier msisdn saisi'
ActualRequisitionA = (ActualRequisitionA + ColonneOperation.get(ColonneOperation.size() - 2).getText())

ActualRequisitionA = (ActualRequisitionA + ColonneSensTraffic.get(ColonneOperation.size() - 2).getText())

ActualRequisitionA = (ActualRequisitionA + ColonneInfoEntree.get(ColonneOperation.size() - 2).getText())

'Vérifier que la requistion du 1e msisdn est affiché dans le tableau'
WebUI.verifyMatch(ActualRequisitionA, ExpectedRequisitionA, false)

'Recuperer les infos relatif au requisition du 2è msisdn saisi'
ActualRequisitionB = (ActualRequisitionB + ColonneOperation.get(ColonneOperation.size() - 1).getText())

ActualRequisitionB = (ActualRequisitionB + ColonneSensTraffic.get(ColonneOperation.size() - 1).getText())

ActualRequisitionB = (ActualRequisitionB + ColonneInfoEntree.get(ColonneOperation.size() - 1).getText())

'Vérifier que la requistion du 2e msisdn est affiché dans le tableau'
WebUI.verifyMatch(ActualRequisitionB, ExpectedRequisitionB, false)


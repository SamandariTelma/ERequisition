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

String ExpectedRequisition = (((GlobalVariable.imeiATraiterA + ',') + GlobalVariable.imeiATraiterB) + '2') + dateHeureTraitement

String ActualRequisition = ''

'Cliquer sur le menu Historique'
WebUI.click(findTestObject('Menu/Menu Historique'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le sous menu Requisition'
WebUI.click(findTestObject('Menu/Sous menu Historique/Menu Identite client'), FailureHandling.CONTINUE_ON_FAILURE)

'Afficher tous les elements'
WebUI.click(findTestObject('Historique traitement appel/Requisition identite client/Option Afficher les elements'))

WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Option Afficher tous les elements'), 3)

WebUI.click(findTestObject('Historique traitement appel/Option Afficher tous les elements'))

WebUI.click(findTestObject('Titre header eRequisition'))

List<WebElement> ColonneInfoEntree = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition identite client/Colonne information entree'), 
    5)

List<WebElement> ColonneNombre = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition identite client/Colonne Nombre'), 
    5)

List<WebElement> ColonneDateHeureTraitement = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition identite client/Date et heure traitement'), 
    5)

'Recuperer les infos relatif aux requisitions'
ActualRequisition = (ActualRequisition + ColonneInfoEntree.get(0).getText())

ActualRequisition = (ActualRequisition + ColonneNombre.get(0).getText())

def dateHeure = ColonneDateHeureTraitement.get(0).getText()

ActualRequisition = (ActualRequisition + dateHeure.substring(0, 16))

'Vérifier que la requistion est affiché dans le tableau'
WebUI.verifyMatch(ActualRequisition, ExpectedRequisition, false)


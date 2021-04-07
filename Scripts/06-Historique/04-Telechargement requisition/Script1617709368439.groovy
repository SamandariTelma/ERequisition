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

WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)
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

List<WebElement> ColonneDateHeureTraitement = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition identite client/Bouton scan requisition 1ere ligne'), 
    5)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement requisition 1ere ligne'), 
    3)

'Cliquer sur le bouton de téléchargement requisition'
WebUI.click(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement requisition 1ere ligne'))

WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement Excel 1ere ligne'), 
    3)

'Vérifier l affichage du tooltip de telechargement qui contient les options suivant\r\n- Visualiser PDF\r\n- Visualiser Excel'
WebUI.verifyElementVisible(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement PDF 1ere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement PDF 1ere ligne'))

WebUI.delay(1)

'Cliquer sur le bouton de téléchargement requisition'
WebUI.click(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement requisition 1ere ligne'))

WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement Excel 1ere ligne'), 
    3)

'Vérifier l affichage du tooltip de telechargement qui contient les options suivant\r\n- Visualiser PDF\r\n- Visualiser Excel'
WebUI.verifyElementVisible(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement PDF 1ere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Historique traitement appel/Requisition identite client/Bouton telechargement Excel 1ere ligne'))


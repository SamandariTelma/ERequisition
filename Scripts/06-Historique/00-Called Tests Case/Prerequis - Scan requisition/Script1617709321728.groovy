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
import java.text.SimpleDateFormat as SimpleDateFormat

'Se connecter à ERequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Nouvelle demande/encart Identite client'), 10)

'Cliquer sur l encart historique d appels'
WebUI.click(findTestObject('Nouvelle demande/encart Identite client'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Champ de saisi numero'), 3)

'Saisir un msisdn dans le champ de saisi numéro'
WebUI.sendKeys(findTestObject('Nouvelle demande/Choix de l input/Champ de saisi numero'), GlobalVariable.msisdnATraiterA)

'Cliquer sur le bouton d ajout numero'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout numero (icon plus)'))

'Vérifier que le numero s affiche avec un icon corbeille'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero A'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute A'), 3)

'Vérifier que le numero affiché correspon au numéro saisi'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute A'), '034' + GlobalVariable.msisdnATraiterA)

'Saisir un autre msisdn dans le champ de saisi numéro'
WebUI.sendKeys(findTestObject('Nouvelle demande/Choix de l input/Champ de saisi numero'), GlobalVariable.msisdnATraiterB)

'Cliquer sur le bouton d ajout numero'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout numero (icon plus)'))

'Vérifier que le numero s affiche avec un icon corbeille'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero B'), 3)

'Vérifier que le numero affiché correspon au numéro saisi'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute B'), 3)

'Cliquer sur le bouton suivant '
WebUI.click(findTestObject('Bouton commun/bouton suivant'))

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Information Obligatoires/Champ numero requisition'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Information Obligatoires/Champ Scan Requisition'), 3)

//Generer une reference avec un nombre aléatoire
int i = Math.random() * (5000 - 1)

String nbrAleatoire = String.valueOf(i)

GlobalVariable.referenceRequisition = nbrAleatoire

'Saisir une reference de requisition'
WebUI.sendKeys(findTestObject('Nouvelle demande/Information Obligatoires/Champ numero requisition'), GlobalVariable.referenceRequisition)

'Cliquer sur le bouton suivant'
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Checkbox Animateur'), 
    3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Checkbox Photo'), 
    3)

'Cliquer sur le checkbox Photo'
WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Label Photo'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier que le checkbox photo est coché'
WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Checkbox Photo'), 
    3)

'Vérifier que le checkbox Animateur n est pas coché'
WebUI.verifyElementNotChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Checkbox Animateur'), 
    3)

'Cliquer sur le bouton suivant'
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

//Recuperer la date courrant sous forme de dd/MM/yyy HH:mm
def date = new Date()

def sdf = new SimpleDateFormat('dd/MM/yyyy HH:mm')

String dateHeureTraitement = sdf.format(date)

'Vérifier qu on revient sur la Home page'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/encart historique d appels'), 10)
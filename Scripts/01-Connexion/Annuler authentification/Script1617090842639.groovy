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

WebUI.callTestCase(findTestCase('00-Called Tests Case/Ouvrir le navigateur'), [:], FailureHandling.CONTINUE_ON_FAILURE)

' je me rends sur l\'Url d\'application : https://tapq466lv/requisition/'
WebUI.navigateToUrl(GlobalVariable.urlPreprod)

WebUI.waitForElementPresent(findTestObject('Login/Champ username'), 10)

'Saisir le bon login et mot de passe'
WebUI.sendKeys(findTestObject('Login/Champ username'), GlobalVariable.loginUsernameAdmin)

WebUI.sendKeys(findTestObject('Login/Champ password'), GlobalVariable.loginPassword)

'Cliquer sur le bouton connexion'
WebUI.click(findTestObject('Login/Bouton Connexion'))

WebUI.waitForElementPresent(findTestObject('Login/Popin Regle de confidentialite/Regle de confidentialite'), 3)

'Vérifier la présence du popin règle de confidentialité'
WebUI.verifyElementPresent(findTestObject('Login/Popin Regle de confidentialite/Regle de confidentialite'), 0)

'Cliquer sur le bouton Annuler'
WebUI.click(findTestObject('Login/Popin Regle de confidentialite/Bouton Annuler'))

'Vérifier qu on est resté sur la page d authentification'
WebUI.verifyElementVisible(findTestObject('Login/Champ password'))

'Cliquer sur le bouton connexion'
WebUI.click(findTestObject('Login/Bouton Connexion'))

'Cliquer sur le bouton valider du popin'
WebUI.waitForElementPresent(findTestObject('Login/Popin Regle de confidentialite/Bouton Valider'), 3)

WebUI.delay(0.500)

'Cliquer sur le bouton valider du popin'
WebUI.click(findTestObject('Login/Popin Regle de confidentialite/Bouton Valider'))

WebUI.waitForElementPresent(findTestObject('Nouvelle demande/Titre page Nouvelle demande'), 10)

'Vérifier que l utilisateur est connecté et voit la page nouvelle demande'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Titre page Nouvelle demande'), 3)


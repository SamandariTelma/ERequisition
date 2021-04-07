import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('00-Called Tests Case/Ouvrir le navigateur'), [:], FailureHandling.CONTINUE_ON_FAILURE)

' je me rends sur l\'Url d\'application : https://tapq466lv/requisition/'
WebUI.navigateToUrl(GlobalVariable.urlPreprod)

WebUI.waitForElementPresent(findTestObject('Login/Champ username'), 10)

'Saisir un nom d utilisateur qui n existe pas'
WebUI.sendKeys(findTestObject('Login/Champ username'), 'blabla')

'Saisir un  bon mot de passe qui existe'
WebUI.sendKeys(findTestObject('Login/Champ password'), GlobalVariable.loginPassword)

'Cliquer sur le bouton connexion'
WebUI.click(findTestObject('Login/Bouton Connexion'))

WebUI.waitForElementPresent(findTestObject('Login/Popin err Login/message d erreur'), 3)

'Vérifier l apparition du popin avec message d erreur'
WebUI.verifyElementPresent(findTestObject('Login/Popin err Login/message d erreur'), 3)

WebUI.delay(1)

'Cliquer sur le bouton Ok du popin'
WebUI.click(findTestObject('Login/Popin err Login/Bouton OK'))

WebUI.clearText(findTestObject('Login/Champ username'))

'Saisir un identifiant qui existe avec un mot de passe qui ne correspond pas'
WebUI.sendKeys(findTestObject('Login/Champ username'), 'antsa11')

'Cliquer sur le bouton connexion'
WebUI.click(findTestObject('Login/Bouton Connexion'))

'Vérifier l affichage du popin avec message d erreur'
WebUI.waitForElementPresent(findTestObject('Login/Popin err Login/message d erreur'), 3)

WebUI.verifyElementPresent(findTestObject('Login/Popin err Login/message d erreur'), 3)

'Cliquer sur le bouton ok '
WebUI.click(findTestObject('Login/Popin err Login/Bouton OK'))

'Vider le champ username puis valider'
WebUI.sendKeys(findTestObject('Login/Champ username'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Login/Champ username'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.click(findTestObject('Login/Bouton Connexion'))

WebUI.waitForElementPresent(findTestObject('Login/Popin err Login/message d erreur'), 3)

'Vérifier l apparition du message d erreur Votre login est obligatoire'
WebUI.verifyElementText(findTestObject('Login/Message err Champ username'), 'Votre login est obligatoire')


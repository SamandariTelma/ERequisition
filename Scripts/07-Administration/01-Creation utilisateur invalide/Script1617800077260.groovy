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
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys

'Se connecter à ERequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Menu/Menu Administration'), 3)

'Cliquer sur lemenu Administration'
WebUI.click(findTestObject('Menu/Menu Administration'))

WebUI.waitForElementPresent(findTestObject('Administration utilisateur/Titre page admin'), 3)

WebUI.verifyElementText(findTestObject('Administration utilisateur/Titre page admin'), 'Administration utilisateur')

'Vérifier que la page d\'administration utilisateur s\'affiche avec les éléments suivant:\r\n- Champ de saisie Login ldap\r\n- Champ de saisie Nom et prénom\r\n- Liste déroulant Profil\r\n- Bouton Créer'
WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Champ login ldap'), 3)

WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Champ nom prenom'), 3)

WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Champ profil'), 3)

WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Bouton creer'), 3)

'Cliquer sur le bouton creer laissant vide les champs de saisie'
WebUI.click(findTestObject('Administration utilisateur/Bouton creer'))

WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Message d err login obligatoire'), 3)

WebUI.verifyElementText(findTestObject('Administration utilisateur/Message d err login obligatoire'), 'Le login ldap de l\'utilisateur est obligatoire')

WebUI.verifyElementText(findTestObject('Administration utilisateur/Message d err nom obligatoire'), 'Le nom et prénom de l\'utilisateur est obligatoire')

'Saisir un login Ldap non existant en laissant vide le champ nom prenom'
WebUI.sendKeys(findTestObject('Administration utilisateur/Champ login ldap'), 'sandsamand007')

WebUI.click(findTestObject('Administration utilisateur/Bouton creer'))

WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Message d err nom obligatoire'), 3)

'Vérifier l apparition du message d erreur nom obligatoire'
WebUI.verifyElementText(findTestObject('Administration utilisateur/Message d err nom obligatoire'), 'Le nom et prénom de l\'utilisateur est obligatoire')

WebUI.sendKeys(findTestObject('Administration utilisateur/Champ login ldap'), Keys.chord(Keys.CONTROL,
	'a'))

WebUI.sendKeys(findTestObject('Administration utilisateur/Champ login ldap'), Keys.chord(Keys.BACK_SPACE))

'Saisir un nom en laissant vide le champ login ldap'
WebUI.sendKeys(findTestObject('Administration utilisateur/Champ nom prenom'), 'Samandari Sandy')

WebUI.click(findTestObject('Administration utilisateur/Bouton creer'))

WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Message d err login obligatoire'), 3)

'Vérifier l apparition du message d erreur nom obligatoire'
WebUI.verifyElementText(findTestObject('Administration utilisateur/Message d err login obligatoire'), 'Le login ldap de l\'utilisateur est obligatoire')

'Saisir un Login qui existe déjà dans ERequisition'
WebUI.sendKeys(findTestObject('Administration utilisateur/Champ login ldap'), GlobalVariable.loginUsernameAdmin)

'Vérifier l apparition du popin avec le message d erreur'
WebUI.waitForElementVisible(findTestObject('Administration utilisateur/Popin err/message err login existant'), 3)

'Vérifier que le message d erreur est conforme'
WebUI.verifyElementText(findTestObject('Administration utilisateur/Popin err/message err login existant'), 'Le login ldap existe déjà !')

'Cliquer sur le bouton OK'
WebUI.click(findTestObject('Administration utilisateur/Popin err/Bouton Ok'))


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

String loginNouvelUsr = 'simpleUserTest'

String nomNouvelUsr = 'nameSimpleUserTest'

'Se connecter à ERequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Menu/Menu Administration'), 3)

'Cliquer sur lemenu Administration'
WebUI.click(findTestObject('Menu/Menu Administration'))

WebUI.waitForElementPresent(findTestObject('Administration utilisateur/Titre page admin'), 3)

WebUI.verifyElementText(findTestObject('Administration utilisateur/Titre page admin'), 'Administration utilisateur')

'Saisir le login du nouvel admin'
WebUI.sendKeys(findTestObject('Administration utilisateur/Champ login ldap'), loginNouvelUsr)

'saisir le nom du nouvel admin'
WebUI.sendKeys(findTestObject('Administration utilisateur/Champ nom prenom'), nomNouvelUsr)

'Cliquer sur la liste déroulante profil'
WebUI.click(findTestObject('Administration utilisateur/Champ profil'))

WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Option Profil Administrateur'), 3)

WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Option Profil Simple utilisateur'), 3)

'Choisir l option simple utilisateur'
WebUI.click(findTestObject('Administration utilisateur/Option Profil Simple utilisateur'))

WebUI.click(findTestObject('Administration utilisateur/Champ profil'))

'Cliquer sur le bouton créer'
WebUI.click(findTestObject('Administration utilisateur/Bouton creer'))

'Vérifier l apparition du popin avec le message de confirmation de création de compte'
WebUI.waitForElementPresent(findTestObject('Administration utilisateur/Popin confirm/Titre popin confirmation ajout'), 3)

'Vérifier que le message de confirmation est correcte'
WebUI.verifyElementText(findTestObject('Administration utilisateur/Popin confirm/Titre popin confirmation ajout'), ('Confirmer l\'ajout du nouvel utilisateur ' + 
    loginNouvelUsr) + ' ?')

'Cliquer sur le bouton Ajouter'
WebUI.click(findTestObject('Administration utilisateur/Popin confirm/Bouton Annuler'))//A modifier en bouton Ajouter lors d un vrai test

'Vérifier que l user venant d etre créer apparait bien dans la liste des users'
WebUI.callTestCase(findTestCase('07-Administration/00-Called Tests Case/Verification utilisateur cree'), [('nomProfilARechercher') : nomNouvelUsr
        , ('loginARechercher') : loginNouvelUsr], FailureHandling.CONTINUE_ON_FAILURE)


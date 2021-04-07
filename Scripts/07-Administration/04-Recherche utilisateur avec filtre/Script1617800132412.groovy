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

String nomProfilARechercher = GlobalVariable.loginUsernameAdmin

'Se connecter à ERequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Menu/Menu Administration'), 3)

'Cliquer sur lemenu Administration'
WebUI.click(findTestObject('Menu/Menu Administration'))

WebUI.waitForElementPresent(findTestObject('Administration utilisateur/Titre page admin'), 3)

WebUI.verifyElementText(findTestObject('Administration utilisateur/Titre page admin'), 'Administration utilisateur')

'Vérifier que la page d administration utilisateur s affiche avec les éléments suivant: \r\n- Un champ de saisie "Rechercher"\r\n- Un tableau de résultat qui contient les colonnes Login ldap, Nom et prénom, Profil et Etat'
WebUI.verifyElementPresent(findTestObject('Administration utilisateur/Champ filtre recherher'), 3)

WebUI.verifyElementText(findTestObject('Administration utilisateur/tableau de resultat/Titre colonne Login ldap'), 'Login ldap')

WebUI.verifyElementText(findTestObject('Administration utilisateur/tableau de resultat/Titre colonne nom prenom'), 'Nom et prénom')

WebUI.verifyElementText(findTestObject('Administration utilisateur/tableau de resultat/Titre colonne profil'), 'Profil')

WebUI.verifyElementText(findTestObject('Administration utilisateur/Colonne Etat'), 'Etat')

'Afficher tous les elements'
WebUI.click(findTestObject('Administration utilisateur/Option Afficher les elements'))

WebUI.waitForElementVisible(findTestObject('Administration utilisateur/Option Afficher tous les elements'), 3)

WebUI.click(findTestObject('Administration utilisateur/Option Afficher tous les elements'))

WebUI.click(findTestObject('Administration utilisateur/Champ filtre recherher'))

'Saisir Administrateur dans le champ de recherche'
WebUI.sendKeys(findTestObject('Administration utilisateur/Champ filtre recherher'), 'administrateur')

WebUI.delay(0.500)

List<WebElement> colonneProfil = WebUiCommonHelper.findWebElements(findTestObject('Administration utilisateur/tableau de resultat/Colonne Profil'), 
    5)

for (def resultatProfil : colonneProfil) {
    String profil = resultatProfil.getText()

    WebUI.verifyMatch(profil, 'Administrateur', false)
}

WebUI.clearText(findTestObject('Administration utilisateur/Champ filtre recherher'), FailureHandling.CONTINUE_ON_FAILURE)

'Saisir Simple utilisasteur dans le champ de recherche'
WebUI.sendKeys(findTestObject('Administration utilisateur/Champ filtre recherher'), 'simple utilisateur')

WebUI.delay(0.500)

colonneProfil = WebUiCommonHelper.findWebElements(findTestObject('Administration utilisateur/tableau de resultat/Colonne Profil'), 
    5)

for (def resultatProfil : colonneProfil) {
    String profil = resultatProfil.getText()

    WebUI.verifyMatch(profil, 'Simple utilisateur', false)
}

WebUI.clearText(findTestObject('Administration utilisateur/Champ filtre recherher'), FailureHandling.CONTINUE_ON_FAILURE)

'Saisir un nom dans le champ de recherche'
WebUI.sendKeys(findTestObject('Administration utilisateur/Champ filtre recherher'), nomProfilARechercher)

WebUI.delay(0.500)

List<WebElement> colonneNomProfil = WebUiCommonHelper.findWebElements(findTestObject('Administration utilisateur/tableau de resultat/Colonne Nom Prenom'), 
    5)

for (def resultatNomProfil : colonneNomProfil) {
    String nomProfil = resultatNomProfil.getText()

    WebUI.verifyMatch(nomProfil, '.*(?i)'+nomProfilARechercher+'(?-i).*', true)
}


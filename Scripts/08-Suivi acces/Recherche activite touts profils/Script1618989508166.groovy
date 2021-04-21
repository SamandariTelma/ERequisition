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

String dateDeFin = '16/04/2021'

String dateDeDebut = '01/04/2021'

'Se connecter a ERequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu/Menu Suivi acces'), 5)

'Cliquer sur le menu Suivi acces'
WebUI.click(findTestObject('Menu/Menu Suivi acces'))

'Choisir Tous les profils dans la liste déroulant'
List<WebElement> listProfil = WebUiCommonHelper.findWebElements(findTestObject('Suivi acces utilisateur/Liste profil utilisateur'), 
    5)

List<WebElement> utilisateur = new ArrayList()

for (def profil : listProfil) {
    if (profil.getText().equals('Tous les profils')) {
        profil.click()
    }
    
    utilisateur.add(profil.getText())
}

WebUI.click(findTestObject('Suivi acces utilisateur/Champ rechercher'))

'Saisir une date de debut et une date de fin'
WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ date fin'), dateDeFin)

WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ date debut'), dateDeDebut)

WebUI.click(findTestObject('Suivi acces utilisateur/Champ rechercher'))

'Cliquer sur le bouton afficher'
WebUI.click(findTestObject('Suivi acces utilisateur/Bouton Afficher'))

WebUI.delay(0.500)

'Cliquer sur la liste déroulantes et choisir afficher tous les éléments'
WebUI.click(findTestObject('Suivi acces utilisateur/Liste deroulant afficher elements'))

WebUI.click(findTestObject('Suivi acces utilisateur/Option Afficher tous'))

WebUI.click(findTestObject('Suivi acces utilisateur/Liste deroulant afficher elements'))

WebUI.delay(0.500)

'Vérifier que les titre des colonnes du tableau sont conformes'
WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Titre colonne IP'), 'IP')

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Titre colonne Login'), 'Login')

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Titre colonne Date'), 'Date time')

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Titre colonne Page'), 'Page')

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Titre colonne parametre'), 'Paramètres')

'Vérifier que le login dans le resultat correspond très bien au login rechercher'
List<WebElement> listLogin = WebUiCommonHelper.findWebElements(findTestObject('Suivi acces utilisateur/Tableau de resultat/Colonne Login'), 
    5)

for (def login : listLogin) {
    WebUI.verifyEqual(true, utilisateur.contains(login.getText() //WebUI.verifyMatch(login.getText(), userRechercher, false)
            ))
}

'Vérifier que la date du resultat correspond à la date rechercher'
List<WebElement> listDate = WebUiCommonHelper.findWebElements(findTestObject('Suivi acces utilisateur/Tableau de resultat/Colonne Date'), 
    5)

for (def date : listDate) {

	CustomKeywords.'myPackage.VerifyDateBetween2Dates.isDateBetween2Date'(dateDeDebut, dateDeFin,  date.getText())
}

'Vérifier l affichage de l adresse IP'
List<WebElement> listIP = WebUiCommonHelper.findWebElements(findTestObject('Suivi acces utilisateur/Tableau de resultat/Colonne IP'), 
    5)

for (def ip : listIP) {
    WebUI.verifyMatch(ip.getText(), '^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$', true //verification avec format IP correcte
        ) //Methode de verification si une date est comprise dans un interval (date de début et date de fin)
} //Methode d'inversion de du format de tate ex: 12/03/2021 to 20210312

boolean isDateBetween2Date(String dateBegin, String dateEnd, String expectedDate) {
    int dateDebut = inverserFormatDate(dateBegin)

    int dateFin = inverserFormatDate(dateEnd)

    int dateAVerifier = inverserFormatDate(expectedDate)

    return (dateDebut <= dateAVerifier) && (dateAVerifier <= dateFin)
}

int inverserFormatDate(String date) {
    String jour = date.substring(0, 2)

    String mois = date.substring(3, 5)

    String annee = date.substring(6, 10)

    String dateInverse = (annee + mois) + jour

    int inverseDate

    inverseDate = dateInverse.toInteger()

    return inverseDate
}


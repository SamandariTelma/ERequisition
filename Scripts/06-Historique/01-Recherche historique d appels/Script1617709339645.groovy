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
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys

//Initialisation du profil et date de recherche
String dateDebutRecherche = '12/03/2021'

String dateFinRecherche = '12/03/2021'

String dateDebutRecherche2 = '01/01/2021'

String dateFinRecherche2 = '01/04/2025'

String profilRechercher = 'sandy'

'Se connecter a eRequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le menu Historique'
WebUI.click(findTestObject('Menu/Menu Historique'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu/Sous menu Historique/Menu Requisition'), 3)

'Cliquer sur le sous menu Requisition'
WebUI.click(findTestObject('Menu/Sous menu Historique/Menu Requisition'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Historique traitement appel/Liste deroulant profil'), 5)

'V??rifier que la page historique des traitements d\'appel s\'affiche avec les ??l??ments suivants:\r\n- Liste d??roulant Profil qui contient tous les utilisateur inscrits dans eRequisition\r\n- Champ date de d??but\r\n- Champ date de fin\r\n- Bouton Afficher'
WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Liste deroulant profil'), 3)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Requisition appel/Champ date debut'), 3)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Requisition appel/Champ date fin'), 3)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Bouton Afficher'), 3)

'Clique sur le bouton Afficher sans remplir les champs'
WebUI.click(findTestObject('Historique traitement appel/Bouton Afficher'))

WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Message d err date debut obligatoire'), 3)

'V??rifier la conformit?? du message d erreur qui s affiche en bas du champ date de debut'
WebUI.verifyElementText(findTestObject('Historique traitement appel/Message d err date debut obligatoire'), 'La date de d??but de p??riode de la r??quisition est obligatoire')

'V??rifier la conformit?? du message d erreur qui s affiche en bas du champ date de fin'
WebUI.verifyElementText(findTestObject('Historique traitement appel/Message d err date fin obligatoire'), 'La date de fin de p??riode de la r??quisition est obligatoire')

'Saisir une date de d??but sup??rieur ?? la date de fin'
WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition appel/Champ date debut'), '19/02/2021')

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition appel/Champ date fin'), '18/02/2021')

'Clique sur le bouton Afficher sans remplir les champs'
WebUI.click(findTestObject('Historique traitement appel/Champ Rechercher'))

WebUI.waitForElementPresent(findTestObject('Historique traitement appel/Popin err/Message d err date debut superieur a la date de fin'), 
    3)

'Affichage du popin avec le message d erreur'
WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Popin err/Message d err date debut superieur a la date de fin'), 
    3)

'Cliquer sur le bouton OK'
WebUI.click(findTestObject('Historique traitement appel/Popin err/Bouton Ok'))

WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Liste deroulant profil'), 3)

'Cliquer sur la liste deroulante toutes les profils'
WebUI.click(findTestObject('Historique traitement appel/Liste deroulant profil'), FailureHandling.CONTINUE_ON_FAILURE)

'Choisir un nom d\'utilisateur dans la liste d??roulant'
WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Option profil username'), 3)

//Recuperation de tous les options dans la lite d??roulante
List<WebElement> optionUsername = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Option profil username'), 
    5)

for (def option : optionUsername) {
    String profil = option.getText()

    if (profil == profilRechercher) {
        option.click()
    }
}

WebUI.click(findTestObject('Historique traitement appel/Liste deroulant profil'), FailureHandling.CONTINUE_ON_FAILURE)

'saisir une date de debut et date de fin valide'
WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition appel/Champ date debut'), dateDebutRecherche)

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition appel/Champ date fin'), dateFinRecherche)

WebUI.click(findTestObject('Historique traitement appel/Champ Rechercher'))

'Cliquer sur le bouton Afficher'
WebUI.click(findTestObject('Historique traitement appel/Bouton Afficher'))

WebUI.delay(0.500)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Requisition appel/Colonne date heure traitement'), 
    0)

//Recuperation de la date dans la colonne date et heure du traitement
String dateTraitement = WebUI.getText(findTestObject('Historique traitement appel/Requisition appel/Colonne date heure traitement'))

//Suppression de l' heure dans la chaine de date heure r??cuperer
dateTraitement = dateTraitement.substring(0, 10)

'V??rifier que le r??sultat dans le tableau retourne des r??quisition du profil choisi et selon l\'interval de temp renseign?? '
WebUI.verifyMatch(dateTraitement, dateDebutRecherche, false)

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Colonne utilisateur'), profilRechercher)

'Affichage des colonnes suivants:\r\n- R??f??rence r??quisition\r\n- Utilisateur\r\n- Op??ration\r\n- Sens du traffic\r\n- Information en entr??e\r\n- Date et heure traitement\r\n- Scan r??quisition\r\n- Accuse r??sultat'
WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre colonne Reference requisition'), 
    'R??f??rence r??quisition')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre colonne Utilisateur'), 'Utilisateur')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre colonne Operation'), 'Op??ration')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre Sens traffic'), 'Sens du traffic')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre Information en entree'), 'Information en entr??e')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre Information Date et heure traitement'), 
    'Date et heure traitement')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre Information Scan requisition'), 
    'Scan r??quisition')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre Information Accuse resultat'), 
    'Accuse r??sultat')

'Choisir tous les profil dans la liste d??roulante '
WebUI.click(findTestObject('Historique traitement appel/Liste deroulant profil'))

'Choisir tous les profil dans la liste d??roulante '
WebUI.click(findTestObject('Historique traitement appel/Option Tous les profils'))

'Choisir tous les profil dans la liste d??roulante '
WebUI.click(findTestObject('Historique traitement appel/Liste deroulant profil'))

'saisir une date de debut et date de fin valide'
WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition appel/Champ date fin'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition appel/Champ date fin'), dateFinRecherche2)

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition appel/Champ date debut'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition appel/Champ date debut'), dateDebutRecherche2)

WebUI.click(findTestObject('Historique traitement appel/Champ Rechercher'))

'Cliquer sur le bouton Afficher'
WebUI.click(findTestObject('Historique traitement appel/Bouton Afficher'))

WebUI.click(findTestObject('Historique traitement appel/Requisition appel/Option Afficher les elements'))

WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Requisition appel/Option Afficher tous'), 3)

WebUI.click(findTestObject('Historique traitement appel/Requisition appel/Option Afficher tous'))

WebUI.click(findTestObject('Historique traitement appel/Requisition appel/Option Afficher les elements'))

'Saisir un mot cle de la recherche'
WebUI.sendKeys(findTestObject('Historique traitement appel/Champ Rechercher'), 'admin')

WebUI.clearText(findTestObject('Historique traitement appel/Champ Rechercher'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(0.500)

WebUI.sendKeys(findTestObject('Historique traitement appel/Champ Rechercher'), 'admin')

WebUI.delay(3)

//Recuperer tous les resultats dans la colonne utilisateur
List<WebElement> colonneUtilisateur = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition appel/Colonne utilisateur'), 
    5)

for (def utilisateur : colonneUtilisateur) {
    String nomUtilisateur = utilisateur.getText()

    WebUI.verifyMatch(nomUtilisateur, 'admin', false)
}

//VERIFICATION DATE
List<WebElement> colonneDateHeure = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition appel/Colonne date heure traitement'),
	5)

'V??rifier que les dates sont au bon format'
for (def date: colonneDateHeure)
{
	WebUI.verifyMatch(date.getText(), '^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$', true)
}

'V??rifier que les r??sultats correspondent ?? l interval de temps renseign??'
for (def date : colonneDateHeure) {
	String dateAVerifier = date.getText().substring(0, 10)

	boolean isDateMatch = isDateBetween2Date(dateDebutRecherche2, dateFinRecherche2, dateAVerifier)

	WebUI.verifyEqual(isDateMatch, true)
}

WebUI.clearText(findTestObject('Historique traitement appel/Champ Rechercher'))

'Saisir un mot cle de la recherche'
WebUI.sendKeys(findTestObject('Historique traitement appel/Champ Rechercher'), profilRechercher)

colonneUtilisateur = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition appel/Colonne utilisateur'), 
    5)

for (def utilisateur : colonneUtilisateur) {
    String nomUtilisateur = utilisateur.getText()

    WebUI.verifyMatch(nomUtilisateur, profilRechercher, false)
} 
//Methode de verification si une date est comprise dans un interval (date de d??but et date de fin)

boolean isDateBetween2Date(String dateBegin, String dateEnd, String expectedDate) {
    int dateDebut = inverserFormatDate(dateBegin)

    int dateFin = inverserFormatDate(dateEnd)

    int dateAVerifier = inverserFormatDate(expectedDate)

    return (dateDebut <= dateAVerifier) && (dateAVerifier <= dateFin)
}

//Methode d'inversion de du format de tate ex: 12/03/2021 to 20210312
int inverserFormatDate(String date) {
    String jour = date.substring(0, 2)

    String mois = date.substring(3, 5)

    String annee = date.substring(6)

    String dateInverse = (annee + mois) + jour
	int inverseDate
		inverseDate = dateInverse.toInteger()
		return inverseDate
}


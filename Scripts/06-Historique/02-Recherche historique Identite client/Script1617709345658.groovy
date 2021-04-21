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
String dateDebutRecherche = '02/04/2021'

String dateFinRecherche = '02/04/2021'

String profilRechercher = 'samandari'

String dateDebutRecherche2='01/01/2021'

String dateFinRecherche2='01/04/2025'
'Se connecter a eRequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le menu Historique'
WebUI.click(findTestObject('Menu/Menu Historique'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu/Sous menu Historique/Menu Identite client'), 3)

'Cliquer sur le sous menu Requisition'
WebUI.click(findTestObject('Menu/Sous menu Historique/Menu Identite client'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Historique traitement appel/Liste deroulant profil'), 5)

'Vérifier que la page historique des traitements d\'appel s\'affiche avec les éléments suivants:\r\n- Liste déroulant Profil qui contient tous les utilisateur inscrits dans eRequisition\r\n- Champ date de début\r\n- Champ date de fin\r\n- Bouton Afficher'
WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Liste deroulant profil'), 3)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Requisition identite client/Champ date debut'), 3)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Requisition identite client/Champ date fin'), 3)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Bouton Afficher'), 3)

'Clique sur le bouton Afficher sans remplir les champs'
WebUI.click(findTestObject('Historique traitement appel/Bouton Afficher'))

WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Message d err date debut obligatoire'), 3)

'Vérifier la conformité du message d erreur qui s affiche en bas du champ date de debut'
WebUI.verifyElementText(findTestObject('Historique traitement appel/Message d err date debut obligatoire'), 'La date de début de période de la réquisition est obligatoire')

'Vérifier la conformité du message d erreur qui s affiche en bas du champ date de fin'
WebUI.verifyElementText(findTestObject('Historique traitement appel/Message d err date fin obligatoire'), 'La date de fin de période de la réquisition est obligatoire')

'Saisir une date de début supérieur à la date de fin'
WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition identite client/Champ date debut'), '19/02/2021')

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition identite client/Champ date fin'), '18/02/2021')

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

'Choisir un nom d\'utilisateur dans la liste déroulant'
WebUI.waitForElementVisible(findTestObject('Historique traitement appel/Option profil username'), 3)

//Recuperation de tous les options dans la lite déroulante
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
WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition identite client/Champ date debut'), dateDebutRecherche)

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition identite client/Champ date fin'), dateFinRecherche)

WebUI.click(findTestObject('Historique traitement appel/Champ Rechercher'))

'Cliquer sur le bouton Afficher'
WebUI.click(findTestObject('Historique traitement appel/Bouton Afficher'))

WebUI.delay(0.500)

WebUI.verifyElementPresent(findTestObject('Historique traitement appel/Requisition identite client/Date et heure traitement'), 
    0)

//Recuperation de la date dans la colonne date et heure du traitement
String dateTraitement = WebUI.getText(findTestObject('Historique traitement appel/Requisition identite client/Date et heure traitement'))

//Suppression de l' heure dans la chaine de date heure récuperer
dateTraitement = dateTraitement.substring(0, 10)

'Vérifier que le résultat dans le tableau retourne des réquisition du profil choisi et selon l\'interval de temp renseigné '
WebUI.verifyMatch(dateTraitement, dateDebutRecherche, false)

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Colonne utilisateur'), profilRechercher)

'Affichage des colonnes suivants:\r\n- Référence réquisition\r\n- Utilisateur\r\n- Information en entrée\r\n- Nombre\r\n- Date et heure traitement\r\n- Scan réquisition'
WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre colonne Reference requisition'), 
    'Référence réquisition')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition appel/Titre colonne Utilisateur'), 'Utilisateur')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition identite client/Titre Information en entree'), 
    'Information en entrée')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition identite client/Titre Information Nombre'), 
    'Nombre')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition identite client/Titre Date et heure traitement'), 
    'Date et heure traitement')

WebUI.verifyElementText(findTestObject('Historique traitement appel/Requisition identite client/Titre Information Scan requisition'), 
    'Scan réquisition')

'Choisir tous les profil dans la liste déroulante '
WebUI.click(findTestObject('Historique traitement appel/Liste deroulant profil'))

'Choisir tous les profil dans la liste déroulante '
WebUI.click(findTestObject('Historique traitement appel/Option Tous les profils'))

'Choisir tous les profil dans la liste déroulante '
WebUI.click(findTestObject('Historique traitement appel/Liste deroulant profil'))

'saisir une date de debut et date de fin valide'
WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition identite client/Champ date fin'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition identite client/Champ date fin'), dateFinRecherche2)

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition identite client/Champ date debut'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Historique traitement appel/Requisition identite client/Champ date debut'), dateDebutRecherche2)

WebUI.click(findTestObject('Historique traitement appel/Champ Rechercher'))

'Cliquer sur le bouton Afficher'
WebUI.click(findTestObject('Historique traitement appel/Bouton Afficher'))

'Saisir un mot cle de la recherche'
WebUI.sendKeys(findTestObject('Historique traitement appel/Champ Rechercher'), 'juliette')

WebUI.clearText(findTestObject('Historique traitement appel/Champ Rechercher'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(0.500)

WebUI.sendKeys(findTestObject('Historique traitement appel/Champ Rechercher'), 'juliette')

//Recuperer tous les resultats dans la colonne utilisateur
List<WebElement> colonneUtilisateur = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition appel/Colonne utilisateur'), 
    5)

for (def utilisateur : colonneUtilisateur) {
    String nomUtilisateur = utilisateur.getText()

    WebUI.verifyMatch(nomUtilisateur, 'juliette', false)
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

'Vérifier que la date est en bonne format'
List<WebElement>dateHeure = WebUiCommonHelper.findWebElements(findTestObject('Historique traitement appel/Requisition identite client/Date et heure traitement'),
	5)
for (def date:dateHeure){
	WebUI.verifyMatch(date.getText(), '^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$', true)
	String expectDate=(date.getText()).substring(0, 10)
	boolean isDateMatch=isDateBetween2Date(dateDebutRecherche2,dateFinRecherche2,expectDate)
	WebUI.verifyEqual(isDateMatch, true)
}

//Methode de verification si une date est comprise dans un interval (date de début et date de fin)

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
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

String dateDeRecherche = '03/03/2021'

String dateDeRechercheUser = '01/04/2021'

String userRechercher = GlobalVariable.loginUsernameAdmin

String login1eLigne = 'samandari'

String date1eLigne = '03/03/2021 09:50:06'

String param1eLigne = 'test1,Simple utilisateur'

String login2eLigne = 'juliette'

String date2eLigne = '03/03/2021 09:53:38'

String param2eLigne = 'admin , 01/02/2021 , 10/03/2021'

'Se connecter a ERequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu/Menu Suivi acces'), 5)

'Cliquer sur le menu Suivi acces'
WebUI.click(findTestObject('Menu/Menu Suivi acces'))

'Vérifier que La page  Suivi accès utilisateur s affiche avec les éléments suivants:\r\n- Liste déroulant affichant tous les utilisateurs inscrit dans eRequisition\r\n- Champ date de début\r\n- Champ date de fin\r\n- Bouton Afficher'
WebUI.verifyElementPresent(findTestObject('Suivi acces utilisateur/Liste deroulant profil'), 3)

WebUI.verifyElementPresent(findTestObject('Suivi acces utilisateur/Champ date debut'), 3)

WebUI.verifyElementPresent(findTestObject('Suivi acces utilisateur/Champ date fin'), 3)

WebUI.verifyElementPresent(findTestObject('Suivi acces utilisateur/Bouton Afficher'), 3)

'Cliquer sur le bouton afficher sans remplir les champs obligatoire'
WebUI.click(findTestObject('Suivi acces utilisateur/Bouton Afficher'))

'Vérifier qu un message d erreur apparait en bas des champs date debut et date de fin'
WebUI.waitForElementVisible(findTestObject('Suivi acces utilisateur/Message d err date debut obli'), 3)

WebUI.waitForElementVisible(findTestObject('Suivi acces utilisateur/Message d err date fin obli'), 3)

'Vérifier la conformité des message d erreur'
WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Message d err date debut obli'), 'La date de début du log est obligatoire')

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Message d err date fin obli'), 'La date de fin du log est obligatoire')

'Saisir une date de debut supérieur à la date de fin'
WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ date fin'), '18/03/2021')

WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ date debut'), '19/03/2021')

'Cliquer sur le bouton rechercher'
WebUI.click(findTestObject('Suivi acces utilisateur/Champ rechercher'))

WebUI.waitForElementVisible(findTestObject('Suivi acces utilisateur/Popin err/Message err date de debut superier'), 3)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Popin err/Message err date de debut superier'), 'La date de début devrait être avant la date fin.')

'Cliquer sur le bouton OK'
WebUI.click(findTestObject('Suivi acces utilisateur/Bouton Ok'))

'Cliquer sur le bouton OK'
WebUI.click(findTestObject('Suivi acces utilisateur/Liste deroulant profil'))

'Choisir un profil dans la liste déroulant'
List<WebElement> listProfil = WebUiCommonHelper.findWebElements(findTestObject('Suivi acces utilisateur/Liste profil utilisateur'), 
    5)

for (def profil : listProfil) {
    if (profil.getText().equals(userRechercher)) {
        profil.click()
    }
}

WebUI.click(findTestObject('Suivi acces utilisateur/Champ rechercher'))

'Saisir une date de debut et une date de fin'
WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ date fin'), dateDeRechercheUser)

WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ date debut'), dateDeRechercheUser)

WebUI.click(findTestObject('Suivi acces utilisateur/Champ rechercher'))

'Cliquer sur le bouton afficher'
WebUI.click(findTestObject('Suivi acces utilisateur/Bouton Afficher'))

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
    WebUI.verifyMatch(login.getText(), userRechercher, false)
}

'Vérifier que la date du resultat correspond à la date rechercher'
List<WebElement> listDate = WebUiCommonHelper.findWebElements(findTestObject('Suivi acces utilisateur/Tableau de resultat/Colonne Date'), 
    5)

for (def date : listDate) {
    WebUI.verifyMatch(date.getText(), ('.*(?i)' + dateDeRechercheUser) + '(?-i).*', true)
}

'Vérifier l affichage de l adresse IP'
List<WebElement> listIP = WebUiCommonHelper.findWebElements(findTestObject('Suivi acces utilisateur/Tableau de resultat/Colonne IP'), 
    5)

for (def ip : listIP) {
    WebUI.verifyMatch(ip.getText(), '^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$', true //verification avec format IP correcte
        )
}

'Choisir Tous les profils dans la liste déroulant'
for (def profil : listProfil) {
    if (profil.getText().equals('Tous les profils')) {
        profil.click()
    }
}

WebUI.click(findTestObject('Suivi acces utilisateur/Champ rechercher'))

WebUI.clearText(findTestObject('Suivi acces utilisateur/Champ date debut'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton OK'
WebUI.delay(0.500)

'Cliquer sur le bouton OK'
WebUI.click(findTestObject('Suivi acces utilisateur/Bouton Ok'))

WebUI.clearText(findTestObject('Suivi acces utilisateur/Champ date fin'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(0.500)

'Cliquer sur le bouton OK'
WebUI.click(findTestObject('Suivi acces utilisateur/Bouton Ok'))

WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ date debut'), dateDeRecherche)

'Saisir une date de debut et une date de fin'
WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ date fin'), dateDeRecherche)

WebUI.click(findTestObject('Suivi acces utilisateur/Champ rechercher'))

'Cliquer sur le bouton afficher'
WebUI.click(findTestObject('Suivi acces utilisateur/Bouton Afficher'))

WebUI.delay(0.500)

'Vérifier l affichage des résultats des activités du profil choisi et selon l\'interval de temp renseigné '
WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Login 1ere ligne'), login1eLigne)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Date 1ere ligne'), date1eLigne)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Parametre 1ere ligne'), param1eLigne)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Login 2eme ligne'), login2eLigne)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Date 2eme ligne'), date2eLigne)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Parametre 2eme ligne'), param2eLigne)

WebUI.sendKeys(findTestObject('Suivi acces utilisateur/Champ rechercher'), login2eLigne)

WebUI.delay(0.500)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Login 1ere ligne'), login2eLigne)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Date 1ere ligne'), date2eLigne)

WebUI.verifyElementText(findTestObject('Suivi acces utilisateur/Tableau de resultat/Parametre 1ere ligne'), param2eLigne)

WebUI.verifyElementNotPresent(findTestObject('Suivi acces utilisateur/Tableau de resultat/Login 2eme ligne'), 3)


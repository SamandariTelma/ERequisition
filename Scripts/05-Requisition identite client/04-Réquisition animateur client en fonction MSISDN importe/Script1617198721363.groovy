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

'Vérifier la présence des éléments suivant:\r\n- Titre: CHOIX DE L\'INPUT\r\n- Bouton radio  MSISDN (Séléctionner par défaut)\r\n- Bouton radio IMEI\r\n- Bouton radio Saisir (Séléctionner par défaut)\r\n- Bouton radio Importer\r\n- Champ de saisie numéro avec un bouton +\r\n- boutons Précedent, Suivant, annuler'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Titre Choix de l input'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout numero (icon plus)'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton radio IMEI'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton radio Importer'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton radio MSISDN'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton radio Saisir'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Champ de saisi numero'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton precedent'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton suivant'), 3)

'Cliquer sur le bouton icon plus sans avoir renseigner un msisdn'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout numero (icon plus)'))

'Vérifier l apparition du popin avec message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur ajout numero vide'), 
    3)

'Cliquer sur le bouton ok du popin'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

'Cliquer sur le bouton suivant sans avoir renseigner un msisdn'
WebUI.click(findTestObject('Bouton commun/bouton suivant'))

'Vérifier l apparition du popin avec message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur champ obli vide'), 
    3)

'Vérifier la conformité du message d erreur'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur champ obli vide'), 
    'Veuillez remplir les champs obligatoires et la liste des MSISDN ou IMEI à traiter ! !')

'Clique sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

'Saisir un msisdn dans le champ de saisi numéro'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton radio Importer'), FailureHandling.CONTINUE_ON_FAILURE)

'Verifier la presence du champ de telechargement msisdn'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Champ de telechargement msisdn csv'), 0)

'Telecharger le fichier avec un mauvais format msisdn'
WebUI.uploadFile(findTestObject('Nouvelle demande/Choix de l input/Champ de telechargement msisdn csv'), 'D:\\Utilisateurs\\samandari\\QA\\PROJET AUTOMATISATION\\E-REQUISITION\\JDD\\msisdnRequisition mauvais numero.csv')

'Vérifier l apparition du popin avec le message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur reverifier numero'), 
    3)

'Vérifier que le message d erreur est conforme'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur reverifier numero'), 
    'Revérifier le numéro 34000h0000')

'Clique sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

'Telecharger le fichier avec les bons format msisdn'
WebUI.uploadFile(findTestObject('Nouvelle demande/Choix de l input/Champ de telechargement msisdn csv'), 'D:\\Utilisateurs\\samandari\\QA\\PROJET AUTOMATISATION\\E-REQUISITION\\JDD\\msisdnRequisition.csv')

'Vérifier que le numero s affiche avec un icon corbeille'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero A'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute A'), 3)

'Vérifier que le numero affiché correspon au 1er numero dans le fichier'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute A'), '034' + GlobalVariable.msisdnATraiterA)

'Vérifier que le numero s affiche avec un icon corbeille'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero B'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute B'), 3)

'Vérifier que le numero affiché correspon au 2e numero dans le fichier'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute B'), '034' + GlobalVariable.msisdnATraiterB)

'Vérifier que le numero s affiche avec un icon corbeille'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero C'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute C'), 3)

'Vérifier que le numero affiché correspon au 3e numéro dans le fichier'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute C'), '034' + GlobalVariable.msisdnATraiterC)

'Cliquer sur le bouton corbeille du 3e numero'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero C'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier que le 3e numero n est plus present'
WebUI.verifyElementNotPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero C'), 3)

'Cliquer sur le bouton suivant '
WebUI.click(findTestObject('Bouton commun/bouton suivant'))

'Vérifier que la page d information apparait avec les éléments suivants:\r\n- Titre: INFORMATION OBLIGATOIRES\r\n- Champ de saisie N° Réquisition\r\n- Champ de Scan Réquisition\r\n- Bouton Précedent, Suivant, Annuler'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Information Obligatoires/Titre Information obligatoires'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Information Obligatoires/Champ numero requisition'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Information Obligatoires/Champ Scan Requisition'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton precedent'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton suivant'), 3)

'Clique sur le bouton suivant en laissant vide les champs'
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier l apparition du popin avec le message d erreur '
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Information Obligatoires/Popin err/Message d erreur information vide'), 
    3)

WebUI.click(findTestObject('Nouvelle demande/Information Obligatoires/Popin err/Bouton Ok'), FailureHandling.CONTINUE_ON_FAILURE)

//Generer une reference avec un nombre aléatoire
int i = Math.random() * (5000 - 1)

String nbrAleatoire = String.valueOf(i)

GlobalVariable.referenceRequisition = nbrAleatoire

'Saisir une reference de requisition'
WebUI.sendKeys(findTestObject('Nouvelle demande/Information Obligatoires/Champ numero requisition'), GlobalVariable.referenceRequisition)

'Scanner le fichier de requisition'
WebUI.uploadFile(findTestObject('Nouvelle demande/Information Obligatoires/Champ Scan Requisition'), 'D:\\Utilisateurs\\samandari\\QA\\PROJET AUTOMATISATION\\E-REQUISITION\\JDD\\Scan requisition.PNG')

'Cliquer sur le bouton suivant'
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

'La page d Options s\'affiche avec les éléments suivants:\r\n- Checbox Animateur\r\n- Checkbox Photo\r\n- Boutons Précédent, Lancer le traitement, Annuler'
WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton suivant'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton precedent'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Checkbox Animateur'), 
    3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Checkbox Photo'), 
    3)

'Cliquer sur le checkbox Photo'
WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Label Animateur'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier que le checkbox photo n est pas coché'
WebUI.verifyElementNotChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Checkbox Photo'), 
    3)

'Vérifier que le checkbox Animateur est coché'
WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition Identite client/Checkbox Animateur'), 
    3)

'Cliquer sur le bouton suivant'
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

//Recuperer la date courrant sous forme de dd/MM/yyy HH:mm
def date = new Date()

def sdf = new SimpleDateFormat('dd/MM/yyyy HH:mm')

String dateHeureTraitement = sdf.format(date)

'Vérifier qu on revient sur la Home page'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/encart historique d appels'), 10)

'Vérifier que la demande est bien ajoute dans l hitorique de requisition'
WebUI.callTestCase(findTestCase('05-Requisition identite client/00-Called Tests Case/Verification ajout requisition identite client en fonction MSISDN(CT appel)'), 
    [('dateHeureTraitement') : dateHeureTraitement], FailureHandling.CONTINUE_ON_FAILURE)


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

'Se connecter à ERequisition'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Connexion a ERequisition'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Nouvelle demande/encart historique d appels'), 10)

'Cliquer sur l encart historique d appels'
WebUI.click(findTestObject('Nouvelle demande/encart historique d appels'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier la présence du titre Type d appel'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Type d appel/Titre type d appel'), 5)

'Vérifier la conformité du description'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Type d appel/Description'), 'Sur cette version, vous pouvez choisir si vous voulez le type d\'appel par voix ou par SMS ou bien les deux. Merci de cocher l\'un des deux cas')

'Vérifier la présence des éléments suivant:\r\n- Checkbox Voix\r\n- Checkbox SMS\r\n- Bouton Annuler\r\n- Bouton Suivant\r\n- Bouton Precedent'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Type d appel/Checkbox SMS'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Type d appel/Checkbox Voix'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton precedent'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton suivant'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

'Cliquer sur le bouton annuler'
WebUI.click(findTestObject('Bouton commun/bouton annuler'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier l apparition de l encart historique d appels'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/encart historique d appels'), 3)

'Cliquer a nouveau sur l encart historique d appels'
WebUI.click(findTestObject('Nouvelle demande/encart historique d appels'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton suivant en laissant décoché les deux checkbox'
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier l appariton du popin avec un messsage d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Type d appel/Popin err/Message d erreur popin'), 3, FailureHandling.STOP_ON_FAILURE)

'Cliquer sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Type d appel/Popin err/bouton OK'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le checkbox SMS'
WebUI.click(findTestObject('Nouvelle demande/Type d appel/Label SMS'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier que Voix n est pas coché'
WebUI.verifyElementNotChecked(findTestObject('Nouvelle demande/Type d appel/Checkbox Voix'), 3)

'Vérifier que SMS est coché'
WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Type d appel/Checkbox SMS'), 3)

'Cliquer sur le bouton '
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier la présence du titre Sens d appel'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Sens d appel/Titre sens d appel'), 5)

'Vérifier la conformité du description'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Sens d appel/Description'), 'Sur cette version, vous pouvez choisir si vous voulez l\'historique des appels entrants ou des appels sortants ou bien les deux. Merci de cocher au moins un choix')

'Vérifier la présence des éléments suivant:\r\n- Checkbox Appels entrants\r\n- Checkbox Appels sortants\r\n- Bouton Annuler\r\n- Bouton Suivant\r\n- Bouton Precedent'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Sens d appel/Checkbox Appels entrants'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Sens d appel/Checkbox Appels sortants'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton precedent'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton suivant'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

'Cliquer sur le bouton suivant en laissant décoché les deux checkbox'
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier l appariton du popin avec un messsage d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Type d appel/Popin err/Message d erreur popin'), 3, FailureHandling.STOP_ON_FAILURE)

'Cliquer sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Type d appel/Popin err/bouton OK'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le checkbox Appels sortants'
WebUI.click(findTestObject('Nouvelle demande/Sens d appel/Label Appels sortants'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier que Appels sortants est coché'
WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Sens d appel/Checkbox Appels sortants'), 3)

'Vérifier que Appels entrants n est pas coché'
WebUI.verifyElementNotChecked(findTestObject('Nouvelle demande/Sens d appel/Checkbox Appels entrants'), 3)

'Cliquer sur le bouton '
WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

'(A enlever après la correction du bug)'
WebUI.waitForElementPresent(findTestObject('Nouvelle demande/Type d appel/Popin err/bouton OK'), 3)

WebUI.delay(0.500)

'(A enlever après la correction du bug)'
WebUI.click(findTestObject('Nouvelle demande/Type d appel/Popin err/bouton OK'), FailureHandling.CONTINUE_ON_FAILURE)

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

'Choisir l option IMEI'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton radio IMEI'))

'Vérifier l apparition du champ de saisi IMEI'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Champ de saisi IMEI'), 3)

'Vérifier la presence du bouton ajout imei icon plus'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout imei (icon plus)'), 3)

'Cliquer sur le bouton ajout IMEI en laissant vide le champ IMEI'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout imei (icon plus)'))

'Vérifier l apparition du popin avec message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur imei vide'), 3)

'Cliquer sur le bouton ok du popin'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

'Cliquer sur le bouton suivant sans avoir renseigner un imei'
WebUI.click(findTestObject('Bouton commun/bouton suivant'))

'Vérifier l apparition du popin avec message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur champ obli vide'), 
    3)

'Vérifier la conformité du message d erreur'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur champ obli vide'), 
    'Veuillez remplir les champs obligatoires et la liste des MSISDN ou IMEI à traiter ! !')

'Clique sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

'Saisir un imei puis cliquer sur le bouton ajouter'
WebUI.sendKeys(findTestObject('Nouvelle demande/Choix de l input/Champ de saisi IMEI'), GlobalVariable.imeiATraiterA)

'Cliquer sur le bouton d ajout imei'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout imei (icon plus)'))

'Vérifier que le numero s affiche avec un icon corbeille'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero A'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute A'), 3)

'Vérifier que l\'imeiaffiché correspon à l imei saisi'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute A'), GlobalVariable.imeiATraiterA)

'Saisir le même imei puis cliquer sur le bouton ajouter'
WebUI.sendKeys(findTestObject('Nouvelle demande/Choix de l input/Champ de saisi IMEI'), GlobalVariable.imeiATraiterA)

'Cliquer sur le bouton d ajout imei'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout imei (icon plus)'))

'Vérifier l apparition du popin avec le message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Popin err/Message d erreur imei existant'), 
    3)

'Clique sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

'Saisir un nouveau imei puis cliquer sur le bouton ajouter'
WebUI.sendKeys(findTestObject('Nouvelle demande/Choix de l input/Champ de saisi IMEI'), GlobalVariable.imeiATraiterB)

'Cliquer sur le bouton d ajout imei'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Bouton d ajout imei (icon plus)'))

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute B'), 3)

'Vérifier que l\'imeiaffiché correspon à l imei saisi'
WebUI.verifyElementText(findTestObject('Nouvelle demande/Choix de l input/Numero ajoute B'), GlobalVariable.imeiATraiterB)

'Vérifier que le numero s affiche avec un icon corbeille'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Choix de l input/Bouton de suppression numero B'), 3)

WebUI.scrollToElement(findTestObject('Bouton commun/bouton suivant'), 3)

'Cliquer sur le bouton suivant '
WebUI.click(findTestObject('Bouton commun/bouton suivant'))

'Vérifier la présence des éléménts suivantes:\r\n- Titre Periode de recherche\r\n- Champ Date de debut\r\n- Champ Date de fin\r\n- Bouton annuler, suivant, precedent'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Periode de recherche/Titre Periode de recherche'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Periode de recherche/Date de debut'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Periode de recherche/Date de fin'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton precedent'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton suivant'), 3)

'Cliquer sur le bouton suivant sans avoir renseigner les dates'
WebUI.click(findTestObject('Bouton commun/bouton suivant'))

'Vérifier l apparition du popin avec message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Periode de recherche/Popin err/Message d erreur date vide'), 
    3)

'Clique sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

'Saisir une date debut'
WebUI.sendKeys(findTestObject('Nouvelle demande/Periode de recherche/Date de debut'), '20/02/2021')

'Cliquer sur le bouton suivant'
WebUI.click(findTestObject('Bouton commun/bouton suivant'))

'Vérifier l apparition du popin avec message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Periode de recherche/Popin err/Message d erreur date vide'), 
    3)

'Clique sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

'Saisir une date de fin inférieur à la date de début '
WebUI.sendKeys(findTestObject('Nouvelle demande/Periode de recherche/Date de fin'), '19/02/2021')

WebUI.click(findTestObject('Nouvelle demande/Periode de recherche/Date de debut'))

'Vérifier l apparition du popin avec message d erreur'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Periode de recherche/Popin err/Message d erreur date debut sup date fin'), 
    3)

'Clique sur le bouton OK'
WebUI.click(findTestObject('Nouvelle demande/Choix de l input/Popin err/Bouton Ok'))

WebUI.clearText(findTestObject('Nouvelle demande/Periode de recherche/Date de fin'))

'Saisir une date de fin correcte puis valider'
WebUI.sendKeys(findTestObject('Nouvelle demande/Periode de recherche/Date de fin'), '21/02/2021')

WebUI.click(findTestObject('Bouton commun/bouton suivant'), FailureHandling.CONTINUE_ON_FAILURE)

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

'La page d Options s\'affiche avec les éléments suivants:\r\n- Checbox Localisation (coché par défaut)\r\n- Checkbox Photo du titulaire (coché par défaut)\r\n- Checkbox Tac (coché par défaut)\r\n- Boutons Précédent, Lancer le traitement, Annuler'
WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox Localisation'), 3)

WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox Photo du titulaire'), 3)

WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox tac'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Bouton Lancer le traitement'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton precedent'), 3)

WebUI.verifyElementPresent(findTestObject('Bouton commun/bouton annuler'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label Localisation'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label Photo du titulaire'), 3)

WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label tac'), 3)

'Décocher tous les checkbox'
WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label Localisation'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label Photo du titulaire'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label tac'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier que les checkbox sont décochés'
WebUI.verifyElementNotChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox Localisation'), 3)

WebUI.verifyElementNotChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox Photo du titulaire'), 3)

'Cocher tous les checkbox'
WebUI.verifyElementNotChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox tac'), 3)

WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label Localisation'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label Photo du titulaire'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Label tac'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier que tous les checkbox sont cochés'
WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox Localisation'), 3)

WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox Photo du titulaire'), 3)

WebUI.verifyElementChecked(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Checkbox tac'), 3)

'Cliquer sur le bouton Lancer le traitement'
WebUI.click(findTestObject('Nouvelle demande/Option d exploitation/Requisition appel/Bouton Lancer le traitement'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier qu on revient sur la Home page'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/encart historique d appels'), 10)

WebUI.callTestCase(findTestCase('03-Requisition appel type sms/00-Called Tests Case/Verification ajout requisition appel sortant de type sms en fonction IMEI(CT appel)'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)


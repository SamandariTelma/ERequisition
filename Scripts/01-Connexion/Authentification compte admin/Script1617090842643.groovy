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

'Ouvrir le navigateur'
WebUI.callTestCase(findTestCase('00-Called Tests Case/Ouvrir le navigateur'), [:], FailureHandling.STOP_ON_FAILURE)

' je me rends sur l\'Url d\'application : https://tapq466lv/requisition/'
WebUI.navigateToUrl(GlobalVariable.urlPreprod)

WebUI.waitForElementPresent(findTestObject('Login/Titre eRequisiton'), 10)

'Vérifier le titre de la page'
WebUI.verifyElementText(findTestObject('Login/Titre eRequisiton'), 'eRequisition')

'Je saisis correctement mon username et mon mot de passe et je clique sur "Connexion"'
WebUI.sendKeys(findTestObject('Login/Champ username'), GlobalVariable.loginUsernameAdmin)

WebUI.sendKeys(findTestObject('Login/Champ password'), GlobalVariable.loginPassword)

WebUI.click(findTestObject('Login/Bouton Connexion'))

WebUI.waitForElementPresent(findTestObject('Login/Popin Regle de confidentialite/Titre popin'), 3)

'Vérifier le titre du popin qui apparait'
WebUI.verifyElementText(findTestObject('Login/Popin Regle de confidentialite/Titre popin'), 'Règle de confidentialité')

'Vérifier le text qui mentionne la règle de confidentialité'
WebUI.verifyElementText(findTestObject('Login/Popin Regle de confidentialite/Regle de confidentialite'), 'En accédant à ce système d\'information et aux données qui y sont transmises/contenues, l\'utilisateur doit respecter la stricte confidentialité et neutralité des informations et du détail/du contenu des communications sur l\'ensemble du réseau.\n' + 
    'Le non-respect de ces obligations expose tout contrevenant (et complice) à des sanctions et poursuites.')

'Vérifier la présence du bouton annuler et valider'
WebUI.verifyElementPresent(findTestObject('Login/Popin Regle de confidentialite/Bouton Annuler'), 3)

WebUI.verifyElementPresent(findTestObject('Login/Popin Regle de confidentialite/Bouton Valider'), 3)

'Cliquer sur valider'
WebUI.click(findTestObject('Login/Popin Regle de confidentialite/Bouton Valider'),FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Nouvelle demande/Titre page Nouvelle demande'), 10)

'Vérifier que l utilisateur est connecté et voit la page nouvelle demande'
WebUI.verifyElementPresent(findTestObject('Nouvelle demande/Titre page Nouvelle demande'), 3)

'Vérifier les élements de la page nouvelle demande'
WebUI.verifyElementText(findTestObject('Nouvelle demande/encart historique d appels'), 'Historique\nd\'appels')

WebUI.verifyElementText(findTestObject('Nouvelle demande/encart Identite client'), 'Identité\nclient')

WebUI.verifyElementText(findTestObject('Nouvelle demande/encart MVola'), 'MVola')

WebUI.verifyElementText(findTestObject('Nouvelle demande/encart MSSISDN IMEI'), 'MSISDN/IMEI')

'Vérifier la présence des menus'
WebUI.verifyElementPresent(findTestObject('Menu/Menu Nouvelle demande'), 3)

WebUI.verifyElementPresent(findTestObject('Menu/Menu Historique'), 3)

WebUI.verifyElementPresent(findTestObject('Menu/Menu Administration'), 3)

WebUI.verifyElementPresent(findTestObject('Menu/Menu Suivi acces'), 3)

WebUI.verifyElementPresent(findTestObject('Menu/Menu Monitoring'), 3)


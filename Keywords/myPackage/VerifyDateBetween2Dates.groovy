package myPackage

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class VerifyDateBetween2Dates {

	@Keyword
	def isDateBetween2Date(String dateBegin, String dateEnd, String expectedDate) {
		int dateDebut = inverserFormatDate(dateBegin)

		int dateFin = inverserFormatDate(dateEnd)

		int dateAVerifier = inverserFormatDate(expectedDate)

		WebUI.verifyEqual(true, (dateDebut <= dateAVerifier) && (dateAVerifier <= dateFin))
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
}

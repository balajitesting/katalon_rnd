import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.xmlbeans.impl.store.Locale.domNthCache as domNthCache
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.comment('Run ENT-6485')


'DE1 TC Execution'
CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

String orDE1 = 'LIMS/DE1/'

WebUI.click(findTestObject(orDE1 + 'Page_Iteration/td_Accession Clinical'))

String barCode = CustomKeywords.'com.gh.core.TestUtil.getRandom'()

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_trfbarcode'), barCode)

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_trfversion'), 'TST-TRF-001 V7')

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_trackingno'), CustomKeywords.'com.gh.core.TestUtil.getRandom'())

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_tubebarcode01'), barCode)

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_tubebarcode02'), barCode)

WebUI.setText(findTestObject('LIMS/DE1/Page_Iteration/input_tubebarcode03'), barCode)

WebUI.setText(findTestObject('LIMS/DE1/Page_Iteration/input_tubebarcode04'), barCode)

String date = CustomKeywords.'com.gh.core.TestUtil.setDate'()

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_bloodcolldate'), date)

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_noofpages'), '2')

WebUI.click(findTestObject('Object Repository/LIMS/DE1/Page_Iteration/FollowofReasonBtn'))

WebUI.switchToWindowIndex(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/LIMS/DE1/Page_Iteration/CheckPlasmaHold'))

WebUI.click(findTestObject('Object Repository/LIMS/DE1/Page_Iteration/Saveplasmacheck'))

WebUI.switchToWindowIndex(0)

WebUI.scrollToPosition(430, 662)

WebUI.click(findTestObject(orDE1 + 'Page_Iteration/input_searchbutton'))

WebUI.switchToWindowTitle('')

WebUI.setText(findTestObject('Portal/page_inprogressreport/inputlastnamesearch'), 'leyland')

WebUI.click(findTestObject(orDE1 + 'Page_/input_Search'))

WebUI.click(findTestObject(orDE1 + 'Page_/input_cb'))

WebUI.switchToDefaultContent()

WebUI.setText(findTestObject(orDE1 + 'Page_Iteration/input_secsearchstr'), 'sqa')

WebUI.click(findTestObject(orDE1 + 'Page_Iteration/input_searchbuttonsr'))

WebUI.switchToDefaultContent()

WebUI.scrollToElement(findTestObject(orDE1 + 'Page_Iteration/input_saveAccession01'), 15)

CustomKeywords.'com.gh.core.JSHandler.JClick'(findTestObject('LIMS/DE1/Page_Iteration/input_saveAccession01'), 15)

aNumber = WebUI.getAttribute(findTestObject(orDE1 + 'Page_Iteration/input_requestid'), 'value')

println(aNumber)

WebUI.waitForElementPresent(findTestObject('LIMS/logout/img'), 15)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

'DE2 TC Execution'
CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/td_Second DataEntry'))

WebUI.setText(findTestObject('LIMS/DE2/Page_Patient Data Entry List/input_searchtext'), aNumber)

WebUI.click(findTestObject('LIMS/DE2/Page_Patient Data Entry List/td_OK'))

Thread.sleep(2000)

WebUI.click(findTestObject('LIMS/DE2/Page_Patient Data Entry List/img_edit'))

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patmon'), 'JAN')

WebUI.setText(findTestObject('LIMS/DE1/Page_Iteration/input_patfname'), 'Katalon')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patlname'), 'Test')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patday'), '11')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patyear'), '1990')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_pataddr1'), '123 Test Drive')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_pataddr2'), 'Apt #501')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patcity'), 'Redwood City')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/img_statelookup'))

WebUI.switchToWindowTitle('')

WebUI.click(findTestObject('LIMS/DE2/Page_/input_cb'))

WebUI.switchToDefaultContent()

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patzip'), '94040')

WebUI.setText(findTestObject('/LIMS/DE2/Page_Iteration/input_patphone'), '650-123-4567')

WebUI.setText(findTestObject('/LIMS/DE2/Page_Iteration/input_patemail'), 'gxu@guardanthealth.com')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patmrn'), '0123456789')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_patcustpatientid'), '0123456789')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_treatmentnotes'), 'Notes')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_pathreporttype'), 'TestType')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/input_patientgender'))

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_diagnosisdate'), '01/02/2018')

WebUI.setText(findTestObject('LIMS/DE2/Page_Iteration/input_otherdiagnosis'), 'Test')

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/table_Patient Contact Permissi'))

WebUI.setText(findTestObject('/LIMS/DE2/Page_Iteration/input_priorgenotypingdetail'), 'Test detail')

WebUI.click(findTestObject('LIMS/DE1/Page_Iteration/input_isprogrssingonrx'))

WebUI.click(findTestObject('LIMS/DE2/Page_Iteration/save_btn'))

WebUI.acceptAlert()

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 15)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

'Verifying in Progress report for created Accession id in portal'
CustomKeywords.'com.gh.portal.Common.switchToPortal'('brian.leylandjones@avera.org', 'Pa22word', aNumber, 300)

'ResolveProblemTestCase Execution'
CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Iteration/td_sitemap_TramStopSelCell'))

WebUI.setText(findTestObject('Object Repository/LIMS/Problem Resolution/Page_Problem Cases Resolution/input_searchtext'), 
    aNumber)

WebUI.click(findTestObject('LIMS/Problem Resolution/Page_Problem Cases Resolution/td_OK'))

edit = 'LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'

CustomKeywords.'com.gh.lims.Common.setClick'(edit)

WebUI.switchToFrame(findTestObject('LIMS/Problem Resolution/Sub_eSign/iframe'), 10)

WebUI.selectOptionByValue(findTestObject('LIMS/Problem Resolution/Sub_eSign/select_ActiveResolvedNA'), 'Resolved', true)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

WebUI.switchToFrame(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Frame'), 10)

Thread.sleep(2000)

WebUI.setText(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Password'), 'abcd1234')

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Dropdown_Btn'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_Select_Reason'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/eSign_OK'))

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

rtl = 'LIMS/Problem Resolution/returnToList/div_Return To List'

CustomKeywords.'com.gh.lims.Common.setClick'(rtl)

WebUI.waitForElementPresent(findTestObject('LIMS/logout/img'), 15)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

'Verifying in Progress report for created Accession id in portal'
CustomKeywords.'com.gh.portal.Common.switchToPortal'('brian.leylandjones@avera.org', 'Pa22word', aNumber, 3)

'DataVerificationWithProblemCase Execution'
CustomKeywords.'com.gh.lims.Common.logon'('abaca', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/DV1/Page_Iteration/td_Data Verification'))

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/DV1/Page_Data Verification Request List/a_GHDVSearch'), 
    20)

WebUI.click(findTestObject('Object Repository/LIMS/DV1/Page_Data Verification Request List/a_GHDVSearch'))

Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/LIMS/DV1/Page_Data Verification Request List/input_GHDVSearch_arg1'), aNumber)

WebUI.click(findTestObject('Object Repository/LIMS/DV1/Page_Iteration/search_btn_ok'))

edit = 'LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'

CustomKeywords.'com.gh.lims.Common.setClick'(edit)

WebUI.waitForElementVisible(findTestObject('LIMS/Problem Resolution/Sub_eSign/iframe'), 10)

WebUI.switchToFrame(findTestObject('LIMS/Problem Resolution/Sub_eSign/iframe'), 10)

WebUI.click(findTestObject('LIMS/DV1/Page_DV Check/input_pr0_u_dvcheck'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/DV1/eSign/iFrame'), 10)

Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/LIMS/DV1/eSign/password'), 'abcd1234')

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/dropdown_Btn'))

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/select_Reason'))

WebUI.click(findTestObject('Object Repository/LIMS/DV1/eSign/eSign_OK'))

WebUI.switchToDefaultContent()

rtl = 'LIMS/DV1/Page_DV Check/div_Return To List'

WebUI.waitForElementPresent(findTestObject(rtl), 10)

CustomKeywords.'com.gh.core.JSHandler.J2Click'(findTestObject(rtl), 10)

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 10)

CustomKeywords.'com.gh.core.JSHandler.JClick'(findTestObject('LIMS/logout/img'), 10)

WebUI.closeBrowser()

'Verifying in Progress report for created Accession id in portal'
CustomKeywords.'com.gh.portal.Common.switchToPortal'('brian.leylandjones@avera.org', 'Pa22word', aNumber, 0)

'DV2WithProblemCase Execution'
CustomKeywords.'com.gh.lims.Common.logon'('CLIAUserDagmar', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('Object Repository/LIMS/DV2/Page_Iteration/td_DV-2 Requests'))

WebUI.waitForPageLoad(2)

Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/LIMS/DV2/Page_DV2 Request List/input_GHDV2Search_arg1'), aNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/LIMS/DV2/Page_DV2 Request List/td_OK'), 10)

WebUI.click(findTestObject('Object Repository/LIMS/DV2/Page_DV2 Request List/td_OK'))

edit = 'LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'

//CustomKeywords.'com.gh.lims.Common.setClick'(edit)
Thread.sleep(3000)

WebUI.click(findTestObject(edit))

WebUI.switchToFrame(findTestObject('LIMS/Problem Resolution/Sub_eSign/iframe'), 10)

WebUI.click(findTestObject('LIMS/DV2/Page_DV2/input_pr0_u_dv2check'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('LIMS/Problem Resolution/Sub_eSign/img'))

WebUI.switchToFrame(findTestObject('Object Repository/LIMS/DV2/eSign/iFrame'), 10)

Thread.sleep(2000)

WebUI.setText(findTestObject('Object Repository/LIMS/DV2/eSign/password'), 'abcd1234')

WebUI.click(findTestObject('Object Repository/LIMS/DV2/eSign/dropdown_Btn'))

WebUI.click(findTestObject('Object Repository/LIMS/DV2/eSign/select_Reason'))

WebUI.click(findTestObject('Object Repository/LIMS/DV2/eSign/eSign_OK'))

WebUI.switchToDefaultContent()

//Thread.sleep(3000)

//WebUI.click(findTestObject('LIMS/DCO/Report/Page_All Requests/returnToList'))

rtl = 'LIMS/DV1/Page_DV Check/div_Return To List'

WebUI.waitForElementPresent(findTestObject(rtl), 10)

CustomKeywords.'com.gh.core.JSHandler.J2Click'(findTestObject(rtl), 10)

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 10)

CustomKeywords.'com.gh.core.JSHandler.JClick'(findTestObject('LIMS/logout/img'), 10)

WebUI.closeBrowser()

'Verifying in Progress report for created Accession id in portal'
CustomKeywords.'com.gh.portal.Common.switchToPortal'('brian.leylandjones@avera.org', 'Pa22word', aNumber, 0)

'BillingWithProblemCase Execution'
CustomKeywords.'com.gh.lims.Common.logon'('abaca', '5Ed5CIkj9UQfaMZXAkDVaQ==')

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/td_Billing'))

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/Search/input_searchtext'), aNumber)

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/Search/td_OK'))

edit = 'LIMS/Problem Resolution/Page_Problem Cases Resolution/div_Edit'

CustomKeywords.'com.gh.lims.Common.setClick'(edit)

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_icdcode01'), '123543')

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_icdcode02'), '34562')

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_icdcode03'), '1236543')

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_billingverified'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_abnstatus'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_releventnsclc'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_patientmedstatus'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_patientbenefitsauthoriza'))

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_button'))

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/primary_payor'))

WebUI.switchToDefaultContent()

WebUI.setText(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_subscriberid_p'), '23145')

WebUI.click(findTestObject('LIMS/DataEntryBilling/Billing/EditScreen/input_save'))

WebUI.waitForElementPresent(findTestObject('Object Repository/LIMS/logout/img'), 15)

WebUI.click(findTestObject('LIMS/logout/img'))

WebUI.closeBrowser()

'Verifying in Progress report for created Accession id in portal'
CustomKeywords.'com.gh.portal.Common.switchToPortal'('brian.leylandjones@avera.org', 'Pa22word', aNumber, 0)

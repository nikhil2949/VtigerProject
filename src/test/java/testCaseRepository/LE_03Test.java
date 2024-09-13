package testCaseRepository;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseClasss;
import genericLibrary.ExcelUtility;
import pomClasses.CreatingNewLeadPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;
@Listeners(genericLibrary.ListenersImplementationClass.class)
public class LE_03Test extends BaseClasss {

	@Test(groups= {"Smoke","Regression"})
	public void LE_03() throws Exception {
		ExcelUtility eutil = new ExcelUtility();
		String fname = eutil.readDataFromExcel("Leads", 7, 1);
		String lname = eutil.readDataFromExcel("Leads", 7, 2);
		String company = eutil.readDataFromExcel("Leads", 7, 3);
		String title = eutil.readDataFromExcel("Leads", 7, 4);
		String phone = eutil.readDataFromExcel("Leads", 7, 5);
		String mobile = eutil.readDataFromExcel("Leads", 7, 6);
		String email = eutil.readDataFromExcel("Leads", 7, 7);
		String noOfEmployees = eutil.readDataFromExcel("Leads", 7, 8);
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp = new LeadsPage(driver);
		lp.clickOnCreateLeadIcon();
		CreatingNewLeadPage clp = new CreatingNewLeadPage(driver);
		clp.createLead(fname, lname, company, title, phone, mobile, email, noOfEmployees);
		System.out.println("LE_03 Execution Successfull!!");

	}
}

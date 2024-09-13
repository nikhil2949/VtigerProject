package testCaseRepository;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseClasss;
import genericLibrary.ExcelUtility;
import pomClasses.CreatingNewLeadPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;
@Listeners(genericLibrary.ListenersImplementationClass.class)
public class LE_02Test extends BaseClasss {
	@Test(groups= {"Regression"})
	public void le02_TC() throws Exception {
		ExcelUtility eutil = new ExcelUtility();
		String fname = eutil.readDataFromExcel("Leads", 4, 1);
		String lname = eutil.readDataFromExcel("Leads", 4, 2);
		String company = eutil.readDataFromExcel("Leads", 4, 3);
		String title = eutil.readDataFromExcel("Leads", 4, 4);
		String phone = eutil.readDataFromExcel("Leads", 4, 5);
		String mobile = eutil.readDataFromExcel("Leads", 4, 6);
		String email = eutil.readDataFromExcel("Leads", 4, 7);
		String noOfEmployees = eutil.readDataFromExcel("Leads", 4, 8);
		String street = eutil.readDataFromExcel("Leads", 4, 9);
		String poBox = eutil.readDataFromExcel("Leads", 4, 10);
		String postalCode = eutil.readDataFromExcel("Leads", 4, 11);
		String city = eutil.readDataFromExcel("Leads", 4, 12);
		String country = eutil.readDataFromExcel("Leads", 4, 13);
		String state = eutil.readDataFromExcel("Leads", 4, 14);
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp = new LeadsPage(driver);
		lp.clickOnCreateLeadIcon();
		CreatingNewLeadPage clp = new CreatingNewLeadPage(driver);
		clp.createLead(fname, lname, company, title, phone, mobile, email, noOfEmployees, street, poBox, postalCode,
				city, country, state);
		System.out.println("le02_TC execution succesfull!!");
	}
}

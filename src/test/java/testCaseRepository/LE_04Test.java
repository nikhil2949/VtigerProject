package testCaseRepository;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseClasss;
import genericLibrary.ExcelUtility;
import pomClasses.CreatingNewLeadPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;
@Listeners(genericLibrary.ListenersImplementationClass.class)
public class LE_04Test extends BaseClasss {
	@Test(groups= {"Sanity"})
	public void LE_03() throws Exception {
		ExcelUtility eutil = new ExcelUtility();
		String fname = eutil.readDataFromExcel("Leads", 10, 1);
		String lname = eutil.readDataFromExcel("Leads", 10, 2);
		String company = eutil.readDataFromExcel("Leads", 10, 3);
		String title = eutil.readDataFromExcel("Leads", 10, 4);
		String street = eutil.readDataFromExcel("Leads", 10, 5);
		String poBox = eutil.readDataFromExcel("Leads", 10, 6);
		String city = eutil.readDataFromExcel("Leads", 10, 7);
		String country = eutil.readDataFromExcel("Leads", 10, 8);
		String state = eutil.readDataFromExcel("Leads", 10, 9);

		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp = new LeadsPage(driver);
		lp.clickOnCreateLeadIcon();
		CreatingNewLeadPage clp = new CreatingNewLeadPage(driver);
		clp.createLead(fname, lname, company, street, poBox, state, city, country, state);
		System.out.println("LE_04 Execution Successfull!!");

	}
}

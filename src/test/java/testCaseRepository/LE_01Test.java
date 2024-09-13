package testCaseRepository;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseClasss;
import genericLibrary.ExcelUtility;
import pomClasses.CreatingNewLeadPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;
@Listeners(genericLibrary.ListenersImplementationClass.class)
public class LE_01Test extends BaseClasss {
	@Test//(groups= {"Smoke"})
	public void le_01TC() throws Exception {
		ExcelUtility eutil = new ExcelUtility();
		String fname = eutil.readDataFromExcel("Leads", 1, 1);
		String lname = eutil.readDataFromExcel("Leads", 1, 2);
		String company = eutil.readDataFromExcel("Leads", 1, 3);
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lp = new LeadsPage(driver);
		lp.clickOnCreateLeadIcon();
		CreatingNewLeadPage clp = new CreatingNewLeadPage(driver);
		clp.createLead(fname, lname, company);
		System.out.println("le_01TC execution successfull!!");
	}
}

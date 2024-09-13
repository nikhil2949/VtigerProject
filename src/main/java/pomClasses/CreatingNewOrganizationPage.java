package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNameTextfield;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteTextfield;
	
	@FindBy(xpath="//input[@name='employees']")
	private WebElement employeesTextfield;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneNumberTextfield;
	
	@FindBy(xpath="//input[@name='otherphone']")
	private WebElement otherPhoneNumberTextfield;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextfield;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billingAddressTextfield;
	
	@FindBy(xpath="//input[@name='bill_city']")
	private WebElement billingCityTextfield;
	
	@FindBy(xpath="//input[@name='bill_state']")
	private WebElement billingStateTextfield;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationNameTextfield() {
		return organizationNameTextfield;
	}

	public WebElement getWebsiteTextfield() {
		return websiteTextfield;
	}

	public WebElement getEmployeesTextfield() {
		return employeesTextfield;
	}

	public WebElement getPhoneNumberTextfield() {
		return phoneNumberTextfield;
	}

	public WebElement getOtherPhoneNumberTextfield() {
		return otherPhoneNumberTextfield;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getBillingAddressTextfield() {
		return billingAddressTextfield;
	}

	public WebElement getBillingCityTextfield() {
		return billingCityTextfield;
	}

	public WebElement getBillingStateTextfield() {
		return billingStateTextfield;
	}
	/**
	 * This is a buisness library for creating new organization
	 */
	public void createOrganization(String orgName,String website,String employees)
	{
		getOrganizationNameTextfield().sendKeys(orgName);
		 getWebsiteTextfield().sendKeys(website);
		 getEmployeesTextfield().sendKeys(employees);
	}
}

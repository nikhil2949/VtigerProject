package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameTextfield;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextfield;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement titleTextfield;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	public WebElement getTitleTextfield() {
		return titleTextfield;
	}
	/**
	 * this is a business library for creating new contact
	 */
	public void createContact(String firstName,String lastName,String title)
	{
		getFirstNameTextfield().sendKeys(firstName);
		getLastNameTextfield().sendKeys(lastName);
		getTitleTextfield().sendKeys(title);
	}
}

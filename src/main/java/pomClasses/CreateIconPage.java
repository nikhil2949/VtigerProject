package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateIconPage {
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createicon;
public CreateIconPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getCreateicon() {
	return createicon;
}
/*
 * This is a business library to perform Creation operation of respective module
 */
public void createIcon()
{
	getCreateicon().click();
}
}

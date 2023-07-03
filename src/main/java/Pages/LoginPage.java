package Pages;

import org.openqa.selenium.By;

import com.cs.Enum.WaitTypes;
import com.cs.Utilis.SeleniumUtils;

public final class LoginPage {
	//locators
	private static final By TXT_USERNAME=By.name("username");
	private static final By TXT_PASSWORD=By.name("password");
	private final static By BTN_LOGIN    = By.xpath("//button[@type='submit']");
	
	//methods
	private LoginPage setUserName(String userName)
	{
		SeleniumUtils.sendKeys(TXT_USERNAME, userName,WaitTypes.VISIBLE,"userName");
		
		return this;
		
	}
	private LoginPage setPassword(String password)
	{
		SeleniumUtils.sendKeys(TXT_PASSWORD, password, WaitTypes.PRESENCE,"password");
		return this;
	}
	private HomePage clickLoginBtn()
	{
		SeleniumUtils.click(BTN_LOGIN, WaitTypes.CLICKABLE,"Login Button");

		return new HomePage();
	}
	
	public HomePage loginAppl(String userName,String password)
	{
		return setUserName(userName)
				.setPassword(password)
				.clickLoginBtn();     // method chaining
	}

}




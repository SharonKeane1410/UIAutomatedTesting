package com.example;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//@Location("https://vhslsqwdwd.sls.rot.hec.sap.biz/gs.com~com~gs~sls~bpo~ui~proj~create_prod~web/index.html")

@Location("")

public class CreateProductTranslationRunner {

	@Drone private WebDriver driver;  

	public void setup() {
//		driver.manage().window().maximize(); //no longer supported
		
	}
	
	//find project name field
	@FindBy(id="create_prod_view--prog_name-inner")
	private WebElement projectNameField;
	//find check project name button
	@FindBy(id="create_prod_view--View1_Button_check-content")
	private WebElement checkButton;
	//find button id
	@FindBy(xpath="//button")
	private WebElement projectCreateYesButton;

	//enter project name, check if name exists and create
	public String createPojectName(String newProjectName) throws Exception {
		//System.out.println ("Project " + newProjectName + " created");
		sendText (projectNameField, newProjectName);
		performClick (checkButton);
		performClick (projectCreateYesButton);
		Thread.sleep(1000);
		return newProjectName;
	}

	public void performClick(WebElement element) throws Exception{
		Graphene.waitGui().until().element(element).is().visible();
		element.click();
		Thread.sleep(1000);
	}

	public void sendText(WebElement element, String text) throws Exception{
		Graphene.waitGui().until().element(element).is().visible();
		element.clear();
		element.sendKeys(text);
		Thread.sleep(1000);
	} 
}

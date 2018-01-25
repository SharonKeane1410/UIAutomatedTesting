package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.testng.Arquillian;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
 
@RunAsClient
public class ProductSuite extends Arquillian{

	public String date;
	public String projectname;
	public int noOfSubProjects = 3;
	//creates a unique project name string using current date 
	//ie: PRODUCT_AutomatedTest_20170817103054 
	public void createUniqueStringDate() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmss");
		date = ft.format(dNow);
	}
	@BeforeSuite(alwaysRun = true)
	public void suiteSetup(){
		createUniqueStringDate();
	}

	//Creates a Product Translation project
	@Test(dataProvider = Arquillian.ARQUILLIAN_DATA_PROVIDER,priority=0)
	public void CreateProductTranslation(@InitialPage CreateProductTranslationRunner CreateProdTrans) throws Exception {
		System.out.println("Creating Product Project... ");
		CreateProdTrans.setup();
		projectname = CreateProdTrans.createPojectName("PRODUCT_AutomatedTest_" +date);
		System.out.println("Project Creation Completed ");
	}
}

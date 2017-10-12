package StepDefinition;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;

public class StepDefinition {
	public WebDriver driver;
	@Given("^Open the browser$")
	public void open_the_browser() throws IOException, AWTException {
	   System.setProperty("webdriver.chrome.driver", "/Users/tatralab/Documents/Drivers/chromedriver");
	   
		//System.setProperty("webdriver.gecko.driver", "/Users/tatralab/Documents/Drivers/geckodriver");
		//driver=new FirefoxDriver();
	   ChromeOptions chromeOptions = new ChromeOptions();
	   chromeOptions.addArguments("--headless");
	   driver=new ChromeDriver(chromeOptions);
	   TestRecorder.StartTestRecording();
	   String currentwindowhandle=driver.getWindowHandle();
	   driver.switchTo().window(currentwindowhandle);
	   driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);	   
	}

	@Given("^User navigates to 'http://qc.ionhands-sa.com/'$")
	public void user_navigates_to_http_www_ionhands_sa_com()  {
		driver.get("http://qc.ionhands-sa.com/");
		driver.manage().window().setSize(new Dimension(2000, 768));
	}
	
	@Given("^User clicks at Login link$")
	public void user_clicks_at_Login_link() throws InterruptedException  {
	  Thread.sleep(3000);
	  driver.findElement(By.className("navbar-nav")).findElements(By.tagName("li")).get(1).findElement(By.tagName("a")).click();
	   
	}
	
	@Given("^Close the browser$")
	public void close_the_browser() throws IOException, AWTException, InterruptedException {
	    driver.quit();
	    Thread.sleep(3000);
	    TestRecorder.EndTestRecording();
	}

	@Given("^The system will open Login page successfully$")
	public void the_system_will_open_Login_page_successfully() {
	Assert.assertTrue(driver.findElement(By.className("login-logo")).isDisplayed());
	}

	@Given("^User enters incorrect username and password$")
	public void user_enters_incorrect_username_and_password(){
	   driver.findElement(By.xpath("//input[@id='txtLoginId']")).sendKeys("supadmin@ionhands.com");
	   driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("123456");	   
	}

	@Given("^User clicks Login button$")
	public void user_clicks_Login_button()  {
	   driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
	}

	@Given("^The system will give a validation incorrect credentials$")
	public void the_system_will_give_a_validation_incorrect_credentials() {
	Assert.assertTrue(driver.findElement(By.className("errorMessage")).isDisplayed());
	}
	
	@Given("^User enters correct username and password$")
	public void user_enters_correct_username_and_password()  {	
		driver.findElement(By.xpath("//input[@id='txtLoginId']")).clear();
		driver.findElement(By.xpath("//input[@id='txtLoginId']")).sendKeys("supadmin@ionhands.com");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Admin@123");	  	   
	}
	
	@Given("^The system will login the user to his dashboard as well$")
	public void the_system_will_login_the_user_to_his_dashboard_as_well() {
	   Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Dashboard"));
	}
	
	@Given("^Click 'Forgot Password' link$")
	public void click_Forgot_Password_link() throws InterruptedException {
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[@id='lnkBtnForgotPassword']")).click();
	}

	@Given("^Forgot password page opens as well$")
	public void forgot_password_page_opens_as_well() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Forgot Password"));
	}

	@Given("^Enter valid Email address$")
	public void enter_valid_Email_address() {
	    driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("supadmin@ionhands.com");
	}

	@Given("^Click Submit$")
	public void click_Submit()  {
	    driver.findElement(By.xpath("//input[@id='btnForgotPassword']")).click();
	}
	
	@Given("^Email will be sent as well$")
	public void email_will_be_sent_as_well() {
	   Assert.assertTrue(driver.findElement(By.className("successMessage")).getText().equalsIgnoreCase("Your new password have been emailed to you. Please check your mail."));
	}
	
	@Given("^User clicks on Help link$")
	public void user_clicks_on_Help_link() {
	   driver.findElement(By.className("ico-cogs")).click();
	   driver.findElement(By.partialLinkText("Help")).click();
	}

	@Given("^Help link opens as well$")
	public void help_link_opens_as_well() {
	    Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Help"));
	}

	@Given("^User clicks on About us link$")
	public void user_clicks_on_About_us_link()  {
		driver.findElement(By.className("ico-cogs")).click();
	    driver.findElement(By.partialLinkText("About Us")).click();
	}

	@Given("^About us link opens as well$")
	public void about_us_link_opens_as_well() {
		Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("About Us"));
	}

	@Given("^User clicks on Edit Profile link$")
	public void user_clicks_on_Edit_Profile_link()  {
		driver.findElement(By.className("ico-cogs")).click();
	    driver.findElement(By.partialLinkText("Edit Profile")).click();
	}

	@Given("^Edit Profile link opens as well$")
	public void edit_Profile_link_opens_as_well() {
		Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Edit Profile"));
	}

	@Given("^User changes name and Contact No$")
	public void user_changes_name_and_Contact_No() {
	    driver.findElement(By.xpath("//input[@id='masterContentBodyContainer_txtFirstName']")).clear();
	    driver.findElement(By.xpath("//input[@id='masterContentBodyContainer_txtFirstName']")).sendKeys("Super Admin");
	    driver.findElement(By.xpath("//input[@id='masterContentBodyContainer_txtMobileNo']")).clear();
	    driver.findElement(By.xpath("//input[@id='masterContentBodyContainer_txtMobileNo']")).sendKeys("11111111111");
	    driver.findElement(By.id("masterContentBodyContainer_txtPassword")).sendKeys("Admin@123");
	    driver.findElement(By.id("masterContentBodyContainer_txtConfirmPassword")).sendKeys("Admin@123");
	}

	@Given("^User clicks Submit$")
	public void user_clicks_Submit()  {
	  driver.findElement(By.id("masterContentBodyContainer_btnSubmit")).click();
	}

	@Given("^Changes done successfully$")
	public void changes_done_successfully() throws InterruptedException {
		Thread.sleep(2000);
	   Assert.assertTrue(driver.findElement(By.id("lblMessage")).getText().contains("Your profile has been successfully updated!"));
	}

	@Given("^User clicks on Logout link$")
	public void user_clicks_on_Logout_link() throws InterruptedException  {
		Thread.sleep(3000);
		driver.findElement(By.className("ico-cogs")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
	}

	@Given("^User logs out successfully$")
	public void user_logs_out_successfully() throws InterruptedException  {
	   Thread.sleep(4000);		
	   Assert.assertTrue(driver.getPageSource().contains("Request a demo"));  
	}
	
	@Given("^user clicks on Hospitals link from side pane$")
	public void user_clicks_on_Hospitals_link_from_side_pane() throws InterruptedException, IOException {
	   driver.navigate().refresh();
	   Thread.sleep(5000);
	   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
	   driver.findElement(By.id("liSuperAdmin")).findElement(By.tagName("a")).click();
	}

	@Given("^Hospitals link opens as well$")
	public void hospitals_link_opens_as_well() {
	   Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().contains("Hospitals"));
	}

	@Given("^Uset clicks on 'Add Hospital'$")
	public void uset_clicks_on_Add_Hospital() {
	   driver.findElement(By.id("masterContentBodyContainer_lnkBtnAdd")).findElement(By.tagName("img")).click();
	}

	@Given("^User add Hospital fields$")
	public void user_add_Hospital_fields() throws InterruptedException {
	   //Hospital name
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfHospital")).sendKeys("Automation Hospital");
		//Hospital group
		Select selectgroup=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlHospitalGroup")));
		selectgroup.selectByVisibleText("Ministry Of Health Hospitals");
		//Region
		Select selectregion=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlRegion")));
		selectregion.selectByVisibleText("Region 1");
		//City
		Thread.sleep(3000);
		Select selectcity=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlCity")));
		selectcity.selectByVisibleText("City 1");
		//Hospital admin email
		Thread.sleep(3000);
		driver.findElement(By.id("masterContentBodyContainer_txtLoginID")).sendKeys("m.zahran+80@softcare.io");
		//Password
		driver.findElement(By.id("masterContentBodyContainer_txtPassword")).sendKeys("123456");
		//Confirm Password
		driver.findElement(By.id("masterContentBodyContainer_txtConfirmPassword")).sendKeys("123456");
		//Admin
		driver.findElement(By.id("masterContentBodyContainer_txtFirstName")).sendKeys("Automation Admin");
		//Contact No
		driver.findElement(By.id("masterContentBodyContainer_txtMobileNo")).sendKeys("1234567890");		
	}

	@Given("^User clicks Submit for Hospitals$")
	public void user_clicks_Submit_for_Hospitals() {
	    driver.findElement(By.id("masterContentBodyContainer_btnSubmit")).click();
	}

	@Given("^Hospital will be added successfully$")
	public void hospital_will_be_added_successfully() {
	   Assert.assertTrue(driver.getPageSource().contains("Automation Hospital"));
	}

	@Given("^User clicks on Edit icon$")
	public void user_clicks_on_Edit_icon() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital");
		driver.findElements(By.className("ico-pencil")).get(0).click();
	}

	@Given("^User edits the hospital$")
	public void user_edits_the_hospital() {
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfHospital")).clear();
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfHospital")).sendKeys("Automation Hospital Updated");
	}

	@Given("^User clicks Submit for Edit form$")
	public void user_clicks_Submit_for_Edit_form() {
	  driver.findElement(By.id("masterContentBodyContainer_btnSubmit")).click();
	}

	@Given("^User clicks Deactivate icon$")
	public void user_clicks_Deactivate_icon() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital");
		driver.findElements(By.className("ico-remove")).get(1).click();
	}

	@Given("^User clicks Confirm for the confirmation shown$")
	public void user_clicks_Confirm_for_the_confirmation_shown() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.className("ui-dialog-buttonset")).findElements(By.tagName("button")).get(0).click();
	}

	@Given("^Hospital will be deactivated successfully$")
	public void hospital_will_be_deactivated_successfully() throws Throwable {
		Thread.sleep(2000);
	   Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Hospital has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate icon$")
	public void user_clicks_Reactivate_icon() throws Throwable {
	   driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital");
	   driver.findElement(By.className("ico-checkmark")).click();
	}

	@Given("^Hospital will be reactivated successfully$")
	public void hospital_will_be_reactivated_successfully() throws InterruptedException {
		 Thread.sleep(2000);
		 Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Hospital has been successfully reactivated!")); 
	}
	
	@Given("^User searches for a hospital at Search box$")
	public void user_searches_for_a_hospital_at_Search_box() {
	driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital");
	}

	@Given("^The system returns search results as well for hospitals$")
	public void the_system_returns_search_results_as_well() throws InterruptedException  {
		Thread.sleep(2000);
	 Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().contains("Automation Hospital"));  
	}
	
	@Given("^User clicks Department Types$")
	public void user_clicks_Department_Types() {
	   driver.findElement(By.xpath(".//li[@id='liDepartmentType']/a")).click();
	}

	@Given("^Department Types page opens as well$")
	public void department_Types_page_opens_as_well() {
	  Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Department Types"));
	}

	@Given("^User clicks Add Department Type button$")
	public void user_clicks_Add_Department_Type_button() {
	    driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/img")).click();
	}

	@Given("^User adds a department type$")
	public void user_adds_a_department_type() {
	    driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_txtNameOfDepartment']")).sendKeys("Automation Department Type");
	}

	@Given("^User clicks Submit button$")
	public void user_clicks_Submit_button() {
	    driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_btnSubmit']")).click();
	}

	@Given("^Department Type will be added successfully$")
	public void department_Type_will_be_added_successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liDepartmentType']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Type");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().equalsIgnoreCase("Automation Department Type"));
	}

	@Given("^User clicks Edit for a department type$")
	public void user_clicks_Edit_for_a_department_type() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Type");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrDepartment_lnkBtnEdit_0']/div/span")).click();		
	}

	@Given("^User edits department type$")
	public void user_edits_department_type() {
	   driver.findElement(By.id("masterContentBodyContainer_txtNameOfDepartment")).clear();
	   driver.findElement(By.id("masterContentBodyContainer_txtNameOfDepartment")).sendKeys("Automation Department Type Updated");
	}

	@Given("^Department Type will be edited successfully$")
	public void department_Type_will_be_edited_successfully() throws InterruptedException  {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liDepartmentType']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).click();
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Type");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().equalsIgnoreCase("Automation Department Type Updated"));
	}

	@Given("^User clicks Deactivate for a department type$")
	public void user_clicks_Deactivate_for_a_department_type() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Type");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrDepartment_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^Department Type will be deactivated as well$")
	public void department_Type_will_be_deactivated_as_well() throws InterruptedException {
	  Thread.sleep(2000);
	  Assert.assertTrue(driver.findElement(By.xpath(".//div[@id='dialog']")).getText().equalsIgnoreCase("Department type has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for a department type$")
	public void user_clicks_Reactivate_for_a_department_type() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Type");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrDepartment_lnkBtnActive_16']/div/span")).click();
	}

	@Given("^Department Type will be reactivated as well$")
	public void department_Type_will_be_reactivated_as_well() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath(".//div[@id='dialog']")).getText().equalsIgnoreCase("Department type has been successfully reactivated!"));
	}

	@Given("^User searches for a departmenttype at Search box$")
	public void user_searches_for_a_departmenttype_at_Search_box() {
	   driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Type");
	}

	@Given("^The system returns search results as well for departmenttype$")
	public void the_system_returns_search_results_as_well_for_departmenttype() {
	   Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().equalsIgnoreCase("Automation Department Type Updated"));
	}

	@Given("^User clicks HPT categories$")
	public void user_clicks_HPT_categories() {
	    driver.findElement(By.xpath(".//li[@id='liHealthcareCategory']/a")).click();
	}

	@Given("^HPT categories page opens as well$")
	public void hpt_categories_page_opens_as_well() {
	   Assert.assertTrue(driver.findElement(By.xpath(".//span[@id='masterContentPageTitle_lblMode']")).getText().equalsIgnoreCase("Healthcare Practitioner Type Categories"));
	}

	@Given("^User clicks Add HPT category button$")
	public void user_clicks_Add_HPT_category_button() {
	    driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/img")).click();
	}

	@Given("^User adds an HPT category$")
	public void user_adds_an_HPT_category() {
	   driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_txtTypeOfHelathcarePractitioner']")).sendKeys("Automation HPT Category");
	}

	@Given("^HPT category will be added successfully$")
	public void hpt_category_will_be_added_successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liHealthcareCategory']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Category");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().equalsIgnoreCase("Automation HPT Category"));
	}

	@Given("^User clicks Edit for an HPT category$")
	public void user_clicks_Edit_for_an_HPT_category() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Category");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHealthPractitionerType_lnkBtnEdit_2']/div/span")).click();
	}

	@Given("^User edits HPT category$")
	public void user_edits_HPT_category() {
		driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_txtTypeOfHelathcarePractitioner']")).clear();
		driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_txtTypeOfHelathcarePractitioner']")).sendKeys("Automation HPT Category Updated");
	}

	@Given("^HPT category will be edited successfully$")
	public void hpt_category_will_be_edited_successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liHealthcareCategory']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Category");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().equalsIgnoreCase("Automation HPT Category Updated"));
	}

	@Given("^User clicks Deactivate for an HPT category$")
	public void user_clicks_Deactivate_for_an_HPT_category() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Category");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHealthPractitionerType_lnkBtnDelete_2']/div/span")).click();	
	}

	@Given("^HPT category will be deactivated as well$")
	public void hpt_category_will_be_deactivated_as_well() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Healthcare Practitioner Type category has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for an HPT category$")
	public void user_clicks_Reactivate_for_an_HPT_category() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Category");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHealthPractitionerType_lnkBtnActive_16']/div/span")).click();
	}

	@Given("^HPT category will be reactivated as well$")
	public void hpt_category_will_be_reactivated_as_well() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Healthcare Practitioner Type category has been successfully reactivated!"));
	}
	
	@Given("^User searches for an HPT category at Search box$")
	public void user_searches_for_an_HPT_category_at_Search_box() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Category");
	}

	@Given("^The system returns search results as well for HPT category$")
	public void the_system_returns_search_results_as_well_for_HPT_category()  {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().equalsIgnoreCase("Automation HPT Category Updated"));
	}

	@Given("^user clicks on Regions link from side pane$")
	public void user_clicks_on_Regions_link_from_side_pane()  {
	    driver.findElement(By.xpath(".//li[@id='liRegions']/a")).click();
	}

	@Given("^Regions link opens as well$")
	public void regions_link_opens_as_well() {
	    Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Region"));
	}

	@Given("^User clicks Add New Region button$")
	public void user_clicks_Add_New_Region_button() {
	   driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/img")).click();
	}

	@Given("^User adds a region$")
	public void user_adds_a_region() {
	    driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_txtNameOfRegion']")).sendKeys("Automation Region");
	}

	@Given("^Region will be added successfully$")
	public void region_will_be_added_successfully() {
	   driver.findElement(By.xpath(".//div[@id='DataTables_Table_2_filter']/label/input")).sendKeys("Automation Region");
	   Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_2']/tbody/tr[1]/td[2]")).getText().contains("Automation Region"));
	}

	@Given("^User clicks Edit for a region$")
	public void user_clicks_Edit_for_a_region() throws InterruptedException {

		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrRegion_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User edits a region$")
	public void user_edits_a_region() {
		driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_txtNameOfRegion']")).clear();
		driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_txtNameOfRegion']")).sendKeys("Automation Region Updated");
	}

	@Given("^Region will be edited successfully$")
	public void region_will_be_edited_successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liRegions']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Updated");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[2]")).getText().contains("Automation Region Updated"));
	}

	@Given("^User clicks Deactivate for a region$")
	public void user_clicks_Deactivate_for_a_region() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrRegion_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^Region will be deactivated as well$")
	public void region_will_be_deactivated_as_well() throws InterruptedException {
	   Thread.sleep(1000);
	   Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Region has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for a region$")
	public void user_clicks_Reactivate_for_a_region() {
	   driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Updated");
	   driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrRegion_lnkBtnActive_10']/div/span")).click();
	}

	@Given("^Region will be reactivated as well$")
	public void region_will_be_reactivated_as_well() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Region has been successfully reactivated!"));
	}

	@Given("^User searches for a region at Search box$")
	public void user_searches_for_a_region_at_Search_box() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Updated");
	}

	@Given("^The system returns search results as well for region$")
	public void the_system_returns_search_results_as_well_for_region() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[2]")).getText().contains("Automation Region Updated"));
	}

	@Given("^user clicks on Cities link from side pane$")
	public void user_clicks_on_Cities_link_from_side_pane() {
	    driver.findElement(By.xpath(".//li[@id='liCities']/a")).click();
	}

	@Given("^Cities link opens as well$")
	public void cities_link_opens_as_well() {
	   Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("City"));
	}

	@Given("^User clicks Add New City button$")
	public void user_clicks_Add_New_City_button() {
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/img")).click();
	}

	@Given("^User adds a city$")
	public void user_adds_a_city() {
		//Select Region
	    Select selectregion=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlRegion")));
	    selectregion.selectByVisibleText("Automation Region Updated");
	    //Add City
	    driver.findElement(By.id("masterContentBodyContainer_txtNameOfCity")).sendKeys("Automation City");
	}

	@Given("^City will be added successfully$")
	public void city_will_be_added_successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liCities']/a")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation City");
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[3]")).getText().contains("Automation City"));
	}

	@Given("^User clicks Edit for a city$")
	public void user_clicks_Edit_for_a_city() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation City");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrCity_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User edits a city$")
	public void user_edits_a_city() {
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfCity")).clear();
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfCity")).sendKeys("Automation City Updated");
	}

	@Given("^City will be edited successfully$")
	public void city_will_be_edited_successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liCities']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation City Updated");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[3]")).getText().contains("Automation City Updated"));
	}

	@Given("^User clicks Deactivate for a city$")
	public void user_clicks_Deactivate_for_a_city()  {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation City Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrCity_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^City will be deactivated as well$")
	public void city_will_be_deactivated_as_well() throws InterruptedException {
	    Thread.sleep(1000);
	    Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("City has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for a city$")
	public void user_clicks_Reactivate_for_a_city() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation City Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrCity_lnkBtnActive_11']/div/span")).click();
	}

	@Given("^City will be reactivated as well$")
	public void city_will_be_reactivated_as_well() throws InterruptedException {
	   Thread.sleep(2000);
	   Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("City has been successfully reactivated!"));
	}

	@Given("^User searches for a city at Search box$")
	public void user_searches_for_a_city_at_Search_box() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation City Updated");
	}

	@Given("^The system returns search results as well for city$")
	public void the_system_returns_search_results_as_well_for_city() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[3]")).getText().contains("Automation City Updated"));
	}
	
	@Given("^user clicks on Group Admins link from side pane$")
	public void user_clicks_on_Group_Admins_link_from_side_pane() {
	  driver.findElement(By.xpath(".//li[@id='liGroupAdmin']/a")).click();
	}

	@Given("^Group Admins link opens as well$")
	public void group_Admins_link_opens_as_well() {
	   Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Group Admin"));
	}

	@Given("^User clicks Add New Admin button$")
	public void user_clicks_Add_New_Admin_button() {
	    driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/img")).click();
	}
	
	@Given("^User adds a new admin$")
	public void user_adds_a_new_admin() throws InterruptedException, IOException {
	   //Group Name
		driver.findElement(By.id("masterContentBodyContainer_txtHospitalGroupName")).sendKeys("Automation Group");
		//Email
		driver.findElement(By.id("masterContentBodyContainer_txtLoginID")).sendKeys("m.zahran+90@softcare.io");
		//Password
		Thread.sleep(2000);
		driver.findElement(By.id("masterContentBodyContainer_txtPassword")).sendKeys("123456");
		//Confirm Password
		driver.findElement(By.id("masterContentBodyContainer_txtConfirmPassword")).sendKeys("123456");
		//First Name
		driver.findElement(By.id("masterContentBodyContainer_txtFirstName")).sendKeys("Automation");
		//Last Name
		driver.findElement(By.id("masterContentBodyContainer_txtLastName")).sendKeys("Group Admin");
		//Contact No
		driver.findElement(By.id("masterContentBodyContainer_txtMobileNo")).sendKeys("+96643245135432");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
	}

	@Given("^GA will be added successfully$")
	public void ga_will_be_added_successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liGroupAdmin']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Group");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().contains("Automation Group"));
	}

	@Given("^User clicks Edit for a group admin$")
	public void user_clicks_Edit_for_a_group_admin() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Group");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrGroupAdmin_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User edits a group admin$")
	public void user_edits_a_group_admin() {
		driver.findElement(By.id("masterContentBodyContainer_txtHospitalGroupName")).clear();
		driver.findElement(By.id("masterContentBodyContainer_txtHospitalGroupName")).sendKeys("Automation Group Updated");
	}

	@Given("^Group Admin will be edited successfully$")
	public void group_Admin_will_be_edited_successfully() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liGroupAdmin']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Group Updated");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().contains("Automation Group Updated"));
	}

	@Given("^User clicks Deactivate for a group admin$")
	public void user_clicks_Deactivate_for_a_group_admin() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Group Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrGroupAdmin_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^Group Admin will be deactivated as well$")
	public void group_Admin_will_be_deactivated_as_well() throws InterruptedException {
		Thread.sleep(1000);
	    Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Group admin has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for a group admin$")
	public void user_clicks_Reactivate_for_a_group_admin() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Group Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrGroupAdmin_lnkBtnActive_5']/div/span")).click();
	}

	@Given("^Group Admin will be reactivated as well$")
	public void group_Admin_will_be_reactivated_as_well() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Group admin has been successfully reactivated!"));
	}

	@Given("^User searches for a group admin at Search box$")
	public void user_searches_for_a_group_admin_at_Search_box() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Group Updated"); 
	}

	@Given("^The system returns search results as well for group admin$")
	public void the_system_returns_search_results_as_well_for_group_admin() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().contains("Automation Group Updated"));
	}
	
	@Given("^User enters correct username and password for hospital admin$")
	public void user_enters_correct_username_and_password_for_hospital_admin() {
	 //Hospital Admin Username
		driver.findElement(By.id("txtLoginId")).sendKeys("m.zahran+80@softcare.io");
	 //Hospital Admin Password	
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
	}

	@Given("^Hospital admin will be logged in as well$")
	public void hospital_admin_will_be_logged_in_as_well() throws InterruptedException {
	 Thread.sleep(3000);
	 Assert.assertTrue(driver.getPageSource().contains("Automation Hospital Updated"));
	}

	@Given("^User clicks Departments link$")
	public void user_clicks_Departments_link() {
	    driver.findElement(By.xpath(".//li[@id='liAdmin1']/a")).click();
	}

	@Given("^Departments page will be opened as well$")
	public void departments_page_will_be_opened_as_well() {
	   Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Departments"));
	}

	@Given("^user clicks 'Add Department'$")
	public void user_clicks_Add_Department() {
	   driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/div")).click();
	}

	@Given("^user selects a department type$")
	public void user_selects_a_department_type() {
	    Select selectdeptype=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlDepartmentType")));
	    selectdeptype.selectByVisibleText("Automation Department Type Updated");
	}

	@Given("^User adds a department$")
	public void user_adds_a_department() {
	   driver.findElement(By.id("masterContentBodyContainer_txtNameOfDepartment")).sendKeys("Automation Department");
	}

	@Given("^Department will be added as well$")
	public void department_will_be_added_as_well() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liAdmin1']/a")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department");
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equalsIgnoreCase("Automation Department"));
	}
	
	@Given("^User clicks Edit for a department$")
	public void user_clicks_Edit_for_a_department() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrDepartment_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User edits a department$")
	public void user_edits_a_department() {
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfDepartment")).clear();
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfDepartment")).sendKeys("Automation Department Updated");
	}

	@Given("^Department will be edited successfully$")
	public void department_will_be_edited_successfully() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//li[@id='liAdmin1']/a")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Updated");
		 Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equalsIgnoreCase("Automation Department Updated"));
	}

	@Given("^User clicks Deactivate for a department$")
	public void user_clicks_Deactivate_for_a_department() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrDepartment_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^Department will be deactivated as well$")
	public void department_will_be_deactivated_as_well() throws InterruptedException {
	   Thread.sleep(1000);
	   Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Department has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for a department$")
	public void user_clicks_Reactivate_for_a_department() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrDepartment_lnkBtnActive_0']/div/span")).click();
	}

	@Given("^Department will be reactivated as well$")
	public void department_will_be_reactivated_as_well() throws InterruptedException {
		Thread.sleep(1000);
	    Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Department has been successfully reactivated!"));
	}

	@Given("^User searches for a department at Search box$")
	public void user_searches_for_a_department_at_Search_box() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Department Updated");
	}

	@Given("^The system returns search results as well for department$")
	public void the_system_returns_search_results_as_well_for_department() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equalsIgnoreCase("Automation Department Updated"));
	}
	
	@Given("^User clicks HPTs link$")
	public void user_clicks_HPTs_link() {
	   driver.findElement(By.xpath(".//li[@id='liAdmin2']/a")).click();
	}

	@Given("^HPTs page will be opened as well$")
	public void hpts_page_will_be_opened_as_well() {
	    Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Healthcare Practitioner Types"));
	}

	@Given("^user clicks 'Add HPT'$")
	public void user_clicks_Add_HPT() {
	   driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/div")).click();
	}

	@Given("^user selects an HPT category$")
	public void user_selects_an_HPT_category() {
	    Select selectHPTcat = new Select(driver.findElement(By.id("masterContentBodyContainer_ddlHealthcarePractitionerTypeCategory")));
	    selectHPTcat.selectByVisibleText("Automation HPT Category Updated");
	}

	@Given("^User adds an HPT$")
	public void user_adds_an_HPT() {
	   driver.findElement(By.id("masterContentBodyContainer_txtTypeOfHelathcarePractitioner")).sendKeys("Automation HPT");
	}

	@Given("^HPT will be added as well$")
	public void hpt_will_be_added_as_well() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//li[@id='liAdmin2']/a")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT");
		 Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equalsIgnoreCase("Automation HPT"));
	}

	@Given("^User clicks Edit for an HPT$")
	public void user_clicks_Edit_for_an_HPT() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHealthPractitionerType_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User edits an HPT$")
	public void user_edits_an_HPT() {
		driver.findElement(By.id("masterContentBodyContainer_txtTypeOfHelathcarePractitioner")).clear();
		driver.findElement(By.id("masterContentBodyContainer_txtTypeOfHelathcarePractitioner")).sendKeys("Automation HPT Updated");
	}

	@Given("^HPT will be edited successfully$")
	public void hpt_will_be_edited_successfully() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//li[@id='liAdmin2']/a")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Updated");
		 Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equalsIgnoreCase("Automation HPT Updated"));
	}

	@Given("^User clicks Deactivate for an HPT$")
	public void user_clicks_Deactivate_for_an_HPT() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHealthPractitionerType_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^HPT will be deactivated as well$")
	public void hpt_will_be_deactivated_as_well() throws InterruptedException {
	   Thread.sleep(1000);
	   Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Healthcare Practitioner Type has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for an HPT$")
	public void user_clicks_Reactivate_for_an_HPT() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHealthPractitionerType_lnkBtnActive_0']/div/span")).click();
	}

	@Given("^HPT will be reactivated as well$")
	public void hpt_will_be_reactivated_as_well() throws InterruptedException {
		 Thread.sleep(1000);
		 Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Healthcare Practitioner Type has been successfully reactivated!"));
	}

	@Given("^User searches for an HPT at Search box$")
	public void user_searches_for_an_HPT_at_Search_box() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation HPT Updated");
	}

	@Given("^The system returns search results as well for HPT$")
	public void the_system_returns_search_results_as_well_for_HPT() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[2]")).getText().equalsIgnoreCase("Automation HPT Updated"));
	}
	
	@Given("^User clicks Observers link$")
	public void user_clicks_Observers_link() {
	   driver.findElement(By.xpath(".//li[@id='liAdmin3']/a")).click();
	}

	@Given("^Observers page will be opened as well$")
	public void observers_page_will_be_opened_as_well() {
	   Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Observers"));
	}

	@Given("^user clicks 'Add observer'$")
	public void user_clicks_Add_observer() {
	    driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/div")).click();
	}

	@Given("^User adds observer$")
	public void user_adds_observer() {
	   //Email
		driver.findElement(By.id("masterContentBodyContainer_txtLoginID")).sendKeys("m.zahran+81@softcare.io");
		//First Name
		driver.findElement(By.id("masterContentBodyContainer_txtFirstName")).sendKeys("Automation");
		//Last Name
		driver.findElement(By.id("masterContentBodyContainer_txtLastName")).sendKeys("Observer");
		//EMP ID
		driver.findElement(By.id("masterContentBodyContainer_txtEmployeeID")).sendKeys("005");
		//Contact No
		driver.findElement(By.id("masterContentBodyContainer_txtMobileNo")).sendKeys("+96643215431523");
	}

	@Given("^observer will be added as well$")
	public void observer_will_be_added_as_well() throws InterruptedException {
	    Thread.sleep(6000);
	    driver.findElement(By.xpath(".//li[@id='liAdmin3']/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Observer");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[1]")).getText().equalsIgnoreCase("m.zahran+81@softcare.io"));
	}

	@Given("^User clicks Edit for an observer$")
	public void user_clicks_Edit_for_an_observer() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Observer");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrObserver_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User edits an observer$")
	public void user_edits_an_observer() throws InterruptedException {
		driver.findElement(By.id("masterContentBodyContainer_txtLoginID")).clear();
		driver.findElement(By.id("masterContentBodyContainer_txtLoginID")).sendKeys("m.zahran+82@softcare.io");
		
		driver.findElement(By.id("editLayerHead")).click();
		Thread.sleep(6000);
	}

	@Given("^Observer will be edited successfully$")
	public void observer_will_be_edited_successfully() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//li[@id='liAdmin3']/a")).click();
	    Thread.sleep(2000);
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Observer");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[1]")).getText().equalsIgnoreCase("m.zahran+82@softcare.io"));
	}

	@Given("^User clicks Deactivate for an observer$")
	public void user_clicks_Deactivate_for_an_observer() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Observer");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrObserver_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^Observer will be deactivated as well$")
	public void observer_will_be_deactivated_as_well() throws InterruptedException {
	    Thread.sleep(1000);
	    Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Observer has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for an observer$")
	public void user_clicks_Reactivate_for_an_observer() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Observer");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrObserver_lnkBtnActive_0']/div/span")).click();
	}

	@Given("^Observer will be reactivated as well$")
	public void observer_will_be_reactivated_as_well() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Observer has been successfully reactivated!"));
	}

	@Given("^User searches for an observer at Search box$")
	public void user_searches_for_an_observer_at_Search_box() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Observer");
	}
	
	@Given("^The system returns search results as well for observer$")
	public void the_system_returns_search_results_as_well_for_observer() {
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[1]")).getText().equalsIgnoreCase("m.zahran+82@softcare.io"));
	}
	
	@Given("^User clicks Settings link$")
	public void user_clicks_Settings_link() {
	 driver.findElement(By.xpath(".//li[@id='liAdmin6']/a")).click();
	}

	@Given("^Settings page will be opened as well$")
	public void settings_page_will_be_opened_as_well() {
	   Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Settings"));
	}

	@Given("^User clicks Edit for monthly target$")
	public void user_clicks_Edit_for_monthly_target() {
	   driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrObservationTarget_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User sets a value$")
	public void user_sets_a_value() {
	    driver.findElement(By.id("masterContentBodyContainer_txtTarget")).clear();
	    driver.findElement(By.id("masterContentBodyContainer_txtTarget")).sendKeys("7");
	}

	@Given("^Value willbe saved as well$")
	public void value_willbe_saved_as_well() throws InterruptedException {
	   Thread.sleep(2000);
	   driver.findElement(By.xpath(".//li[@id='liAdmin6']/a")).click();
	   Thread.sleep(2000);
	   Assert.assertTrue(driver.findElement(By.xpath("(//table[contains(@class,'table')])[1]/tbody/tr[1]/td[1]")).getText().contains("7"));
	}

	@Given("^User adds another value at Time between sessions$")
	public void user_adds_another_value_at_Time_between_sessions() {
	    driver.findElement(By.id("masterContentBodyContainer_txtTimeBetweenSessionsValue")).clear();
	    driver.findElement(By.id("masterContentBodyContainer_txtTimeBetweenSessionsValue")).sendKeys("3");
	}

	@Given("^user selects minutes option$")
	public void user_selects_minutes_option() {
	   Select selecttimeunit=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlTimeBetweenSessionsInterval")));
	   selecttimeunit.selectByVisibleText("Mins.");
	}

	@Given("^User clicks Save$")
	public void user_clicks_Save() {
	    driver.findElement(By.xpath(".//input[@id='masterContentBodyContainer_Button1']")).click();
	}

	@Given("^Selected options will be saved as well$")
	public void selected_options_will_be_saved_as_well() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liAdmin6']/a")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.id("masterContentBodyContainer_txtTimeBetweenSessionsValue")).getAttribute("value").contains("3"));
		Select selecttimeunit=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlTimeBetweenSessionsInterval")));
		Assert.assertTrue(selecttimeunit.getFirstSelectedOption().getText().contains("Min"));
	}
	
	@Given("^User enters correct username and password for group admin$")
	public void user_enters_correct_username_and_password_for_group_admin() {
	   driver.findElement(By.id("txtLoginId")).sendKeys("m.zahran+90@softcare.io");
	   driver.findElement(By.id("txtPassword")).sendKeys("123456");
	}

	@Given("^Group admin will be logged in as well$")
	public void group_admin_will_be_logged_in_as_well() {
	    driver.getPageSource().contains("Automation  Group Admin");
	}

	@Given("^User clicks Hospitals link$")
	public void user_clicks_Hospitals_link() {
	    driver.findElement(By.xpath(".//li[@id='liSuperAdmin']/a")).click();
	}

	@Given("^Hospitals page will be opened as well$")
	public void hospitals_page_will_be_opened_as_well() {
	    Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Hospitals"));
	}

	@Given("^User clicks Add Hospital$")
	public void user_clicks_Add_Hospital() {
	    driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/div")).click();
	}

	@Given("^User adds hospital fields$")
	public void user_adds_hospital_fields() throws InterruptedException {
	    //Hospital Name
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfHospital")).sendKeys("Automation Hospital from group Admin");
		//Region
		Select selectregion=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlRegion")));
		selectregion.selectByVisibleText("Automation Region Updated");
		//City
		Thread.sleep(3000);
		Select selectcity=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlCity")));
		selectcity.selectByVisibleText("Automation City Updated");
		//Email
		Thread.sleep(3000);
		driver.findElement(By.id("masterContentBodyContainer_txtLoginID")).sendKeys("m.zahran+91@softcare.io");
		//Password
		driver.findElement(By.id("masterContentBodyContainer_txtPassword")).sendKeys("123456");
		//Confirm Password
		driver.findElement(By.id("masterContentBodyContainer_txtConfirmPassword")).sendKeys("123456");
		//Admin Name
		driver.findElement(By.id("masterContentBodyContainer_txtFirstName")).sendKeys("Automation Hospital Admin 1");
		//Contact No
		driver.findElement(By.id("masterContentBodyContainer_txtMobileNo")).sendKeys("11111111111111");
	}

	@Given("^Hospital will be added as well$")
	public void hospital_will_be_added_as_well() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//li[@id='liSuperAdmin']/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital from group Admin");
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().contains("Automation Hospital from group Admin"));
	}

	@Given("^User clicks Edit for hospital$")
	public void user_clicks_Edit_for_hospital() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital from group Admin");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHospital_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User edits a hospital$")
	public void user_edits_a_hospital() {
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfHospital")).clear();
		driver.findElement(By.id("masterContentBodyContainer_txtNameOfHospital")).sendKeys("Automation Hospital from group Admin Updated");
	}

	@Given("^Hospital will be edited as well$")
	public void hospital_will_be_edited_as_well() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//li[@id='liSuperAdmin']/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital from group Admin Updated");
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().contains("Automation Hospital from group Admin Updated"));
	}

	@Given("^User clicks Deactivate for hospital$")
	public void user_clicks_Deactivate_for_hospital() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital from group Admin Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHospital_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^Hospital will be deactivated as well$")
	public void hospital_will_be_deactivated_as_well() throws InterruptedException {
	   Thread.sleep(2000);
	   Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Hospital has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for hospital$")
	public void user_clicks_Reactivate_for_hospital() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital from group Admin Updated");
	    driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHospital_lnkBtnActive_0']/div/span")).click();
	}

	@Given("^Hospital will be reactivated as well$")
	public void hospital_will_be_reactivated_as_well() throws InterruptedException {
		 Thread.sleep(1000);
		 Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Hospital has been successfully reactivated!"));
	}

	@Given("^User edits the hospital group$")
	public void user_edits_the_hospital_group() throws Throwable {
		Select selectgroup=new Select(driver.findElement(By.id("masterContentBodyContainer_ddlHospitalGroup")));
		selectgroup.selectByVisibleText("Automation Group Updated");
	}

	@Given("^Hospital will be shown successfully$")
	public void hospital_will_be_shown_successfully() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital Updated");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[1]")).getText().equalsIgnoreCase("Automation Hospital Updated"));
	}
	
	@Given("^User clicks Region Admin link$")
	public void user_clicks_Region_Admin_link() {
	    driver.findElement(By.xpath(".//li[@id='liRegionAdmin']/a")).click();
	}

	@Given("^Region page will be opened as well$")
	public void region_page_will_be_opened_as_well() {
	   Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Region Admin"));
	}

	@Given("^User clicks Add New Region Admin$")
	public void user_clicks_Add_New_Region_Admin() {
	   driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_lnkBtnAdd']/div")).click();
	}

	@Given("^User adds region admin fields$")
	public void user_adds_region_admin_fields() throws InterruptedException {
	    //Email
		driver.findElement(By.id("masterContentBodyContainer_txtLoginID")).sendKeys("m.zahran+92@softcare.io");
		//Password
		Thread.sleep(5000);
		driver.findElement(By.id("masterContentBodyContainer_txtPassword")).sendKeys("123456");
		//Confirm Password
		driver.findElement(By.id("masterContentBodyContainer_txtConfirmPassword")).sendKeys("123456");
		//First Name
		driver.findElement(By.id("masterContentBodyContainer_txtFirstName")).sendKeys("Automation");
		//Last Name
		driver.findElement(By.id("masterContentBodyContainer_txtLastName")).sendKeys("Region Admin");
		//Contact No
		driver.findElement(By.id("masterContentBodyContainer_txtMobileNo")).sendKeys("+9662222222222");
	}

	@Given("^Region Admin will be added as well$")
	public void region_Admin_will_be_added_as_well() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//li[@id='liRegionAdmin']/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Admin");
		Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[2]")).getText().equalsIgnoreCase("Automation Region Admin"));
	}

	@Given("^User clicks Edit for Region Admin$")
	public void user_clicks_Edit_for_Region_Admin() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Admin");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrGroupAdmin_lnkBtnEdit_0']/div/span")).click();
	}

	@Given("^User edits a region admin$")
	public void user_edits_a_region_admin() {
		driver.findElement(By.id("masterContentBodyContainer_txtLastName")).clear();
		driver.findElement(By.id("masterContentBodyContainer_txtLastName")).sendKeys("Region Admin Updated");
	}

	@Given("^Region Admin will be edited as well$")
	public void region_Admin_will_be_edited_as_well() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.xpath(".//li[@id='liRegionAdmin']/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Admin Updated");
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr[1]/td[2]")).getText().equalsIgnoreCase("Automation Region Admin Updated"));
	}

	@Given("^User clicks Deactivate for region admin$")
	public void user_clicks_Deactivate_for_region_admin() {
		 driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Admin Updated");
		 driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrGroupAdmin_lnkBtnDelete_0']/div/span")).click();
	}

	@Given("^Region Admin will be deactivated as well$")
	public void region_Admin_will_be_deactivated_as_well() throws InterruptedException {
	   Thread.sleep(2000);
	   Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Region admin has been successfully deactivated!"));
	}

	@Given("^User clicks Reactivate for a region admin$")
	public void user_clicks_Reactivate_for_a_region_admin() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Admin Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrGroupAdmin_lnkBtnActive_0']/div/span")).click();
	}

	@Given("^Region Admin will be reactivated as well$")
	public void region_Admin_will_be_reactivated_as_well() throws InterruptedException {
		 Thread.sleep(2000);
		 Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Region admin has been successfully reactivated!"));
	}
	
	@Given("^User clicks Assign Hospitals button for hospitals$")
	public void user_clicks_Assign_Hospitals_button_for_hospitals() {
		driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Region Admin Updated");
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrGroupAdmin_lnkBtnAssignedHospitals_0']/div/span")).click();
		driver.findElement(By.xpath(".//a[@id='masterContentBodyContainer_rptrHospital_lnkBtnAdd_0']/div/span")).click();
	}

	@Given("^Hospital will be assigned as well to region admin$")
	public void hospital_will_be_assigned_as_well_to_region_admin() throws InterruptedException {
		 Thread.sleep(2000);
		 Assert.assertTrue(driver.findElement(By.id("dialog")).getText().equalsIgnoreCase("Hospital has been successfully Assigned!"));  
	}
	
	@Given("^User enters correct username and password for region admin$")
	public void user_enters_correct_username_and_password_for_region_admin() {
	   driver.findElement(By.id("txtLoginId")).sendKeys("m.zahran+92@softcare.io");
	   driver.findElement(By.id("txtPassword")).sendKeys("123456");
	}

	@Given("^Region admin will be logged in as well$")
	public void region_admin_will_be_logged_in_as_well() {
	    Assert.assertTrue(driver.findElement(By.xpath("(//a[contains(@class,'name')])[1]/span[1]")).getText().contains("Automation Region Admin Updated"));
	}

	@Given("^User clicks Hospitals link from side menu$")
	public void user_clicks_Hospitals_link_from_side_menu() {
	   driver.findElement(By.xpath(".//li[@id='liSuperAdmin']/a")).click();
	}

	@Given("^Hospitals page will be opened successfully$")
	public void hospitals_page_will_be_opened_successfully() {
	    Assert.assertTrue(driver.findElement(By.id("masterContentPageTitle_lblMode")).getText().equalsIgnoreCase("Hospitals"));
	}

	@Given("^User searches for a hospital of region admin at Search box$")
	public void user_searches_for_a_hospital_of_region_admin_at_Search_box() {
	   driver.findElement(By.xpath(".//div[@id='DataTables_Table_0_filter']/label/input")).sendKeys("Automation Hospital Updated");
	}

	@Given("^The system returns search results as well for region admin$")
	public void the_system_returns_search_results_as_well_for_region_admin() {
	    Assert.assertTrue(driver.findElement(By.xpath(".//table[@id='DataTables_Table_0']/tbody/tr/td[1]")).getText().equalsIgnoreCase("Automation Hospital Updated"));
	}

}

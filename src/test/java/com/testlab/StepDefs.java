package com.testlab;

import java.net.MalformedURLException;
import java.util.Random;

import com.web.testlab.*;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepDefs {

    static WebDriver driver;
    LoginPage loginPage;
    HomePage home;
    ForgotPwdPage forgotpwdpage;
    AddProjectPage addProject;
    ProjectHomePage projecthomepage;
    AddProjectAdminPage addprojectadminpage;
    Testers testers;
    AddTester addtester;
    Random random = new Random();
    String name1;
    public static String name;
    String fullname, uname, pwd, confpwd, email, favplace, project;

    @Before
    public void StartBrowser() throws MalformedURLException, InterruptedException {
        try {
            BrowserFactory.StartBrowser("firefox", "http://tvishitech.com/webdev/testlab/web/index.php");
            driver = BrowserFactory.driver;
        } catch (Exception e) {
            e.printStackTrace();
        }

        loginPage = new LoginPage();
        home = new HomePage();
        forgotpwdpage = new ForgotPwdPage();
        addProject = new AddProjectPage();
        projecthomepage = new ProjectHomePage();
        addprojectadminpage = new AddProjectAdminPage();
        testers = new Testers();
        addtester = new AddTester();

       if(Utils.isElementPresent(By.linkText("Logout")))
       home.Logout();

    }

    @After
    public void closeBrowser() throws MalformedURLException, InterruptedException {

        driver.quit();

        //.QuitBrowser();

    }

    @Given("^Admin is in login page$")
    public void Admin_is_in_login_page() {
        Assert.assertTrue(Utils.getVisibleText().contains("WEB LOGIN"));
    }

    @When("^Admin enters '(.*)' as username$")
    public void Admin_enters_username(String username) {

        driver.findElement(By.id("username")).sendKeys(username);
    }

    @When("^Admin enters '(.*)' as password$")
    public void Admin_enters_Admin_as_password(String password) {
        driver.findElement(By.name("password")).sendKeys(password);

    }

    @When("^Admin clicks on 'login' button$")
    public void Admin_clicks_on_login_button() {

        driver.findElement(By.tagName("button")).click();
        Utils.sleep(5);
    }

    @Then("^Admin should login successfully$")
    public void Admin_should_login_successfully() {

        Utils.sleep(5);
        Assert.assertTrue(Utils.isElementPresent(By.linkText("Logout")));
    }

    @Then("^Admin should see 'Welcome Admin' text message,dashboard.$")
    public void Admin_should_see_Welcome_Admin_text_message_dashboard() {
        Assert.assertTrue(Utils.isTextPresent("Hi, superadmin"));
    }


    @Then("^'(.*)' should be displayed$")
    public void error_message(String error) {
        Assert.assertTrue(Utils.isTextPresent(error));
    }

    @Given("^Admin is logged in$")
    public void Admin_is_logged_in() {
        loginPage.login("testlabadmin", "Admin1");
        Utils.sleep(5);
        Assert.assertTrue(Utils.isTextPresent("Hi, superadmin"));

    }


    @Given("^Admin can see logout button on Home Screen$")
    public void Admin_can_see_logout_button_on_Home_Screen() {
        Assert.assertTrue(Utils.isElementPresent(By.linkText("Logout")));

    }

    @When("^Admin clicks on Logout button$")
    public void Admin_clicks_on_Logout_button() {
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isEnabled());
        driver.findElement(By.linkText("Logout")).click();
    }

    @Then("^Admin should be Logged out and should navigate to Login page$")
    public void Admin_should_be_Logged_out() {
        Utils.sleep(5);
        Assert.assertTrue(Utils.getVisibleText().contains("WEB LOGIN"));
    }

    @Then("^Admin should see the tabs 'Projects','Project Admins'$")
    public void Admin_should_see_the_tabs_Projects_Project_Admins() {
        Utils.sleep(5);
        Assert.assertTrue(Utils.isTextPresent("Projects"));
        Assert.assertTrue(Utils.isTextPresent("Project Admins"));
    }

    @Then("^Admin should see the 'Add Project' button in the 'Projects' tab$")
    public void user_should_see_the_Add_Project_button_in_the_Projects_tab() {
        Utils.sleep(5);
        Assert.assertTrue(Utils.isElementPresent(By.linkText("Add project")));
    }

    @When("^Admin clicks the 'Add Project' button$")
    public void user_clicks_the_Add_Project_button() {
        driver.findElement(By.linkText("Add project")).click();
        Utils.sleep(5);
    }

    @Then("^Admin should navigate to the 'Add Project' Page$")
    public void User_should_navigate_to_the_Add_Project_Page() {
        Utils.sleep(5);
        Assert.assertTrue(Utils.isTextPresent("Add Project"));
    }

    @Given("^Admin is on the 'Add Project' Page$")
    public void Admin_is_on_the_Add_Project_Page() {
        loginPage.login("testlabadmin","Admin1");
        Utils.sleep(5);
        //   Assert.assertTrue(Utils.isTextPresent("Add project"));
        home.navigateToAddProject();

    }

    @When("^Admin enters an new Project  with valid 'Project name' and valid 'Project Desc'$")
    public void Admin_enters_an_new_Project_with_valid_Project_name_and_valid_Project_Desc() {
        Utils.sleep(5);
        name = "Manual Testing" + new Random().nextInt(100);
        addProject.enterProjectname(name);
        addProject.enterProjectDesc("Manual Testing");

    }

    @When("^Admin should click on 'Save' button$")
    public void Admin_should_click_on_Save_button() {
        addProject.clickSaveButton();
        Utils.sleep(5);
    }

    @Then("^Admin should see the message as 'Project saved successfully'$")
    public void Admin_should_see_the_message_as_Project_saved_successfully() {
        Utils.sleep(5);
        //Assert.assertTrue(Utils.isTextPresent("Project saved successfully"));
        Assert.assertEquals("Project saved successfully", driver.findElement(By.id("success_message")).getText());

    }

    @When("^Admin clicks on 'Ok' button$")
    public void Admin_clicks_on_Ok_button() {
        // driver.findElement(By.tagName("button")).click();
        Utils.sleep(5);
        //Assert.assertTrue(Utils.isElementPresent(By.cssSelector("div.title_content > div.buttons")));
        driver.findElement(By.cssSelector("div.title_content > div.buttons > button[type=\"button\"]")).click();
    }

    @Then("^Admin should see the 'Home Page' with the new project added in the 'Projects Tab'$")
    public void Admin_should_see_the_Home_Page_with_the_new_project_added_in_the_Projects_Tab() {
        Utils.sleep(5);

        for (int i = 0; i < 10; i++) {
            Utils.sleep(5);
            if (Utils.isTextPresent((name)))
                break;
            home.goToNextPage();
        }
//        driver.findElement(By.linkText("Projects")).click();

    }

    @When("^Admin enters an existing project name in the 'Project Name' textbox$")
    public void Admin_enters_an_existing_project_name_in_the_Project_Name_textbox() {
        Utils.sleep(5);
        //name1="123Banking";
        System.out.println(name);
        name1 = name;
        addProject.enterProjectname(name1);

    }

    @When("^Admin enters valid description in the 'Project Desc' textbox$")
    public void Admin_enters_valid_description_in_the_Project_Desc_textbox() {
        addProject.enterProjectDesc("Manual Testing");
        Utils.sleep(5);
    }

    @Then("^Admin should see an error message as '(.*)'$")
    public void Admin_should_see_an_error_message_as_Project_already_exist_(String msg) {
        Assert.assertTrue(Utils.isTextPresent(msg));
    }

    @And("^Clicks on 'forgot Password' link$")
    public void Clicks_on_forgot_Password_link() {

        forgotpwdpage.click_on_forgot_password();

        Utils.sleep(5);

    }

    @Then("^Admin sees 'Which is yor favourite place' in new page$")
    public void Admin_sees_Which_is_yor_favourite_place_in_new_page() {

        Assert.assertTrue(Utils.isElementPresent(By.name("favplace")));

    }


    @When("^Admin enters  answer as '(.*)'$")
    public void Admin_enters_answer_as_london(String favplace) {
        forgotpwdpage.enter_answer_as_london(favplace);
    }

    @When("^Clicks on 'Go' Button$")
    public void Clicks_on_Go_Button() {
        forgotpwdpage.click_on_go_buton();
        Utils.sleep(5);
    }

    @Then("^Admin should redirect to new password page$")
    public void Admin_should_redirect_to_new_password_page() {
        Assert.assertTrue(Utils.isElementPresent(By.name("newpassword")));
        Assert.assertTrue(Utils.isElementPresent(By.name("confpass")));
    }

    @When("^Admin enters 'new password' as '(.*\\d+)'$")
    public void Admin_enters_new_password_as_Tvishi_(String pwd) {
        forgotpwdpage.enter_new_pwd(pwd);


    }

    @When("^Admin enters  'confirmpassword' as '(.*\\d+)'$")
    public void Admin_enters_confirmpassword_as_Tvishi_(String confpass) {
        forgotpwdpage.enter_confirmpassword(confpass);


    }

    @Then("^Admin clicks on 'save'$")
    public void Admin_clicks_on_save() {
        forgotpwdpage.click_on_save();
        Utils.sleep(5);
    }


    @And("^Error message 'please enter correct password' should display.$")
    public void Error_message_please_enter_correct_password_should_display() {
        Assert.assertTrue(Utils.isElementPresent(By.id("passworderror")));

    }

    @Then("^Error message 'Invalid Answer' should display$")
    public void Error_message_Invalid_Answer_should_display() {
        Assert.assertTrue(Utils.isElementPresent(By.id("usererror")));
    }

    @When("^Admin clicks 'logout' button$")
    public void Admin_clicks_logout_button() {
        forgotpwdpage.click_logout();
        Utils.sleep(5);
    }

    @Then("^project admin is in project home page$")
    public void project_admin_is_in_project_home_page() {
        Assert.assertTrue(Utils.isTextPresent("Hi, ProjectAdmin"));
    }

    @When("^project admin open the tester module$")
    public void open_the_tester_module() {
        projecthomepage.clickTesterTab();
        Utils.sleep(5);

    }

    @When("^Click on Add tester button$")
    public void Click_on_Add_tester_button() {
        testers.clickAddTesterButton();

        Utils.sleep(5);

    }

    @Then("^the add tester page is displayed$")
    public void the_add_tester_page_is_displayed() {
        Assert.assertTrue(Utils.getVisibleText().contains("Add Tester"));
    }


    @When("^enters the '(.*)' as Fullname$")
    public void enters_the_Testerone_as_Fullname(String Fullname) {

        addtester.enterFullname(Fullname);
    }

    @When("^enters '(.*)' as username$")
    public void enters_TestUser_as_username(String username) {
        addtester.enterUsername(username);

    }

    @When("^enters '(.*)' as a new username$")
    public void enters_TestUser_as_new_username(String username) {
        username = username + String.valueOf(Math.abs(random.nextInt()));
        addtester.enterUsername(username);

    }

    @When("^edits '(.*)' as a new username$")
    public void edits_username_as_a_new_username(String username) {
        addtester.enterUsername(username);
    }

    @When("^enters '(.*)' as password$")
    public void enters_Password_as_password(String password) {
        addtester.Password(password);
    }

    @When("^enters '(.*)' as confirm password$")
    public void enter_Password_as_confirm_password(String password) {
        addtester.ConfirmPassword(password);
    }

    @When("^enters '(.*)' as email$")
    public void _testuser_example_com_as_email(String email) {
        addtester.email(email);
    }

    @When("^enters '(.*)' as a favourite Place$")
    public void _London_as_a_favourite_Place(String favouritePlace) {
        addtester.FavouritePlace(favouritePlace);
    }

    @When("^saves the form$")
    public void saves_the_form() {
        addtester.clickSaveButton();

    }

    @Then("^the success message is shown as dialog$")
    public void the_success_message_is_shown_as_dialog() {
        Assert.assertTrue(Utils.getVisibleText().contains("Tester details saved Successfully"));
    }

    @Then("^Click on ok button$")
    public void Click_on_ok_button() {
        addtester.clickokButton();

    }

    @Then("^the user is in Tester List page$")
    public void the_user_is_in_Tester_List_page() {
        Assert.assertTrue(Utils.getVisibleText().contains("Testers"));
    }

    @Then("^the Error message '(.*)' is shown as Error$")
    public void the_Error_message_is_shown_as_Error(String error) {
        Assert.assertTrue(Utils.getVisibleText().contains(error));
    }

    @Then("^the Error message is shown as Password mismatch$")
    public void the_Error_message_is_shown_as_Password_mismatch() {
        Assert.assertTrue(Utils.getVisibleText().contains("Confirm password does not match the password"));
    }

    @Then("^the Error message shown as Username already exists.$")
    public void the_Error_message_shown_as_Username_already_exists() {
        Assert.assertTrue(Utils.getVisibleText().contains("Username already exists."));
    }

    @When("^Click on Edit tester link for first user$")
    public void Click_on_Edit_tester_link_for_first_user() {

        testers.clickEditTester();


    }

    @Then("^the edit tester form is displayed$")
    public void the_edit_tester_form_is_displayed() {
        Assert.assertTrue(Utils.getVisibleText().contains("Edit Tester"));
    }

    @Then("^the success message for edit is shown as dialog$")
    public void the_success_message_for_edit_is_shown_as_dialog() {
        Assert.assertTrue(Utils.getVisibleText().contains("Tester details Updated Successfully"));
    }

    @Then("^user can view updated details for tester$")
    public void user_can_view_updated_details_for_tester() {
        Assert.assertTrue(Utils.getVisibleText().contains("Testerone"));
    }

    @Given("^User is on the 'Add Project Admin' Page logged in with 'testlabadmin' as username and 'admin' as password$")
    public void User_is_on_the_Add_Project_Admin_Page_logged_in_with_testlabadmin_as_username_and_admin_as_password() {

    }


    // Add Project Admin User by Super User - ---- Bharathi


    @Given("^User is on the 'Add Project Admin' Page logged in with '(.*)' as username and '(.*)' as password$")
    public void User_is_on_the_Add_Project_Admin_Page_logged_in_with_testlabadmin_as_username_and_Admin1_as_password(String uname, String pwd) {
        loginPage.login(uname,pwd);
        Utils.sleep(5);
        home.navigateToAddProjectAdminUser();
        Assert.assertTrue(Utils.isTextPresent("Add Project Admin"));
    }

    @When("^the User enters the Valid data in all the fields$")
    public void the_User_enters_the_Valid_data_in_all_the_fields() {

        fullname = "James" + new Random().nextInt(100);
        uname = "jack" + new Random().nextInt(100);
        pwd = "Kate12";
        confpwd = "Kate12";
        email = "james02@gmail.co.uk";
        favplace = "london";
        project = "testlab";
        addprojectadminpage.enterProjectAdmins(fullname, uname, pwd, confpwd, email, favplace, project);

    }

    @And("^User Clicks the 'Save ' button$")
    public void User_Clicks_the_Save_button() {
        addprojectadminpage.saveProjectAdmins();
    }

    @Then("^User Should see the message dialog box 'Project Admin User details saved Successfully'$")
    public void User_Should_see_the_message_dialog_box_Project_Admin_User_details_saved_Successfully() {
        Assert.assertTrue(Utils.isElementPresent(By.xpath(".//*[@id='success_dialog']/div/div/div/button")));
    }

    @When("^User clicks 'Ok' button in the message dialog box$")
    public void User_clicks_Ok_button_in_the_message_dialog_box() {
        addprojectadminpage.clikok();
    }

    @And("^User can see the newly added user in the 'Project Admin User ' Lists in the home page under the 'users' tab$")
    public void User_can_see_the_newly_added_user_in_the_Project_Admin_User_Lists_in_the_home_page_under_the_users_tab() {
        Utils.sleep(5);

        for (int i = 0; i < 10; i++) {
            Utils.sleep(5);
            if (Utils.isTextPresent((fullname)))
                break;
            home.goToNextPage();

        }

    }

    @When("^User does not enter the mandatory fields$")
    public void User_does_not_enter_the_mandatory_fields() {
        home.navigateToAddProjectAdminUser();
        Utils.sleep(5);
    }

    @And("^User clicks 'Save' button$")
    public void User_clicks_Save_button() {
        addprojectadminpage.saveProjectAdmins();
    }

    @Then("^User should see a message ' Please enter all the mandatory fields'$")
    public void User_should_see_a_message_Please_enter_all_the_mandatory_fields() {
        Assert.assertTrue(Utils.isTextPresent("Please enter all the mandatory fields"));
    }

//    @When("^User enters '(.*)' '(.*) '(.*)' '(.*)' '(.*)' '(.*)' '(.*)' as invalid details$")
//    public void User_enters_fullname_Username_Password_Confirmpassword_Email_favouriteplace_Project_as_invalid_details(String fullname,String uname,String pwd,String confpwd,String email,String favplace,String project)
//    {
//        addprojectadminpage.enterProjectAdmins(fullname,uname,pwd,confpwd,email,favplace,project);
//
//    }

    @When("^User enters '(.*)','(.*)','(.*)','(.*)','(.*)','(.*)','(.*)' as invalid details$")
    public void User_enters_fullname_Username_Password_Confirmpassword_Email_favouriteplace_Project_as_invalid_details(String fullname, String uname, String pwd, String confpwd, String email, String favplace, String project) {
        addprojectadminpage.enterProjectAdmins(fullname, uname, pwd, confpwd, email, favplace, project);


    }


    //smitha
    @Given("^Admin is on the 'Add Project Admins ' Page$")
    public void Admin_is_on_the_Add_Project_Admins_Page() {

        Utils.sleep(5);
        //   Assert.assertTrue(Utils.isTextPresent("Add project"));
        home.navigateToAddProjectAdminUser();
    }

    @Then("^user navigate to project admins list page$")
    public void user_navigate_to_project_admins_list_page() {
        Assert.assertTrue(Utils.getVisibleText().contains("Project Admins"));
    }

    @When("^Project Admin enter Username and Password created by super admin$")
    public void enter_Username_and_Password_created_by_super_admin() {
        loginPage.login("testlabadmin","Admin1");
        Utils.sleep(5);

    }
    @Then("^Project Admin should login successfully$")
    public void Project_Admin_should_login_successfully() {
        // Utils.sleep(5);
        Assert.assertTrue(Utils.isElementPresent(By.linkText("Logout")));
    }

    @Then("^Project Admin should see 'Welcome ProjectAdmin' text message,dashboard.$")
    public void Admin_should_see_Welcome_ProjectAdmin_text_message_dashboard() {
        Assert.assertTrue(Utils.isTextPresent(fullname));
    }
    @And("^Admin Saved new project admin details$")
    public void Admin_Saved_the_ProjectAdmin_details()  {
        addprojectadminpage.saveProjectAdmins();

    }

    @And("^Admin Clicks the 'Save ' button$")
    public void Admin_Clicks_the_Save_button() {
        addprojectadminpage.saveProjectAdmins();
    }
}




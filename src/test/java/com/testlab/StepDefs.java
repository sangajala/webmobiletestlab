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
    ProjectsPage projectspage;
    TestFolderPanelPage folderpanelpage;
    ProjectSettings projectsettings;
    Testers testers;
    AddTester addtester;
    EditProjectAdminPage editprojectadminpage;
    MyaccountPage myaccount;
    TestCasesPage testcasespage;
    Random random = new Random();
    String name1, desc;
    public static String name;
    String fullname, uname, pwd, confpwd, email, favplace, project;
    String Title, Owner, Description, ExpectedResult;
    static String fname;
    static int index;

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
        testcasespage = new TestCasesPage();
        projectspage = new ProjectsPage();
        folderpanelpage = new TestFolderPanelPage();
        projectsettings = new ProjectSettings();
        editprojectadminpage = new EditProjectAdminPage();
        myaccount = new MyaccountPage();

        if (Utils.isElementPresent(By.linkText("Logout")))
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
        loginPage.login("testlabadmin", "Admin1");
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

    @Then("^Admin sees the new page to enter username and favorite place$")
    public void Admin_sees_Which_is_yor_favourite_place_in_new_page() {

        Assert.assertTrue(Utils.isElementPresent(By.name("favplace")));

    }


    @And("^Admin enters  answer as '(.*)'$")
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





    @Given("^User is on the 'Add Project Admin' Page logged in with '(.*)' as username and '(.*)' as password$")
    public void User_is_on_the_Add_Project_Admin_Page_logged_in_with_testlabadmin_as_username_and_Admin1_as_password(String uname, String pwd) {
        loginPage.login(uname, pwd);
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
        project = "Manual Testing94";
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
        fullname = null;
        uname = "jack" + new Random().nextInt(100);
        pwd = "Kate12";
        confpwd = "Kate12";
        email = "james02@gmail.co.uk";
        favplace = "london";
        //project = "Manual Testing60";
        addprojectadminpage.enterProjectAdmins(fullname, uname, pwd, confpwd, email, favplace, project);
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

    @When("^Admin enters '(.*)','(.*)','(.*)','(.*)','(.*)','(.*)','(.*)' as invalid details$")
    public void User_enters_fullname_Username_Password_Confirmpassword_Email_favouriteplace_Project_as_invalid_details(String fullname, String uname, String pwd, String confpwd, String email, String favplace, String project) {
        addprojectadminpage.enterProjectAdmins(fullname, uname, pwd, confpwd, email, favplace, project);


    }


    //smitha
    @Given("^Admin is on the 'Add Project Admins ' Page$")
    public void Admin_is_on_the_Add_Project_Admins_Page() {
        loginPage.login("testlabadmin", "Admin1");
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
        loginPage.login(uname, pwd);
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
    public void Admin_Saved_the_ProjectAdmin_details() {
        addprojectadminpage.saveProjectAdmins();

    }

    @And("^Admin Clicks the 'Save ' button$")
    public void Admin_Clicks_the_Save_button() {
        addprojectadminpage.saveProjectAdmins();
    }

    @Given("^Project Admin is in 'Test Case view panel' Page logged in as '(.*)' as username and '(.*)' as password$")
    public void Project_Admin_is_in_Add_Test_Case_Page(String uname,String pwd) {
        loginPage.login(uname,pwd);
        Utils.sleep(5);
        home.navigateToTestCaseViewPanel();
    }


    @And("^Click on AddTestCase$")
    public void Click_on_AddTestCase() {
        testcasespage.clickAddtestcase();

    }

    @When("^enters all valid data$")
    public void enters_all_valid_data() {
        Title = "Test case Title";
        Owner = "Testerone";
        Description = "Testcase description";
        ExpectedResult = "Result expected";
        testcasespage.AddTestCase(Title, Owner, Description, ExpectedResult);
    }

    @And("^'Save' AddTestCase$")
    public void click_Save_button_for_save_new_TestCase() {
        testcasespage.SaveTestCase();
    }

    @Then("^Navigates to the Test cases view panel$")
    public void Navigates_to_the_Test_cases_view_panel() {
        Assert.assertTrue(Utils.isTextPresent("TC Id"));
    }

    @And("^can see the newly added test case$")
    public void can_see_the_newly_added_test_case() {
        Utils.sleep(5);
        Assert.assertTrue(Utils.isTextPresent(Title));
    }

    @When("^User enters '(.*)','(.*)','(.*)','(.*)' as invalid details$")
    public void User_enters_Title_Owner_Description_Expected_Results_as_invalid_details(String Title, String Owner, String Description, String ExpectedResult) {
        testcasespage.AddTestCase(Title, Owner, Description, ExpectedResult);
        Utils.sleep(5);
    }

    @And("^Testcases already added to the view panel$")
    public void Testcases_already_added_to_the_view_panel() {
        Assert.assertTrue(Utils.isElementPresent(By.cssSelector("img[title=\"Edit Testcase\"]")));

    }

    @When("^Clicks on the 'Edit Test Case' image button of the testcase to be edited$")
    public void Clicks_on_the_Edit_Test_Case_image_button_of_the_testcase_to_be_edited() {
        testcasespage.ClickEditTestCaselink();
    }

    @Then("^User sees the 'Edit Test Case' Page with the already added data$")
    public void User_sees_the_Edit_Test_Case_Page_with_the_already_added_data() {
        Assert.assertTrue(Utils.isTextPresent("Edit Testcase"));

    }

    @When("^User changes any field with valid data$")
    public void User_changes_any_field_with_valid_data() {
        Title = "Edit Test case";
        Owner = "Testerone1";
        Description = "Edit Testcase description";
        ExpectedResult = "Edit Result expected";
        testcasespage.EditTestCase(Title, Owner, Description, ExpectedResult);

    }


    @And("^save Edit TestCase$")
    public void save_Edit_TestCase() {
        testcasespage.SaveEditTestCase();
    }


    @When("^User edits '(.*)','(.*)','(.*)','(.*)' as invalid details$")
    public void User_edits_Title_Owner_Description_Expected_Results_as_invalid_details(String Title, String Owner, String Description, String ExpectedResult) {
        testcasespage.EditTestCase(Title, Owner, Description, ExpectedResult);
        Utils.sleep(5);
    }

    @Given("^user is in projects page$")
    public void user_is_in_projects_page() {
       loginPage.login("testlabadmin", "Admin1");
        Utils.sleep(5);
    }

    @When("^click on delete option for selected project$")
    public void click_on_delete_option_for_selected_project()  {
      //driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[4]/a[2]/img")).click();
        projectspage.DeleteProject();
    }

    @Then("^navigate to the confirmation box with the two option ok and cancel$")
    public void navigate_to_the_confirmation_box_with_the_two_option_ok_and_cancel() {
        Assert.assertTrue(Utils.isTextPresent("Ok"));

    }

    @When("^click on ok button$")
    public void click_on_ok_button() {
        driver.findElement(By.xpath("//*[@id=\"delete_dialog\"]/div/div/form/div/button[1]")).click();
    }

    @Then("^Selected project should be deleted from the list$")
    public void Selected_projected_should_be_deleted_from_the_list() {
        Assert.assertTrue(Utils.isTextPresent("Name"));
    }

    @Given("^Project Admin is in testers page$")
    public void Project_Admin_is_in_testers_page() {
        loginPage.login("projectadmin", "Admin1");
        Utils.sleep(5);
        home.navigateToTesterPage();
        Utils.sleep(5);
    }

    @When("^click on delete option for selected tester$")
    public void click_on_delete_option_for_selected_tester() {
      testers.DeleteTester();
    }

    @Then("^selected Tester should be deleted from the list$")
    public void selected_Tester_should_be_deleted_from_the_list(){
        Assert.assertTrue(Utils.isTextPresent("Name"));

    }

    @When("^click on cancel button$")
    public void click_on_cancel_button()  {
        driver.findElement(By.xpath("//*[@id=\"delete_dialog\"]/div/div/form/div/button[2]")).click();


    }

    @Then("^selected Tester should not be deleted$")
    public void selected_Tester_should_not_be_deleted() {
        Assert.assertTrue(Utils.isTextPresent("Name"));

    }

    @And("^click on Edit option for selected project$")
    public void click_on_Edit_option_for_selected_project()  {
      projectspage.EditProject();
        Utils.sleep(5);
    }

    @When("^Admin edit Project with valid 'Project name' and 'Project description'$")
    public void Admin_edit_Project_with_valid_Project_name_and_valid_Project_Desc() {
        name = "Edit Project" + new Random().nextInt(100);
        addProject.enterProjectname(name);
        desc = "Edit project description" + new Random().nextInt(100);
        addProject.enterProjectDesc(desc);
        //addProject.enterProjectDesc("Edit Description");
    }

    @And("^edited project should be there in projects list$")
    public void edited_projct_should_be_there_in_projects_list() throws Throwable {
        Assert.assertTrue(Utils.isTextPresent(name));
    }

    @When("^Admin edit Project with existing 'Project name'$")
    public void Admin_edit_Project_with_existing_Project_name() {
        name = "Latest";
        addProject.enterProjectname(name);
    }
    @Given("^Project Admin is in 'Test Case view panel' Page logged in as '(.*)' as username and '(.*)' as Password$")
       public void Project_Admin_is_in_Test_Case_view_panel_Page_logged_in_as_projectadmin_as_username_and_Admin_as_Password(String uname,String Pwd)
        {
                loginPage.login(uname,Pwd);
                Utils.sleep(5);
                home.navigatetotestcasepage();
                Assert.assertTrue(Utils.isTextPresent("Test Cases"));
                Utils.sleep(5);

          }

       @When("^User clicks button to add a new folder$")
       public void User_clicks_button_to_add_a_new_folder() {
            folderpanelpage.clickaddfolder();
           Utils.sleep(5);
      }

     @Then("^User can see the Add Folder popup window$")
        public void User_can_see_the_Add_Folder_popup_window(){
       Assert.assertTrue(Utils.isTextPresent("Add Folder"));
   }

    @When("^User enters the folder name as '(.*)'$")
    public void User_enters_the_folder_name_as_Level_(String foldername) {
        fname = foldername + new Random().nextInt(100);
                folderpanelpage.enterfoldername(fname);

    }

      @And("^clicks save button$")
      public void clicks_save_button() {
           folderpanelpage.clicksave();
            Utils.sleep(5);
     }

     @Then("^User can see the folder in the folder panel$")
       public void User_can_see_the_folder_in_the_folder_panel() {
            Assert.assertTrue(Utils.isTextPresent(fname));
       }
  /*  @And("^Admin edit Project with valid 'Project description'$")
    public void Admin_edit_Project_with_valid_Project_description() {
       addProject.enterProjectDesc("Edit project Description");
    }*/
    @Given("^User is in project Admins page$")
     public void User_is_in_project_Admins_page() {
              loginPage.login("testlabadmin","Admin1");
              Utils.sleep(5);
              home.NavigateProjectAdminspage();

                 }

             @And("^Click on Edit Project Admin link for the first user$")
       public void Click_on_Edit_Project_Admin_link_for_the_first_user() {
                driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[5]/a[1]/img")).click();
                Utils.sleep(5);
           }

               @When("^edit the '(.*)' as Fullname$")
        public void edit_the_Project_admin_as_Fullname(String fullname) {
             editprojectadminpage.Editfullname(fullname);

                   }

              @And("^edit the '(.*)' as new UserName$")
        public void edit_the_Proadmin_as_new_UserName(String uname)  {
               uname = uname + String.valueOf(Math.abs(random.nextInt()));
                editprojectadminpage.EdituserName(uname);
           }

               @And("^edit the '(.*)' as Password$")
      public void edit_the_Password_as_Password(String pwd) {
                editprojectadminpage.EditPassword(pwd);
           }

              @And("^edit the '(.*)' as Confirm Password$")
       public void edit_the_Password_as_Confirm_Password(String pwd)  {
                editprojectadminpage.EditConfirmPassword(pwd);
           }

                @And("^edit the '(.*)' as Email$")
        public void edit_the_Example_test_com_as_Email(String Email)  {
                editprojectadminpage.EditEmail(Email);
           }

               @And("^edit the '(.*)' as FavouritePlace$")
       public void edit_the_London_as_FavouritePlace(String favplace) {
              editprojectadminpage.EditFavouriteplace(favplace);
           }

              @And("^select the project$")
      public void edit_the_Manual_testing_as_project() {
              editprojectadminpage.Editproject(2);

              Utils.sleep(5);
           }

              @And("^user can view updated details for Project Admin$")
        public void user_can_view_updated_details_for_Project_Admin() {
               Utils.sleep(5);
               // Assert.assertFalse(Utils.isTextPresent(uname));
                      Assert.assertTrue(Utils.getVisibleText().contains("Project admin"));
        }

               @Then("^User Should see the message dialog box 'Project Admin details updated Successfully'$")
     public void User_Should_see_the_message_dialog_box_Project_Admin_details_updated_Successfully() throws Throwable {
               Assert.assertTrue(Utils.isTextPresent("Project Admin details updated Successfully"));
          }

              @And("^User is in project Admins list page$")
     public void User_is_in_project_Admins_list_page() {
                Assert.assertTrue(Utils.isTextPresent("Assigned Project"));
          }

               @When("^User edits '(.*)','(.*)','(.*)','(.*)','(.*)','(.*)','(\\d+)' as invalid details for project Admin$")
     public void User_edits_fullname_Username_Password_Confirmpassword_Email_favouriteplace_as_invalid_details_for_project_Admin(String fullname, String Username, String pswd, String Cpswd, String Email, String favplace,int projectindex) {


                   editprojectadminpage.editProjectAdmins(fullname,Username,pswd,Cpswd,Email,favplace,projectindex);
           }

                @Given("^User is in 'Project Settings' page$")
        public void User_is_in_Project_Settings_page() {
                loginPage.login("projectadmin", "Admin1");
                Utils.sleep(5);
                home.navigateToProjectSettings();
               Utils.sleep(5);
              }

                @When("^User selects 'Hold test case execution' button$")
        public void User_selects_Hold_test_case_execution_button() {
                projectsettings.HoldTestCase();
           }

              @Then("^User sees the message dialogue box 'Do you really want to Hold Testcase execution ' with 'Ok' and 'Cancel' button$")
       public void User_sees_the_message_dialogue_box_Do_you_really_want_to_Hold_Testcase_execution_with_Ok_and_Cancel_button() {
                Assert.assertTrue(Utils.isTextPresent("Do you really want to Hold Testcase Execution ?"));
          }

                @When("^User selects 'Ok'$")
      public void User_selects_Ok()  {
              projectsettings.ClickOk();
           }

               @Then("^User sees the 'hold test case execution' button changed to 'unhold test case execution'$")
     public void User_sees_the_hold_test_case_execution_button_changed_to_unhold_test_case_execution()  {
             Assert.assertTrue(Utils.isTextPresent("UnHold Testcase Execution"));

                  }

               @Then("^All the active testcases becomes inactive$")
      public void All_the_active_testcases_becomes_inactive()  {
               Utils.sleep(5);
               home.navigateToReports();
                Utils.sleep(5);
                Assert.assertTrue(Utils.isTextPresent("No testcases yet for this project."));
           }


              @When("^User selects 'Unhold test case execution' button$")
     public void User_selects_Unhold_test_case_execution_button() {
                home.navigateToProjectSettings();
                Utils.sleep(5);
                projectsettings.UnHoldTestCase();
                         }

              @Then("^User sees the message dialogue box 'Do you really want to UnHold Testcase execution ' with 'Ok' and 'Cancel' button$")
     public void User_sees_the_message_dialogue_box_Do_you_really_want_to_UnHold_Testcase_execution_with_Ok_and_Cancel_button() {
                Assert.assertTrue(Utils.isTextPresent("Do you want to UnHold Testcase Execution ?"));
          }

          @Then("^User sees the 'unhold test case execution' button changed to 'hold test case execution'$")
     public void User_sees_the_unhold_test_case_execution_button_changed_to_hold_test_case_execution() {
                Assert.assertTrue(Utils.isTextPresent("Hold Testcase Execution"));
          }

                @Then("^All the holded testcases are now unholded i.e made active$")
     public void All_the_holded_testcases_are_now_unholded_i_e_made_active() {
                    home.navigateToReports();
                    Utils.sleep(5);
                    Assert.assertFalse(Utils.isTextPresent("No testcases yet for this project."));
                }
                    @When("^User selects 'Ok' for Unhold$")
                    public void User_selects_Ok_for_Unhold () {
                        projectsettings.UnholdClickOk();
                    }

    @When("^Admin Enters '(.*)' as username$")
    public void Admin_Enters_testlabadmin_as_username(String uname){
        forgotpwdpage.enterusername(uname);
    }
    @Given("^Super Admin is in 'My Accounts' Page logged in as '(.*)' as username and '(.*)' as password$")
    public void Super_Admin_is_in_My_Accounts_Page_logged_in_as_testlabadmin_as_username_and_Admin_as_password(String uname,String pwd){
        loginPage.login(uname,pwd);
        Utils.sleep(5);
        home.navigatetoaccountdetails();
        Utils.sleep(5);
    }

    @When("^edit the full name as '(.*)'$")
    public void edit_the_full_name_as_Superadmin_(String fullname)  {
        myaccount.editfullname(fullname);
    }

    @And("^edit the username as '(.*)'$")
    public void edit_the_username_as_Testlabadmin_(String uname)  {
        myaccount.edituname(uname);
    }

    @And("^edit the password as '(.*)'$")
    public void edit_the_password_as_Admin_(String pwd)  {
        myaccount.editpwd(pwd);
    }

    @And("^edit the confirm password as '(.*)'$")
    public void edit_the_confirm_password_as_Admin_(String confpwd) {
        myaccount.editconfpwd(confpwd);
    }

    @And("^edit email as '(.*)'$")
    public void edit_email_as_testlabadmin_example_com(String email) {
        myaccount.editemail(email);
    }

    @And("^edit Favorite place as '(.*)'$")
    public void edit_Favorite_place_as_London(String favplace) {
        myaccount.editfavplace(favplace);
    }

    @And("^clicks 'Save' button$")
    public void clicks_Save_button() {
        myaccount.clicksave();
        Utils.sleep(5);
    }

    @Then("^can see the success message dialog box as 'Profile is updated successfully'$")
    public void can_see_the_success_message_dialog_box_as_Profile_is_updated_successfully()  {
        Assert.assertTrue(Utils.isTextPresent("Profile is updated Successfully"));
    }

    @When("^click 'Ok' button$")
    public void click_Ok_button() {
        myaccount.clickok();
    }

    @Then("^ user is in same  page with updated details$")
    public void _user_is_in_same_page_with_updated_details(){
        Assert.assertTrue(Utils.isTextPresent("My Account"));

    }

    @Then("^the message '(.*)'$")
    public void the_message_ErrorMessage_(String error){
        Assert.assertTrue(Utils.getVisibleText().contains(error));
    }


    @And("^the user is in 'My Accounts' Page$")
    public void the_user_is_in_My_Accounts_Page() {
        Assert.assertTrue(Utils.isTextPresent("My Account"));
    }

    @When("^Super admin edits '(.*)','(.*)','(.*)','(.*)','(.*)','(.*)' as invalid details$")
    public void Super_admin_edits_fullname_username_Password_ConfPassword_email_favplace_as_invalid_details(String fname,String uname,String pwd,String confpwd,String email,String favplace){
        myaccount.editfullname(fname);
        myaccount.edituname(uname);
        myaccount.editpwd(pwd);
        myaccount.editconfpwd(confpwd);
        myaccount.editemail(email);
        myaccount.editfavplace(favplace);
    }



    @Then("^can see '(.*)' displayed$")
    public void can_see_ErrorMessage_displayed(String error) {
        System.out.println(error);

        Assert.assertTrue(Utils.isTextPresent(error));

    }
}







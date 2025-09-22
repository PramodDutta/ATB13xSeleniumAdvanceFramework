package com.thetestingacademy.tests.vwo.pageObjectModelTC;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManger;
import com.thetestingacademy.pages.pageObjectModel.vwo.DashBoardPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_Prop_POM extends CommonToAllTest {

    //  D
    // L
    // V


    @Owner("PRAMOD")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(DriverManger.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));



    }

    @Owner("PRAMOD")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage_VWO = new LoginPage(DriverManger.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(DriverManger.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));



    }


}




package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase {
    @BeforeMethod
    public void precondicion() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticerForm();

    }

    @Test
    public void createStudentAccountTest() {
        new PracticeFormPage(driver).hildelframes();
        //enter personal data
        new PracticeFormPage(driver)
                .enterPersonalData("Anna", "Ara", "anaara@123.de", "1234567890")
                //select gender(radio button)
                .selectGender("Male")
                //enter birthday
                .enterBirthDay("16 August 1983")
        //enter subjects
                .enterSubjects(new String[]{"Maths","Chemistry"})
        //select hobby(check box)
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("C:/Tools/iStock-109722775.jpg")
                //select state
                .selectState("NCR")
                //selectCity
                .selectCity("Delhi")
                //click on submit button
                .clickOnSubmit()
                //assert student form is appeared
                .verifySuccessTitle("Thanks for submitting the form");
    }
}

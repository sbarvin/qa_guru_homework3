package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;


public class RegistrationForm extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Test
    void successFillTest() {

        registrationFormPage
                .openPage()
                .checkHeaderTitle("Student Registration Form")
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setBirthDay(testData.birthDayDay, testData.birthDayMonth, testData.birthDayYear)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .uploadFile(testData.file)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .sendForm()
                .checkResultModalTitle("Thanks for submitting the form")
                .checkResultModalTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultModalTable("Student Email", testData.userEmail)
                .checkResultModalTable("Gender", testData.gender)
                .checkResultModalTable("Mobile", testData.userNumber)
                .checkResultModalTable("Date of Birth", testData.birthDayDay + " " + testData.birthDayMonth + "," + testData.birthDayYear)
                .checkResultModalTable("Subjects", testData.subject)
                .checkResultModalTable("Hobbies", testData.hobby)
                .checkResultModalTable("Picture", testData.file.split("/")[testData.file.split("/").length - 1])
                .checkResultModalTable("Address", testData.currentAddress)
                .checkResultModalTable("State and City", testData.state + " " + testData.city);

    }
}

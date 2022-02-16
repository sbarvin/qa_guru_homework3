package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        $("h5").shouldHave(text("Student Registration Form"));

        registrationFormPage.setFirstName("Sergey");
        registrationFormPage.setLastName("Barvin");
        registrationFormPage.setUserEmail("bsk@comp.com");

        $(byText("Male")).click();
        $("#userNumber").setValue("0123456789");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1995");
        $("[aria-label$='July 9th, 1995']").click();

        $("#subjectsInput").setValue("Arts").pressEnter();

        $(byText("Sports")).click();

        File file = new File("src/test/resources/img/pic.png");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Russia, Republic of Bashkortostan");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Sergey Barvin"),
                text("bsk@comp.com"),
                text("Male"),
                text("0123456789"),
                text("9 July,1995"),
                text("Arts"),
                text("Sports"),
                text("pic.png"),
                text("Russia, Republic of Bashkortostan"),
                text("NCR Noida"));

    }
}

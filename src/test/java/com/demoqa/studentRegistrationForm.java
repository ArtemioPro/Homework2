package com.demoqa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class studentRegistrationForm {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1500x1080";
        Configuration.holdBrowserOpen = Boolean.parseBoolean("true");
    }


    @Test
    void fillFormTest() {
        open("automation-practice-form");
        $("[id=userName]").setValue("Artem");
        $("#userEmail").setValue("Artem69@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("55555555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(4);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(1994);
        $(".react-datepicker__year-select").click();
        $("react-datepicker__day react-datepicker__day--005").click();
        $("subjectsContainer").setValue("Biology").pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo.jpg"));
        $("#currentAddress").setValue("Moscow, Koroleva 21");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Artem"));
        $(".modal-body").shouldHave(text("Artem69@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("55555555"));
        $(".modal-body").shouldHave(text("05 May,1994"));
        $(".modal-body").shouldHave(text("Moscow, Koroleva 21"));
        $(".modal-body").shouldHave(text("Biology"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("photo.jpg"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

    }
}



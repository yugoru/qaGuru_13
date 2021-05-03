package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Форма регистрации студента")
public class TextBoxTestsYugoru extends TestBase {

    String firstName = "Ada",
            lastName = "Lovelace",
            subject = "Hindi",
            subject2 = "Maths",
            currentAddress = "Russia \n St.Petersburg \n Viborgskaya naberejnaya \n Rozoviy dom",
            email = "e@ma.ru",
            phone = "0909090909",
            gender = "label[for=gender-radio-2]",
            genderName = "Female",
            hobby2 = "Music",
            hobby3 = "Reading",
            month = "April",
            year = "1991",
            day = ".react-datepicker__day--026",
            convertedDate = "26 " + month + "," + year,
            state = "Haryana",
            fileName = "1.jpeg",
            city = "Panipat";
    Path filePath = Paths.get("src/test/resources/" + fileName);
    File file = new File(filePath.toString());

    @Test
    @DisplayName("Это SMOKE")
    @Owner("yugoru")
    @Tag("smoke")

    void successfulTest2() {
        step("Открываем форму регистрации студента", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        step("Вводим имя и e-mail", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(email);
        });
        step("Выбираем гендер (радиобаттон)", () -> {
            $(gender).click();
        });
        step("Заполняем телефон", () -> {
            $("#userNumber").setValue(phone);
        });
        step("Выбираем дату рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").find(byText(month)).click();
            $(".react-datepicker__year-select").find(byText(year)).click();
            $(day).click();
        });
        step("Выбор Subject (подставляем значение и кликаем)", () -> {
            $("#subjectsInput").setValue(subject).pressEnter();
            $("#subjectsInput").setValue(subject2).pressEnter();
        });
        step("Выбираем хобби (чекбокс)", () -> {
            $("#hobbiesWrapper").find(byText(hobby2)).click();
            $("#hobbiesWrapper").find(byText(hobby3)).click();
        });
        step("Загружаем картинку", () -> {
            $("#uploadPicture").uploadFile(file);
        });
        step("Вводим адрес (текстовое поле)", () -> {
            $("#currentAddress").setValue(currentAddress);
        });
        step("Выбираем штат, потом город (два последовательно выпадающих меню)", () -> {
            $("#stateCity-wrapper").$("#state").scrollTo().click();
            $(".css-26l3qy-menu div").find(byText(state)).click();
            $("#stateCity-wrapper").find(byId("city")).click();
            $(".css-26l3qy-menu div").find(byText(city)).click();
        });
        step("Подтверждаем регистрацию", () -> {
            $("#submit").click();
        });
        step("Проверяем заполненные поля", () -> {
            $(".table-responsive").shouldHave((text(firstName + " " + lastName)),
                    text(email),
                    text(genderName),
                    text(phone),
                    text(convertedDate),
                    text(subject),
                    text(subject2),
                    text(hobby2),
                    text(hobby3),
                    text(fileName),
                    text(currentAddress),
                    text(state + " " + city));
        });
        step("Закрываем форму проверки", () -> {
            $(".modal-content").find(byCssSelector("#closeLargeModal")).click();
        });
    }
    @Test
    @DisplayName("ЭТО REGRESS")
    @Owner("yugoru")
    @Tag("regress")
    void successfulTest() {
        step("Открываем форму регистрации студента", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        step("Вводим имя и e-mail", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(email);
        });
        step("Выбираем гендер (радиобаттон)", () -> {
            $(gender).click();
        });
        step("Заполняем телефон", () -> {
            $("#userNumber").setValue(phone);
        });
        step("Выбираем дату рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").find(byText(month)).click();
            $(".react-datepicker__year-select").find(byText(year)).click();
            $(day).click();
        });
        step("Выбор Subject (подставляем значение и кликаем)", () -> {
            $("#subjectsInput").setValue(subject).pressEnter();
            $("#subjectsInput").setValue(subject2).pressEnter();
        });
        step("Выбираем хобби (чекбокс)", () -> {
            $("#hobbiesWrapper").find(byText(hobby2)).click();
            $("#hobbiesWrapper").find(byText(hobby3)).click();
        });
        step("Загружаем картинку", () -> {
            $("#uploadPicture").uploadFile(file);
        });
        step("Вводим адрес (текстовое поле)", () -> {
            $("#currentAddress").setValue(currentAddress);
        });
        step("Выбираем штат, потом город (два последовательно выпадающих меню)", () -> {
            $("#stateCity-wrapper").$("#state").scrollTo().click();
            $(".css-26l3qy-menu div").find(byText(state)).click();
            $("#stateCity-wrapper").find(byId("city")).click();
            $(".css-26l3qy-menu div").find(byText(city)).click();
        });
        step("Подтверждаем регистрацию", () -> {
            $("#submit").click();
        });
        step("Проверяем заполненные поля", () -> {
            $(".table-responsive").shouldHave((text(firstName + " " + lastName)),
                    text(email),
                    text(genderName),
                    text(phone),
                    text(convertedDate),
                    text(subject),
                    text(subject2),
                    text(hobby2),
                    text(hobby3),
                    text(fileName),
                    text(currentAddress),
                    text(state + " " + city));
        });
        step("Закрываем форму проверки", () -> {
            $(".modal-content").find(byCssSelector("#closeLargeModal")).click();
        });
    }
}

package guru.qa.tests;

import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static guru.qa.utils.Testdata.*;

public class TextBoxPageTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @CsvSource(value = {
            "John Jackson   | john.jackson@gmail.com     | Washington | Massachusetts",
            "Hailie Jackson | hailie.jackson@hotmail.com | Washington | Washington",
            "Valarie Rivera | valarie.rivera@gmail.com   | Nevada     | Virginia",
            "Linzi Morgan   | linzi.morgan@mail.ru       | Virginia   | Nevada"
    },
            delimiter = '|')
    @ParameterizedTest(name = "В output блоке отображается FullName {0}, Email {1}, " +
            "CurrentAddress {2}, PermanentAddress {3}")
    @DisplayName("fillFormCsvSourceTest. В output блоке отображается FullName {0}, Email {1}, " +
            "CurrentAddress {2}, PermanentAddress {3}")
    void fillFormCsvSourceTest(String userFullName, String userEmail, String userCurrentAddress, String userPermanentAddress) {
        textBoxPage
                .openPage()
                .deleteBannersAndFooters()
                .setUserName(userFullName)
                .setUserEmail(userEmail)
                .setCurrentAddress(userCurrentAddress)
                .setPermanentAddress(userPermanentAddress)
                .clickSubmit();

        textBoxPage
                .checkResultName(userFullName)
                .checkResultEmail(userEmail)
                .checkResultCurrentAddress(userCurrentAddress)
                .checkResultPermanentAddress(userPermanentAddress);
    }

    @CsvFileSource(resources = "/fillFormCsvFileSourceTest.csv",
            delimiter = '|')
    @ParameterizedTest(name = "В output блоке отображается FullName {0}, Email {1}, " +
            "CurrentAddress {2}, PermanentAddress {3}")
    @DisplayName("fillFormCsvFileSourceTest. В output блоке отображается FullName {0}, Email {1}, " +
            "CurrentAddress {2}, PermanentAddress {3}")
    void fillFormCsvFileSourceTest(String userFullName, String userEmail, String userCurrentAddress, String userPermanentAddress) {
        textBoxPage
                .openPage()
                .deleteBannersAndFooters()
                .setUserName(userFullName)
                .setUserEmail(userEmail)
                .setCurrentAddress(userCurrentAddress)
                .setPermanentAddress(userPermanentAddress)
                .clickSubmit();

        textBoxPage
                .checkResultName(userFullName)
                .checkResultEmail(userEmail)
                .checkResultCurrentAddress(userCurrentAddress)
                .checkResultPermanentAddress(userPermanentAddress);
    }

    static Stream<Arguments> fillFormMethodSourceTest() {
        return Stream.of(
                Arguments.of(userFullName, userEmail, userCurrentAddress, userPermanentAddress)
        );
    }
    @MethodSource
    @ParameterizedTest(name = "В output блоке отображается FullName {0}, Email {1}, " +
            "CurrentAddress {2}, PermanentAddress {3}")
    @DisplayName("fillFormMethodSourceTest. В output блоке отображается FullName {0}, Email {1}, " +
            "CurrentAddress {2}, PermanentAddress {3}")
    void fillFormMethodSourceTest(String userFullName, String userEmail, String userCurrentAddress, String userPermanentAddress) {
        textBoxPage
                .openPage()
                .deleteBannersAndFooters()
                .setUserName(userFullName)
                .setUserEmail(userEmail)
                .setCurrentAddress(userCurrentAddress)
                .setPermanentAddress(userPermanentAddress)
                .clickSubmit();

        textBoxPage
                .checkResultName(userFullName)
                .checkResultEmail(userEmail)
                .checkResultCurrentAddress(userCurrentAddress)
                .checkResultPermanentAddress(userPermanentAddress);
    }
}

//import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import pages.MainPersonPage;
import pages.SendFormPage;
import pages.TravelIsurancePage;
import pages.TravelPage;
import steps.BaseSteps;

import java.util.Set;

public class MyRefactoringTest extends BaseSteps {

    @Test
    @Ignore
    public void newInsuranceTest(){
        getDriver().get(baseUrl);
        MainPersonPage mainPersonPage = new MainPersonPage(getDriver());
        mainPersonPage.selectMainMenu("Страхование");
        mainPersonPage.selectSubMenu("Страхование путешественников");

        TravelPage travelPage = new TravelPage(getDriver());
        Set<String> oldWindowsSet = getDriver().getWindowHandles();
        travelPage.goToBlanc(getDriver(), oldWindowsSet);


        TravelIsurancePage travelIsurancePage = new TravelIsurancePage(getDriver());
        Assert.assertEquals("Выбор полиса", travelIsurancePage.titlePolice.getText());

        travelIsurancePage.insuranceType.click();
        travelIsurancePage.issueButton.click();

        SendFormPage sendFormPage = new SendFormPage(getDriver());
        //Заполнение полей
        sendFormPage.fillField("insured_surname", "Petrova");
        sendFormPage.fillField("insured_name", "Marija");
        sendFormPage.fillField("insured_birthDate", "12052014");
        sendFormPage.fillField("surname", "Петров");
        sendFormPage.fillField("name", "Петр");
        sendFormPage.fillField("middlename", "Петрович");
        sendFormPage.fillField("birthDate", "06071997");
        sendFormPage.fillField("docSeries", "0607");
        sendFormPage.fillField("docNumber", "236755");
        sendFormPage.fillField("issueDate", "25072019");
        sendFormPage.fillField("issuePlace", "Какой-то УВД г.Москвы");

        //Проверка заполнения
        sendFormPage.checkFillField("insured_surname", "Petrova");
        sendFormPage.checkFillField("insured_name", "Marija");
        //String Str = sendFormPage.getIssueDate();
        sendFormPage.checkFillField("insured_birthDate", "12.05.2014");
        sendFormPage.checkFillField("surname", "Петров");
        sendFormPage.checkFillField("name", "Петр");
        sendFormPage.checkFillField("middlename", "Петрович");
        sendFormPage.checkFillField("birthDate", "06.07.1997");
        sendFormPage.checkFillField("docSeries", "0607");
        sendFormPage.checkFillField("docNumber", "236755");
        sendFormPage.checkFillField("issueDate", "25.07.2019");
        sendFormPage.checkFillField("issuePlace", "Какой-то УВД г.Москвы");

        sendFormPage.continueButton.click();

        //проверка сообщения об ошибке
        sendFormPage.CheckAllFieldsFillingMessage();

    }
}
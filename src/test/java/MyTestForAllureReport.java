import org.junit.Test;
import pages.TravelIsurancePage;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;
import java.util.Set;

public class MyTestForAllureReport extends BaseSteps {

    @Test
    @Title("Страхование")
    public void testInsurance(){
        MainPersonSteps mainPersonSteps = new MainPersonSteps();
        TravelSteps travelSteps = new TravelSteps();
        TravelIsuranceSteps travelIsuranceSteps = new TravelIsuranceSteps();
        SendFormSteps sendFormSteps = new SendFormSteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("insured_surname", "Petrova");
        testData.put("insured_name", "Marija");
        testData.put("insured_birthDate", "12052014");
        testData.put("surname", "Петров");
        testData.put("middlename", "Петрович");
        testData.put("birthDate", "06071997");
        testData.put("docSeries", "0607");
        testData.put("docNumber", "236755");
        testData.put("issueDate", "25072019");
        testData.put("issuePlace", "Какой-то УВД г.Москвы");

        mainPersonSteps.stepSelectMenuItem("Страхование");
       // mainPersonSteps.stepSelectMenuInsurance("Страхование путешественников");

        Set<String> oldWindowsSet = getDriver().getWindowHandles();
        travelSteps.stepGoToBlanc(oldWindowsSet); //goToBlanc(getDriver(), oldWindowsSet);


        /*mainPersonPage.selectMainMenu("Страхование");
        mainPersonPage.selectSubMenu("Страхование путешественников");*/



    }
}

package steps;

import pages.TravelIsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;


public class TravelIsuranceSteps extends BaseSteps {


    @Step("выбран тип стрaховки")
    public void stepSelectInsuranceType(){
        new TravelIsurancePage(getDriver()).insuranceType.click();
    }


    @Step("заголовок страницы - Выбор полиса равен {0}")
    public void stepCheckPageTitle(String expectedTitle){
        String actualTitle = new TravelIsurancePage(getDriver()).titlePolice.getText(); //title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    /*Assert.assertEquals("Выбор полиса", travelIsurancePage.titlePolice.getText());

        travelIsurancePage.insuranceType.click();
        travelIsurancePage.issueButton.click();*/
}

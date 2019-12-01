package steps;

import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Set;

public class TravelSteps extends BaseSteps {

    @Step("выполнено нажатие на Отправить онлайн")
    public void stepGoToBlanc(Set<String> oldWindowsSet){
        new TravelPage(getDriver()).goToBlanc(getDriver(), oldWindowsSet);//DMSPage().sendAppBtn.click();
    }


    /*@Step("заголовок страницы - ДМС равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = new DMSPage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }*/

}

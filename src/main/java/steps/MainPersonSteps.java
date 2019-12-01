package steps;
import pages.MainPersonPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPersonSteps extends BaseSteps {

    @Step("выбран пункт меню {0}")
    public void stepSelectMenuItem(String menuItem){
        new MainPersonPage(getDriver()).selectMainMenu(menuItem); //MainPersonPage().selectMenuItem(menuItem);
    }

    @Step("выбран вид страхования {0}")
    public void stepSelectMenuInsurance(String menuItem){
        new MainPersonPage(getDriver()).selectSubMenu(menuItem);
    }

}

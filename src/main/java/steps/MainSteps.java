package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {

    @Step("выбран пункт меню {0}")
    public void stepSelectMenuItem(String menuItem){
       new MainPage(driver).selectMenuItem(menuItem);
    }

    @Step("выбран пункт меню {0}")
    public void stepSelectInsuranceItem(String menuItem){
        new MainPage(driver).selectInsuranceItem(menuItem);
    }
}

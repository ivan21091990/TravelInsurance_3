package steps;

import pages.PolicySelectionPage;
import ru.yandex.qatools.allure.annotations.Step;

public class PolicySelectionSteps extends BaseSteps{

    @Step("Выбор суммы страховой защиты - 'Минимальная'")
    public void stepMinBtnClickable(){
        new PolicySelectionPage(driver).waitMinBtnClickable();
    }

    @Step("выполнено нажатие на кнопку - 'Оформить'")
    public void stepIssueBtn(){
        new PolicySelectionPage(driver).issueBtn.click();
    }
}

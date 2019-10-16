package steps;

import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class SendAppSteps extends BaseSteps {

    @Step("поле {0} заполняется значением {1}")
    public void stepFileField(String field, String value){
        new SendAppPage(driver).fillField(field,value);
    }

    @Step("проверка заполнения поля {0} значением {1}")
    public void stepCheckFileField(String value, String fieldName){
        new SendAppPage(driver).checkFillField(value,fieldName);
    }

    @Step("проверка появления сообщения {0}")
    public void stepCheckFieldErrorMessage(String expectedValue){
        new SendAppPage(driver).checkFieldErrorMessage(expectedValue);
    }

    @Step("заполняются поля: ")
    public  void stepFileFields(HashMap<String,String> fields){
        fields.forEach(this::stepFileField);
    }

    @Step("проверяются поля: ")
    public  void stepCheckFileFields(HashMap<String,String> values){
        values.forEach(this::stepCheckFileField);
    }

    @Step("нажатие на кнопку - 'Продолжить'")
        public void stepSendButton (){
            new SendAppPage(driver).sendButton.click();
    }
}

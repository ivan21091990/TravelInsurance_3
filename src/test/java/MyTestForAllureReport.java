import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

    public class MyTestForAllureReport extends BaseSteps {
        MainSteps mainSteps = new MainSteps();
        PolicySelectionSteps policySelectionSteps = new PolicySelectionSteps();
        SendAppSteps sendAppSteps = new SendAppSteps();
        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();

        HashMap<String,String> fields = new HashMap<>();
        HashMap<String,String> values = new HashMap<>();

    @Test
    @Title("Страхование путешественников")
    public void testTravelInsurance(){
        fields.put("Фамилия застрахованного", "Ivanov");
        fields.put("Имя застрахованного", "Ivan");
        fields.put("Дата рождения застрахованного", "21091990");
        fields.put("Фамилия страхователя", "Сергеев");
        fields.put("Имя страхователя", "Сергей");
        fields.put("Отчество страхователя", "Сергеевич");
        fields.put("Дата рождения страхователя", "01011985");

        values.put("Ivanov",   "Фамилия застрахованного");
        values.put("Ivan", "Имя застрахованного");
        values.put("21.09.1990","Дата рождения застрахованного");
        values.put("Сергеев","Фамилия страхователя");
        values.put("Сергей","Имя страхователя");
        values.put("Сергеевич","Отчество страхователя");
        values.put("01.01.1985","Дата рождения страхователя");


        mainSteps.stepSelectMenuItem("Страхование");
        mainSteps.stepSelectInsuranceItem("Страхование путешественников");

        travelInsuranceSteps.stepSendAppBtn();
        travelInsuranceSteps.stepArrangeOnlineBtn();

        TabNavigation();
        policySelectionSteps.stepMinBtnClickable();
        policySelectionSteps.stepIssueBtn();

        sendAppSteps.stepFileFields(fields);
        sendAppSteps.stepCheckFileFields(values);
        sendAppSteps.stepSendButton();
        sendAppSteps.stepCheckFieldErrorMessage("Заполнены не все обязательные поля");

    }
}

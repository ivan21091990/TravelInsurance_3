import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

    public class MyAllureReportTest extends BaseSteps {
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

        values.put("Фамилия застрахованного", "Ivanov");
        values.put("Имя застрахованного", "Ivan");
        values.put("Дата рождения застрахованного", "21.09.1990");
        values.put("Фамилия страхователя", "Сергеев");
        values.put("Имя страхователя", "Сергей");
        values.put("Отчество страхователя", "Сергеевич");
        values.put("Дата рождения страхователя", "01.01.1985");


        mainSteps.stepSelectMenuItem("Страхование");
        mainSteps.stepSelectInsuranceItem("Страхование путешественников");

        travelInsuranceSteps.stepSendAppBtn();
        travelInsuranceSteps.stepArrangeOnlineBtn();

        TabNavigation();
        policySelectionSteps.stepMinBtnClickable();
        policySelectionSteps.stepIssueBtn();

        sendAppSteps.stepFileFields(fields);
        sendAppSteps.stepCheckFileFields(values);
        sendAppSteps.stepFloorRadBtn();
        sendAppSteps.stepSendButton();
        sendAppSteps.stepCheckFieldErrorMessage("Заполнены не все обязательные поля");

    }
}

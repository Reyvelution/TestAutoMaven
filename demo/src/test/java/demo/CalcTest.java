package demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Verify Calculator Addition Function")
@Feature("Test Add feature")
public class CalcTest {

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the add function positive flow")
    @Story("Add two numbers-Postive flow")
    @Test
    public void addTwoNumbers_1() {
        int a = 2 + 2;
        System.out.println("Execute Unit Tests");
        Assertions.assertTrue(a == 4);

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the add function negative flow")
    @Story("Add two numbers-negative flow")
    @Test
    public void addTwoNumbers_2() {
        int a = 3 + 5;
        Assertions.assertTrue(a == 7);

    }
}

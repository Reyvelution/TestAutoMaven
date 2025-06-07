package demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class CalcTest {

    @Test
    public void addTwoNumbers_1() {
        int a = 2 + 2;
        System.out.println("Execute Unit Tests");
        Assertions.assertTrue(a == 4);

    }

    @Test
    public void addTwoNumbers_2() {
        int a = 3 + 5;
        Assertions.assertTrue(a == 7);

    }
}

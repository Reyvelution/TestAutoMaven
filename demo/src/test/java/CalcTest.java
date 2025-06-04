import org.junit.Test;
import org.junit.Assert;

public class CalcTest {

    @Test
    public void addTwoNumbers_1() {
        int a = 2 + 2;
        System.out.println("Test Maven Auto Project");
        Assert.assertTrue(a == 4);

    }

    @Test
    public void addTwoNumbers_2() {
        int a = 3 + 5;
        Assert.assertTrue(a == 7);

    }
}

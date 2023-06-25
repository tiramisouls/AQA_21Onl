import data.StaticProviderDoubleHW;
import data.StaticProviderIntHW;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTestHW extends BaseTest {
    @Test
    public void divInt_1() {
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test
    public void divDouble_1() {
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (enabled = false)
    public void divInt_2() {
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (enabled = false)
    public void divDouble_2() {
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (description = "Тест с описанием")
    public void divInt_3() {
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (description = "Тест с описанием")
    public void divDouble_3() {
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (testName = "Test with name_1")
    public void divInt_4() {
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (testName = "Test with name_2")
    public void divDouble_4() {
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (timeOut = 1000)
    public void divInt_5() throws InterruptedException {
        Thread.sleep(1000);
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (timeOut = 1000)
    public void divDouble_5() throws InterruptedException {
        Thread.sleep(1000);
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void divInt_6() throws InterruptedException {
        Thread.sleep(500);
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void divDouble_6() throws InterruptedException {
        Thread.sleep(500);
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (expectedExceptions = NullPointerException.class)
    public void divInt_7() {
        List list = null;
        int size = list.size();
    }
    @Test (expectedExceptions = NullPointerException.class)
    public void divDouble_7() {
        List list = null;
        int size = list.size();
    }
    @Test (priority = 1)
    public void divInt_8() {
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (priority = 2)
    public void divDouble_8() {
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (dependsOnMethods = "divInt_5")
    public void divInt_9() {
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (dependsOnMethods = "divInt_9", alwaysRun = true)
    public void divDouble_9() {
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (groups = "smoke", dependsOnGroups = "regression")
    public void divInt_10() {
        int expectedValue = 5;
        int actualValue = calculator.divInt(10,2);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (groups = {"smoke", "regression"})
    public void divDouble_10() {
        double expectedValue = 4.2;
        double actualValue = calculator.divDouble(10.5,2.5);
        Assert.assertEquals(actualValue, expectedValue, "Значения не одинаковые");
    }
    @Test (dataProvider = "Data for Div Int test", dataProviderClass = StaticProviderIntHW.class)
    public void divInt_11(int a, int b, int expectedValue) {
        Assert.assertEquals(calculator.divInt(a, b),expectedValue, "Значения не одинаковые");
    }
    @Test (dataProvider = "Data for Div Double test", dataProviderClass = StaticProviderDoubleHW.class)
    public void divDouble_11(double a, double b, double expectedValue) {
        Assert.assertEquals(calculator.divDouble(a, b),expectedValue, "Значения не одинаковые");
    }
}
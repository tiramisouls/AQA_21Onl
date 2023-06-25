package data;

import org.testng.annotations.DataProvider;

public class StaticProviderDoubleHW {
    @DataProvider(name = "Data for Div Double test", parallel = true)
    public static Object[][] dataForDivDoubleTest() {
        return new Object[][] {
                {-10.5, -2.5, 4.2},
                {0, 0, 0},
                {10.5, 2.5, 4.2},
                {0, 2.5, 0}
        };
    }
}
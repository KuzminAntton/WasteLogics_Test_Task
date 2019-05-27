import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void testGoogle() {
        getDriver().get("https://www.google.ru/");
        System.out.println();
    }
}

/**
 * Created by thanos-imac on 20/7/18.
 */
package junitexamples.listener;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
@RunWith(TestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListenerExampleTest {

    static WebDriver driver;
    final private static String URL = "https://www.google.com";

    @BeforeClass
    public static void setupTest(){
        driver = new HtmlUnitDriver();
        driver.get(URL);
    }

    @Test
    public void TC01_PassTest() {
        //Check title
        assertThat(driver.getTitle(), is("Google"));
    }

    @Test
    public void TC02_FailTest() {
        //Check title
        assertEquals("Google", "Gogle", driver.getTitle());
    }

    //IntelliJ ignored by default
    @Ignore
    public void TC03_IgnoreTest() {
        //Check title is correct
        assertThat(driver.getTitle(), is("New Title For Google Search"));
    }

    //Throw Exception
    @Test
    public void TC04_ExceptionTest() {
        throw new RuntimeException();
    }

    @Test
    public void TC05_PassTest(){
        String actualString = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).getText();
        assertTrue("Αναζήτηση Google".contains(actualString));
    }

    @Test
    public void TC06_PassTest(){
        String actualString = driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[2]")).getText();
        assertTrue("Αισθάνομαι τυχερός".contains(actualString));
    }

    @Test
    public void TC07_PassTest() {
        String actualString = driver.findElement(By.xpath("//span[@class='Q8LRLc']")).getText();
        assertTrue(actualString.contains("Ελλάδα"));
    }

    public Boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0)
            return true;
        else
            return false;
    }


}

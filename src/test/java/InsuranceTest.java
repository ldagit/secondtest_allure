import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import steps.BaseSteps;


/**
 * Created by Julia 19.11.2019
 */

public class InsuranceTest extends BaseSteps {
    /*WebDriver driver;
    String baseUrl;*/

    /*@Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }*/

    @Test
    @Ignore
    public void testInsurance() throws InterruptedException {
        getDriver().get(baseUrl);

        //driver.findElement(By.xpath("//button//*[contains(text(),'Страхование')]")).click();
        //driver.findElement(By.xpath("//ul[contains(@aria-label,'Подменю')]//*[contains(text(),'Страхование путешественников')]")).click();

        click(By.xpath("//button//*[contains(text(),'Страхование')]"));
        click(By.xpath("//ul[contains(@aria-label,'Подменю')]//*[contains(text(),'Страхование путешественников')]"));

        Wait<WebDriver> wait = new WebDriverWait(getDriver(), 5, 1000);
        WebElement title = getDriver().findElement(By.xpath("//div[contains(@class, 'sbrf-rich-outer')]//h1"));
        wait.until(ExpectedConditions.visibilityOf(title));
        Assert.assertEquals("Страхование путешественников", title.getText());


        //У меня не получилось выполнить переход по клику на бланк оформления полиса -
        // страничка с выбором полиса отображается, но почему-то на ней не ищутся элементы,
        // поэтому сделала переход по ссылке, которую вытащила из атрибутов :(

        //driver.findElement(By.xpath("//img[contains(@src, 'banner-zashita-traveler')]//parent::a//parent::p")).click();//("//img[contains(@src, 'banner-zashita-traveler')]")).click();
        WebElement elementRef = getDriver().findElement(By.xpath("//img[contains(@src, 'banner-zashita-traveler')]//parent::a"));//parent::p//parent::div")).click();
        String str = elementRef.getAttribute("href");
        getDriver().get(str);

        WebElement titlePolice = getDriver().findElement(By.xpath("//*[contains(text(), 'Выбор полиса')]"));
        wait.until(ExpectedConditions.visibilityOf(titlePolice));
        Assert.assertEquals("Выбор полиса", titlePolice.getText());


        //driver.findElement(By.xpath("//div[contains(text(), 'Минимальная')]//parent::div[contains(@ng-class, '1')]")).click();
        //driver.findElement(By.xpath("//span[contains(text(), 'Оформить')]")).click();
        click(By.xpath("//div[contains(text(), 'Минимальная')]//parent::div[contains(@ng-class, '1')]"));
        click(By.xpath("//span[contains(text(), 'Оформить')]"));


        WebElement titlePers = getDriver().findElement(By.xpath("//h3[contains(text(), 'Застрахованные')][contains(@class, 'b-form-section-title')]"));
        Assert.assertNotNull(titlePers);

        //Заполнение полей
        fillField(By.name("surname"), "Петров");
        fillField(By.name("name"), "Петр");
        fillField(By.name("middlename"), "Петрович");
        fillField(By.name("birthDate"), "06071997");

        getDriver().findElement(By.xpath("//h3[text()='Страхователь']")).click();// клик мимо календаря, чтобы он закрылся

        fillField(By.xpath("//input[contains(@ng-model, 'DOCSERIES')]"), "0607");
        fillField(By.xpath("//input[contains(@ng-model, 'DOCNUMBER')]"), "236755");
        fillField(By.name("issueDate"), "30082009");

        getDriver().findElement(By.xpath("//h3[text()='Данные паспорта РФ']")).click();

        fillField(By.name("issuePlace"), "Какой-то УВД г.Москвы");

        getDriver().findElement(By.xpath("//span[text() ='Продолжить']")).click();



        WebElement errMessage = getDriver().findElement(By.xpath("//div[contains(@ng-show, 'invalid')]"));
        wait.until(ExpectedConditions.visibilityOf(errMessage));
        Assert.assertEquals("Заполнены не все обязательные поля", errMessage.getText());



    }

    /*@After
    public void afterTest(){
        driver.quit();

    }
    */

    /*private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    /*private void click(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(locator));
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }*/
}

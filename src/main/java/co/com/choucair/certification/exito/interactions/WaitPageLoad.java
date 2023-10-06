package co.com.choucair.certification.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitPageLoad implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState !== 'loading'"));
    }
    public static WaitPageLoad page() {
        return Tasks.instrumented(WaitPageLoad.class);
    }
}

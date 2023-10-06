package co.com.choucair.certification.exito.runners;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\comprar_productos_aletorios.feature",
        glue = "co.com.choucair.certification.exito.stepsdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class ComprarProductosAleatoriosRunner {
}

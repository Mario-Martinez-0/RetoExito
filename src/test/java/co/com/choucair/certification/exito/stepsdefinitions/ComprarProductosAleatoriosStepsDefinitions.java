package co.com.choucair.certification.exito.stepsdefinitions;

import co.com.choucair.certification.exito.questions.ValidateProductsAmount;
import co.com.choucair.certification.exito.questions.ValidateProductsCost;
import co.com.choucair.certification.exito.questions.ValidateProductsNames;
import co.com.choucair.certification.exito.questions.ValidateProductsTotalAmount;
import co.com.choucair.certification.exito.tasks.AddArticles;
import co.com.choucair.certification.exito.tasks.SelectSubcategory;


import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class ComprarProductosAleatoriosStepsDefinitions {


    @Managed
    static WebDriver driver;

    @Before
    public void configurar() {
    /**    WebDriverManager.edgedriver().setup();
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(driver)));//
        OnStage.theActorCalled("Prueba");
        driver.manage().window().maximize();
     */
        WebDriverManager.chromedriver().setup();
        setTheStage(OnlineCast.ofStandardActors());
        OnStage.theActorCalled("Pruibaa");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
        driver.manage().window().maximize();
    }


    @Dado("^que el usuario se encuentra en la pagina$")
    public void queElUsuarioSeEncuentraEnLaPagina() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.exito.com/"));
    }


    @Dado("^que el usuario se dirige a la (.*) con (.*)$")
    public void queElUsuarioSeDirigeALaCategoriaConSubCategoria(String categoria, String subCateogira) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectSubcategory.with(categoria, subCateogira));
    }

    @Cuando("^el usuario selecciona (.*) productos aletorios y estos con cantidades aletorias$")
    public void elUsuarioSeleccionaCantidadProductosAletoriosYEstosConCantidadesAletorias(int cantidad) {
        OnStage.theActorInTheSpotlight().attemptsTo(AddArticles.with(cantidad));
    }

    @Entonces("^el usuario validara el nombre de los productos en el carrito$")
    public void elUsuarioValidaraElNombreDeLosProductosEnElCarrito() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateProductsNames.validate()));
    }

    @Y("^validara el precio total de productos en el carrito$")
    public void validaraElPrecioTotalDeProductosEnElCarrito() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateProductsCost.validate()));
    }

    @Y("^validara las cantidades de los productos$")
    public void validaraLasCantidadesDeLosProductos() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateProductsAmount.validate()));
    }

    @Y("^validara el mumero de productos$")
    public void validaraElMumeroDeProductos() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateProductsTotalAmount.validate()));
    }

}

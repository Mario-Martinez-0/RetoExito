package co.com.choucair.certification.exito.tasks;

import co.com.choucair.certification.exito.interactions.ClickNTimes;
import co.com.choucair.certification.exito.interactions.PreviousPage;
import co.com.choucair.certification.exito.interactions.ScrollDown;
import co.com.choucair.certification.exito.interactions.WaitPageLoad;
import co.com.choucair.certification.exito.models.Item;
import co.com.choucair.certification.exito.userinterfaces.MenuHome;
import co.com.choucair.certification.exito.userinterfaces.Products;
import co.com.choucair.certification.exito.utils.Numbers;
import co.com.choucair.certification.exito.utils.StringToNumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddArticles implements Task {
    private final int number;

    public AddArticles(int number) {
        this.number = number;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int amount = Numbers.randomNumber(10);
        int[] element = Numbers.randomArray(20, number);
        ArrayList<Item> items = new ArrayList<>();
        for (int j : element) {

            actor.attemptsTo(
                    WaitPageLoad.page(),
                    ScrollDown.go(),
                    WaitUntil.the(Products.lIST_OF_ARTICLES.of(String.valueOf(j)), isPresent())
                            .forNoMoreThan(10).seconds(),
                    Scroll.to(Products.lIST_OF_ARTICLES.of(String.valueOf(j))),
                    Click.on(Products.lIST_OF_ARTICLES.of(String.valueOf(j))),
                    Click.on(Products.BTN_BUY),
                    WaitUntil.the(Products.BTN_MORE_ITEMS, isVisible()).forNoMoreThan(10).seconds(),
                    ClickNTimes.the(amount, Products.BTN_MORE_ITEMS),
                    WaitUntil.the(Products.TXT_VALUE, isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(Products.TXT_NAME, isVisible()).forNoMoreThan(10).seconds()
            );
            String name = Products.TXT_NAME.resolveFor(actor).getText();
            double value = StringToNumber.number(Products.TXT_VALUE.resolveFor(actor).getText());
            items.add(new Item(name, value, amount));
            actor.attemptsTo(PreviousPage.back());
        }
        actor.remember("items", items);
        actor.attemptsTo(WaitPageLoad.page(), Click.on(MenuHome.BTN_CART));
    }

    public static AddArticles with(int number) {
        return Tasks.instrumented(AddArticles.class, number);
    }
}

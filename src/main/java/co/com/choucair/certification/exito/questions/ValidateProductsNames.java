package co.com.choucair.certification.exito.questions;

import co.com.choucair.certification.exito.interactions.WaitPageLoad;
import co.com.choucair.certification.exito.models.Item;
import co.com.choucair.certification.exito.userinterfaces.Cart;
import co.com.choucair.certification.exito.utils.StringToNumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.ArrayList;

public class ValidateProductsNames implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        ArrayList<Item> items = actor.recall("items");
        ArrayList<Item> cartItems = new ArrayList<>();
        String email = "prueba@gmail.com";
        actor.attemptsTo(
                WaitPageLoad.page(),
                Enter.keyValues(email).into(Cart.INP_EMAIL),
                Click.on(Cart.BTN_CONFIRM)
        );
        for (int i = 1; i <= items.size(); i++) {
            String name = Cart.TXT_NAME.of(String.valueOf(i)).resolveFor(actor).getText();
            double value = StringToNumber.number(Cart.TXT_VALUE.of(String.valueOf(i)).resolveFor(actor).getText());
            int amount = Integer.parseInt(Cart.TXT_AMOUNT.of(String.valueOf(i)).resolveFor(actor).getText());
            cartItems.add(new Item(name, value / amount, amount-1));
        }
        actor.remember("cartItems", cartItems);
        actor.remember("productCost", StringToNumber.number(Cart.TXT_PRODUCTS_COST.resolveFor(actor).getText()));
        return items.equals(cartItems);
    }

    public static Question<Boolean> validate() {
        return new ValidateProductsNames();
    }
}
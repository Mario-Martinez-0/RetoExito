package co.com.choucair.certification.exito.questions;

import co.com.choucair.certification.exito.models.Item;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

public class ValidateProductsTotalAmount implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        ArrayList<Item> items = actor.recall("items");
        ArrayList<Item> cartItems = actor.recall("cartItems");
        return items.size() == cartItems.size();
    }

    public static Question<Boolean> validate() {
        return new ValidateProductsTotalAmount();
    }
}

package co.com.choucair.certification.exito.questions;

import co.com.choucair.certification.exito.models.Item;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

public class ValidateProductsAmount implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        ArrayList<Item> items = actor.recall("items");
        ArrayList<Item> cartItems = actor.recall("cartItems");
        return items.stream().mapToInt(Item::getAmount).sum() == cartItems.stream().mapToInt(Item::getAmount).sum();
    }

    public static Question<Boolean> validate() {
        return new ValidateProductsAmount();
    }
}

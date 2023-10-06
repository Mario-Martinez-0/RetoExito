package co.com.choucair.certification.exito.questions;

import co.com.choucair.certification.exito.models.Item;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

public class ValidateProductsCost implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        double productCost = actor.recall("productCost");
        ArrayList<Item> items = actor.recall("items");
        double total = 0;
        for (Item item : items) {
            total += item.totalCost();
        }
        return productCost == total;
    }

    public static Question<Boolean> validate() {
        return new ValidateProductsCost();
    }
}

package co.com.choucair.certification.exito.tasks;

import co.com.choucair.certification.exito.userinterfaces.MenuHome;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectSubcategory implements Task {

    private final String category;
    private final String subCategory;

    public SelectSubcategory(String category, String subCategory) {
        this.category = category;
        this.subCategory = subCategory;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MenuHome.BTN_MENU_HOME),
                Click.on(MenuHome.BTN_ITEM_MENU_HOME.of(category)),
                Click.on(MenuHome.BTN_SUB_ITEM.of(subCategory))
        );
    }

    public static SelectSubcategory with(String category, String subCategory) {
        return Tasks.instrumented(SelectSubcategory.class, category, subCategory);
    }
}


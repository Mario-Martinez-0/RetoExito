package co.com.choucair.certification.exito.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ClickNTimes implements Interaction {

    private final int number;
    private final Target element;

    public ClickNTimes(int number, Target element) {
        this.number = number;
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < number; i++) {
            actor.attemptsTo(Click.on(element));
        }
    }
    public static ClickNTimes the(int number, Target element) {
        return Tasks.instrumented(ClickNTimes.class, number, element);
    }
}

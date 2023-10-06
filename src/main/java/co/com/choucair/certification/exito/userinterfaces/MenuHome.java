package co.com.choucair.certification.exito.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;


public class MenuHome {

    public static final Target BTN_MENU_HOME = Target.the("Button menu home").
            locatedBy("//div[@id='category-menu']");
    public static final Target BTN_ITEM_MENU_HOME = Target.the("Button menu home {0}").
            locatedBy("//p[@id='undefined-nivel2-{0}']");
    public static final Target BTN_SUB_ITEM = Target.the("Button menu home {0}").
            locatedBy("//p[contains(text(),'{0}')]");
    public static final Target BTN_CART = Target.the("Button cart").
            locatedBy("//a[@class='exito-header-3-x-minicartLink']");




    private MenuHome() {
    }
}

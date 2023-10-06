package co.com.choucair.certification.exito.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Cart {
    public static final Target TXT_NAME = Target.the("Name of product {0}").
            locatedBy("(//div[@data-molecule-product-detail-name]/span)[{0}]");
    public static final Target TXT_VALUE = Target.the("Name of product {0}").
            locatedBy("(//div[@data-molecule-product-detail-price-best-price]/span)[{0}]");
    public static final Target TXT_AMOUNT = Target.the("Name of product {0}").
            locatedBy("(//div[@data-molecule-quantity-und])[{0}]/span");
    public static final Target INP_EMAIL = Target.the("Input for email").
            locatedBy("//input[@type='email']");
    public static final Target BTN_CONFIRM = Target.the("Button for confirm email").
            locatedBy("//button[@type='submit']");
    public static final Target TXT_PRODUCTS_COST = Target.the("Text witn products total cost").
            locatedBy("(//span[@data-molecule-summary-item-value])[2]");











    //

    private Cart(){}
}

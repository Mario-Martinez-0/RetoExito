package co.com.choucair.certification.exito.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Products {


    public static final Target lIST_OF_ARTICLES = Target.the("List of artcile").
            locatedBy("(//article[1])[{0}]");
    public static final Target BTN_BUY = Target.the("Button for buy product").
            locatedBy("//button//span[contains(text(), 'Agregar')]");
    public static final Target BTN_MORE_ITEMS = Target.the("Button for add mores items").
            locatedBy("//button[contains(@class,'product-summary-add-to-car-plus')]");

    public static final Target TXT_VALUE = Target.the("Value of item").
            locatedBy("(//span[@class='exito-vtex-components-4-x-currencyContainer'])[2]");
    public static final Target TXT_NAME = Target.the("Name of item").
            locatedBy("//span[@class='vtex-store-components-3-x-productBrand ']");







    private Products(){}
}

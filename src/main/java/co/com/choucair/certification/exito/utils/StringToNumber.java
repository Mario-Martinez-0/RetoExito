package co.com.choucair.certification.exito.utils;

public class StringToNumber {

    public static double number(String number){
        return Double.parseDouble(number.replace("$", "").replace(".", "").trim());
    }
    private StringToNumber(){}
}

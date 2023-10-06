package co.com.choucair.certification.exito.utils;

import java.util.Random;

public class Numbers {

    public static int randomNumber(int n){
        Random rand = new Random();
        return rand.nextInt(n-1) + 1;
    }

    public static int[] randomArray(int maxNumber, int amount) {
        int[] array = new int [amount];
        for (int i = 0; i <array.length ; i++) {
            array[i]=randomNumber(maxNumber);
        }
        return array;
    }
}

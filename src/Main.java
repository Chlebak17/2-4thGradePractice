import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main {

    //Ukol 1
    public static void nahodnaCisla(int min,int max, int n){

        for (int i = 0; i < n; i++) {
            System.out.println( (int) ((Math.random() * (max - min + 1)) + min));
        }

    }

    //Ukol 2
    public static void vypisMin(int[] poleCisel){
        int min = 100;
        //0-100
        for (int i = 0; i < poleCisel.length; i++) {
            if (poleCisel[i] < min) {
                min = poleCisel[i];
            }
        }
        System.out.println("Nejmenší číslo v poli je: " +min);
    }

    public static void vypisMax(int[] poleCisel){
        int max = 0;
        //0-100
        for (int i = 0; i < poleCisel.length; i++) {
            if (poleCisel[i] > max) {
                max = poleCisel[i];
            }
        }
        System.out.println("Největší číslo v poli je: " + max);
    }

    //Ukol 3
    public static int vracetMin(int[] poleCisel){
        int min = 100;
        //0-100
        for (int i = 0; i < poleCisel.length; i++) {
            if (poleCisel[i] < min) {
                min = poleCisel[i];
            }
        }

        return min;
        //System.out.println("Nejmenší číslo v poli je: " +min);
    }

    public static int vracetMax(int[] poleCisel){
        int max = 0;
        //0-100
        for (int i = 0; i < poleCisel.length; i++) {
            if (poleCisel[i] > max) {
                max = poleCisel[i];
            }
        }
        return max;
        //System.out.println("Největší číslo v poli je: " + max);
    }

    //Ukol 4
    public static void sigmaKraj(){
        String SPZ = "4U05015";

        //POLE slozeny z Character

        char pismoKraje = SPZ.charAt(1);

        String pismenoKraje = String.valueOf(pismoKraje);

        if (pismenoKraje.equals("E")) {
            System.out.println("Pardubický kraj");
        } else if (pismenoKraje.equals("A")) {
            System.out.println("Praha");
        }else if (pismenoKraje.equals("U")) {
            System.out.println("Skibbidi");
        }

    }

    //Ukol 5
    public static String sigmaKrajVratit(){
        String SPZ = "4X05015";
        String sigmaKraj;
        //POLE slozeny z Character

        char pismoKraje = SPZ.charAt(1);

        String pismenoKraje = String.valueOf(pismoKraje);

        if (pismenoKraje.equals("E")) {
            sigmaKraj = "Pardubicky kraj";
        } else if (pismenoKraje.equals("A")) {
            sigmaKraj = "Praha kraj";
        }else if (pismenoKraje.equals("U")) {
            sigmaKraj = "Skibisf kraj";
        }else {
            sigmaKraj = "není v krajích";
        }

        return sigmaKraj;
    }

    //Ukol 6
    public static void ohio(int den,int mesic){
        int fromStartedYear = 0;

        int[] dny = {31,28,30,31,30,31,31,31,30,31, 30, 31};
//                   1. 2. 3. 4. 5. 6. 7. 8. 9. 10. 11. 12.
        // od leden do brezen
        for (int i = 0; i < mesic-1; i++) {
            fromStartedYear += dny[i];
        }

         fromStartedYear += den;

        System.out.println(fromStartedYear);
    }



    //Ukol 7                                   //true = prestupny rok nebo false = prestupny rok
    public static void ohio2(int den,int mesic,boolean prestupny){
        int fromStartedYear = 0;

        int[] dny = {31,28,30,31,30,31,31,31,30,31, 30, 31};
//                   1. 2. 3. 4. 5. 6. 7. 8. 9. 10. 11. 12.
        // od leden do brezen

        if (prestupny) {
          dny[1] = 29;
        }

        for (int i = 0; i < mesic-1; i++) {
            fromStartedYear += dny[i];
        }

        fromStartedYear += den;

        System.out.println(fromStartedYear);
    }

    //Ukol 8
    public static int ohio3(int den,int mesic,boolean prestupny){
        int fromStartedYear = 0;

        int[] dny = {31,28,30,31,30,31,31,31,30,31, 30, 31};
//                   1. 2. 3. 4. 5. 6. 7. 8. 9. 10. 11. 12.
        // od leden do brezen

        if (prestupny) {
            dny[1] = 29;
        }

        for (int i = 0; i < mesic-1; i++) {
            fromStartedYear += dny[i];
        }

        fromStartedYear += den;

        return fromStartedYear;
    }

    //Ukol 9
    public static String toilet(String slovo){
        String reversed = "";
        /*
        slovo.length() - 1:
            <-
        1 2 3 4 5 6 7
        0 1 2 3 4 5 6

         */
        for (int i = slovo.length()-1; i >= 0; i--) {
            reversed += slovo.charAt(i);
        }

        return reversed;
    }

    //Ukol 10
    public static String pohlavi(String rodneCislo){
        String gender = "";

        String meziKrok = "";
        meziKrok += rodneCislo.charAt(2);//mezikrok = "5"
        int thirdNum = Integer.parseInt(meziKrok);//thirdNum = 5

        System.out.println(thirdNum);

        if (thirdNum == 5 || thirdNum == 6) {
            gender = "Žena";
        }else {
            gender = "Muž";
        }

        return gender;
    }

//    %
    public static void main(String[] args) {

//        nahodnaCisla(2,10,6);
//
        int[] poleCisel = {10,53,45,15,1};
//        vypisMin(poleCisel);
//        vypisMax(poleCisel);

//        System.out.println(vracetMin(poleCisel));

//        ohio(14,3);

//        ohio2(14,3,true);

//        ohio3(14,3,true);


//        System.out.println(toilet("savesta"));


        System.out.println("Je to " + pohlavi("854126/1158"));

    }
}
package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    // int[] name, int[] name = {2,3,1,9}
    public static void oneMonthCalendar(int days, int first){

        int count = 1;
        int c = first;
        int r;

        if((days+first)%7!=0)
            r = days/7 +1;
        else
            r = days/7;

        for (int i = 1; i < first; i++) {
            System.out.print("   ");
        }

        for (int a = 0; a < r; a++) {
            while (c <= 7) {
                System.out.printf("%2d ",count);
                if (count == days){
                    System.out.println();
                    return;
                }
                c++;
                count++;
            }
            c = 1;
            System.out.println();
        }

    }

    public static long [] lcg(long seed){

        long[] random = new long [11]; // 1 seed und 10 = "zufallszahlen", AppTest verlangt aber random = new long[10]
        long[] save = new long [11];

        long a = 1103515245;
        long m = (long) Math.pow(2, 31);
        long c = 12345;
        random[0] = seed;
        save[0] = seed;

        for(int i = 1; i < random.length; i++) {
                random[i] = (a * save[i-1] + c) % m;
                save[i] = random[i];
        }

        return  random;
    }

    public static void guessingGame( int numberToGuess){
        Scanner scanner = new Scanner(System.in);

        for( int i = 1;i < 11; i++) {
            System.out.print("Guess number " + i + ": ");
            int guess = scanner.nextInt();

            if (guess > numberToGuess && i != 10)
                System.out.println("The number AI picked is lower than your guess.");
            if (guess < numberToGuess && i != 10)
                System.out.println("The number AI picked is higher than your guess.");

            if (i == 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }


            if (guess == numberToGuess){
                System.out.println("You won wisenheimer!");
                break;
            }

        }

    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        return random.nextInt(100)+1;
    }

    public static boolean swapArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] - arr2[i];
            arr2[i] = arr2[i] + arr1[i];
            arr1[i] = arr2[i] - arr1[i];
        }

        return true;
    }

    public static String camelCase(String sent) {
        char[] chr = sent.toCharArray();

        if (chr[0] >= 97 && chr[0] <= 122)
            chr[0] -= 32;

        for (int i = 0; i < chr.length; i++) {
            if (i >= 1 && chr[i-1] == ' ' && chr[i] >= 97 && chr[i] <= 122){
                chr[i] -= 32;
            }
            if (i >= 1 && chr[i-1] != ' ' && chr[i] >= 65 && chr[i] <= 90){
                chr[i] += 32;
            }
        }

        for (int i = 0; i < chr.length; i++) {
            if ((chr[i] > 0 && chr[i] <= 64) || (chr[i] >= 91 && chr[i] <= 96) || (chr[i] >= 123 && chr[i] <= 127)){
                chr[i] = 32;
            }
        }
        String x = String.valueOf(chr).replaceAll(" ","");
        return x;
    }

    public static int checkDigit(int[] array) {
        int mod;
        int gewichtung = 2;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i] * (gewichtung+i);
        }

        mod = sum % 11;

        if (11-mod == 11)
            return 5;

        if (11-mod == 10)
            return 0;


        return 11-mod;
    }


    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        System.out.println("---- <One Month Calendar> ----");
        oneMonthCalendar(30,4);
        System.out.println();

        System.out.println("---- <Pseudo Random Numbers> ----");
        System.out.println(Arrays.toString(lcg(8)));
        System.out.println();

        System.out.println("---- <Guessing Game> ----");
        guessingGame(randomNumberBetweenOneAndHundred());
        System.out.println();

        System.out.println("---- <Swap Arrays> ----");
        int[] afirst = new int[] { 3, 9, 1, 5, 8, 7};
        int[] asecond = new int[] {143, 13, 1, 18, 25, 6};

        System.out.println("Array 1: " + Arrays.toString(afirst));
        System.out.println("Array 2: " + Arrays.toString(asecond));

        if(swapArrays(afirst,asecond) == false) {
            System.out.println(swapArrays(afirst, asecond));
        } else {
            System.out.println();
            System.out.println("Array 1: " + Arrays.toString(afirst));
            System.out.println("Array 2: " + Arrays.toString(asecond));
            System.out.println();
        }



        System.out.println("---- <CamelCase> ----");
        System.out.println(camelCase("I be that pretty boy"));
        System.out.println();


        System.out.println("---- <Check Digit> ----");
        System.out.println(checkDigit(afirst));

    }
}
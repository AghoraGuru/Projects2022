import java.util.Scanner;


public class SupportFunctions {

    public static int[] getIntInput16() {
        try (Scanner sc = new Scanner(System.in)) {
            int[] array = new int[16];
            System.out.println("Enter the elements of the array: ");
            for (int i = 0; i < 16; i++) {
                // reading array elements from the user
                array[i] = sc.nextInt();
            }

            return array;
        }
    }

    public static String getStringInput() {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            return input;
        }
    }

    public static int getIntInput() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter value: ");
            int userIn = sc.nextInt();
            
            return userIn;
        }
    }
    // This is the Finaly input function we gonna use for HardWareSimulation Input!
    
/**
 * DEC-BIN Converter
 
    public int[] DbConv(int inp) {
    // public static int[] bin;
        System.out.println("Enter Value");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        // String oout = toBinary(in);
        // System.out.println(toBinary(in));

        String temp = toBinary(in);
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }
        return numbers;
    }

    public static String toBinary(int in) {
        StringBuilder result = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((in & mask) != 0 ? 1 : 0);
        }

        return result.toString();
    }
    */
    //The real METHOD
    public static int[] Binaryconvertor(int in) {

        //To get Input from User
        //System.out.println("Enter Int Value");
        //Scanner input = new Scanner(System.in);
       // in = input.nextInt();
        String temp = toBinary(in);
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }
        return numbers;


    }
    public static String toBinary(int in) {
        StringBuilder result = new StringBuilder();

        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((in & mask) != 0 ? 1 : 0);
        }

        return result.toString();
    }
    public static int[] binaryconvertor4bit(int input) {
        String temp = toBinary(input);
        int[] numbers = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }
        return numbers;
        
    }
}
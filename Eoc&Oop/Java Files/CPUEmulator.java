import java.util.Arrays;
import java.util.Scanner;

public class CPUEmulator {
    //decleared before loop to load these without flaw as static
    private static float clockvalue = 0;
    private static int[] OutM = {0};
    private static int[] COutM = {0};
    private static int WriteM = 0;
    private static int[] AddressM = {0};
    private static int[] CAddressM = {0};
    private static int[] PC = {0};
    private static int[] CPC = {0};
    public static void main(String[] args) {

        SupportFunctions Instructions = new SupportFunctions();
        SupportFunctions InM = new SupportFunctions();
        int usrins;
        int usrinM;

        System.out.println("Enter a decimal value as input for the instruction bits: ");        //asks user

        try (Scanner sc = new Scanner(System.in)) {
            int userIn = sc.nextInt();
            usrins = userIn;
            int[] instruction = Instructions.Binaryconvertor(usrins);                               //!instruction Variable

            System.out.println("Enter a decimal value as input for the inM bits: ");

            try (Scanner input = new Scanner(System.in)) {
            }
            int userInM = sc.nextInt();
            usrinM = userInM;
            int[] inM = InM.Binaryconvertor(usrinM);                                                //!inM Variable

            while (true) {
                System.out.println("Would you like to clock or stop?");
                String programChoice = SupportFunctions.getStringInput().toUpperCase();             // wheather uppercase or lowercase , this line changes into Uppercase
                switch (programChoice) {                                                            //switches based on user input
                    case "STOP":                                                                    //! stops if input is stop
                        System.out.println("Bye!");                                                 // optional message to indicate exit
                        System.exit(0);
                        break;
                    case "CLOCK":
                        if (clockvalue == 0) {
                            System.out.println(clockvalue);
                            System.out.println("OutM = 0");             //<-------------------------------------------------------|
                            System.out.println("WriteM = 0");           //<-------------------------------------------------------|
                            System.out.println("AddressM = 0");         //<-------------------------------------------------------|
                            System.out.println("PC = 0");               //<-------------------------------------------------------|
                            clock.clocking(); //clocks next cycle adds 0.5 to prev clock                                        //|
                        } else if ((clockvalue * 10) % 2 == 0) {                                                                //|
                            System.out.println(clockvalue);                                                                     //|
                            CPU.cpu(inM, instruction, 0);                                                                       //|
                            OutM = CPU.getOutM();                                                                               //|
                            WriteM = CPU.getWriteM();                                                                           //|
                            AddressM = CPU.getAddress();                                                                        //|
                            PC = CPU.getPC();                                                                                   //|
                            COutM = ReverseArray.Reverse(OutM);                    //!output now is reversed array     <--------//|
                            CAddressM = ReverseArray.Reverse(AddressM);                                                         //|
                            CPC = ReverseArray.Reverse(PC);                                                                     //|

                            System.out.println("OutM = " + Arrays.toString(COutM));
                            System.out.println("WriteM = " + WriteM);
                            System.out.println("AddressM = " + Arrays.toString(CAddressM));
                            System.out.println("PC = " + Arrays.toString(CPC));
                            clock.clocking();
                        } else {
                            System.out.println(clockvalue);
                            System.out.println("OutM = " + Arrays.toString(COutM));
                            System.out.println("WriteM = " + WriteM);
                            System.out.println("AddressM = " + Arrays.toString(CAddressM));
                            System.out.println("PC = " + Arrays.toString(CPC));
                            clock.clocking();
                        }
                        clockvalue = clock.time();
                        break;
                    case "CHANGE":                  //allows usr to change ins, inM values while operation going on seamlessly
                        main(args);
                        break;
                    case default:
                        System.out.println("Please enter if you would like to Stop the program, Clock it or Change the values?"); //default case cuz it takes usr input
                }
            }
        }
    }
}

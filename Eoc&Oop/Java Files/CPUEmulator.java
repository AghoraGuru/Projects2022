import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CPUEmulator {

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
        System.out.println("Enter a decimal value as input for the instruction bits: ");
        usrins = SupportFunctions.getIntInput();
        int[] instruction = Instructions.Binaryconvertor(usrins);
        int usrinM;
        System.out.println("Enter a decimal value as input for the inM bits: ");
        int[] inM = InM.Binaryconvertor(usrinM);
        while (true) {
            System.out.println("Would you like to clock or stop?");
            String programChoice = SupportFunctions.getStringInput().toUpperCase(); // read any token from the input as String
            switch (programChoice) {
                case "STOP":
                    System.out.println("Bye!"); // optional message to indicate exit
                    System.exit(0);
                    break;
                case "CLOCK":
                    if (clockvalue == 0) {
                        System.out.println(clockvalue);
                        System.out.println("OutM = 0");
                        System.out.println("WriteM = 0");
                        System.out.println("AddressM = 0");
                        System.out.println("PC = 0");
                        clock.clocking();
                    } else if ((clockvalue * 10) % 2 == 0) {
                        System.out.println(clockvalue);
                        CPU.cpu(inM, instruction, 0);
                        OutM = CPU.getOutM();
                        WriteM = CPU.getWriteM();
                        AddressM = CPU.getAddress();
                        PC = CPU.getPC();
                        COutM = ReverseArray.Reverse(OutM);
                        CAddressM = ReverseArray.Reverse(AddressM);
                        CPC = ReverseArray.Reverse(PC);

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
                case "CHANGE":
                    main(args);
                    break;
                case default:
                    System.out.println("Please enter if you would like to Stop the program, Clock it or Change the values?");
            }
        }
    }
}

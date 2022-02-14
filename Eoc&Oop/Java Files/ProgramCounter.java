public class ProgramCounter extends ALU {

    static int[] out = new int[16];

    public static int[] pc(int in[], int inc, int load, int reset) {

        if (reset == 1) {                           //gets the input and checks with condition
            out[0] = 0;
        }
        else if (load == 1) {                       //self explanatory
            out = in;
        }
        else if (inc == 1) {
            out = Inc16(out);                       //takes out to Inc16 from Adders class and returns output
        }
        
        return out;                                 
    }
}
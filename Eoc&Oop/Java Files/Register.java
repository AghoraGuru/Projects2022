public class Register {

    public static int[] out = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public static int[] Reg(int in[], int load) {

        if (load == 1) {            //outs input if load is 1
            out = in;
            
            return out;
        } else {

            return out;             //outs if load is not 1
        }
    }
}
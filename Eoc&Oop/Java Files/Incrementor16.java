
public class Incrementor16 {

    public static int[] Inc16(int in[]) {

        int[] increment = new int[16];
        increment[0] = 1;
        return Gate16.Add16(in, increment);
    }
}
public class clock{

    static float clocked = 0;           //as clock gets tik tok with 0.5
    public static void clocking() {
        clocked += 0.5;                 //adds 0.5 to the previous clock
    }

    public static float time() {
        return clocked;                 //returns the next clock cycle
    }
}

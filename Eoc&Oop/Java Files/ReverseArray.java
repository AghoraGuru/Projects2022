public class ReverseArray {
    public static int[] Reverse(int a[]) {
        int[] out = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            out[i] = a[i];
        }
        return out;
    }
}

public class ALU {
	public static int zr;
	public static int[] ng;
	public static int[] out;

	public static void Calculation(int x[], int y[], int zx, int zy, int nx, int ny, int f, int no) {

		// pre-setting x input
		int b[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int x1[] = Muxes.Mux16(x, b, zx);
		int notx1[] = Gate16.Not16(x1);
		int x2[] = Muxes.Mux16(x1, notx1, nx);

		// pre setting y input
		int y1[] = Muxes.Mux16(y, b, zy);
		int noty1[] = Gate16.Not16(y1);
		int y2[] = Muxes.Mux16(y1, noty1, ny);

		// And & Add Operations on the new values in case the gets changed
		int andout[] = Gate16.And16(x2, y2);
		int addout[] = Gate16.Add16(x2, y2);

		// Selecting between And / Or operations
		int out1[] = Muxes.Mux16(andout, addout, f);

		// setting if out will be Not out / out
		int notout1[] = Gate16.Not16(out1);
		out = Muxes.Mux16(out1, notout1, no);

		// if output is 0, zr will be 1
		int zrsel = Gate16.Or16Way(out);
		zr = Muxes.Mux(1, 0, zrsel);

		// If output is less than 0 , ng will be 1
		int[] ones = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		ng = Gate16.And16(ones, out);
		/*
		 * int[] ZR = {zr};
		 * int[][] output = {out,ZR,ng};
		 * 
		 * return output;
		 */
	}

	public static int[] getoutput() {
		return out;
	}

	public static int getZr() {
		return zr;
	}

	public static int getNg() {
		return ng[15];
	}

}
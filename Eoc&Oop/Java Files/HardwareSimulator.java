import java.util.Arrays;

public class HardwareSimulator {

	public static void main(String[] args) {

		int a[] = { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };// We use this for literally all inputs
		int b[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		// int A = 1;
		// int B = 1;
		// int A[] = {1,1,0,0}; //4bit inputs (if you need)
		// int B[] = {1,1,0,0}; //4bit inputs (if you need)
		//
		/*
		 * zx,zy,nx,ny,f,no //corresponding ALU changes
		 * ALU.Calculation(a, b, 0, 0, 1, 1, 0, 1);
		 * int[] out = ALU.getoutput();
		 * System.out.println(Arrays.toString(out));
		 * System.out.println("We survived ALU"); //Ignore
		 */
		// CSA4bit
		/*
		 * CarrySelectAdders.CSA4bit(A, B, 0);
		 * int x = CarrySelectAdders.getCarry();
		 * int[] sum = CarrySelectAdders.getSum();
		 */

		// CSA16bit

		/*
		 * CSA16.Operations(a, b, 1);
		 * int x = CSA16.getCarr16();
		 * int[] sum = CSA16.getSum16();
		 * System.out.println((x));
		 * System.out.println(Arrays.toString(sum));
		 */

		// ProgramCounter
		
		  int[] e = ProgramCounter.pc(b, 1, 0, 0);
		  int[] f = ProgramCounter.pc(a, 1, 1, 0);
		  int[] g = ProgramCounter.pc(a, 1, 0, 0);
		  System.out.println(Arrays.toString(g));
		 
		//Register
		/*
		int[] out;
		int[] e;
		int[] f;
		out = Register.Reg(a, 1);
		e = Register.Reg(b, 0);
		f = Register.Reg(b, 1);
		System.out.println(Arrays.toString(f));
		*/
		//CPU
		/*
		int inM[] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		int instruction[] = new int []{0,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0};
		int reset = 0;
		int[][] printthis = CPU.cpu(inM, instruction, reset);
		System.out.println(Arrays.toString(printthis[3]));
		*/

	}
}
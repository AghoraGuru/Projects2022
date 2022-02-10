public class Adders {
	public static int HASum(int a, int b) {
		return Gates.Xor(a, b);

	}

	public static int HACarry(int a, int b) {
		return Gates.And(a, b);
	}

	public static int FASum(int a, int b, int c) {
		return Gates.Xor(Gates.Xor(a, b), c);

	}

	public static int FACarry(int a, int b, int c) {
		return Gates.Or(Gates.Or(Gates.And(a, b), Gates.And(b, c)), Gates.And(a, c));

	}

	public static int CLAAdderSum(int a, int b, int Cin) {
		int ab = Gates.Xor(a, b);
		return Gates.Xor(ab, Cin);
	}

	public static int CLAAdderCarry(int a, int b, int Cin) {
		int ab = Gates.Xor(a, b);
		int Aca = Gates.And(ab, Cin);
		int Aab = Gates.And(a, b);
		return Gates.Or(Aca, Aab);
	}

	public static int FAusingHAsum(int a, int b, int c) {
		int sum1 = HASum(a, b);
		int sum = HASum(sum1, c);
		return sum;
	}

	public static int FAusingHAcarry(int a, int b, int c) {
		int carry1 = HACarry(a, b);
		int carry2 = HACarry(HASum(a, b), c);
		int carry = Gates.Or(carry1, carry2);
		return carry;
	}
}
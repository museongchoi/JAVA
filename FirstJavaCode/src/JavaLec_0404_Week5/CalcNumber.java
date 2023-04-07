package JavaLec_0404_Week5;

public class CalcNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int aVal = 5;
		int bVal = 3;
		int result = 0;
		double resultDouble = 0;
		
		printValue("a and b", aVal, bVal);
		
		result = add(aVal, bVal);
		printValue("a+b", result);
		
		result = substract(aVal, bVal);
		printValue("a-b", result);
		
		result = multiple(aVal, bVal);
		printValue("a*b", result);
		
		resultDouble = divide(aVal, bVal);
		printValue("a/b", resultDouble);
		
	}

	private static void printValue(String string, int aVal, int bVal) {
		// TODO Auto-generated method stub
		System.out.println("Input Value " + string + " : " + aVal + ", " + bVal);
	}

	private static void printValue(String operation, double resultDouble) {
		// TODO Auto-generated method stub
		System.out.println("Result " + operation + " = " + resultDouble);
	}
	
	private static void printValue(String operation, int result) {
		// TODO Auto-generated method stub
		System.out.println("Result " + operation + " = " + result);
	}

	private static double divide(int aVal, int bVal) {
		// TODO Auto-generated method stub
		
		double temp;
		try {
			temp = (double) aVal/bVal;
			return temp;
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("Error : Divide by Zero!!!!");
			//e.printStackTrace();
		}
		return 0;
	}

	private static int multiple(int aVal, int bVal) {
		// TODO Auto-generated method stub
		return aVal*bVal;
	}

	private static int substract(int aVal, int bVal) {
		// TODO Auto-generated method stub
		return aVal - bVal;
	}

	private static int add(int aVal, int bVal) {
		// TODO Auto-generated method stub
		return aVal + bVal;
	}

}

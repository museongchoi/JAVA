package JavaLec_0404_Week5;

import java.util.ArrayList;

public class LottoGenerateTest {

	// Step 1 : Define Value, Array, etc.
	static int pickBall = 6;
	static int numGenCount = 0; // number Generation Counter
	static int temp;
	static int lottoSet = 5;
	static ArrayList<Integer> intList = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=0; i<lottoSet; i++) {
			genAndPrintLottoSet(intList);
		}
		
	}

	private static void genAndPrintLottoSet(ArrayList<Integer> intList) {
		// TODO Auto-generated method stub
		// Step 2 : Generate Value & Store on Array
		while (numGenCount <= pickBall) {
			temp = (int)(Math.random()*45+1);
			if (!intList.contains(temp)) {
				intList.add(temp);
				numGenCount++;
			}
		}

		// Step 3 : Sorting the Array & Display
		intList.sort(null);
		for (int ball: intList) {
			System.out.print(ball + " ");
		}
		System.out.println();
		
		// Step 4 : Clear intList & numGenCount value for generate New Set
		intList.clear();  // clear
		numGenCount = 0;  // reset
	}

}

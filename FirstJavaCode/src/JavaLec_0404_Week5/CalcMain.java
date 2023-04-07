package JavaLec_0404_Week5;

public class CalcMain {
    public static void main(String[] args)
    {
        Calc myCalc = new Calc();   // new Calc() --> 생성자!!! --> 객체 생성됨

        myCalc.aVal = 5;
        myCalc.bVal = 3;
        myCalc.add();
        myCalc.printResult();

        myCalc.substract();
        myCalc.printResult();

        myCalc.multiply();
        myCalc.printResult();

        myCalc.divide();
        myCalc.printResultDouble();

        Calc yourCalc = new Calc(10,3);
        yourCalc.add();
        yourCalc.printResult("+");

        yourCalc.substract();
        yourCalc.printResult("-");

        yourCalc.multiply();
        yourCalc.printResult("*");

        yourCalc.divide();
        //yourCalc.printResultDouble("/");
        yourCalc.printResult("/");

    }
}

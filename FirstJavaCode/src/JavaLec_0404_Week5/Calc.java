package JavaLec_0404_Week5;

public class Calc {
    int aVal;
    int bVal;

    int result;
    double resultDouble;

    public Calc(int i, int i1) {
        aVal = i;
        bVal = i1;
    }
    
    public Calc() { //default 생성자
        
    }

    public void add() {
        this.result = this.aVal + this.bVal;
    }

    public void printResult() {
        System.out.println(this.result);
    }

    public void substract() {
        this.result = this.aVal - this.bVal;
    }

    public void multiply() {
        this.result = this.aVal * this.bVal;
    }

    public void divide() {
        try {
            this.resultDouble = (double) (this.aVal / this.bVal);
        } catch (ArithmeticException e) {
            System.out.println("Divide by Zero Error!!!...");
            e.printStackTrace();
        }
    }

    public void printResultDouble() {
        System.out.println(this.resultDouble);
    }

    public void printResult(String s) {
        switch (s)
        {
            case"+" :
                System.out.println("a + b = " + this.result);
                break;
            case"-" :
                System.out.println("a - b = " + this.result);
                break;
            case"*" :
                System.out.println("a * b = " + this.result);
                break;
            case"/" :
                System.out.println("a / b = " + this.resultDouble);
                break;
            default :
                System.out.println("worg perand");
                break;
        }
    }
}

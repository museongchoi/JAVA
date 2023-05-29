package JavaLec_0509;

public class StudentWorker extends Student{
    /// field 2개
    ///method 5개

    public StudentWorker() {
        System.out.println("StudentWorker 생성자 호출");
    }

    public StudentWorker(String name, int i) {  // 이름, 점수
        //super(name, i);
        this.name = name;
        this.score = i;
    }

    @Override
    public void printGrade() {
        //super.printGrade();
        if(this.score >= 60) {
            System.out.println("a학점!!!");
        }
        else {
            System.out.println("b학점!!!");
        }
    }

    public void work() {

    }
}

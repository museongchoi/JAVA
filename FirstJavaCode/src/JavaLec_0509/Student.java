package JavaLec_0509;

public class Student extends Person implements MyInterFace {
    /// field 2개
    ///method 4개    --> 상속과정에서 SUPER CLASS에 있는 메소드
    int score;
    public Student() {
        super("홍길동");
        System.out.println("Student 생성자 호출");
    }

    public Student(String name, int i) {    // 이름, 점수
        //this.name = name;
        //this.score = i;
        super(name);
        this.score = i;
    }

    // super 클래스에 있는 접근제어자가 public이라 사용 가능.
    // default, public, private 사용 가능, 중요도에 따라 사용
    public void study() {
        super.speak();
    }
    
    // super클래스에 있는 speak를 student 클래스에서 재정의...(오버라이딩)
    // 접근지정자, 리턴타입, 메소드이름, 괄호안에 있는 파라메터 개수/타입 완전 일치
    public void speak() {
        // 내용만 다시 재정의...
        System.out.println(this.name + "Person --> 말하기");
    }



    public static void main(String[] args) {
//        Student s = new Student();
//
//        s.sleep();
//
//        Person p = new Person();
//
        Person pp = new Student();  // 업 캐스팅, student 5개 person 4개 변환을 할때 손실이 없다

        //Student ss = (Student) new Person();    // 다운 캐스팅, 손실이 있다.
        //ss.study();

        //Student std = new Student();
        //StudentWorker stdwor = new StudentWorker();
    }

    public void printGrade() {
        if(this.score >= 70) {
            System.out.println("a학점!!!");
        }
        else {
            System.out.println("b학점!!!");
        }
    }

    @Override
    public void eat() {

    }

    @Override
    public void walk() {

    }

    @Override
    public void commom() {

    }

    @Override
    public void volt() {
        //220...
    }
}

package JavaLec_0502;

// human 클래스
// 동물 클래스로부터 상속을 받는다
public class Human extends Animal{
    // name과 age 가 있다. 상속을 받았기 떄문
    public String hobby;
    public String job;

    public Human(String name, int age) {
        super(name, age);   // Animal...
    }


    // Animal 클래스에 있었던 메소드를 재정의(overriding)
    protected void print() {
        System.out.println("This is Human...!");
    }

    protected void print(String name, int age) {

    }

}

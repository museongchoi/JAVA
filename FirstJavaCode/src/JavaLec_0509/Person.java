package JavaLec_0509;

public abstract class Person {
    /// field
    public String name;
    public int age;

    /// method

    public Person() {
        System.out.println("Person 생성자 호출");
    }

    public Person(String string) {
        System.out.println("Person 생성자 + 이름을 갖는 생성자 호출");
        this.name = string;
    }

    public void speak() {
        System.out.println(this.name + "Person --> 말하기");
    }

    //default
    void sleep() {

    }
}

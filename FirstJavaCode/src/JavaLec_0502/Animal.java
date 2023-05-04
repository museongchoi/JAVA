package JavaLec_0502;

public class Animal {
    public String name;
    public int age; // 다른 클래스, 패키지 안에 있는 클래스, 외부에서 접근 허용
    private int pw; // 데이터의 중요도, 처리하고자 하는 목적..

    // name setting method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal(String name, int age){
        super();
        this.name = name;
        this.age = age;
    }

    public Animal(String name) {
        super();
        this.name = name;
    }

    // 메소드 중첩(overload)... 여러개의 메소드를 정의
    // 메소드 중첩 : 괄호 안에 파라메터의 개수, 타입 등이 다르게 정의...
    protected void print(){ // protected로 인해 humann에서 접근 가능 접근 지정자를 같이 맞춰야함
        System.out.println("This is Anmal!!!");
    }

    public void print(String name) {
        System.out.println("This is Animal...!!!" + "name : " + name);
    }


}


package JavaLec_0411;

class Animal {
    // field (공통적인 속성 목록, animal의 기본 정보)
    private String name;    // 이름 - 오픈 되어 있다. 상속을 했을 때 다른 클래스가 접근 가능하게 함.
    private int age;    // 나이 - 다른 클래스에서 접근 할 수 없다.
    protected int weight;    // 몸무게 - 상속 받은 곳에서만 접근 가능하다
    int height;     // 키 - 동일한 패키지에서는 움직일 수 있다.

    public Animal(String poppy) {
        this.name = poppy;
    }

    public Animal() {

    }

    public String getName() {       // 접근자
        return name;
    }

    private void setName(String name) {     // 설정자
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

// 하나의 자바 코드에서는 public이 하나 만 필요
public class AnimalMain {
    public static void main(String[] args){
        Animal cat; // animal 클래스에 해당하는 인스턴스(객체)를 정의
        cat = new Animal(); // 객체를 생성하는 메소드(생성자)를 처음 한번 반드시 호출

        // cat.setName("thunder");

        Animal dog = new Animal("poppy");
        System.out.println(dog.getName());
    }
}

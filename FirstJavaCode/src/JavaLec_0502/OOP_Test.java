package JavaLec_0502;

import JavaLec_0418_Week7.PhoneBook;

public class OOP_Test {
    public static void main(String[] args) {
        Animal ani1 = new Animal("사자", 10);
        Human hum = new Human("홍길동", 20);

        ani1.print();
        hum.print();

        JavaLec_0418_Week7.PhoneBook ph = new PhoneBook();
        //ph.setName("이순신");    // 폰북의 setName 을 private로 변경 하면 접근 불가능(private는 동일 패키지에서만 접근 가능)
        ph.setTel("010-2228-8299");
    }
}

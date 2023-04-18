package JavaLec_0418_Week7;

public class PhoneBook {
    // 접근 지정자는 생략 가능
    public String name; // 이름
    public String tel; // 전화번호

    // 생성자 작성 - public이면서 클래스 이름과 동일한 메소드.
    public PhoneBook() {
        super();
        // 상속 받을 수 있기 때문에
    }

    public PhoneBook(String name) {
        this.name = name;
    }

    public PhoneBook(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

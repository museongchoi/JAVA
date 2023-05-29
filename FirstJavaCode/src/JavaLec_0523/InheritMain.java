package JavaLec_0523;

import JavaLec_0509.*;

public class InheritMain {

    public static void main(String[] args) {
        InheritMain im = new InheritMain();
        //Researcher r = new Researcher();
        //Professor p = new Professor();
        //im.addUser(new Person());

        //im.addUser(new Professor());    // 업캐스팅
        //im.addUser(r);    // 업캐스팅

        //im.addUser(new Researcher());   // 업캐스팅
        //im.addUser(p);   // 업캐스팅

        //im.addUser(new Student());      // 업캐스팅
        //im.addUser(new StudentWorker());    // 업캐스팅

        Person[] per = new Person[5];

        // user select 0 --> 학생 정보 입력
        per[0] = new Student("홍길동", 65);
        // user select 1 --> 일하는 학생 정보 입력
        per[1] = new StudentWorker("이순신", 65);
        per[2] = new Researcher();
        per[3] = new Professor();
        //per[4] = new Person();  // Person이 추상 클래스로 바뀌면 이름을 사용 불가, new 를 할 수 없다.
        // 추상화가 되면 상속받은 곳에서 재 정의를 해야함.

        im.scoreDecison(per[0]);
        im.scoreDecison(per[1]);
    }

    private void scoreDecison(Person person) {
        if(person instanceof Student)
        {
            Student s = (Student) person;
            s.printGrade();
        }
        else if(person instanceof Professor)
        {
            StudentWorker sw = (StudentWorker) person;
            sw.printGrade();
        }
    }

    private void addUser(Person person) {

        //person.commom();

        if(person instanceof Researcher)
        {
            System.out.println("Researcher 객체임!!!");
            Researcher r = (Researcher) person;     // 다운캐스팅
            r.commom();
        }
        else if(person instanceof Professor)
        {
            System.out.println("Professor 객체임!!!");
            Professor p = (Professor) person;   // 다운캐스팅
            p.commom();
        }
        else if(person instanceof Student)
        {
            System.out.println("Student 객체임!!!");
        }
        else if(person instanceof StudentWorker)
        {
            System.out.println("StudentWorker 객체임!!!");
        }
    }

//    private void addUser(Student student) {
//        if(student instanceof Student)
//        {
//            System.out.println("Student 객체임!!!");
//        }
//        else if(student instanceof StudentWorker)
//        {
//            System.out.println("StudentWorker 객체임!!!");
//        }
//    }
//
//    private void addUser(Researcher researcher) {
//        if(researcher instanceof Researcher)
//        {
//            System.out.println("Researcher 객체임!!!");
//        }
//        else if(researcher instanceof Professor)
//        {
//            System.out.println("Professor 객체임!!!");
//        }
//    }
}

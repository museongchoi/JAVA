package JavaLec_0418_Week7;

public class CourseMain {
    public static void main(String[] args) {
        int courseWork = 10;

        Course[] comEng = new Course[courseWork];

        for(int i = 0; i < comEng.length; i++)
        {
            comEng[i] = new Course();
        }

        // "자료구조", "담당교수님", "강의실명", "학점", "수강생수"
        comEng[0].setCourse("고급프로그래밍", "김성기교수님", "18424", "3", 50);
        comEng[0].printCourse();


        // "이름", "학과/학부", "학번", "학년"
        comEng[0].addStudent("홍길동", "컴공", "202358001", 2);
        comEng[0].addStudent("이순신", "컴공", "202358001", 3);
        comEng[0].printStudent();
    }

}

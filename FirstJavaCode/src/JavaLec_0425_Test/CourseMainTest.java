package JavaLec_0425_Test;

// 강의 당 수강인원에 맞춰 학생 정보 저장
public class CourseMainTest {
    public static void main(String[] args)
    {
        int courseWork = 10;    // Size

        Course[] comEng = new Course[courseWork];   // 새로운 클래스? 객체 생성

        for(int i =0; i < comEng.length; i++)
        {
            comEng[i] = new Course();
        }
        
        // 강의 정보 저장
        //"자료구조", "담당교수님", "강의실명", "학점", "수강생수"
        comEng[0].setCourse("고급프로그래밍", "이형우교수님", "18424", "3", 3);
        comEng[0].printCourse();
        comEng[1].setCourse("자료구조", "나경식교수님", "18425", "3", 3);
        comEng[1].printCourse();
        
        // 학생 정보 저장 => 0번 강의인 고급프로그래밍은 총 3명까지 수강 가능 현재 2명 수강 신청 빈자리는 null로 채워짐
        // "이름", "학과/학부", "학번", "학년"
        comEng[0].addStudent("홍길동", "컴공", "202358001", 1);
        comEng[0].addStudent("이순신", "컴공", "202358002", 3);
        comEng[0].addStudent("최최최", "컴공", "202358003", 4);
        comEng[0].printStudent();
    }
}

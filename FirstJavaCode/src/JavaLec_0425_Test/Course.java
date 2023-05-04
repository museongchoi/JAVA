package JavaLec_0425_Test;

public class Course {
    // "자료구조", "담당교수님", "강의실명", "학점", "수강생수" 데이터 타입, 변수 설정
    String courseName;  //자료구조
    String professor;   // 담당교수님
    String roomNum; // 강의실명
    String credit; // 학점
    int maxNumOfStudent; // 수강생수


    Student[] student;
    static int studentCount = 0;

    public void setCourse(String courseName, String professor, String roomNum, String credit, int maxNumOfStudent) {
        // 입력(강의) 받은 값 저장
        this.courseName = courseName;
        this.professor = professor;
        this.roomNum = roomNum;
        this.credit = credit;
        this.maxNumOfStudent = maxNumOfStudent;

        // 강의 당 학생 저장
        student = new Student[this.maxNumOfStudent];
        for(int i = 0; i < student.length; i++)
        {
            student[i] = new Student();
        }
    }

    public void printCourse() {
        // 출력 값 설정
        System.out.println("--------------------------------");
        System.out.println("과목명 : " + this.courseName);
        System.out.println("담당교수 : " + this.professor);
        System.out.println("강의실 : " + this.roomNum);
        System.out.println("학점 : " + this.credit);
        System.out.println("--------------------------------");
    }

    public void addStudent(String studentName, String dept, String studentIDNum, int grade) {
        student[studentCount].setStudentName(studentName);
        student[studentCount].setDept(dept);
        student[studentCount].setStudentIDNum(studentIDNum);
        student[studentCount].setGrade(grade);

        studentCount++; // 만들고 증가 시켜야한다.
        if(studentCount >= maxNumOfStudent)
        {
            System.out.println("수강인원이 초과되었습니다.");
        }
    }

    public void printStudent() {
        for(int i = 0; i < studentCount; i++)
        {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.print("과목명 : " + student[i].studentName);
            System.out.print("\t학부 : " + student[i].dept);
            System.out.print("\t학번 : " + student[i].studentIDNum);
            System.out.print("\t학년 : " + student[i].grade + "\n");
            System.out.println("+++++++++++++++++++++++++++++++++");
        }
    }
}

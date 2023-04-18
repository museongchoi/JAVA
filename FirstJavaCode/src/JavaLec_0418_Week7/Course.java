package JavaLec_0418_Week7;

public class Course {
    // "자료구조", "담당교수님", "강의실명", "학점", "수강생수"
    String courseName;
    String professor;
    String roomNum;
    String credit; // 학점

    int maxNumOfStudent; // 수강생수

    Student[] student;

    static int studentCount = 0;

    public void setCourse(String courseName, String professor, String roomNum, String credit, int maxNumOfStudent) {
        this.courseName = courseName;
        this.professor = professor;
        this.roomNum = roomNum;
        this.credit = credit;
        this.maxNumOfStudent = maxNumOfStudent;

        student = new Student[this.maxNumOfStudent];
        for(int i = 0; i < student.length; i++)
        {
            student[i] = new Student(); // 생성자가 들어와야 함.
        }
    }

    public void addStudent(String studentName, String dept, String studentIDNum, int grade) {
        student[studentCount].setStudentName(studentName);
        student[studentCount].setDept(dept);
        student[studentCount].setStudentIDNum(studentIDNum);
        student[studentCount].setGrade(grade);

        //Student newStudent = new Student(studentName, dept, studentIDNum, grade);
        //student[studentCount] = newStudent;

        studentCount++; // 만들고 증가 시켜놔야한다.

    }

    public void printCourse() {
        System.out.println("--------------------------------");
        System.out.println("과목명 : " +this.courseName);
        System.out.println("담당교수 : " +this.professor);
        System.out.println("강의실 : " +this.roomNum);
        System.out.println("학점 : " +this.credit);
        System.out.println("--------------------------------");
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

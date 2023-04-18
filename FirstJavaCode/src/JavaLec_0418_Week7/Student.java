package JavaLec_0418_Week7;

public class Student {
    // "이름", "학과/학부", "학번", "학년"
    String studentName;
    String dept;
    String studentIDNum;
    int grade; // 학년

    public Student(String studentName, String dept, String studentIDNum, int grade) {
        this.studentName = studentName;
        this.dept = dept;
        this.studentIDNum = studentIDNum;
        this.grade = grade;
    }

    public Student() {

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getStudentIDNum() {
        return studentIDNum;
    }

    public void setStudentIDNum(String studentIDNum) {
        this.studentIDNum = studentIDNum;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

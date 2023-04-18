package JavaLec_0411;

public class Student {
    // 이름, 학번, 학부, 나이, 과목(InfiSec, DBProg, Algo, SWEng)
    String name;
    String  idNum;
    String dept;
    int age;

    // String[] course
    int kor;
    int eng;
    int math;
    char grade;
    char[] gradeList = {'A', 'B', 'C', 'D', 'E', 'F'};

    public Student(String a, String idNum, String dept)
    {
        this.name = a;
        this.idNum = idNum;
        this.dept = dept;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public char[] getGradeList() {
        return gradeList;
    }

    public void setGradeList(char[] gradeList) {
        this.gradeList = gradeList;
    }

    public void setScore(int i, int j, int k) {
        //this.kor = i;       // kor 필드값에 i값을 입력/설정
        this.setKor(i);

        //this.eng = j;
        this.setEng(j);

        //this.math = k;
        this.setMath(k);
    }

    public double averageScore() {
        return (double)(this.getKor() + this.getEng() + this.getMath()) / 3;
        // this.getkor
    }

    public void printGrade() {
        double avg = this.averageScore(); // 90.333
        int index = 9-(int)avg/10;  // 0,1,2,3,4,5,6,...
        index = (index <= 3) ? index : 4;
        System.out.println(gradeList[index]);
    }
}

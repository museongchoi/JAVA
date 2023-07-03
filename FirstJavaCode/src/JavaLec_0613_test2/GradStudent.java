package JavaLec_0613_test2;

public class GradStudent extends Student implements Compute{
    public GradStudent(String name, int score) {
        super(name, score);
    }

    public GradStudent(String name, int score, String grade) {
        super(name, score, grade);
    }

    @Override
    public String computeGrade() {
        if (score >= 70) {
            grade = "통과";
        } else {
            grade = "낙제";
        }
        return grade;
    }

    @Override
    public String toString() {
        return "소속: 대학원, " + super.toString();
    }
}
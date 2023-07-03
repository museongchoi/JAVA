package JavaLec_0613_test2;

public class UnderStudent extends Student implements Compute{
    public UnderStudent(String name, int score) {
        super(name, score);
    }

    public UnderStudent(String name, int score, String grade) {
        super(name, score, grade);
    }

    @Override
    public String computeGrade() {
        if (score >= 60) {
            grade = "통과";
        } else {
            grade = "낙제";
        }
        return grade;
    }

    @Override
    public String toString() {
        return "소속: 학부, " + super.toString();
    }
}

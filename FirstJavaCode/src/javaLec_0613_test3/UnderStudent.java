package javaLec_0613_test3;

public class UnderStudent extends Student{
    public UnderStudent(String name, int score) {
        super(name, score);
    }

    public UnderStudent(String name, int score, String grade) {
        super(name, score, grade);
    }

    @Override
    public String computeGrade() {
        if (score >= 60) {
            return "통과";
        } else {
            return "낙제";
        }
    }

    @Override
    public String toString() {
        return "소속: 학부, " + super.toString();
    }
}

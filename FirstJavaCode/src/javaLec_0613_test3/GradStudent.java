package javaLec_0613_test3;

public class GradStudent extends Student{
    public GradStudent(String name, int score) {
        super(name, score);
    }

    public GradStudent(String name, int score, String grade) {
        super(name, score, grade);
    }

    @Override
    public String computeGrade() {
        if (score >= 70) {
            return "통과";
        } else {
            return "낙제";
        }
    }

    @Override
    public String toString() {
        return "소속: 대학원, " + super.toString();
    }
}

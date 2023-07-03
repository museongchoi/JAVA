package javaLec_0613_test3;

public class Student {
    protected String name;
    protected int score;
    protected String grade;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, String grade) {
        this.name = name;
        this.score = score;
        this.grade = grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String computeGrade() {
        if (score >= 50) {
            return "통과";
        } else {
            return "낙제";
        }
    }

    @Override
    public String toString() {
        return name + "\t" + score + "\t" + grade;
    }
}

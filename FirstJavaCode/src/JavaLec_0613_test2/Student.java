package JavaLec_0613_test2;

public abstract class Student {
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

    public abstract String computeGrade();

    @Override
    public String toString() {
        return name + "\t" + score + "\t" + grade;
    }
}

package JavaLec_0523;

// Problem을 상속 받은 shortProblem 이 있다.
public class shortProblem extends Problem implements ProblemInterface {
    @Override
    public void makeProblem(String qusetion, String answer, String level) {
        super.makeProblem(qusetion, answer, level);
    }

    @Override
    public void showProblem() {
        //super.showProblem();
        System.out.println("주관식 문제(난이도:" + this.problem[2] + ") : " + this.problem[0]);
    }

    @Override
    public boolean correct(String inputValue) {
        return super.correct(inputValue);
    }

    // Problem에서 파라미터가 4개인 makeProblem이 추상클래스가 되어있기 때문에 상속받은 shortProblem 에서 재정의 해야한다.
    @Override
    public void makeProblem(String s, String s1, String s2, String s3) {

    }
}

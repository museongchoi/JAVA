package JavaLec_0523;

// abstract 추상클래스는 new를 할 수 없다. Problem을 이번에는 추상클래스로 만들어도된다
public abstract class Problem implements ProblemInterface {
    // interface 만들어서 추가
    // 필드값
    String[] problem = new String[3];

    // 수업 시간에 작성. // 주관식 문제 입고 과정
    public void makeProblem(String question, String answer, String level) {
        this.problem[0] = question;
        this.problem[1] = answer;
        this.problem[2] = level;
        // 만약, 문제 출제 범위, 분야 등에 대한 정보 추가...
    }


    public void showProblem()
    {
        System.out.println("문제 : " + this.problem[0]);
    }


    // 첫 번째 answer1 이 정답
    public boolean correct(String inputValue) {
        if(this.problem[1].equals(inputValue)) {
            return true;
        }
        else {
            return false;
        }
    }

    // 파라미터 4개짜리는 추상 클래스로 만들 수 있다.
    public abstract void makeProblem(String s, String s1, String s2, String s3);

//    public String toString() {
//        return "문제은행";
//    }
}

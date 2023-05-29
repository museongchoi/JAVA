package JavaLec_0523;

public class Problem {
    // interface 만들어서 추가
    
    String[] problem = new String[3];

    public void makeProblem(String qusetion, String answer, String level) {
        this.problem[0] = qusetion;
        this.problem[1] = answer;
        this.problem[2] = level;

    }

    public void showProblem() {
        System.out.println("문제 : " + this.problem[0]);

    }

    public boolean correct(String inputValue) {
        if(this.problem[1].equals(inputValue)) {
            return true;
        }
        else {
            return false;
        }
    }
}

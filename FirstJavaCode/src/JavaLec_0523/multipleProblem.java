package JavaLec_0523;

public class multipleProblem extends Problem implements ProblemInterface{
    String muitipleList;    // "1.토트넘, 2.맨유, 3.첼시, 4.아스날"

    @Override
    public void makeProblem(String qusetion, String answer, String level) {
        super.makeProblem(qusetion, answer, level);
    }

    @Override
    public void makeProblem(String question, String multipleList, String level, String answer) {
        super.makeProblem(question, answer, level);
//        this.problem[0] = question;
//        this.problem[1] = answer;
//        this.problem[2] = level;
        this.muitipleList = multipleList;
    }

    @Override
    public void showProblem() {
        //super.showProblem();
        System.out.println("객관식 문제(난이도:" + this.problem[2] + ") : " + this.problem[0]);
        System.out.println(this.muitipleList);
    }

    @Override
    public boolean correct(String inputValue) { // Stirng inputValue = "1"
        return super.correct(inputValue);
    }

    public String correctAnswer() {
        String[] list = this.muitipleList.split(",");   // ,를 기준으로 문자열을 나눔
        // "1.토트넘, 2.맨유, 3.첼시, 4.아스날"
        // list[0] = "1.토트넘", list[1] = "맨유", ...
        return list [ Integer.parseInt(this.problem[1]) - 1];    // "1" --> 1
        // 위 Integer를 래퍼클래스라 부른다.
    }
}

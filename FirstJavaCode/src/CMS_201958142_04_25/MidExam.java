package CMS_201958142_04_25;

// static 과 void 순서 바뀜
public class MidExam {
    public static void main(String[] args) {
        int unit[] = { 3, 2, 1, 0, 1, 2 };
        char ch[] = { '@', '#', '$', '&' };
        System.out.printf("%c %c\n", ch[unit[1]], ch[unit[2]]);
    }
}

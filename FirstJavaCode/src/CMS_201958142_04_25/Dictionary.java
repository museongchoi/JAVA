package CMS_201958142_04_25;

public class Dictionary {
    private static String[] kor = {"사랑", "아기", "미래", "희망"};
    private static String[] eng = {"Love", "Baby", "Future","Hope"};
    public static String kor2Eng(String word) { /*검색 코드 작성*/
        for(int i=0; i<kor.length;i++) {
            if(word.equals(kor[i])) {
                if(i%2==1)
                    System.out.print(word+"은 ");
                else
                    System.out.print(word+"는 ");
                return eng[i];
            }
        }
        return "false";
    }
}

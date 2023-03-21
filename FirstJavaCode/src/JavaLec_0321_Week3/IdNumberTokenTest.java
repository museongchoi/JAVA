package JavaLec_0321_Week3;

import java.util.Scanner;

public class IdNumberTokenTest {
    public static void main(String[] args)
    {
        String s = "한글 출력";
        System.out.println(s);

        System.out.println("주민등록번호를 입력하세요 :");
        Scanner sc = new Scanner(System.in).useDelimiter("\\s|-");

        String idFrontNum = sc.next();
        String idBackNum = sc.next();
        System.out.println("주민등록번호 앞자리는 " + idFrontNum + "입니다.");
        System.out.println("주민등록번호 뒷자리는 " + idBackNum + "입니다.");

        if(idBackNum.charAt(0) == '1' || idBackNum.charAt(0) == '2')
        {
            System.out.println("출생년도 :" + "19" +idFrontNum.charAt(0) + idFrontNum.charAt(1) + "년 입니다.");
            if(idBackNum.charAt(0) == '1')
            {
                System.out.println("성별 : 남");
            }
            else {
                System.out.println("성별 : 여");
            }
        }
        else if(idBackNum.charAt(0) == '3' || idBackNum.charAt(0) == '4')
        {
            System.out.println("출생년도 : " + "20" + idFrontNum.charAt(0) + idFrontNum.charAt(1) + "년 입니다.");
            if(idBackNum.charAt(0) == '3')
            {
                System.out.println("성별 : 남");
            }
            else {
                System.out.println("성별 : 여");
            }
        }
//        if(idBackNum.charAt(0) == '1' || idBackNum.charAt(0) == '3')
//        {
//            System.out.println("성별 : 남");
//        }
//        else{
//            System.out.println("성별 : 여");
//        }
    }
}

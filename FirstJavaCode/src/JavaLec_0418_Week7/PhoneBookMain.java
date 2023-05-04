package JavaLec_0418_Week7;

import java.util.Scanner;

public class PhoneBookMain {
    // 1. 클래스 내에 생성자 2개 이상 중복(오버로딩)하여 작성하시오.
    public static void main(String[] args) {
        PhoneBook myPB = new PhoneBook(); // 생성자 호출

        PhoneBook yourPB = new PhoneBook("홍길동");

        PhoneBook ourPB = new PhoneBook("이순신", "010-1234-5678");

        // -------------------------------------------
        Scanner scan = new Scanner(System.in);

        System.out.println("전화번호 저장 개수 >> ");
        int cnt = scan.nextInt();

        // 객체 배열을 사용할 경우, 반드시 new를 두번 코딩해야 한다.
        PhoneBook[] arrayPB = new PhoneBook[cnt];

        // 입력받고 저장해주는 메소드
        // cnt나 arrayPB의 길이로 돌면된다. 입력된 값 만큼 돌아야 하기 때문이다.
        for(int i = 0; i < arrayPB.length; i++)
        {
            System.out.println("사용자의 이름 및 전화번호를 입력 >> ");
            String inputName = scan.next();
            String inputTel = scan.next();

            arrayPB[i] = new PhoneBook(inputName, inputTel); // 생성자를 불러 준다. 초기화

        }
        System.out.println("저장되었습니다...");

        search(arrayPB);

//        boolean foundFlag = false;
//        String queryName = ""; // queyName 이 그만이 아니면 계속 돈다.
//        while (true)
//        {
//            System.out.println("검색할 이름 : ");
//            queryName = scan.next();
//
//            if(queryName.equals("그만"))
//            {
//                break;
//            }
//
//            for(int i = 0; i < arrayPB.length; i++)
//            {
//                if(arrayPB[i].name.equals(queryName)) // arrayPB[]의 i 번째에 있는 이름과 입력 받은 이름이 같으면 출력
//                {
//                    System.out.println("사용자 이름 : " + arrayPB[i].name + "전화번호 : " + arrayPB[i].tel);
//                    foundFlag = true;
//                    break;
//                }
//            }
//            if(!foundFlag)
//            {
//                System.out.println("사용자 이름 : " + queryName + " 의 전화번호는 등록되어 있지 않습니다.");
//            }
//        }
    }

    private static void search(PhoneBook[] arrayPB) {
        // 검색하는 메소드
        boolean foundFlag = false;
        String queryName = ""; // queyName 이 그만이 아니면 계속 돈다.
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.println("검색할 이름 : ");
            queryName = scan.next();

            if(queryName.equals("그만"))
            {
                break;
            }

            for(int i = 0; i < arrayPB.length; i++)
            {
                if(arrayPB[i].getName().equals(queryName)) // arrayPB[]의 i 번째에 있는 이름과 입력 받은 이름이 같으면 출력
                {
                    System.out.println("사용자 이름 : " + arrayPB[i].getName() + " 전화번호 : " + arrayPB[i].getTel());
                    foundFlag = true;
                    break;
                }
                if(i-1 == arrayPB.length && !foundFlag)
                {
                    System.out.println("사용자 이름 : " + queryName + " 의 전화번호는 등록되어 있지 않습니다.");
                }
                foundFlag = false;  // 사용자 이름 전화번호 확인 뒤에 다시 초기화 해주는 개념
            }
        }
    }
}

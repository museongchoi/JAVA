package CMS_201958142_04_25;

import JavaLec_0418_Week7.PhoneBook;

import java.util.Scanner;

public class Book {
    public static void main(String[] args) {
        BookST bst = new BookST();

        Scanner sc = new Scanner(System.in);
        System.out.print("책의 개수 >> ");
        int cnt = sc.nextInt();

        BookST[] arrayBST = new BookST[cnt];

        for(int i = 0; i < arrayBST.length; i++)
        {
            System.out.print("책의 이름, 저자 및 가격 입력 >> ");
            String title = sc.next();
            String author = sc.next();
            int price = sc.nextInt();

            arrayBST[i] = new BookST(title, author, price); // 생성자를 불러 준다. 초기화

        }
        System.out.println("저장되었습니다...");

        search(arrayBST);
    }

    private static void search(BookST[] arrayBST) {
        // 검색하는 메소드
        boolean foundFlag = false;
        String queryName = ""; // queyName 이 그만이 아니면 계속 돈다.
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.print("검색할 이름 >> ");
            queryName = scan.next();

            if(queryName.equals("그만"))
            {
                break;
            }

            for(int i = 0; i < arrayBST.length; i++)
            {
                if(arrayBST[i].getTitle().equals(queryName)) // arrayPB[]의 i 번째에 있는 이름과 입력 받은 이름이 같으면 출력
                {
                    System.out.println("책 이름 : " + arrayBST[i].getTitle() + " 저자 : " + arrayBST[i].getAuthor()
                            + " 가격 : " + arrayBST[i].getPrice());
                    foundFlag = true;
                    break;
                }
                foundFlag = false;  // 사용자 이름 전화번호 확인 뒤에 다시 초기화 해주는 개념
            }
            if(foundFlag == false)
            {
                System.out.println("책 이름 : " + queryName + " 는 등록되어 있지 않습니다.");
            }
        }
    }
}

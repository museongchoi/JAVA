package CMS_201958142_04_25;

import JavaLec_0404_Week5.Lotto;
import JavaLec_0418_Week7.PhoneBook;

import java.util.Scanner;

public class LottoNumBer {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("로또 번호를 몇 세트 생성할까요 : ");
        int setNum = scan.nextInt();

        Lotto1 lot = new Lotto1();

        for(int i=0; i<setNum; i++)
        {
            lot.makeLottoNumList();
            lot.printLottoNumList();
        }
    }
}

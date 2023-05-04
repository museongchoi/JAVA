package CMS_201958142_04_25;

import JavaLec_0404_Week5.Lotto;

public class B2 {
    public static void main(String[] args) {
        System.out.println("1-100사이 양의 정수 10개 생성 결과");
        int setNum = 1;
        RandNum ra = new RandNum();

        for(int i=0; i<setNum; i++)
        {
            ra.makeLottoNumList();
            ra.printLottoNumList();
        }
    }
}

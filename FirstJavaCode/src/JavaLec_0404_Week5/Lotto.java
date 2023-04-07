package JavaLec_0404_Week5;

import java.util.Arrays;

public class Lotto {
    // field part
    int[] lottoNumList = new int[6];
    
    // 같은 class 안에 있는 객체들은 지역변수 field 값을 사용 가능
    public void makeLottoNumList() {
        for(int i=0; i<lottoNumList.length; i++)
        {
            this.lottoNumList[i] = (int)(Math.random()*45+1);
            for(int j=0; j<i; j++)
            {
                if(this.lottoNumList[j] == this.lottoNumList[i])
                {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lottoNumList);
    }

    public void printLottoNumList() {
        for(int i=0; i<lottoNumList.length; i++)
        {
            System.out.print(lottoNumList[i] + " ");
        }
        System.out.println();
    }

    // method part
    
}

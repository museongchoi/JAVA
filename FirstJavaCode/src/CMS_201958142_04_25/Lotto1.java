package CMS_201958142_04_25;

import java.util.Arrays;

public class Lotto1 {
    int[] lottoNumList = new int[7];
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
            if(i== lottoNumList.length-2)
            {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }
}

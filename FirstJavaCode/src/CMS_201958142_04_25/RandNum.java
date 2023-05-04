package CMS_201958142_04_25;

import java.util.Arrays;

public class RandNum {
    int[] ranum = new int[10];
    public void makeLottoNumList() {
        for(int i=0; i<ranum.length; i++)
        {
            this.ranum[i] = (int)(Math.random()*100+1);
            for(int j=0; j<i; j++)
            {
                if(this.ranum[j] == this.ranum[i])
                {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(ranum);
    }

    public void printLottoNumList() {
        int tmp = 0;
        for(int i=0; i<ranum.length; i++)
        {
            System.out.print(ranum[i] + " ");
        }
        System.out.println();
        System.out.print("3의 배수 : ");
        for(int i=0; i<ranum.length; i++)
        {
            if(ranum[i] % 3 == 0)
            {
                System.out.print(ranum[i] + " ");
                tmp += ranum[i];
            }
        }
        System.out.print("합계 : " + tmp);
    }
}

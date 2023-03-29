package JavaLec_0328_Week4;

public class MultiDimArray {
    public static void main(String[] args) {
        int numOfLotto = 6;
        int numOfSet = 4;
        int maxNumOfLotto = 45;

        int[][] randArray = new int[numOfSet][numOfLotto]; // set, 갯수

        MakeArray(randArray);

        System.out.println(randArray);
        System.out.println(randArray[0]);
        System.out.println(randArray[1]);
        System.out.println(randArray[2]);
        System.out.println(randArray[3]);

        System.out.println(randArray.length);
        System.out.println(randArray[0].length);


    }
    private static void MakeArray(int[][] randArray) {
        for(int i = 0; i < randArray.length; i++)
        {
            for(int j = 0; j < randArray[i].length; j++)
            {
                randArray[i][j] = (int) (Math.random()*45 +1);
                for(int k = 0; k < j; k++)
                {
                    if(randArray[i][k] == randArray[i][j])
                    {
                        i--;
                        break;
                    }
                }
            }
        }

    }
}

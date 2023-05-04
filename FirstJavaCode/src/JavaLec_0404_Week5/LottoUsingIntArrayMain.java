package JavaLec_0404_Week5;

public class LottoUsingIntArrayMain {
    public static void main(String[] args)
    {
        int setNum = 5;
        Lotto lot = new Lotto();

        for(int i=0; i<setNum; i++)
        {
            lot.makeLottoNumList();
            lot.printLottoNumList();
        }

        // second..
        Lotto[] lotArray = new Lotto[setNum];

        // 객체배열을 사용할 경우 --> new를 두번 호출 해야한다...
//        lotArray[0] = new Lotto();
//        lotArray[1] = new Lotto();
//        lotArray[2] = new Lotto();
//        lotArray[3] = new Lotto();
//        lotArray[4] = new Lotto();
       /* for(int i = 0; i < lotArray.length; i++)
        {
            lotArray[i] = new Lotto();  // i번째 생성을 하지 않을 경우를 대비해서 Null Point try/catch 사용

            try {
                try {
                    lotArray[i].makeLottoNumList();
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Array Index Error!!!...");
                    e.printStackTrace();
                }
                lotArray[i].printLottoNumList();
            }catch (NullPointerException e){
                System.out.println("Null Point Error!!!...");
                e.printStackTrace();
            }

        }*/
    }
}

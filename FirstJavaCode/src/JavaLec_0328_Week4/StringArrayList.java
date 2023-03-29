package JavaLec_0328_Week4;

import java.util.ArrayList;

public class StringArrayList {
    public static void main(String[] args)
    {
        String[] stList = {"Java", "Python", "C", "C++", "PHP", "JavaScript"};
        ArrayList<String> tempList = new ArrayList<String>();
        for(int i=0; i<stList.length; i++)
        {
            tempList.add(stList[i]);
        }

        tempList.sort(null);

        // ArrayList 는 다른 구조체 lenght가 아닌 size가 있다
        for(int i=0; i<tempList.size(); i++)
        {
            System.out.print(tempList.get(i) + " ");
        }
    }
}

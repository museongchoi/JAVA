package Basic.Arrangement;
import java.util.*;

// 잘라서 배열로 저장하기
public class Arr_2 {
    //import java.util.*;

    class Solution {
        public String[] solution(String my_str, int n) {
            List<String> list = new ArrayList<>();
            String str = "";

            for(int i = 0; i < my_str.length(); i++)
            {
                str += my_str.charAt(i);
                if(str.length() == n || i+1 == my_str.length())
                {
                    list.add(str);
                    str = "";
                }
            }

            String[] answer = new String[list.size()];
            for(int i = 0; i < answer.length; i++)
            {
                answer[i] = list.get(i).toString();
            }
            return answer;
        }
    }

}

/*
import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> str = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < my_str.length(); i++)
        {
            if(i%n == 0 && i != 0)
            {
                str.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(my_str.charAt(i));
        }
        str.add(sb.toString());

        String[] answer = new String[str.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = str.get(i).toString();
        }
        return answer;
    }
}
 */
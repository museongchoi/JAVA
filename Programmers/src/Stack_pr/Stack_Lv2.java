package Stack_pr;
import java.util.*;

// 올바른 괄호
public class Stack_Lv2 {
    //import java.util.*;
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<Character> st = new Stack<>();

            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == '(')
                {
                    st.push('(');
                } else if(s.charAt(i) == ')')
                {
                    if(st.isEmpty())
                    {
                        return answer = false;
                    } else {
                        st.pop();
                    }
                }
            }

            return answer = st.isEmpty();
        }
    }
}


// cnt 를 사용 한 비교
// cnt1, cnt2 로 '(' 와 ')' 를 cnt 하고 값이 같으면 다 지워지는 것이니 true
// 중간에 cnt2 가 cnt1 보다 커지면 음수 즉, ')' 가 연속으로 들어온 것 or 맨 처음 들어왔기 때문에 false

/*
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                cnt1++;
            } else if(s.charAt(i) == ')')
            {
                cnt2++;
            }
            if(cnt1 < cnt2)
            {
                return answer = false;
            }
        }
        if(cnt1 == cnt2)
        {
            answer = true;
        }

        return answer;
    }
}
 */
package Week8;
import java.util.*;

// 주사위 게임 3
public class W8_2 {
    //import java.util.*;

    class Solution {
        public int solution(int a, int b, int c, int d) {
            int answer = 0;
            int[] nums = new int[4];
            nums[0] = a;
            nums[1] = b;
            nums[2] = c;
            nums[3] = d;
            int multi = 1;

            Arrays.sort(nums);
            int[] dice = new int[6];
            for(int i = 0; i < 4; i++)
            {
                dice[nums[i]-1]++;
            }
            for(int i = 0; i < 6; i++)
            {
                if(dice[i] == 4) {
                    answer = 1111 * (i+1);
                    break;
                } else if (dice[i] == 3) {
                    for(int j = 0; j < 6; j++)
                    {
                        if(dice[j] == 1) {
                            answer = (int)Math.pow(10*(i+1)+(j+1), 2);
                            break;
                        }
                    }
                } else if (dice[i] == 2) {
                    for(int j = 0; j < 6; j++)
                    {
                        if(dice[j] == 2) {
                            if(i == j) {
                                continue;
                            } else {
                                answer = ((i+1) + (j+1)) * Math.abs((i+1) - (j+1));
                                break;
                            }
                        } else if (dice[j] == 1) {
                            multi = multi * (j+1);
                        }
                    }
                    if(multi != 1) {
                        answer = multi;
                    }
                }
                if(nums[0]!=nums[1] && nums[1]!=nums[2] && nums[2]!=nums[3]){
                    answer=nums[0];
                }
            }

            return answer;
        }
    }
}

// 정렬 위치로 비교
/*
import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {

        int[] dice = { a, b, c, d };
        Arrays.sort(dice);

        int ans = 0;

        if (dice[0] == dice[3]) {
            ans = 1111 * dice[3];
        } else if (dice[0] == dice[2] || dice[1] == dice[3]) {
            ans = (int) Math.pow(dice[1] * 10 + (dice[0] + dice[3] - dice[1]), 2);
        } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
            ans = (dice[0] + dice[3]) * (dice[3] - dice[0]);
        } else if (dice[0] == dice[1]) {
            ans = dice[2] * dice[3];
        } else if (dice[1] == dice[2]) {
            ans = dice[0] * dice[3];
        } else if (dice[2] == dice[3]) {
            ans = dice[0] * dice[1];
        } else {
            ans = dice[0];
        }

        return ans;
    }
}
 */


// 내가 푼 알고리즘 오류가 있음
/*
import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
         int answer = 0;
            ArrayList <Integer> arr = new ArrayList<>();
            ArrayList <Integer> tmp = new ArrayList<>();
            arr.add(a); arr.add(b); arr.add(c); arr.add(d);
            int cnt = 0;

            for(int i = 0; i <= 7; i++)
            {
                tmp.add(0);
            }

            for(int i = 0; i < arr.size(); i++)
            {
                int value = arr.get(i);
                tmp.set(value, tmp.get(value) + 1);
            }

            for(int i = 0; i < tmp.size(); i++)
            {
                if(tmp.get(i) == 4) {
                    answer = (1111*i);
                    return answer;
                } else if(tmp.get(i) == 3) {
                    int p = i;
                    for(int j = 1; j < tmp.size(); j++)
                    {
                        if(tmp.get(j) == 1)
                        {
                            int q = j;
                            answer = (int)Math.pow(10*p+q, 2);
                            return answer;
                        }
                    }
                } else if(tmp.get(i) == 2) {
                    int p = i;
                    int q = -1;
                    int r = -1;
                    for(int j = i+1; j < tmp.size(); j++)
                    {
                        if(tmp.get(j) == 2)
                        {
                            q = j;
                            answer = (p + q) * Math.abs(p - q);
                            return answer;
                        } else if(tmp.get(j) == 1) {
                            q = j;
                            for(int k = j+1; k < tmp.size(); k++)
                            {
                                if(tmp.get(k) == 1) {
                                    r = k;
                                    answer = q * r;
                                    return answer;
                                }
                            }
                        }
                    }
                }
            }
            answer = Collections.min(arr);
            return answer;
    }
}
 */
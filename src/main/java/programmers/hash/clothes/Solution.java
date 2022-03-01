package programmers.hash.clothes;

import java.util.HashMap;
import java.util.Set;


class Solution {

    //내가 푼 문제
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> ClothesCnt = new HashMap<String, Integer>();

        for(int i = 0; i< clothes.length; i++){
            if(i == 0){
                ClothesCnt.put(clothes[i][1], 1);
            }else{
                if(ClothesCnt.get(clothes[i][1]) != null){
                    ClothesCnt.put(clothes[i][1], 1);
                }else{
                    //변수 하나 선언해서 해당하는 옷의 종류의 cnt 수를 하나 늘려준다.
                    int a = ClothesCnt.get(clothes[i][1]);
                    ClothesCnt.put(clothes[i][1], a+1);
                }
            }
        }
        int [] a = {};
        Set<String> keyset = ClothesCnt.keySet();
        int i = 0;
        for(String key : keyset){
            a[i] = ClothesCnt.get(key);
            i++;
        }
        3 5 8
        for(int ii = 0; ii<a.length; ii++){
            if(ii == 0){
                answer += a[ii];
            }else{
                answer = answer + a[ii] + (answer * a[ii]);
            }
        }

        //나올 수 있는 경우의 수 : 옷의 종류를 모두 더한값 + 각 종류의 옷을 각각 곱함
        return answer;
    }

}

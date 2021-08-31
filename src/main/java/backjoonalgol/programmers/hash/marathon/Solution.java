package backjoonalgol.programmers.hash.marathon;

import java.util.Arrays;
import java.util.HashMap;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        HashMap <Integer, String> participantHash = new HashMap<Integer, String>();
        HashMap <Integer, String> completionHash = new HashMap<Integer, String>();

        for(int i = 0; i< participant.length; i++){
            participantHash.put(i, participant[i]);
        }

        for(int i = 0; i< participant.length; i++){
            completionHash.put(i, completion[i]);
        }

        for(int i = 0; i< participantHash.size(); i++){
            for(int j = 0; j< completionHash.size();j++){
                if(participantHash.get(i) == completionHash.get(j)){
                    participantHash.remove(i);
                }
            }
        }
        for(int key : participantHash.keySet()){

            String value = participantHash.get(key);

            answer = value;

        }

        return answer;
    }
        public String solution2(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
            for (String player : completion) hm.put(player, hm.get(player) - 1);

            for (String key : hm.keySet()) {
                if (hm.get(key) != 0){
                    answer = key;
                }
            }
            return answer;
        }

}

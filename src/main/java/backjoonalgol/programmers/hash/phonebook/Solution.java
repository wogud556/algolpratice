package backjoonalgol.programmers.hash.phonebook;

public class Solution {
    public boolean solution(String[] phone_book) {//내가 푼 문제
        String [] compare = phone_book.clone();
        boolean answer = true;
        for(int i=0 ; i<phone_book.length; i++){
            for(int j = 0; j <= compare.length ; j++){
                if(i!=j){
                    if(phone_book[i].indexOf(compare[j]) != -1){
                        answer = false;
                    }
                }
            }
        }
        return answer;
    }

    public boolean solution2(String[] phoneBook) {//실제로 푼 문제
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}//이거 쓰면 편하다더라
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}
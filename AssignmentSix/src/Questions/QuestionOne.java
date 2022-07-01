package Questions;
/*
    Given a string S, find the longest palindromic substring in S.
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.


 */
public  class QuestionOne {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("aabab"));
    }


public static String longestPalindrome(String s){
    if( s!= null && s.length() <= 1)
        return s;
    int len =0, start=0, end=0, len1=0, len2=0;
    for (int i = 0; i < s.length(); i++) {
        len1 = expandAroundCenter(s, i, i);
        len2 = expandAroundCenter(s, i, i+1);
        len = Math.max(len1, len2);
        if(len > end -start){
            start = i - (len-1)/2;
            end = i + len/2;

        }
    }
    return s.substring(start, end+1);
}

public static int expandAroundCenter(String s, int i, int j){
    while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
        i--;
        j++;
    }
    return j-1-i;
}

}

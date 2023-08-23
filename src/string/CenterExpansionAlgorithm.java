package string;


import java.util.Random;
import java.util.UUID;

//最长回文字符串，中心阔山算法
public class CenterExpansionAlgorithm {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHABET.length());
            char randomChar = ALPHABET.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20 ; i++) {
            String s = generateRandomString(20);
            System.out.println(s);
            String s1 = new CenterExpansionAlgorithm().longestPalindrome(s);
            System.out.println(s1);
        }



    }

    //获取字符串最长回文
    public String longestPalindrome(String s){
        if(s == null || s.length() < 1){
            return null;
        }
        int start = 0,end = 0,length = 0;
        for (int i = 0; i < s.length(); i++) {
            int i1 = expandAroundCenter(s, i, i);
            int i2 = expandAroundCenter(s, i, i + 1);
            //获取最大长度
            length = Math.max(i1, i2);

            if (length > end - start + 1){
                start = i - (length - 1)/2;
                end = i + length/2;
            }

//            if(end - start < length){
//                start = i-(length/2);
//                if(length % 2 == 0){
//                    start++;
//                }
//                end = start + length;
//            }
        }
        return s.substring(start,end+1);
    }
    /**
     * 环绕中心扩展
     */
    public int expandAroundCenter(String s,int left,int right){
        while (left >= 0 && right< s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }

}

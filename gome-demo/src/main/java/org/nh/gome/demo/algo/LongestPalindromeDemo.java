package org.nh.gome.demo.algo;

/**
 * 力扣5
 * @program: LongestPalindromeDemo.java
 * @description: 为什么我的超时?
 * @author: yindanqing
 * @create: 2020/6/18 16:48
 */
public class LongestPalindromeDemo {

    public static void main(String[] args) {
        String str = "iopsajhffgvrnyitusobwcxgwlwniqchfnssqttdrnqqcsrigjsxkzcmuoiyxzerakhmexuyeuhjfobrmkoqdljrlojjjysfdslyvckxhuleagmxnzvikfitmkfhevfesnwltekstsueefbrddxrmxokpaxsenwlgytdaexgfwtneurhxvjvpsliepgvspdchmhggybwupiqaqlhjjrildjuewkdxbcpsbjtsevkppvgilrlspejqvzpfeorjmrbdppovvpzxcytscycgwsbnmspihzldjdgilnrlmhaswqaqbecmaocesnpqaotamwofyyfsbmxidowusogmylhlhxftnrmhtnnljjhhcfvywsqimqxqobfsageysonuoagmmviozeouutsiecitrmkypwknorjjiaasxfhsftypspwhvqovmwkjuehujofiabznpipidhfxpoustquzyfurkcgmioxacleqdxgrxbldcuxzgbcazgfismcgmgtjuwchymkzoiqhzaqrtiykdkydgvuaqkllbsactntexcybbjaxlfhyvbxieelstduqzfkoceqzgncvexklahxjnvtyqcjtbfanzgpdmucjlqpiolklmjxnscjcyiybdkgitxnuvtmoypcdldrvalxcxalpwumfx";
        System.out.println(new LongestPalindromeDemo().longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j ++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp) && temp.length() > max) {
                    res = temp;
                    max = Math.max(temp.length(), max);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s){
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }


    public String longestPalindrome2(String s) {
        if(s == null || s.equals("")){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] result = new int[2];
        for(int i = 0; i<s.length(); i++) dp[i][i] = true;
        for(int i = s.length()-1; i>=0; i--){
            for(int j = i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    if(result[1]-result[0] <= j - i){
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return s.substring(result[0],result[1]+1);

    }

}

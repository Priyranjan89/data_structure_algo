package datastrcture.recursion;

public class StringIsPalindrome {

    public static boolean isPalindrome(String s){

        if (s.length() == 0 || s.length() == 1){
            return true;
        }

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
           return isPalindrome(s.substring(1, s.length()-1));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("DALAD"));
        System.out.println(isPalindrome("tacocat"));
        System.out.println(isPalindrome("Awesome"));
    }
}

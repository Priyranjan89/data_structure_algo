package datastrcture.recursion;

public class CapitalizeFirstCharWordInString {

    public static String capitalizeWord(String str){
        if (str.isEmpty()){
            return str;
        }
        char ch = str.charAt(str.length()-1);

        if (str.length() == 1)
            return Character.toString(Character.toUpperCase(ch));

        if (str.substring(str.length()-2, str.length()-1).equals(" ")){
            ch = Character.toUpperCase(ch);
        }

        return capitalizeWord(str.substring(0, str.length()-1))+Character.toString(ch);
    }

    public static void main(String[] args) {
        System.out.println(capitalizeWord("i love you"));
    }
}

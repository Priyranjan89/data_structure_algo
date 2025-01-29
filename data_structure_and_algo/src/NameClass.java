import com.my.datastrcture.CatogeryLimit;

import java.util.HashMap;
import java.util.Map;

/*Age
20-30
rating 8

Age
31-35
rating 7

Age
36-40
rating 6

Age
41-50
5

CreditLimit
1-10
rating 5

CreditLimit
10-90
rating 9/

ex
age , 32 ===> rating 7
creditlimit ,11 ===> 9
salary ,1000 =>1
salary , 90000 ===> 90

 */
public class NameClass {
    private static Map<String, CatogeryLimit> catogeryLimitMap = new HashMap<>();
    public static void main(String[] args) {
        storyCatogery();
        int rating = ratingBaseOnCatogary("Age", 22, 0.0);
        System.out.println(rating);
    }

    public static int ratingBaseOnCatogary(String catogary, int age, double salary){
        int rating = -1;
        switch (catogary){
            case "Age" : {
                if (age >= 20 && age <= 30){
                    rating = ageCatogery("age2030");
                }
            }
        }
        return rating;
    }

    private static int ageCatogery(String key){
        CatogeryLimit ageCatogery = catogeryLimitMap.get(key);
        return ageCatogery.rating;
    }

    private static void storyCatogery(){

        CatogeryLimit ageCatogery = new CatogeryLimit(20, 30, 8);
        catogeryLimitMap.put("age2030", ageCatogery);

    }

}

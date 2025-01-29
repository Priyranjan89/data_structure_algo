package com.my.datastrcture.interview;
/*
*  in this task a basic message delivery service is to be implemented that has a rate limiting algorithm that drop any message that has already been delibre in the last case second given the Integer k a list of message as an array of instin message and a sorted integer times represented the time at which the message arrive

* for each message report the string to if the message is deliver and false otherwise example support in equal to 6 and time is time equal to array of [1,4,5,10 ,11 ,14] and message equal to [hello, bye, bye, hello, bye, hello](it is a string array )and K equal to 5  please solve this problem in java
*
*
STDIN           FUNCTION
-----           --------
4         →     timestamp[] size n = 4
1         →     timestamp = [1, 1, 1, 11]
1
1
11
4         →     messages[] size n = 4
message-2 →     messages = ["message-2", "message-2", "message-3", "message-2"]
message-2
message-3
message-2
5         →     k = 5

true
false
true
true

Language
Java 15
 Environment
Autocomplete Ready


* */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageDeliveryService {

    public static List<String> getMessageStatus(List<Integer> timestamp, List<String> message, int k) {
        // Result list to store "true" or "false" if each message is delivered or not
        List<String> result = new ArrayList<>();

        // Map to track the last delivered time of each message
        HashMap<String, Integer> lastDeliveredTime = new HashMap<>();

        for (int i = 0; i < message.size(); i++) {
            String currentMessage = message.get(i);
            int currentTime = timestamp.get(i);

            // Check if the message can be delivered based on the last delivered time
            if (!lastDeliveredTime.containsKey(currentMessage) || (currentTime - lastDeliveredTime.get(currentMessage)) >= k) {
                // Deliver the message and update the last delivered time
                result.add("true");
                lastDeliveredTime.put(currentMessage, currentTime);
            } else {
                // Drop the message
                result.add("false");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> timestamp = List.of(1, 4, 5, 10, 11, 14);
        List<String> message = List.of("hello", "bye", "bye", "hello", "bye", "hello");
        int k = 5;

        List<String> result = getMessageStatus(timestamp, message, k);

        // Print the result
        System.out.println("Message delivery status: " + result);
    }
}

package com.my.datastrcture.codingninja.string;

import java.util.*;

public class MemberMessageCounter {
    public static void main(String[] args) {
        // Input arrays
        String[] members = {"b123", "b321", "ac654", "m198", "s10"};
        String[] messages = {
                "hey @b123, b321, please review my PR",
                "Hello @ac654 is it correct approch",
                "yeah @s10, @b123, @ac654 it right",
                "Thanks @k190, @b123, @ac654"
        };

        List<String> result = getStringList(members, messages);

        // Print the result
        System.out.println(result);
    }

    private static List<String> getStringList(String[] members, String[] messages) {
        // Create a set for quick member lookup
        Set<String> memberSet = new HashSet<>(Arrays.asList(members));

        // Map to store the count of mentions for each member
        Map<String, Integer> mentionCount = new HashMap<>();

        // Initialize mentionCount with all members set to 0
        for (String member : members) {
            mentionCount.put(member, 0);
        }

        // Iterate through each message
        for (String message : messages) {
            // Split message into words
            String[] words = message.split("[ ,]");
            for (String word : words) {
                // Normalize the word to remove @
                String id = word.startsWith("@") ? word.substring(1) : word.trim();
                // Count the mention only if it's in the member set
                if (memberSet.contains(id)) {
                    mentionCount.put(id, mentionCount.getOrDefault(id, 0) + 1);
                }
            }
        }

        // Prepare the output
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mentionCount.entrySet()) {
            result.add(entry.getKey() + "-" + entry.getValue());
        }
        return result;
    }
}

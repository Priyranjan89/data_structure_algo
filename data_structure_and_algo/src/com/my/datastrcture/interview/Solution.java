package com.my.datastrcture.interview;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'getRegions' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY ip_addresses as parameter.
     */

    public static List<Integer> getRegions(List<String> ip_addresses) {
        List<Integer> regions = new ArrayList<>();

        for (String ip : ip_addresses) {
            if (isValidIPv4(ip)) {
                regions.add(classifyRegion(ip));
            } else {
                regions.add(-1); // Invalid IP address
            }
        }

        return regions;
    }

    // Helper method to check if an IPv4 address is valid
    private static boolean isValidIPv4(String ip) {
        String[] octets = ip.split("\\.");
        if (octets.length != 4) {
            return false;
        }

        try {
            for (String octet : octets) {
                int value = Integer.parseInt(octet);
                if (value < 0 || value > 255) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Helper method to classify an IPv4 address into a region
    private static int classifyRegion(String ip) {
        String[] octets = ip.split("\\.");
        int firstOctet = Integer.parseInt(octets[0]);

        if (firstOctet >= 0 && firstOctet <= 127) {
            return 1;
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            return 2;
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            return 3;
        } else {
            return -1; // Should not reach here for valid IPv4 addresses
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        List<String> ip_addresses = new ArrayList<>();
        ip_addresses.add("192.168.1.1");
        ip_addresses.add("10.20.30.40");
        ip_addresses.add("172.16.0.1");
        ip_addresses.add("300.400.500.600"); // Invalid
        ip_addresses.add("abc.def.ghi.jkl"); // Invalid

        List<Integer> result = Result.getRegions(ip_addresses);

        for (int region : result) {
            System.out.println(region);
        }
    }
}

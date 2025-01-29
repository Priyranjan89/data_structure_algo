package com.my.datastrcture.interview;

import java.util.ArrayList;
import java.util.List;

public class BatchProcessor {

    public static void main(String[] args) {
        List<String> records = new ArrayList<>();
        // Populate records with data (simulate 10,000 records here)
        for (int i = 1; i <= 10000; i++) {
            records.add("Record " + i);
        }

        int batchSize = 3000;
        List<List<String>> batches = createBatches(records, batchSize);

        for (List<String> batch : batches) {
            // Process each batch of 3000 records in the database
            processBatch(batch);
        }
    }

    private static List<List<String>> createBatches(List<String> records, int batchSize) {
        List<List<String>> batches = new ArrayList<>();
        for (int i = 0; i < records.size(); i += batchSize) {
            int end = Math.min(i + batchSize, records.size());
            List<String> batch = new ArrayList<>(records.subList(i, end));  // Make a new copy of each batch
            batches.add(batch);
        }
        return batches;
    }

    private static void processBatch(List<String> batch) {
        // Add your database processing logic here
        System.out.println("Processing batch of size: " + batch.size());
    }
}

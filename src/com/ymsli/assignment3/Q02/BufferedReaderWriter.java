package com.ymsli.assignment3.Q02;

import java.io.*;

public class BufferedReaderWriter {
    public static void main(String[] args) {

        File source = new File("sample.txt");
        File dest1 = new File("copyWithoutBuffer.txt");
        File dest2 = new File("copyWithBuffer.txt");

        long startTime;
        long timeWithoutBuffer = 0, timeWithBuffer = 0;

        startTime = System.currentTimeMillis();

        try (FileReader fr = new FileReader(source);
             FileWriter fw = new FileWriter(dest1)) {

            int charData;
            while ((charData = fr.read()) != -1) {
                fw.write(charData);
            }

            long endTime = System.currentTimeMillis();
            timeWithoutBuffer = endTime - startTime;
            System.out.println("Without buffering: " + timeWithoutBuffer + " ms");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        startTime = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dest2))) {

            char[] buffer = new char[8192];
            int charsRead;

            while ((charsRead = br.read(buffer)) != -1) {
                bw.write(buffer, 0, charsRead);
            }

            bw.flush();

            long endTime = System.currentTimeMillis();
            timeWithBuffer = endTime - startTime;
            System.out.println("With buffering: " + timeWithBuffer + " ms");

            System.out.println("Performance improved by: "+ (timeWithoutBuffer - timeWithBuffer)+ "ms");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

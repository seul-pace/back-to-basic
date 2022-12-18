package com.seul.backtobasic.code;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Nexon4 {
    private static final Scanner scan = new Scanner(System.in);

    private static final String METHOD = "GET";
    private static final String RESPONSE_CODE = "200";
    private static final String FILE_NAME_EXTENSION_LOWER = ".gif";
    private static final String FILE_NAME_EXTENSION_UPPER = ".GIF";
    private static final String WRITE_FILE_NAME = "gifs_";

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
//        filename = scan.nextLine();
        filename = "hosts_access_log_00.txt";

        try {
            File file = new File("/Users/iseulhui/" + filename);

            if (!file.exists() || !file.isFile() || !file.canRead()) {
                return;
            }

            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";

            HashSet<String> fileSet = new HashSet<>();

            // read File
            while((line = bufferedReader.readLine()) != null) {

                String[] splitLine = line.split("\"");

                // method, code validate
                if (!splitLine[1].startsWith(METHOD)) continue;
                if (!splitLine[2].trim().startsWith(RESPONSE_CODE)) continue;

                // gif validate
                String[] splitGetResponse = splitLine[1].split(" ");

                String fileNameWithPath = "";
                for (String s : splitGetResponse) {
                    if (s.contains(FILE_NAME_EXTENSION_LOWER) || s.contains(FILE_NAME_EXTENSION_UPPER)) {
                        fileNameWithPath = s;
                        break;
                    }
                }

                if (fileNameWithPath.equals("")) continue;

                String[] splitFileNameWithPath = fileNameWithPath.split("/");
                for (String s : splitFileNameWithPath) {
                    if (s.contains(FILE_NAME_EXTENSION_LOWER) || s.contains(FILE_NAME_EXTENSION_UPPER)) {
                        fileSet.add(s);
                    }
                }
            }

            bufferedReader.close();

            // write File
            File writeFile = new File("/Users/iseulhui/" + WRITE_FILE_NAME + filename);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeFile));

            for (String f : fileSet) {
                bufferedWriter.write(f);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.seul.backtobasic.code;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;

public class Nexon5 {
    private static final Scanner scan = new Scanner(System.in);

    private static final String METHOD = "GET";
    private static final String RESPONSE_CODE = "200";
    private static final String FILE_NAME_EXTENSION_LOWER = ".gif";
    private static final String FILE_NAME_EXTENSION_UPPER = ".GIF";
    private static final String WRITE_FILE_NAME = "req_";

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

            HashSet<String> timeSet = new HashSet<>();
            List<String> list = new ArrayList<>();
            List<String> comparisonList = new ArrayList<>();

            // read File
            while((line = bufferedReader.readLine()) != null) {

                String[] splitLine = line.split("\\[");
                String[] againSplitLine = splitLine[1].split(" -");

                list.add(againSplitLine[0]);
                comparisonList.add(againSplitLine[0]);
            }

            bufferedReader.close();

            for (String l : list) {
                if(list.indexOf(l) != comparisonList.lastIndexOf(l)) {
                    timeSet.add(l);
                }
            }

            // write File
            File writeFile = new File("/Users/iseulhui/" + WRITE_FILE_NAME + filename);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeFile));

            for (String f : timeSet) {
                bufferedWriter.write(f);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

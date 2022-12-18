package com.seul.backtobasic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nexon1 {
        public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Integer> rotate = new ArrayList<>();
        rotate.add(1);
        rotate.add(2);
        rotate.add(3);
        rotate.add(4);

        List<Integer> result = getMaxElementIndexes(a, rotate);

        for(int i : result) {
            System.out.println(i);
        }
    }

    public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {

        List<Integer> result = new ArrayList<>();

        int max = Collections.max(a);

        for (int r : rotate) {
            int index = r % a.size();

            List<Integer> rotatedList = getLeftRotateList(a, index);

            result.add(rotatedList.indexOf(max));
        }

        return result;
    }

    public static List<Integer> getLeftRotateList(List<Integer> list, int index) {
        List<Integer> temp = new ArrayList<>(list);
        Collections.rotate(temp, -index);
        return temp;
    }
}

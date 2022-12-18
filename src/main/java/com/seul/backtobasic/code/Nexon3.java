package com.seul.backtobasic.code;

import java.util.*;

class Nexon3 {

    public static void main(String[] args) {
        int x = 3;
        int y = 3;

        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> grid2 = new ArrayList<>();
        grid2.add(4);
        grid2.add(5);
        grid.add(grid2);
        List<Integer> grid3 = new ArrayList<>();
        grid3.add(6);
        grid3.add(7);
        grid.add(grid3);

        int result = largestSubgrid(grid, 2);

        System.out.println(result);
    }

    public static int largestSubgrid(List<List<Integer>> grid, int maxSum) {

        int result = 0;
        int size = grid.size();
        Integer[][] gridArray = new Integer[size][size];
        int[] sumArray = new int[size];

        // 배열 변환
        for (int i = 0; i < grid.size(); i++) {
            Integer[] temp = grid.get(i).toArray(Integer[]::new);

            System.arraycopy(temp, 0, gridArray[i], 0, grid.size());
        }

        for (int i = 0; i < size; i++) {
            int max = 0;

            for (int x = 0; x < size - i; x++) {
                for (int y = 0; y < size - i; y++) {

                    int sum = 0;

                    // 해당 위치 sum
                    for(int a = x; a <= x + i; a++) {
                        for(int b = y; b <= y + i; b++) {
                            sum += gridArray[a][b];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }

            sumArray[i] = max;
        }

        for (int i = 0; i < sumArray.length - 1; i++) {
            if (sumArray[i] < maxSum
                    && sumArray[i+1] >= maxSum) {
                result = i;
                break;
            }
        }

        return result;
    }

}


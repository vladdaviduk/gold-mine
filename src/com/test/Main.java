package com.test;

import static com.test.GMI.getMaxGold;

public class Main {

    public static void main(String[] args) {
        int[][] gold =  {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        int m = 4, n = 4;

        System.out.println(getMaxGold(gold, m, n));
    }
}

package com.test;

import static java.lang.Math.max;

public class GMI {

    private static final int max = 100;

    public static int getMaxGold(int[][] gold, int m, int n){

        if(gold.length > max) throw new RuntimeException("Too large array");

        int maxGold = 0;
        for (int i = 0; i < gold.length; i++) {
            maxGold = max(maxGold, stepAndCalculate(gold, buildStep(gold, i, 0), gold[i][0], maxGold, m, n));
        }

        return maxGold;
    }

    private static int stepAndCalculate(int[][] gold, Step step, int totalGold, int maxGold, int m, int n){

        if(step.getColumn() < m - 1){
            int nextColumn = step.getColumn() + 1;

            Step nextRightStep = buildStep(gold, step.getRow(), nextColumn);
            maxGold = stepAndCalculate(gold, nextRightStep, totalGold + nextRightStep.getGold(), maxGold, m, n);

            if(step.getRow() < n - 1){
                Step nextRightUpStep = buildStep(gold, step.getRow() + 1, nextColumn);
                maxGold = stepAndCalculate(gold, nextRightUpStep, totalGold + nextRightUpStep.getGold(), maxGold, m, n);
            }

            if(step.getRow() > 0){
                Step nextRightDownStep = buildStep(gold, step.getRow() - 1, nextColumn);
                maxGold = stepAndCalculate(gold, nextRightDownStep, totalGold + nextRightDownStep.getGold(), maxGold, m, n);
            }
        }

        return max(totalGold, maxGold);
    }

    private static Step buildStep(int[][] gold, int row, int column){
        return new Step(row, column, gold[row][column]);
    }
}

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Simple ADFGVX cipher solver written in Java.
 *
 * Authors: Andrew Lubinger and Amy Niu
 */
public class Main {

    public static void main(String[] args) {
        //ciphertext
        String s = "ABCDEF";
        //get transposition columns
        char[][] columns = getTranspositionColumns(s, 2, 3);
        //convert columns to list form
        List<List<Character>> cList = matrixToList(columns,  2, 3);
        //get all possible permutations of the columns
        List<List<List<Character>>> perms = new ArrayList<>();
        heapPermutation(cList, perms, cList.size());
        //get the pre-transposition CT
        String ct = getPreTranspositionCT(perms.get(0));
        //split ct into pairs
        List<String> pairs = getPairs(ct);
        //Map<String,Integer> frequencies = getFrequency(pairs);
        //List<Map.Entry<String,Integer>> orderFrequency = orderFrequency(frequencies);
        //System.out.println("here: " + orderFrequency);
        //test pairs with different possible combinations
    }

    /**
     * Find all possible columns permutations in transposition.
     * @param a list of columns
     * @param perms all possible column permutations
     * @param size number of columns
     */
    public static void heapPermutation (List<List<Character>> a, List<List<List<Character>>> perms, int size) {
        if (size == 1) {
            perms.add(a);
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(a, perms,size - 1);
            //if size is odd, swap the first and last element
            if (size % 2 != 0) {
                List<Character> temp = a.remove(0);
                a.add(0, a.remove(a.size() - 1));
                a.add(a.size() - 1, temp);
            } else {
                //otherwise, swap the ith and last element
                List<Character> temp = a.remove(i);
                a.add(i, a.remove(a.size() - 1));
                a.add(a.size() - 1, temp);
            }
        }
    }

    /**
     * Adds all columns of a matrix into a list.
     * @param columns matrix
     * @param r number of rows of the matrix
     * @param c number of columns of the matrix
     * @return list of columns in the matrix
     */
    public static List<List<Character>> matrixToList(char[][] columns, int r, int c) {
        List<List<Character>> allCols = new ArrayList<>();
        List<Character> col = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                col.add(col.size(),columns[j][i]);
            }
            allCols.add(col);
            col = new ArrayList<>();
        }
        return allCols;
    }

    public static List<Map.Entry<String,Integer>> orderFrequency(Map<String,Integer> frequencies) {
        List<Map.Entry<String,Integer>> order = new ArrayList<>();
        for (Map.Entry<String,Integer> m : frequencies.entrySet()) {
            if (order.size() == 0) {
                order.add(0,m);
            } else {
                int size = order.size();
                for (int i = 0; i < size; i++) {
                    if (order.get(i).getValue() <= m.getValue()) {
                        order.add(i,m);
                        break;
                    }
                }
            }
        }
        return order;
    }

    public static Map<String, Integer> getFrequency(List<String> pairs) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            if (frequencies.containsKey(pairs.get(i))) {
                int val = frequencies.get(pairs.get(i));
                val++;
                frequencies.replace(pairs.get(i),val);
            } else {
                frequencies.put(pairs.get(i),1);
            }
        }
        return frequencies;
    }

    /**
     * Splits the ciphertext into pairs.
     * @param s ciphertext
     * @return a list of pairs
     */
    public static List<String> getPairs (String s) {
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < s.length(); i+=2) {
            pairs.add(s.substring(i,i+2));
        }
        return pairs;
    }

    /**
     * Find the ciphertext pre-transposition.
     * @param columns list of all columns in transposition table
     * @return the pre-transposition ciphertext
     */
    public static String getPreTranspositionCT(List<List<Character>> columns) {
        StringBuilder ct = new StringBuilder();
        for (int i = 0; i < columns.get(0).size(); i++) {
            for (int j = 0; j < columns.size(); j++) {
                ct.append(columns.get(j).get(i));
            }
        }
        return ct.toString();
    }

    /**
     * Gets the columns from the transposition table.
     * @param s the initial ciphertext
     * @param r the number of rows of the transposition table
     * @param c the columns of columns of the transposition table
     * @return a matrix of the ciphertext
     */
    public static char[][] getTranspositionColumns(String s, int r, int c) {
        char[][] transpositionColumns = new char[r][c];
        int charCount = 0;
        for (int i = 0; i < c; i ++) {
            for (int j = 0; j < r; j++) {
                transpositionColumns[j][i] = s.charAt(charCount);
                charCount++;
            }
        }
        return transpositionColumns;
    }

    /**
     * Prints out a matrix.
     * @param columns the matrix to be printed
     */
    public static void printMatrix(char[][] columns) {
        for (int i = 0; i < columns.length;i ++) {
            for (int j = 0; j < columns[i].length; j++) {
                System.out.print(columns[i][j] + " ");
            }
            System.out.println();
        }
    }
}

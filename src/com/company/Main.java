package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * Simple ADFGVX cipher solver written in Java.
 *
 * Authors: Andrew Lubinger and Amy Niu
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String ct = "oAnFpApGnGpDoFoDmXpGnXnGpAlAoGoDpFoGoAmDnFmGoAoDoAlFpDnFmGoGoAmDlAnXoAlAmGoGnGmXoDlGoDpGpDoGnGoAlApAoGoFnDlAlXpGoFpGnXlAoDpAnAmDoGlFnDlAoGnFmDoAlGoAoDoAlApAmGpAnAnGnApGoDpFlFlAnFmFnGpAoXnGoFoDnFoGoDlAmGpFmAmDpGoApGoAnAnGnFoDoGoApGoAnXnGnGpGnApFoFmGnGoDnFnGoAnFpFnFlAlDoGoDlGnGnFoFlAmDlAnAlDoDoFlAlFmGoAmFmAoAnGoAoGpAnApGoGnGnGpGoGpAnGnApDmDoAmFmDoDoFpDnApFoAoFnDlAnAnFpGpDoFoGoApAoGnGpFnGmAoFnGlDoApDoAnAoGoGoDnAoFlXnFpFmGpDpDnApGpAnXnXpAnGpDoFoApApAmXnFpGoFmApAlAlGoGpFlGnAnGoGnGoGnGoFoAnXoGpXoAmDoFlAlGpFoAoGpFnDlGnAoDnFnFpGoAmGoGnAoDlAmFoAnFnGpGoFnXpApDpAoFmGoFnAoAmXpFmFoGpFoAlFpGmGnGoAmGoFmApAoApAoAoGlGmFpGoGpDoAmAlGlFmAoGmDpDnXpGoAlFnDmFpAnAoFoGoDlFnGlApAlGmGnGlDoDpGoFoFmDoDpGnGmDoFoGnFpGoAlAnAlGoAoAmAnAlDnFlGmDnXoFoAlFpGoXpFoAoFoAoApAoFnFoAoAoGoAnFnGoFmDlFlFoFlApDoAmFoGlAlAmGpGpGoFoAnFoDnAnXpXnGpFoXoXlAmGoGnFoAnAnDnFlAoDpGnFoAoFnGoGoGlFlDpAmGlGnXpDpGnGpAoAnGoGpDoGpFpGoFmGoAoFnGnFpFoDoFoAnFpFlXoAoFlFnAlFoApAoFnFmDoFmFmApAmGoFoAnFoGlGnGmAlAnAnDpAmFoAnFmGoGpFpFlDlGnFoApAnApAoFoFmXpGpDpAoGoGlDoFlXpGoXpFmGoAoAoAoFlGpAmAnFlFnFnApGnFoFpDnFpGoGnAlFmDnAnGnFmGmFoFnXoGpXoAmDoFlAoDpGpDnXoGoDoDlAnGmFpAlXlGoAlFnGnDoDpAoGnAoGoDlDoDoGoDlGmFpFmFlGpAnApGnGpDoFoAoGlGoAmAoGlAmAmDoAoGmAmFlGpGpGoAlGoDlDoApXpFpAnApGnXpAnFlAmAnAoAlDoDlGoFmGnDpAnGnGnGpXpAnDpFlGnGoFnFlGnGoAoAoDpGlAlApGpGnDpAmFmGmFlAoDoDpGlFoDpFlAmAnAoFpAnFnGoFmGpAmGnDpFpGmGnDlGoAoAoGnGoDlAoFnGpDoFmXoDnGnGoApGnDoDoDoFpDlDnFpGnGoFlGoAmFnAnAoDmFnXpDlFnFnGnApFoFmFpAoDpFoDlDnGnGoFlGnGoGlFnAmGnDpFmGlFoFmDoAlXnFoDnAlFpAmDoGnGnFlFoGoDlAmGnGoFoAlDoDnAoGpAmDoAnFoDoGnApFoFmGoGoDoApGnFlGlXpDnApFoAoGnApAnXpGlDoFmFpAoAoGnFlAnDmGoApDpGnGlAmAmAlAmAlXlDoAlXnFpDpGoDpGoAoDpApGnGlGmAmDmXpGmFnFoGlAnAoDlAnAmXoDlFlFpApFoDlAnDoGoFmGoDnFlFpAmDpGpAnGoAnGnDpApFoAoFpAnAlDpApGnAoFpFlGoDoAlAoAlAoGnGlAmAoDmFoFpAoGnGoDmDpApApGlDpDnAnFmeeGnFoAoAnDpAnApGnGlAoFoDpAnAmXmGoAoApGmFlFoDmDlDnFnAmGnGlFoGlFlApFoGlFoDmFpGmAoGpDoAmDnAnAmFmDlDnFpAnAoGoAoXpAmAoGoAlAnAoGoAnFoGoDoDmFoAnApDpGoDnFmDlDnDnFpAoAlAmFoFoDmAnFmAnDnAnGoApAnFoAmGoApGnFoApGmAlGoFmDmFoAlGoFlGmFoFoDpDlGlXoFlGmFoDoDlAoDpGoAoDoGoDmFlAoGmGlFmXoAoFoDlXlXpDoGlAoFlGnAoGnFlFoGnAmDmFmGnGlGoDmDlAnXpFmGoAnFlDpFoAoGlAnFoDmAoFpFlGnGoFnFoAoDoAnDnGoFpAoGmAlApAnApGlGnAnFlDpAnFnGpGoFpAoGnGnGpGoGpGnFpDlFmFpAoFmFoAoAoDoAnAlFoGpAnGpAnApGnAnAoGmGpFoGlGmFpFoAnGlAmXpFmFoDnDpFpDpFmGpAoDlAmDnGpFmAnAoAmGpGoAnFnFpDpDlGoFnAlFlGlFmDpDlFmGlAmAoGoGnDoDlAnAlAlAoFpDoAmGoDoAmFpGpGlGmAoAnXoDoGmDlAoGlAnFmAmAlApAlGoFnFnGnGnDmAoAoGoAnGoAoGpAnXnXpDpFpAmFoAmApGnXoGpXoAmDoFnDlFlAoAmFpAmGpFmGmDpGpFmDnDpAnApAoGnXpFpGnAlFoFlGoAnXnAnFpAnXpGoDlAmFnXoGoDmGlGoFlAmDnApDnGoGoGoDoAoAoGpAnAoGnDoAnAnAmXlAnAnDlGoAoFmAmAoAmDoFoDnGoAmXpGpFoAoFnFoAoAoAoAlGoDlGoFoGpFmAmDoAoXpAnDlAnApDoFlAmFoGoGnFmApAnDoGpDmAoDoDoAoFnFlAmAlAlAoFnGpDnAoFlApGnGoFlGpFmAoDmFnGlDnFmFmFmAoDoDmAoGoAnAlFpGmGoGpGoApFpAmAoDoGnFmGoAnXlAoGpAmAoAoGpDoAoFnDpAnGoApXpGnGnAnGoAlAmAmDlFoAoFnAlDlGnGmGpFoGpGnXpGlGpDoAoFoFpGoAoDlAmDnGpFmAnApAnAoAoDlDmGnAoGoDpAmFlFoGpAmFmDpDmAnFlDpFoFmAlDnDnFmAnGlDoDnDpFmGoAnGpAnApGnXpAlFnGlAlAmFmGoGnFnAoGoDoGnApGnAnFnAoFnAoApFmGoAnDlAnFoAnDmFoApAoFnAnFoXoDoAlAoDlDpAmAoGoAmXpFoFlDoAoDpDmGnGoAnAoAnApAoDpAoGlFoGoFlGmDnAnAmDnAoAnDmFoFlAmGoAlAoDoGlGoGoAnGnGoDpAnGnGnXpGoFnFoAlAlAoFmGoDoFmDpGpAnGoFnFmGnAnAnAlAoAlDoDpGnGnFnAoAnFoDlAnAlGoApDpGoAoDnGnAoAoDoAlFoGoDlAmGpFmAmFnFpGoAlXpDlFmGoDnFlAoGlFpAlGnGoFmDpGpDoApGmAlGoGoApGnFoFpDnXpDnXoGnFlDnFlDpGoAoDpDoGoDnAlDoAnAmAoDoAnDnGoDmAnFpAmAmGnFpAoAnXpDlFmGlGnFnGpAoDlDpGpGoDoGnAoAnDnFlGpFlAoFoAmDlDnGnAmDoFlDpGnXlAnGlApDpAlFnAoDpGnDpDoAnAlAmAoDnAmDoDoFmApGnGnAlAmGnAnAnGpGpGoDpAnAnGnGoGnFmAnGnAmDpFmAmDoGoDnAlAmAnFnDoFpDpGmDlAmGnGoDoGmDoAmDpDlAlAlGoFoDeeDpDnGpFoFmGoAnGmAlDnFmAmFpGmApGnFlAnGpAoDnApFoFmFnFpGoAlFnAnFoGoGlAmFoGlAnGpGpAmGnAmApXoGoGoAoFnGoGlDnDnGoAnGlAnFnAmDmXlGnApGpFlGnGoGlAlAoAoDmFlApFoFmFnGoAlAnFpGlAoGpGoGoGoGpApGoAoApDpAoGpAnGoDnGnGoFlGnGoGlGnAmApAmFpGlAoAmFoAmApAmFpGmFnAmAoAmDlDnDoFmDoAlFnXlApGoDmGpXlDoDoAoFpAnAoFlGnXpDlFmGoGnFpGoGpDpDoAmGnAmDlAnGpDoFoDoApDoAnAoGlAoGpGoAmXpFoFlDoDnDmGpFnFpXoAnXpApAmFmGoAnAoDpFoDoAmAoGoGnDoAmFlDpFoAoGlAnDmGmAnFpAnFmGoDnFlDmGpFnXpGoAlFlFmGoAnDpFoAlFoGpFmDoGpGmDnFnAoDoAmFpGnFoAnGoFmFoAoDlFnGlApAlGmFoGoFpAoFmAoAoAoAoXoDoGlDoXpDmFoAnXoXlAnGpFnGmAoFnAoGmFoXpDnAmGoGlDnFlGnAnAlAlGpGmFoDoFpGpAmGoAnDpGoGpDpAmFoFoGoAmGnDpGpGmDlFlGoDpFlAlFoGpAnAoFlFpGpFoAnAoDlAmDnGpFmGoAoAoGnDmGnXoDlGlGoAmAlGmFoAnXoAnApDpAoAoDpFlAlFoFnAoDoDmGlDlApGnFlGmFpDnFnGnFlDoAnGlGpFmApDnDnDnGnGmDnAnFnFlDpFlGoFoGoAnGnFoAlFpFnFoGpFlGoDnFlAoFmGoAnAmDnDlGlGoDpGpGnAnDmFlDoDnFmDmFoGnAlAnAoAoGpFoDnFpDpFoFmFlGmAlAoFnAoGpGoDnFmDnDoAnApAmAnAlAlAoGoDlAnAoAlDoAlAlGmDoGlDpAmDoDpAoFnXnDnGpGpGlDoXpAnXlGoAnFmFoGlGlDoDnDpGpDoFnAnGoAlGnGnApAmFmGoFoAnApDlFoAmDlDlGpDnDoGlGlAmDnFlGoAoAlDoDnGpFmAmDlApAoAoDnFmDoAnGoDlFnGlApAlGmFoAlFnFlDlFmDnGnXpDnAnGlFoDnAoFoDoAnDnFoDoAmGoFnFlFnGoGoFnAnDnGoGnGpDoFoFmGoAnDlAnFnGpXpAnFpApFlDpGpFlAoGmGoAnDpGnAoGoFmGmAnGpDoFoAoGlAlFoGlGpGnGoFnGoAoDoGnDlGoAoAnGlAlGnDoAmFmDoDoGoAoFpDlGnGoGpAnFoAoAlApAlFmDlAnXnAnGoAlGnAlFoGlGnFlDpDnFpDnFnAnFnGnAoFoXoAlAoDlDlAnGmFmXlXoAoAlGpFlAoDoAnGoFoFlDoXoDmAnFoAlApAoFnGmDpAoFpGpDoGoAoGnFlDnAoAmDlDnDoGpGnDnGoFoApGmAlGoFmDmFoAlFpGnFoAmFoGoDmFlFoFnAoAoDoFoXlGoApAoDnGnGoFlGnGpAnGlGnGmDlAnFpFlDpAmFmDoAmDlDnFmFmFnGoAoDnFpGoDmGpFnFpXoGpDpAlGnXoAoFlGpDlAnAlXlDoGoAnFoAoAoAmGlXlGpDpGmGlFlFoGpFoAoGnApFoFmFoGoDnAmAlAnAoFoAnAlAnDpApFlFlGlAmGnGmFlGnDlFmGnFlGnXnGoDoGmFlGlAnXoFoGnFlGoAlFnGoDlXoAlGpAnFoGoAnGnGoDoFlFoFpDpFoFoDnAoAlXoAnAoFoFoDnXoGnGlDlAmFoFoGpDneee";
        //It's already lower/uppercase pairs and we don't need to reverse transposition. But we do need to remove the "e"s.
        //Note: I am assuming the "e"s are meaningless and can be removed, but it may be worthwhile to look back again later.
        ct = ct.replaceAll("e", "").toLowerCase();

        System.out.println("Enter the number of maximum attempts I should make:\n");
        int maxAttempts = in.nextInt();

        //Making the first key.
        Map<String, Character> keyMap = getKeyMap();

        int attempt = 0;
        int bestAttempt = -1;
        String bestPT = "";
        double bestScore = -1.0;
        double bestCurrentScore = -1.0;
        Map<String, Character> bestKey = new HashMap<>();
        Map<String, Character> bestCurrentKey = new HashMap<>();
        boolean shouldTryAgain = false;
        Set<String> usedKeys = new HashSet<>();
        //tetragrams
        Tetragrams t = new Tetragrams();
        Map<String, Double> tetragrams = t.getTetragrams();
        //System.out.println(tetragrams);

        while(attempt < maxAttempts) {
            if(shouldTryAgain) {
                //Struggling to find a new key from this variation, start again with a new random key.
                shouldTryAgain = false;
                bestCurrentScore = -1.0;
                keyMap = getKeyMap();
            } else {
                //Get next key normally.
                shouldTryAgain = nextKey(keyMap, usedKeys);
            }
            String plaintext = decipher(ct, keyMap);
            double score = getScore(plaintext, tetragrams);
            if(attempt % 1000 == 0) {
                System.out.println(attempt + " " + score);
            }
            //Higher score is better
            if(score >= bestCurrentScore) {
                bestCurrentScore = score;
                bestCurrentKey.clear();
                bestCurrentKey.putAll(keyMap);
                System.out.println("\n\n");
                System.out.println(plaintext);
                System.out.println(score);
                System.out.println(keyMap.toString());
                System.out.println("\n\n");
                if(score >= bestScore) {
                    bestScore = score;
                    bestKey.clear();
                    bestKey.putAll(keyMap);
                    bestPT = plaintext;
                    bestAttempt = attempt;
                }
            } else {
                //Didn't get a better score. Reset back to the current best key so we can find a new one off the current best.
                keyMap.clear();
                keyMap.putAll(bestCurrentKey);
            }

            attempt++;
        }

        System.out.println("Best try on attempt number " + bestAttempt + " scored " + bestScore + ".");
        System.out.println("Key: " + bestKey.toString());
        System.out.println("Plaintext:");
        System.out.println(bestPT);
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

    /**
     * Creates a new randomized key map.
     * @return a random Map of [ct pair] => [pt char]
     */
    public static Map<String, Character> getKeyMap() {
        //Without j since it's mixed in with i.
        List<Character> alphabet = Arrays.asList('a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        //Possible row/col combos. lmnop . adfgx
        List<String> ctCombos = Arrays.asList("la","ld","lf","lg","lx","ma","md","mf","mg","mx","na","nd","nf","ng","nx","oa","od","of","og","ox","pa","pd","pf","pg","px");

        //Shuffle the alphabet.
        Collections.shuffle(alphabet, new Random());

        Map<String, Character> keyMap = new HashMap<>();
        for(int i = 0; i < ctCombos.size(); i++) {
            keyMap.put(ctCombos.get(i), alphabet.get(i));
        }

        return keyMap;
    }

    /**
     * Find the next key given the current key and the set of used keys. If a new key can't be found in a timely manner,
     * return true to indicate that we should start over with a brand new random key.
     * @param keyMap - the current key which should be used to find the next key with small changes
     * @param usedKeys - set of keys that have been tried already
     * @return whether or not we should start over with a new key (true if couldn't find an unused key from current key)
     */
    public static boolean nextKey(Map<String, Character> keyMap, Set<String> usedKeys) {
        Map<String, Character> keyCopy = new HashMap<>(keyMap);
        int tries = 0;

        //Try to find a new key only a certain number of times before giving up.
        while(usedKeys.contains(keyCopy.toString()) && tries < 100000) {
            keyCopy = new HashMap<>(keyMap);
            changeKey(keyCopy);
            tries++;
        }

        //Either start over with new random key or set the new key and add it to used keys.
        if(tries >= 100000) {
            System.out.println("Resetting local best.");
            return true;
        } else {
            keyMap.clear();
            keyMap.putAll(keyCopy);
            usedKeys.add(keyMap.toString());
            return false;
        }
    }

    /**
     * Makes a small change to the key map by swapping values for two keys.
     * @updates keyMap - the map that will be changed
     */
    public static void changeKey(Map<String, Character> keyMap) {
        Random rand = new Random();
        List<String> keys = new ArrayList<>(keyMap.keySet());

        //Get random keys to swap.
        String k1 = keys.get(rand.nextInt(keys.size()));
        String k2 = keys.get(rand.nextInt(keys.size()));

        //Swap.
        Character c1 = keyMap.get(k1);
        keyMap.replace(k1, keyMap.get(k2));
        keyMap.replace(k2, c1);
    }

    /**
     * Convert the ciphertext to plaintext given a key map of ct pairs to pt chars.
     * @param ct - the ciphertext to convert
     * @param keyMap - the key map to convert ct pairs to pt characters
     * @return the plaintext
     */
    public static String decipher(String ct, Map<String, Character> keyMap) {
        StringBuilder pt = new StringBuilder();

        //Get each pair in the ct and find the corresponding pt character from the key map. Add that to the pt.
        for(int i = 0; i < ct.length(); i += 2) {
            pt.append(keyMap.get(ct.substring(i, i + 2)));
        }

        return pt.toString();
    }

    /**
     * Score a plaintext using English tetragram frequencies.
     * @param pt - the plaintext to score
     * @return the cumulated score
     */
    public static Double getScore(String pt, Map<String, Double> tetragrams) {
        Double score = 0.0;

        //Go through the
        for(int i = 0; i < pt.length() - 3; i++) {
            String quartet = pt.substring(i, i + 4);
            score += (tetragrams.containsKey(quartet)) ? tetragrams.get(quartet) : 1.0;
        }

        return score;
    }
}

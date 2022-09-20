/**

There is a dictionary containing words from an alien language for which we don’t know the ordering of the letters. Write a method to find the correct order of the letters in the alien language. It is given that the input is a valid dictionary and there exists an ordering among its letters.

Example 1:

Input: Words: ["ba", "bc", "ac", "cab"]
Output: bac
Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
from the given words we can conclude the following ordering among its characters:

1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
2. From "bc" and "ac", we can conclude that 'b' comes before 'a'

From the above two points, we can conclude that the correct character order is: "bac"

Example 2:

Input: Words: ["cab", "aaa", "aab"]
Output: cab
Explanation: From the given words we can conclude the following ordering among its characters:

1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'

From the above two points, we can conclude that the correct character order is: "cab"

Example 3:

Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
Output: ywxz
Explanation: From the given words we can conclude the following ordering among its characters:

1. From "ywx" and "wz", we can conclude that 'y' comes before 'w'.
2. From "wz" and "xww", we can conclude that 'w' comes before 'x'.
3. From "xww" and "xz", we can conclude that 'w' comes before 'z'
4. From "xz" and "zyy", we can conclude that 'x' comes before 'z'
5. From "zyy" and "zwz", we can conclude that 'y' comes before 'w'

From the above five points, we can conclude that the correct character order is: "ywxz"

Solution#

Since the given words are sorted lexicographically by the rules of the alien language, we can always compare two adjacent words to determine the ordering of the characters. Take Example-1 above: [“ba”, “bc”, “ac”, “cab”]

    Take the first two words “ba” and “bc”. Starting from the beginning of the words, find the first character that is different in both words: it would be ‘a’ from “ba” and ‘c’ from “bc”. Because of the sorted order of words (i.e. the dictionary!), we can conclude that ‘a’ comes before ‘c’ in the alien language.
    Similarly, from “bc” and “ac”, we can conclude that ‘b’ comes before ‘a’.

These two points tell us that we are actually asked to find the topological ordering of the characters, and that the ordering rules should be inferred from adjacent words from the alien dictionary.

This makes the current problem similar to Tasks Scheduling Order, the only difference being that we need to build the graph of the characters by comparing adjacent words first, and then perform the topological sort for the graph to determine the order of the characters.

**/

import java.util.*;
class Program {
        public static String findOrder(String[] words) {

            //Step 1: Initialize maps

            HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
            HashMap<Character, Integer> degrees = new HashMap<>();

            for(int i =0; i < words.length; i++){
                String currentWord = words[i];
                for(int j = 0; j < currentWord.length(); j++){
                    graph.put(currentWord.charAt(j), new ArrayList<Character>());
                    degrees.put(currentWord.charAt(j), 0);
                }
            }

            //Step 2: build graph and populate degrees hashmap
            for(int i = 0; i < words.length - 1; i++){
                String word1 = words[i];
                String word2 = words[i+1];

                for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                    char parent = word1.charAt(j);
                    char child = word2.charAt(j);

                    if(parent != child){
                        graph.get(parent).add(child);
                        degrees.put(child, degrees.get(child) + 1);
                        break;
                    }
                }
            }

            //for every child with a degree of zero, aka the source node, add to queue for processing

            Queue<Character> charQueue = new LinkedList<>();

            for(Map.Entry<Character, Integer> entry: degrees.entrySet()){

                if(entry.getValue() == 0){
                    charQueue.add(entry.getKey());
                }
            }

            //Sort algo
            StringBuilder sb = new StringBuilder();

            while(!charQueue.isEmpty()){
                Character current = charQueue.poll();
                sb.append(current);

                List<Character> list = graph.get(current);

                for(char chr: list){

                    degrees.put(chr, degrees.get(chr) - 1);
                    if(degrees.get(chr) == 0){
                        charQueue.add(chr);
                    }
                }
            }

            String result = sb.toString();

            if(result.length() != degrees.size()){
                return "";
            }
            
            return result;
        }

        public static void main(String[] args) {
            String result = findOrder(new String[] { "ba", "bc", "ac", "cab" });
            System.out.println("Character order: " + result);

            result = findOrder(new String[] { "cab", "aaa", "aab" });
            System.out.println("Character order: " + result);

            result = findOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
            System.out.println("Character order: " + result);
        }
    }






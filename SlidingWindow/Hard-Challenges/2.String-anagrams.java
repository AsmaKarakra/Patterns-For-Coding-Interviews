


import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> result = new ArrayList<Integer>();
    
    HashMap<Character, Integer> map = new HashMap<>(); 

    int windowStart = 0; 
    int windowEnd = 0;
    int windowSize = pattern.length(); 

    for(char chr: pattern.toCharArray()){
      map.put(chr, map.getOrDefault(chr, 0) +1);
    }

    HashMap<Character, Integer> mapCopy =  new HashMap<>(map);

    // ppqp "pq" output = [1,2]

    for(windowEnd = 0; windowEnd < str.length(); windowEnd++){
      char right = str.charAt(windowEnd); 

      if(map.containsKey(right)){
        int val = map.get(right);

        if(val <= 1){
          map.remove(right);
        }
        else{
          map.put(right, val -1);
        }

        if(map.size() == 0){
          result.add(windowStart);
          map.put((str.charAt(windowStart)), 1); 
          windowStart++;
        }
      }
      else{
      map = new HashMap<>(mapCopy);
      windowStart = windowEnd + 1; 
      }
    }

      return result;
  }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args){
        String a = "Hello";
        String b= "Helpo";
        System.out.println("is A and B anagrams: "+ isAnagram(a,b) );
    }
    static boolean isAnagram(String a, String b) {


//        if(a.length()!= b.length()){return false;}
//        a = a.toLowerCase();
//        b = b.toLowerCase();
//        // Complete the function
//        char[] ar = a.toCharArray();
//        char[] br = b.toCharArray();
//
//        Arrays.sort(ar);
//        Arrays.sort(br);
//
//        return Arrays.equals(ar,br);

        Map<Character,Integer> map = new HashMap<>();
        for(char c : a.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c : b.toCharArray()){
            map.put(c,map.getOrDefault(c,0)-1);
        }
//        for(Map.Entry<Character,Integer> entry : map.entrySet()){
//            if(entry.getValue() != 0)
//                return false;
//        }
        for(char c : map.keySet()){
            if(map.get(c)!=0){
                return false;
            }
        }
        return true;



    }
}

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String[] args){
        String s= "PAYPALISHIRING";
        int numRows= 4;
        System.out.println(Solution.convert(s, numRows));
        assert(Solution.convert(s, numRows).equals("PINALSIGYAHRPI"));
    }

    class Solution{
        public static String convert(String s, int numRows) {
            /*
            1) Create an array of n strings, arr[n]
            2) Initialize direction as "down" and row as 0. The
               direction indicates whether we need to move up or
               down in rows.
            3) Traverse the input string, do following for every
               character.
               a) Append current character to string of current row.
               b) If row number is n-1, then change direction to 'up'
               c) If row number is 0, then change direction to 'down'
               d) If direction is 'down', do row++.  Else do row--.
            4) One by one print all strings of arr[].
             */
            String[] arr= new String[numRows];

            Arrays.fill(arr, "");
            int row = 0;
            boolean down = true;
            int n = s.length();

            for (int i = 0; i <n ; i++) {
                arr[row]+=s.charAt(i);
                if(row == numRows-1){
                    down = false;
                } else if (row== 0 ) {
                    down = true;
                }
                if(down == true){row++;} else if (down == false) {row--;}

            }

            String result ="";
            for (int i = 0; i < numRows ; i++) {
                result = result + String.valueOf(arr[i]);
            }


            return result;

        }
    }

}

import java.util.HashMap;
import java.util.Map;


public class RomanToInteger {


    private static final Map<Character, Integer> romanMap = new HashMap<>();
    
    static{
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }


    public int romanToInt(String s){
        int sum= 0;
        int prevValue =0;

        for(int i =s.length()-1; i>=0; i--){
            int value = romanMap.get(s.charAt(i));

            if(value >=prevValue){
                sum+= value;
            }else{
                sum -=value;
            }

            prevValue =value;
        }
        return sum;
    }


    public static void main(String[] args){
        RomanToInteger converter = new RomanToInteger();

        System.out.println("III = " + converter.romanToInt("III"));// Output: 3
        System.out.println("LVIII = " + converter.romanToInt("LVIII"));  // Output: 58
        System.out.println("MCMXCIV = " + converter.romanToInt("MCMXCIV"));  // Output: 1994
    }

}




import java.util.HashMap;
import java.util.Map;

class FindValue {

    public static void main(String[] args) {

        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {

            if (b == 0x90) {

                System.out.print("We found it");

             }

        }
        System.out.println(Byte.MAX_VALUE);
        System.out.println(0x90);
        
        Map<Integer, String> hashMap = new HashMap<Integer, String>(5);
        hashMap.put(1, "apple");
        hashMap.put(2, null);
        hashMap.put(new Integer(3), "peach");
        hashMap.put(3, "orange");
        hashMap.put(4, "peach");

        for (String v : hashMap.values()) {

            if ("orange".equals(v)) {
                hashMap.put(5, "banana");
            }    
        }
        System.out.println(hashMap.get(5));
        

    }

}
package Easy;

public class Challenge605_CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            // Check if a flower can be planted at position i
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) && 
                (i == length - 1 || flowerbed[i + 1] == 0)) {
                
                // Plant the flower
                flowerbed[i] = 1;
                n--; // Reduce the number of flowers to plant

                // Early exit if we've planted all required flowers
                if (n == 0) {
                    return true;
                }
            }
        }

        // If there are still flowers left to plant, return false
        return n <= 0;
    }


    
    public static void main(String[] args) {
        // Test cases
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)); // Output: true
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)); // Output: false
        System.out.println(canPlaceFlowers(new int[]{0, 0, 1, 0, 0, 0}, 2)); // Output: true
    }
}

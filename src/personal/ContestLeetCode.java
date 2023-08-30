package personal;

public class ContestLeetCode {

    public static void main(String[] args) {
        System.out.println(
                countBeautifulPairs(new int[]{2, 5, 1, 4})
        );
        System.out.println(
                countBeautifulPairs(new int[]{11,21,12})
        );
        System.out.println(
                countBeautifulPairs(new int[]{31,25,72,79,74})
        );
        System.out.println(
                countBeautifulPairs(new int[]{84,91,18,59,27,9,81,33,17,58})
        );
    }

    public static int countBeautifulPairs(int[] nums) {
        int sum=0, x=0, y=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= 10) {
                x = String.valueOf(nums[i]).charAt(0) - 48;
            }
            else x=nums[i];

            for (int j=i+1; j<nums.length; j++) {
                y = nums[j] % 10;

                if (gcd(x, y) == 1) sum++;
            }
        }
        return sum;
    }

    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static void countSubArray() {
        // Input: nums = [0,1,0,0,1]
        // when array contains 0 element, count=0
        // when array contains 1 element, count = 1 if element is 1
    }
}

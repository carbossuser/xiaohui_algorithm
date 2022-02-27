package chapter5.part5;

/**
 * 申晓创建于2022年2月27日.
 * 题目：实现一个方法，来判断一个正整数是否是2的整数次幂（如16是2的4次方，返回true；
 * 18不是2的整数次幂，则返回false）。要求性能尽可能高。
 */
public class PowerOf2 {
    //暴力求解法。如果目标整数的大小是n,则此方法的时间复杂度是O(logn).
    public static boolean isPowerOf2(int num) {
        int temp = 1;
        while(temp<=num){
            if(temp == num){
                return true;
            }
            temp = temp*2;
        }
        return false;
    }
    //提高性能，把之前乘以2的操作改为向左移动，位移的性能比乘法高得多。但本质没有变。时间复杂度为O(logn).
    public static boolean isPowerOf2V2(int num) {
        int temp = 1;
        while(temp<=num){
            if(temp == num){
                return true;
            }
            temp = temp<<1;
        }
        return false;
    }
   //利用位运算&的性能。时间复杂度为O(1)。
    public static boolean isPowerOf2V3(int num) {
        return (num&num-1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2V3(32));
        System.out.println(isPowerOf2V3(19));
    }
}

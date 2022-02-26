package chapter5.part4;

/**
 * 申晓创建于2022年2月26日.
 */
public class GreatestCommonDivisor {
    //暴力求解法
    public static int getGreatestCommonDivisor(int a, int b){
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        if(big%small == 0){
            return small;
        }
        for(int i= small/2; i>1; i--){
            if(small%i==0 && big%i==0){
                return i;
            }
        }
        return  1;
    }
    //辗转相除法
    public static int getGreatestCommonDivisorV2(int a, int b){
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        if(big%small == 0){
            return small;
        }
        return getGreatestCommonDivisorV2(big%small, small);
    }
    //更相减损术
    public static int getGreatestCommonDivisorV3(int a, int b){
        if(a == b){
            return a;
        }
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        return getGreatestCommonDivisorV3(big - small, small);
    }
    //更相减损术与移位相的结合
    public static int gcd(int a, int b){
        if(a == b){
            return a;
        }
        if((a&1)==0 && (b&1)==0){
            return gcd(a >> 1, b >> 1)<<1;
        } else if((a&1)==0 && (b&1)!=0){
            return gcd(a >> 1, b);
        } else if((a&1)!=0 && (b&1)==0){
            return gcd(a, b >> 1);
        } else {
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return gcd(big - small, small);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(25, 5));
        System.out.println(gcd(100, 80));
        System.out.println(gcd(27, 14));
    }
}

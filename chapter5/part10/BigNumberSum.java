/**
 *申晓创建于2022年3月5日.
 */
public class BigNumberSum {

    /**
     * 大整数求和
     * @param bigNumberA  大整数A
     * @param bigNumberB  大整数B
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        //1.把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();
        //A ? B : C .如果A条件满足就执行B,否则执行C
        int[] arrayA = new int[maxLength+1];  //定义出A数组的长度
        for(int i=0; i< bigNumberA.length(); i++){
            arrayA[i] = bigNumberA.charAt(bigNumberA.length()-1-i) - '0';  //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
        }
        int[] arrayB = new int[maxLength+1];  //定义出B数组的长度
        for(int i=0; i< bigNumberB.length(); i++){
            arrayB[i] = bigNumberB.charAt(bigNumberB.length()-1-i) - '0';
        }
        //如何理解-'0'，http://cn.voidcc.com/question/p-fnnbzlgk-zn.html
        //string.charAt(i)返回一个字符，string.charAt(i)-'0'将返回实际的整数值
        //2.构建result数组，数组长度等于较大整数位数+1
        int[] result = new int[maxLength+1];
        //3.遍历数组，按位相加
        for(int i=0; i<result.length; i++){
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            //判断是否进位
            if(temp >= 10){
                temp = temp-10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }
        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        //StringBuilder类也代表可变字符串对象。实际上，StringBuilder和StringBuffer基本相似，
        // 两个类的构造器和方法也基本相同。不同的是：StringBuffer是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。
        // https://blog.csdn.net/csxypr/article/details/92378336
        //是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if(!findFirst){
                if(result[i] == 0){
                    continue;//返回到起点，进行下一个循环
                }
                findFirst = true;
            }
            sb.append(result[i]); //append()是往动态字符串数组添加
        }
        return sb.toString();
        //toString() 方法可把一个 Number 对象转换为一个字符串，并返回结果。
    }

    public static void main(String[] args) {
        System.out.println(bigNumberSum("426709752318", "95481253129"));
    }
}

package chapter4.part3;

/**
 * Created by 申晓 on 2022/2/17.
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSortWithStack
{
    public static void quickSort(int[] arr, int startIndex, int endIndex)
    {
    //用一个集合栈来代替递归的函数栈
    Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
    //Map<String, Integer>代表了一个集合，其中String是键，Integer是值
    //整个数列的起止下标，以哈希的形式入栈
    Map rootParam = new HashMap();
    rootParam.put("startIndex", startIndex);  //put（）函数，V.put(nums[i], i)
        // java中Map集合中的put函数是有key和value值的。和get函数进行区分。
    rootParam.put("endIndex", endIndex);
    quickSortStack.push(rootParam);  //push函数代表入栈，入栈是先入后出

    //循环结束的条件：栈为空时；
    while(!quickSortStack.isEmpty())
    {
        //栈顶元素出栈，得到起始下标
        Map<String, Integer> param = quickSortStack.pop(); //pop代表出栈
        //得到基准元素位置
        int pivotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));
        //根据基准元素分成两部分，把每一部分的起止下标入栈
        //pivotIndex,startIndex,endIndex就是只对应元素的下标，即从0开始：0, 1, 2, 3, 4, 5 ......

        if(param.get("startIndex") < pivotIndex - 1){
            Map<String, Integer> leftparam = new HashMap<String, Integer>();
            leftparam.put("startIndex", param.get("startIndex"));
            leftparam.put("endIndex", pivotIndex-1);
            //我理解“endIndex”和pivotIndex对应的是一个值，即两者相同。相当于一个映射。
            quickSortStack.push(leftparam);
        }
        //这个地方不是很理解，需要答疑
        if(pivotIndex + 1 < param.get("endIndex")){
            Map<String, Integer> rightParam = new HashMap<String, Integer>();
            rightParam.put("startIndex", pivotIndex +1 );
            rightParam.put("endIndex", param.get("endIndex"));
            quickSortStack.push(rightParam);
        }

    }
}


/**
 * 分治（单边循环法）
 * @param arr  待交换的数组
 * @param startIndex   起始下标
 * @param endIndex   结束下标
 */
private static int partition(int[] arr, int startIndex, int endIndex)
{
    //取第一个位置（也可以选择随机位置）的元素作为基准元素
    int pivot = arr[startIndex];
    int mark = startIndex;
    for(int i=startIndex+1; i<=endIndex; i++){
        if(arr[i] < pivot){
            mark++;
            int p = arr[mark];
            arr[mark] = arr[i];
            arr[i] = p;
        }
    }
    arr[startIndex] = arr[mark];
    arr[mark] = pivot;
    return mark;
}

public static void main(String[] args){
    int[] arr = new int[]{4,7,6,5,3,2,8,1};
    quickSort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
}

}

package chapter4.part3;

/**
 * Created by shenxiao on 2022/2/17.
 *快速排序-双边循环法和单边循环法
 *快排的思想是每趟排序确定一个基准值的位置，并使得该值左边的值都小于它，右边的值都大于它，
 *再对左右两个子数组进行快排的递归调用，直至所有数字都放到了对应的位置上，排序结束。
 */

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);  //partition函数
        // 根据基准元素，分成两部分递归排序
        quickSort(arr, startIndex, pivotIndex - 1);  //递归左边的子数组
        quickSort(arr, pivotIndex + 1, endIndex);  //递归右边的子数组
    }

    /**
     * 分治（双边循环法）
     * @param arr     待交换的数组
     * @param startIndex    起始下标
     * @param endIndex    结束下标
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while( left != right) {
            //控制right指针比较并左移
            //从right指针开始，让指针所指向的元素和基准元素作比较。如果大于或等于pivot，则指针向左移动；
            //如果小于pivot，则right指针停止移动，切换到left指针
            while(left<right && arr[right] > pivot){
                right--;
            }
            //控制left指针比较并右移
            //轮到left指针行动，让指针所指向的元素和基准元素比较。如果小于或等于pivot，则指针向右移动；
            //如果大于pivot，则left指针停止移动。然后让left和right所指向的数进行交换。
            while( left<right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指向的元素
            if(left<right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot和指针重合点交换
        arr[startIndex] = arr[left];  //起始位置变为left指针所指的值
        arr[left] = pivot;  //left指针指位置的数变为pivot

        return left;
    }

  
  /**
     * 分治（单边循环法）
     * @param arr     待交换的数组
     * @param startIndex    起始下标
     * @param endIndex    结束下标
     */
    private static int partitionV2(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素（也可以选择随机位置）
        int pivot = arr[startIndex];
        int mark = startIndex;
        //从基准元素的下一个位置开始遍历数组。如果遍历到的元素大于基准元素，就继续往后遍历
        
        //如果遍历的元素小于基准元素，则需要做两件事：第一，把mark指针右移1位，因为小于pivot
        //的区域边界增大了1；第二，让最新遍历到的元素和mark指针所在位置的元素交换位置，因为
        //最新遍历的元素归属预小于pivot的区域。
        for(int i=startIndex+1; i<=endIndex; i++){
            if(arr[i]<pivot){
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {4,4,6,5,3,2,8,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

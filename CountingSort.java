import java.util.Arrays;


/**
 * 计数排序
 * @author asus
 *
 */
public class CountingSort implements IArraySort {
	/**
	 * 计数排序,是一种适合于最大值和最小值的差值不是很大的排序。
	*基本思想:把数组元素作为数组的下标，然后用一个临时数组统计该元素
	*出现的次数，例如 temp[i] = m, 表示元素 i 一共出现了 m 次。最后再把
	*临时数组统计的数据从小到大汇总起来，此时汇总起来是数据是有序的。
	 */
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//拷贝arr数组,不改变原参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		//获取数组中的最大值
		int maxValue = getMaxValue(arr);
		//返回计数排序的结果
		return countingSort(arr, maxValue);
	}
	private int[] countingSort(int[] arr, int maxValue) {
		int bucketLen = maxValue + 1;
		//创建一个新数组,数组的长度为要排序的数组的最大值,其下标对应要排序的数组中的元素
		int[] bucket = new int[bucketLen];
		//将要排序的数组中的元素存入新建数组对应的下标,值为该元素出现的次数
		for(int value : arr) {
			bucket[value]++;
		}
		//根据新数组的下标即存储的内容,完成排序过程
		int sortedIndex = 0;
		for(int i = 0; i < bucketLen; i++) {
			while(bucket[i] > 0) {
				arr[sortedIndex++] = i;
				bucket[i]--;
			}
		}
		return arr;
	}
	/**
	 * 获取数组中的最大值
	 * @param arr
	 * @return
	 */
	private int getMaxValue(int[] arr) {
		int maxValue = arr[0];
		for(int value : arr) {
			if(maxValue < value) {
				maxValue = value;
			}
		}
		return maxValue;
	}
}

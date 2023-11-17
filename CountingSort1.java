import java.util.Arrays;


/**
 * 桶排序优化
 * @author asus
 *
 */
public class CountingSort1  implements IArraySort {
	/**
	 * 桶排序的优化:上面的代码中，我们是根据 max 的大小来创建对应大小的数组，假如原数组只有10个元素，
	 * 并且最小值为 min = 10000，最大值为 max = 10005，那我们创建 10005 + 1 大小的数组不是很吃亏，最大值
	 * 与最小值的差值为 5，所以我们创建大小为6的临时数组就可以了。
	* 也就是说，我们创建的临时数组大小 (max - min + 1)就可以了，然后在把 min作为偏移量。优化之后的代码如下所示:
	 */
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//拷贝arr数组,不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		//获取数组的最大值
		int maxValue = getMaxValue(arr);
		//获取数组的最小值
		int minValue = getMinValue(arr);
		return countingSort(arr, maxValue, minValue);
	}
	private int[] countingSort(int[] arr, int maxValue, int minValue) {
		int bucketLen = maxValue - minValue + 1;
		//创建一个长度为最大值与最小值的差值的数组
		int[] bucket = new int[bucketLen];
		//遍历要排序的数组将要排序的数组中的元素对最小值的偏移量与新数组的下标对应,
		//元素出现的次数为新数组对应下标的内容
		for(int i = 0; i < arr.length; i++) {
			bucket[arr[i] - minValue]++;
		}
		//根据新数组下标即元素值实现原数组的排序过程
		int sortedLen = 0;
		for(int j = 0; j < bucketLen; j++) {
			while(bucket[j] > 0) {
				arr[sortedLen++] = j + minValue;
				bucket[j]--;
			}
		}
		return arr;
	}
	/**
	 * 获取数组的最大值
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
	/**
	 * 获取数组中的最小值
	 * @param arr
	 * @return
	 */
	private int getMinValue(int[] arr) {
		int minValue = arr[0];
		for(int value :  arr) {
			if(minValue > value) {
				minValue = value;
			}
		}
		return minValue;
	}
}
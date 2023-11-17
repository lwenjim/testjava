import java.util.Arrays;


/**
 * 基数排序
 * @author asus
 *
 */
public class RadixSort implements IArraySort {
	/**
	 * 基数排序,先计算绝对值最大的数的位数,创建20个桶,从最低位开始进行最大位数次
	 * 排序,每次排序时将元素放入对应的桶中
	 */
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//拷贝数组arr,不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		//获取待排序数组的最大值有多少位数
		int maxDigit = getMaxDigit(arr);
		//返回基数排序的结果
		return radixSort(arr, maxDigit);
	}
	/**
	 * 获取待排序数组中的绝对值最大的数的位数
	 * @param arr
	 * @return
	 */
	private int getMaxDigit(int[] arr) {
		int maxValue = getMaxValue(arr);
		return getNumLength(maxValue);
	}
	/**
	 * 获取数组中的最大值
	 * @param arr
	 * @return
	 */
	private int getMaxValue(int[] arr) {
		int maxValue = Math.abs(arr[0]);
		for(int value : arr) {
			if(maxValue < Math.abs(value)) {
				maxValue = Math.abs(value);
			}
		}
		return maxValue;
	}
	/**
	 * 获取元素的位数
	 * @param num
	 * @return
	 */
	private int getNumLength(long num) {
		if(num == 0) {
			return 1;
		}
		int length = 0;
		for(long tmp = num; tmp != 0; tmp /= 10) {
			length++;
		}
		return length;
	}
	/**
	 * 基数排序
	 * @param arr
	 * @param maxDigit
	 * @return
	 */
	private int[] radixSort(int[] arr, int maxDigit) {
		int mod = 10;
		int dev = 1;
		for(int i = 1; i <= maxDigit; i++, mod *= 10, dev *= 10) {
			//考虑负数,其中[0-9]对应负数,[10-19]对应正数
			int[][] buckets = new int[20][0];
			for(int j = 0; j < arr.length; j ++) {
				int index = ((arr[j] % mod) / dev) + 10;
				buckets[index] = arrAppend(buckets[index], arr[j]);
			}
			int arrIndex = 0;
			for(int[] bucket : buckets) {
				//该桶为空
				if(bucket.length <= 0) {
					continue;
				}
				//将该桶中的元素放入结果数组中
				for(int value : bucket) {
					arr[arrIndex++] = value;
				}
			}
		}
		
		return arr;
	}
	/**
	 * 自动将桶的大小扩充1后,将元素添加进对应的桶中
	 * @param arr
	 * @param valuee
	 * @return
	 */
	private int[] arrAppend(int[] arr, int value) {
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = value;
		return arr;
	}
}
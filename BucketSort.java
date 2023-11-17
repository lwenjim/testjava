import java.util.Arrays;


/**
 * 桶排序
 * @author asus
 *
 */
public class BucketSort implements IArraySort {
	//创建插入排序对象
	private static final InsertSort insertSort = new InsertSort();
	/**
	 * 桶排序是对计数排序的一种升级,因为不一定所有的元素都是整数,都可以
	 * 与其下标一一对应,并且元素可能比较分散,就可以用桶排序来代替计数排序.
	 * 创建等间距的桶,将待排序元素放入对应的桶中,再将每个桶内部的元素进行
	 * 插入排序,最后将桶中的元素依次放入结果数组
	 */
	
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//拷贝数组arr,不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		return bucketSort(arr, 5);
	}
	/**
	 * 
	 * @param arr
	 * @param bucketSize 每个桶数据的范围
	 * @return
	 * @throws Exception 
	 */
	private int[] bucketSort(int[] arr, int bucketSize) throws Exception {
		if(arr.length == 0) {
			return arr;
		}
		int minValue = arr[0];
		int maxValue = arr[0];
		//找到数组中的最大值和最小值
		for(int value : arr) {
			if(value < minValue) {
				minValue = value;
			}else if(value > maxValue) {
				maxValue = value;
			}
		}
		//计算需要的桶的数量
		int bucketCount = (int)Math.floor((maxValue - minValue) / bucketSize) + 1;
		//创建需要的桶
		int[][] buckets = new int[bucketCount][0];
		//将待排序数组的每一个元素添加到对应的桶中
		for(int i = 0; i < arr.length; i++) {
			int index = (int)Math.floor((arr[i] - minValue) / bucketSize);
			//buckets[index]对应的是该元素所对应的桶,是一个一维数组
			buckets[index] = arrAppend(buckets[index], arr[i]);
		}
		int arrIndex = 0;
		//将每个桶中的元素排序并添加到结果数组中
		for(int[] bucket : buckets) {
			//说明该桶是一个空桶
			if(bucket.length <= 0) {
				continue;
			}
			//对每个桶内部的元素进行插入排序
			bucket = insertSort.sort(bucket);
			//遍历排序好的数组,将元素添加到结果数组中
			for(int value : bucket) {
				arr[arrIndex++] = value;
			}
		}
		return arr;
	}
	/**
	 * 每添加一个元素前,先将桶扩容1
	 * @param arr
	 * @param value
	 * @return
	 */
	private int[] arrAppend(int[] arr, int value) {
		arr = Arrays.copyOf(arr, arr.length + 1);
		//将该元素添加到桶的最后一个位置
		arr[arr.length - 1] = value;
		return arr;
	}
}

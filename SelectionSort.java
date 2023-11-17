import java.util.Arrays;
/**
 * 选择排序
 */

public class SelectionSort implements IArraySort {
	/**
	 * 选择排序,将未排序数组分为左右两区,左边为已排序区,右边为未排序区
	 * 假设未排序区的第一个元素为未排序部分的最小值,将此值与未排序区所
	 * 有值进行比较
	 */
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//对arr进行拷贝,不改变原参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		//总共需要N-1趟比较
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					//说明此时min中记录的值并非最小值,记录新的最小值下标
					min = j;
				}
			}
			//此时min所记录的值便是本趟循环的最小值
			if(i != min) {
				//说明i记录的不是最小值,交换位置
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
		return arr;
	}

}
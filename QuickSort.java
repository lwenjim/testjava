import java.util.Arrays;

/**
 * 快速排序采用了分而治之的思想,用递归来实现
	 * 主要有三个重要的步骤:分,治
	 * 分:即分割,不断地找到基准点,将无序数组以基准点分割成左右分区,
	 * 		基准点处于有序状态,左分区的值都小于基准点,右分区的
	 * 		值都大于基准点
	 * 治:只需不断地分割,每分割一次,就有一个基准点处于有序状态,
	 * 		直到每个分组只有一个元素,则所有的元素都处于有序状态
 * @author asus
 *
 */
public class QuickSort implements IArraySort {
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//对arr进行拷贝,不改变原参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		//返回快速排序的结果
		return quickSort(arr, 0, arr.length - 1);
	}
	//对无序数组进行快速排序
	private int[] quickSort(int[]arr, int left, int right) {
		if(left < right) {
			//如果left < right,说明排序还没有完成,递归的对左右分区进行快速排序
			//先找到分区的基准点,该点处于有序状态
			int partitionIndex = partition1(arr, left, right);
			//对左右分区递归的进行快速排序
			quickSort(arr, left, partitionIndex -1);
			quickSort(arr, partitionIndex + 1, right);
		}
		return arr;
	}
	/**
	 * 分割操作方法一:单向调整
	 * 缺点:该方法可能会对一个元素进行多次无效的调整,因为i和index可能对应同一个元素
	 * 				或者对一个元素进行多次重复交换
	 * 该方法用于找到分区的基准,该基准处于有序状态,基准左侧的值都小与基准值,
	 * 基准右侧的值都大于基准值
	 * @param arr
	 * @param left
	 * @param right
	 * @return 返回基准值坐标
	 */
	private int partition1(int[ ] arr, int left, int right) {
		//pivot基准值
		int pivot = left;
		int index = pivot + 1;
		for(int i = index; i <= right; i++) {
			if(arr[i] < arr[pivot]) {
				//说明i下标对应的值应该在pivot的左侧,而index就是用来做找到基准值pivot的临时变量
				swap(arr, i, index);
				//交换位置后,index位置的元素一定小与pivot,所以index向后移动
				index++;
			}
		}
		//循环结束后index - 1 便是基准值的下标,交换原基准值下标与现基准值下标所对应的值
		swap(arr, pivot, index - 1);
		return index - 1;
	}
	/**
	 * 交换两个下标对应的值得操作
	 * @param i
	 * @param j
	 */
	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	/**
	 * 分割操作方法二:双向调整
	 * 优点:比单向调整效率更高,每个元素只需要进行一次调整
	 * @param arr
	 * @return
	 */
	private int partition2(int[] arr, int left, int right) {
		int pivot = left;
		int i = left + 1;
		int j =  right;
		while(true) {
			while( i <= j && arr[i] <= arr[pivot]) {
				i++;
			}
			while( i <= j && arr[j] >= arr[pivot]) {
				j--;
			}
			if(i >= j) {
				break;
			}
			swap(arr, i, j);
		}
		//此时j下标对应的应该就是基准值的位置,交换原基准值下标与现基准值下标对应的值
		swap(arr, pivot, j);
		//返回现在的基准值下标
		return j;
	}
}


import java.util.Arrays;


/**
 * 堆排序
 * @author asus
 *
 */
public class HeapSort implements IArraySort {
	/**
	 * 堆排序,最主要的是构建最大堆,将对顶元素与未排序部分最后一个元素交换
	 * 位置,则此元素处于有序状态,直到最大堆只剩下最后一个元素,则所有元素有序
	 * 在构建最大堆的时候,一定要从最后一个父节点开始下浮
	 */
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//拷贝数组arr,不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		//二叉堆一般使用数组结构
		int len = arr.length;
		//将整个数组构建成二叉堆(最大堆)
		buildMaxHeap(arr, len);
		//因为最大堆的堆顶元素,即下标为0的元素是整个二叉堆的最大值,
		//因此每次取出最大值,然后将二叉堆的长度缩小1,将最后一个元素
		//补充到堆顶,并将此元素在二叉堆中归位就会形成新的二叉堆,重复
		//以上步骤,直到二叉堆为空
		for(int i = len - 1; i > 0; i--) {
			//将第一个元素与无序部分的最后一个元素交换,则最后一个元素处于有序状态
			swap(arr,0, i);
			//将二叉堆的长度缩小1,并将新的堆顶元素归位,使其重新成为最大堆
			len--;
			//heapify堆化
			heapify(arr, 0, len);
		}
		return arr;
	}
	
	private void buildMaxHeap(int[] arr, int len) {
		for(int i = (int)Math.floor(len / 2); i >= 0; i--) {
			//建堆的时候一定是从最后一个父节点开始下浮,而此时的i便是可能存在的最大的父节点下标
			//将此父节点堆化
			heapify(arr, i, len);
		}
	}
	/**
	 * 堆化传进来的父节点i
	 * @param arr
	 * @param i
	 * @param len
	 */
	private void heapify(int[] arr, int i, int len) {
		//该父节点的左孩子的下标
		int left = 2 * i + 1;
		//该节点的右孩子的下标
		int right = 2 * i + 2;
		//记录最大值的下标
		int largest = i;
		if(left < len && arr[left] > arr[largest]) {
			//说明该父节点存在左孩子,且左孩子大于父节点,则此父节点需要下浮
			largest = left;
		}
		if(right < len && arr[right] > arr[largest]) {
			//说明该父节点存在右孩子,且右孩子大于父节点,则此父节点需要下浮
			largest = right;
		}
		//说明此时largest对应的值是最大值,交换位置,并继续将堆顶元素堆化
		if(i != largest) {
			swap(arr, i, largest);
			heapify(arr, largest, len);
		}
	}
	/**
	 * 交换两个下标所对应的元素
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
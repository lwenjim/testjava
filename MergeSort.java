import java.util.Arrays;


/**
 * 归并排序
 * @author asus
 *
 */
public class MergeSort implements IArraySort {
	/**
	 * 归并排序采用了分而治之的思想,归并即合并之意
	 * 主要有三个重要的步骤:分,治,合
	 * 分:分组
	 * 治:只需不断地分组,直到每组只有一个元素
	 * 合:合并两个有序数组
	 */
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//对arr进行拷贝,不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		if(arr.length < 2) {
			return arr;
		}
		//找到未排序的数组的中间位置
		int middle = (int)Math.floor(arr.length / 2);
		//左分组的待排序数组,包含头,不包含尾
		int[] left = Arrays.copyOfRange(arr, 0, middle);
		//右分组的待排序数组,包含头,不包含尾
		int[] right = Arrays.copyOfRange(arr, middle, arr.length);
		//返回合并两个有序数组的结果
		return merge(sort(left),sort(right));
	}
	/**
	 * 合并两个有序数组
	 * @param left 左组的有序数组
	 * @param right 右组的有序数组
	 * @return
	 */
	protected int[] merge(int[] left, int[] right) {
		//定义一个数组来存储合并后的有序数组
		int[] result = new int[left.length + right.length];
		int i = 0;
		//左右有序链表都有剩余元素,比较第一个元素,将较小的元素存入结果数组
		while(left.length > 0 && right.length > 0) {
			if(left[0] <= right[0]) {
				result[i++] = left[0];
				left = Arrays.copyOfRange(left, 1, left.length);
			} else {
				result[i++] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length);
			}
		}
		//左有序链表有剩余,将左有序链表剩余部分存入结果数组
		while(left.length > 0) {
			result[i++] = left[0];
			left = Arrays.copyOfRange(left, 1, left.length);
		}
		//右有序链表有剩余,将右有序链表剩余部分存入结果数组
		while(right.length > 0) {
			result[i++] = right[0];
			right = Arrays.copyOfRange(right, 1, right.length);
		}
		return result;
	}
}
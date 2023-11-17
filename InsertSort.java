import java.util.Arrays;


/**
 * 插入排序
 * @author asus
 *
 */
public class InsertSort implements IArraySort {
	/**
	 * 插入排序,分为左右两区,左边为已排序区,右边为未排序区,假设
	 * 左边第一个元素已排好序,从第二个元素开始,将该元素插入到已
	 * 排序区的适当位置
	 */
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//对arr进行拷贝,不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		//第一个元素默认已经排好序,从第二个元素开始遍历
		for(int i = 1; i < arr.length; i++) {
			//tmp记录要排序的元素
			int tmp = arr[i];
			//j记录要排序元素的下标
			int j = i;
			while(j > 0 && tmp < arr[j - 1]) {
				//将要插入元素从后向前与已排序的序列的元素进行比较,
				//若已排序元素大于要插入的元素,则向后移动一位,为要插入的
				//元素腾出位置,最终找到要插入的位置的下标j
				arr[j] = arr[j - 1];
				//因为j下标,及其所对应的元素已经被记录,所以不会被覆盖
				j--;
			}
			if(j != i) {
				//如果要插入位置的下标不等于要插入元素的原始下标,则插入要插入的元素
				arr[j] = tmp;
			}
		}
		return arr;
	}
}
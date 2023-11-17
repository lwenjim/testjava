/**
 * 冒泡排序
 */
import java.util.Arrays;


public class BubbleSort implements IArraySort {
	/**
	 * 相邻两个元素进行比较
	 */
	@Override
	public int[] sort(int[] sourceArray) throws Exception {
		//对arr进行拷贝,不改变参数内容
				int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
				for(int i = 0; i < arr.length - 1; i++) {
					//一共需要比较N - 1趟
					//设定一个标记,若为true,则表示此次循环没有进行交换,也就是待排序列已经有序,排序已经完成
					boolean flag = true;
					for(int j = 0; j < arr.length - (i + 1); j ++) {
						//每趟需要比较N - 第几趟,趟数从1开始算起
						if(arr[j] > arr[j + 1]) {
							int tmp = arr[j];
							arr[j] = arr[j + 1];
							arr[j + 1] = tmp;
							
							flag = false;
						}
					}
					//说明此趟没有进行任何交换,则排序已经完成
					if(flag) {
						break;
					}
				}
		return arr;
	}
}
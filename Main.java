public class Main {
    public static void main(String[] args) {
        
    }

    public void sort(){
        int[] arr = { 1, 2, 5, 4 };
        QuickSort qs = new QuickSort();
        try {
            qs.sort(arr);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        BubbleSort bs = new BubbleSort();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            bs.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SelectionSort ss = new SelectionSort();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            ss.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        InsertSort is = new InsertSort();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            is.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        MergeSort ms = new MergeSort();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            ms.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        CountingSort1 cs = new CountingSort1();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            cs.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HeapSort hs = new HeapSort();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            hs.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        CountingSort c2s = new CountingSort();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            c2s.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        BucketSort bs2 = new BucketSort();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            bs2.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        RadixSort rs = new RadixSort();
        try {
            int[] arr2 = { 1, 2, 5, 4 };
            rs.sort(arr2);
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
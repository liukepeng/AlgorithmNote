package com.example.algotithm;

import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 4, 6, 2, 7, 0};
        quickSort(nums, 0, 7);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 冒泡排序
     * 基本思想
     * 给定一个数组，我们把数组里的元素通通倒入到水池中，这些元素将通过相互之间的比较，按照大小顺序一个一个地像气泡一样浮出水面。
     * <p>
     * 实现
     * 每一轮，从杂乱无章的数组头部开始，每两个元素比较大小并进行交换，直到这一轮当中最大或最小的元素被放置在数组的尾部，
     * 然后不断地重复这个过程，直到所有元素都排好位置。其中，核心操作就是元素相互比较。
     * <p>
     * 算法分析
     * 空间复杂度
     * <p>
     * 假设数组的元素个数是 n，由于在整个排序的过程中，我们是直接在给定的数组里面进行元素的两两交换，所以空间复杂度是 O(1)。
     * <p>
     * 时间复杂度
     * <p>
     * 1. 给定的数组按照顺序已经排好
     * <p>
     * 在这种情况下，我们只需要进行 n?1 次的比较，两两交换次数为 0，时间复杂度是 O(n)。这是最好的情况。
     * <p>
     * 2. 给定的数组按照逆序排列
     * <p>
     * 在这种情况下，我们需要进行 n(n-1)/2 次比较，时间复杂度是 O(n^2)。这是最坏的情况。
     * <p>
     * 3. 给定的数组杂乱无章
     * <p>
     * 在这种情况下，平均时间复杂度是 O(n^2)。
     * <p>
     * 冒泡排序的时间复杂度是 O(n^2)。它是一种稳定的排序算法。
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        // 定义一个布尔变量?hasChange，用来标记每轮遍历中是否发生了交换
        boolean hasChange = true;
        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;
            // 进行两两比较，如果发现当前的数比下一个数还大，那么就交换这两个数，同时记录一下有交换发生
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    hasChange = true;
                }
            }
        }
    }

    /**
     * 插入排序（Insertion Sort）
     * 基本思想
     * 不断地将尚未排好序的数插入到已经排好序的部分。
     * <p>
     * 特点
     * 在冒泡排序中，经过每一轮的排序处理后，数组后端的数是排好序的；
     * 而对于插入排序来说，经过每一轮的排序处理后，数组前端的数都是排好序的。
     * <p>
     * 空间复杂度
     * <p>
     * 假设数组的元素个数是 n，由于在整个排序的过程中，是直接在给定的数组里面进行元素的两两交换，空间复杂度是 O(1)。
     * <p>
     * 时间复杂度
     * <p>
     * 1. 给定的数组按照顺序已经排好
     * <p>
     * 只需要进行 n-1 次的比较，两两交换次数为 0，时间复杂度是 O(n)。这是最好的情况。
     * <p>
     * 2. 给定的数组按照逆序排列
     * <p>
     * 在这种情况下，我们需要进行 n(n-1)/2 次比较，时间复杂度是O(n^2)。这是最坏的情况。
     * <p>
     * 3. 给定的数组杂乱无章
     * <p>
     * 在这种情况下，平均时间复杂度是O(n^2)。
     * <p>
     * <p>
     * 由此可见，和冒泡排序一样，插入排序的时间复杂度是?O(n^2)，并且它也是一种稳定的排序算法
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 1, j, current; i < nums.length; i++) {
            current = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > current; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = current;
        }
    }

    /**
     * 选择排序
     * 算法步骤
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 1、时间复杂度：O(n2) 2、空间复杂度：O(1) 3、非稳定排序
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    /**
     * 归并排序（Merge Sort）
     * 基本思想
     * 核心是分治，就是把一个复杂的问题分成两个或多个相同或相似的子问题，然后把子问题分成更小的子问题，
     * 直到子问题可以简单的直接求解，最原问题的解就是子问题解的合并。归并排序将分治的思想体现得淋漓尽致。
     * <p>
     * 实现
     * 一开始先把数组从中间划分成两个子数组，一直递归地把子数组划分成更小的子数组，直到子数组里面只有一个元素，才开始排序。
     * <p>
     * 排序的方法就是按照大小顺序合并两个元素，接着依次按照递归的返回顺序，不断地合并排好序的子数组，直到最后把整个数组的顺序排好。
     * <p>
     * 算法分析
     * <p>
     * 空间复杂度
     * <p>
     * 由于合并 n 个元素需要分配一个大小为 n 的额外数组，合并完成之后，这个数组的空间就会被释放，所以算法的空间复杂度就是 O(n)。归并排序也是稳定的排序算法。
     * <p>
     * 时间复杂度
     * <p>
     * 归并算法是一个不断递归的过程。
     * <p>
     * 举例：数组的元素个数是 n，时间复杂度是 T(n) 的函数。
     * <p>
     * 解法：把这个规模为 n 的问题分成两个规模分别为 n/2 的子问题，每个子问题的时间复杂度就是 T(n/2)，那么两个子问题的复杂度就是 2×T(n/2)。
     * 当两个子问题都得到了解决，即两个子数组都排好了序，需要将它们合并，一共有 n 个元素，每次都要进行最多 n-1 次的比较，所以合并的复杂度是 O(n)。
     * 由此我们得到了递归复杂度公式：T(n) = 2×T(n/2) + O(n)。
     * <p>
     * 对于公式求解，不断地把一个规模为 n 的问题分解成规模为 n/2 的问题，一直分解到规模大小为 1。如果 n 等于 2，只需要分一次；
     * 如果 n 等于 4，需要分 2 次。这里的次数是按照规模大小的变化分类的。
     * <p>
     * 以此类推，对于规模为 n 的问题，一共要进行 log(n) 层的大小切分。在每一层里，我们都要进行合并，所涉及到的元素其实就是数组里的所有元素，
     * 因此，每一层的合并复杂度都是 O(n)，所以整体的复杂度就是O(nlogn)。
     *
     * @param A
     * @param low
     * @param high
     */
    public static void mergeSort(int[] A, int low, int high) {
        // 判断是否只剩下最后一个元素
        if (low >= high) return;
        // 从中间将数组分成两个部分
        int mid = low + (high - low) / 2;
        // 分别递归地将左右两半排好序
        mergeSort(A, low, mid);
        mergeSort(A, mid + 1, high);
        // 将排好序的左右两半合并
        mergeArray(A, low, mid, high);
    }

    private static void mergeArray(int[] nums, int low, int mid, int high) {
        // 复制一份原来的数组
        int[] copy = nums.clone();
        // 定义一个k指针表示从什么位置开始修改原来的数组，i指针表示左半边的起始位置，j表示右半边的起始位置
        int k = low, i = low, j = mid + 1;

//        左半边的数都处理完毕，只剩下右半边的数，只需要将右半边的数逐个拷贝过去。
//
//        右半边的数都处理完毕，只剩下左半边的数，只需要将左半边的数逐个拷贝过去就好。
//
//        右边的数小于左边的数，将右边的数拷贝到合适的位置，j 指针往前移动一位。
//
//        左边的数小于右边的数，将左边的数拷贝到合适的位置，i 指针往前移动一位。

        while (k <= high) {
            if (i > mid) {
                nums[k++] = copy[j++];
            } else if (j > high) {
                nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                nums[k++] = copy[j++];
            } else {
                nums[k++] = copy[i++];
            }
        }
    }

    /**
     * 快速排序（Quick Sort）
     * <p>
     * 基本思想
     * <p>
     * 快速排序也采用了分治的思想。
     * <p>
     * 实现对数组 [2, 1, 7, 9, 5, 8] 进行排序。
     * <p>
     * 把原始的数组筛选成较小和较大的两个子数组，然后递归地排序两个子数组。
     * <p>
     * 按照快速排序的思想，首先把数组筛选成较小和较大的两个子数组。
     * <p>
     * 随机从数组里选取一个数作为基准值，比如 7，于是原始的数组就被分成了两个子数组。注意：快速排序是直接在原始数组里进行各种交换操作，所以当子数组被分割出来的时候，原始数组里的排列也被改变了。
     * <p>
     * 接下来，在较小的子数组里选 2 作为基准值，在较大的子数组里选 8 作为基准值，继续分割子数组。
     * <p>
     * 继续将元素个数大于 1 的子数组进行划分，当所有子数组里的元素个数都为 1 的时候，原始数组也被排好序了。
     * 算法分析
     * 时间复杂度
     * <p>
     * 1. 最优情况：被选出来的基准值都是当前子数组的中间数。
     * <p>
     * 这样的分割，能保证对于一个规模大小为 n 的问题，能被均匀分解成两个规模大小为 n/2 的子问题（归并排序也采用了相同的划分方法），时间复杂度就是：T(n) = 2×T(n/2) + O(n)。
     * <p>
     * 把规模大小为 n 的问题分解成 n/2 的两个子问题时，和基准值进行了 n-1 次比较，复杂度就是 O(n)。很显然，在最优情况下，快速排序的复杂度也是O(nlogn)。
     * <p>
     * 2. 最坏情况：基准值选择了子数组里的最大或者最小值
     * <p>
     * 每次都把子数组分成了两个更小的子数组，其中一个的长度为 1，另外一个的长度只比原子数组少 1。
     * <p>
     * 空间复杂度
     * <p>
     * 和归并排序不同，快速排序在每次递归的过程中，只需要开辟 O(1) 的存储空间来完成交换操作实现直接对数组的修改，
     * 又因为递归次数为 logn，所以它的整体空间复杂度完全取决于压堆栈的次数，因此它的空间复杂度是 O(logn)。
     *
     * @param nums
     * @param lo
     * @param hi
     */
    public static void quickSort(int[] nums, int lo, int hi) {
        if (lo > hi) return; // 判断是否只剩下一个元素，是，则直接返回
        // 利用partition函数找到一个随机的基准点
        int p = partition(nums, lo, hi);
        // 递归地对基准点左半边和右半边的数进行排序
        quickSort(nums, lo, p - 1);
        quickSort(nums, p + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        // 随机选择一个数作为基准值，nums[hi]就是基准值
        swap(nums, randomRange(lo, hi), hi);
        int i, j;
        // 从左到右用每个数和基准值比较，若比基准值小，则放到指针i所指向的位置。循环完毕后，i指针之前的数都比基准值小
        for (i = lo, j = lo; j < hi; j++) {
            if (nums[j] <= nums[hi]) {
                swap(nums, i++, j);
            }
        }
        // 末尾的基准值放置到指针i的位置，i指针之后的数都比基准值大
        swap(nums, i, j);
        // 返回指针i，作为基准点的位置
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int randomRange(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static void topologicalSort() {

    }
}
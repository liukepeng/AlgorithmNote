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
     * ð������
     * ����˼��
     * ����һ�����飬���ǰ��������Ԫ��ͨͨ���뵽ˮ���У���ЩԪ�ؽ�ͨ���໥֮��ıȽϣ����մ�С˳��һ��һ����������һ������ˮ�档
     * <p>
     * ʵ��
     * ÿһ�֣����������µ�����ͷ����ʼ��ÿ����Ԫ�رȽϴ�С�����н�����ֱ����һ�ֵ���������С��Ԫ�ر������������β����
     * Ȼ�󲻶ϵ��ظ�������̣�ֱ������Ԫ�ض��ź�λ�á����У����Ĳ�������Ԫ���໥�Ƚϡ�
     * <p>
     * �㷨����
     * �ռ临�Ӷ�
     * <p>
     * ���������Ԫ�ظ����� n����������������Ĺ����У�������ֱ���ڸ����������������Ԫ�ص��������������Կռ临�Ӷ��� O(1)��
     * <p>
     * ʱ�临�Ӷ�
     * <p>
     * 1. ���������鰴��˳���Ѿ��ź�
     * <p>
     * ����������£�����ֻ��Ҫ���� n?1 �εıȽϣ�������������Ϊ 0��ʱ�临�Ӷ��� O(n)��������õ������
     * <p>
     * 2. ���������鰴����������
     * <p>
     * ����������£�������Ҫ���� n(n-1)/2 �αȽϣ�ʱ�临�Ӷ��� O(n^2)��������������
     * <p>
     * 3. ������������������
     * <p>
     * ����������£�ƽ��ʱ�临�Ӷ��� O(n^2)��
     * <p>
     * ð�������ʱ�临�Ӷ��� O(n^2)������һ���ȶ��������㷨��
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        // ����һ����������?hasChange���������ÿ�ֱ������Ƿ����˽���
        boolean hasChange = true;
        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;
            // ���������Ƚϣ�������ֵ�ǰ��������һ����������ô�ͽ�������������ͬʱ��¼һ���н�������
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
     * ��������Insertion Sort��
     * ����˼��
     * ���ϵؽ���δ�ź���������뵽�Ѿ��ź���Ĳ��֡�
     * <p>
     * �ص�
     * ��ð�������У�����ÿһ�ֵ��������������˵������ź���ģ�
     * �����ڲ���������˵������ÿһ�ֵ�������������ǰ�˵��������ź���ġ�
     * <p>
     * �ռ临�Ӷ�
     * <p>
     * ���������Ԫ�ظ����� n����������������Ĺ����У���ֱ���ڸ����������������Ԫ�ص������������ռ临�Ӷ��� O(1)��
     * <p>
     * ʱ�临�Ӷ�
     * <p>
     * 1. ���������鰴��˳���Ѿ��ź�
     * <p>
     * ֻ��Ҫ���� n-1 �εıȽϣ�������������Ϊ 0��ʱ�临�Ӷ��� O(n)��������õ������
     * <p>
     * 2. ���������鰴����������
     * <p>
     * ����������£�������Ҫ���� n(n-1)/2 �αȽϣ�ʱ�临�Ӷ���O(n^2)��������������
     * <p>
     * 3. ������������������
     * <p>
     * ����������£�ƽ��ʱ�临�Ӷ���O(n^2)��
     * <p>
     * <p>
     * �ɴ˿ɼ�����ð������һ�������������ʱ�临�Ӷ���?O(n^2)��������Ҳ��һ���ȶ��������㷨
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
     * ѡ������
     * �㷨����
     * ������δ�����������ҵ���С����Ԫ�أ���ŵ��������е���ʼλ�á�
     * �ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ�أ�Ȼ��ŵ����������е�ĩβ��
     * 1��ʱ�临�Ӷȣ�O(n2) 2���ռ临�Ӷȣ�O(1) 3�����ȶ�����
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
     * �鲢����Merge Sort��
     * ����˼��
     * �����Ƿ��Σ����ǰ�һ�����ӵ�����ֳ�����������ͬ�����Ƶ������⣬Ȼ���������ֳɸ�С�������⣬
     * ֱ����������Լ򵥵�ֱ����⣬��ԭ����Ľ�����������ĺϲ����鲢���򽫷��ε�˼�����ֵ����쾡�¡�
     * <p>
     * ʵ��
     * һ��ʼ�Ȱ�������м仮�ֳ����������飬һֱ�ݹ�ذ������黮�ֳɸ�С�������飬ֱ������������ֻ��һ��Ԫ�أ��ſ�ʼ����
     * <p>
     * ����ķ������ǰ��մ�С˳��ϲ�����Ԫ�أ��������ΰ��յݹ�ķ���˳�򣬲��ϵغϲ��ź���������飬ֱ���������������˳���źá�
     * <p>
     * �㷨����
     * <p>
     * �ռ临�Ӷ�
     * <p>
     * ���ںϲ� n ��Ԫ����Ҫ����һ����СΪ n �Ķ������飬�ϲ����֮���������Ŀռ�ͻᱻ�ͷţ������㷨�Ŀռ临�ӶȾ��� O(n)���鲢����Ҳ���ȶ��������㷨��
     * <p>
     * ʱ�临�Ӷ�
     * <p>
     * �鲢�㷨��һ�����ϵݹ�Ĺ��̡�
     * <p>
     * �����������Ԫ�ظ����� n��ʱ�临�Ӷ��� T(n) �ĺ�����
     * <p>
     * �ⷨ���������ģΪ n ������ֳ�������ģ�ֱ�Ϊ n/2 �������⣬ÿ���������ʱ�临�ӶȾ��� T(n/2)����ô����������ĸ��ӶȾ��� 2��T(n/2)��
     * �����������ⶼ�õ��˽���������������鶼�ź�������Ҫ�����Ǻϲ���һ���� n ��Ԫ�أ�ÿ�ζ�Ҫ������� n-1 �εıȽϣ����Ժϲ��ĸ��Ӷ��� O(n)��
     * �ɴ����ǵõ��˵ݹ鸴�Ӷȹ�ʽ��T(n) = 2��T(n/2) + O(n)��
     * <p>
     * ���ڹ�ʽ��⣬���ϵذ�һ����ģΪ n ������ֽ�ɹ�ģΪ n/2 �����⣬һֱ�ֽ⵽��ģ��СΪ 1����� n ���� 2��ֻ��Ҫ��һ�Σ�
     * ��� n ���� 4����Ҫ�� 2 �Ρ�����Ĵ����ǰ��չ�ģ��С�ı仯����ġ�
     * <p>
     * �Դ����ƣ����ڹ�ģΪ n �����⣬һ��Ҫ���� log(n) ��Ĵ�С�з֡���ÿһ������Ƕ�Ҫ���кϲ������漰����Ԫ����ʵ���������������Ԫ�أ�
     * ��ˣ�ÿһ��ĺϲ����Ӷȶ��� O(n)����������ĸ��ӶȾ���O(nlogn)��
     *
     * @param A
     * @param low
     * @param high
     */
    public static void mergeSort(int[] A, int low, int high) {
        // �ж��Ƿ�ֻʣ�����һ��Ԫ��
        if (low >= high) return;
        // ���м佫����ֳ���������
        int mid = low + (high - low) / 2;
        // �ֱ�ݹ�ؽ����������ź���
        mergeSort(A, low, mid);
        mergeSort(A, mid + 1, high);
        // ���ź������������ϲ�
        mergeArray(A, low, mid, high);
    }

    private static void mergeArray(int[] nums, int low, int mid, int high) {
        // ����һ��ԭ��������
        int[] copy = nums.clone();
        // ����һ��kָ���ʾ��ʲôλ�ÿ�ʼ�޸�ԭ�������飬iָ���ʾ���ߵ���ʼλ�ã�j��ʾ�Ұ�ߵ���ʼλ��
        int k = low, i = low, j = mid + 1;

//        ���ߵ�����������ϣ�ֻʣ���Ұ�ߵ�����ֻ��Ҫ���Ұ�ߵ������������ȥ��
//
//        �Ұ�ߵ�����������ϣ�ֻʣ�����ߵ�����ֻ��Ҫ�����ߵ������������ȥ�ͺá�
//
//        �ұߵ���С����ߵ��������ұߵ������������ʵ�λ�ã�j ָ����ǰ�ƶ�һλ��
//
//        ��ߵ���С���ұߵ���������ߵ������������ʵ�λ�ã�i ָ����ǰ�ƶ�һλ��

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
     * ��������Quick Sort��
     * <p>
     * ����˼��
     * <p>
     * ��������Ҳ�����˷��ε�˼�롣
     * <p>
     * ʵ�ֶ����� [2, 1, 7, 9, 5, 8] ��������
     * <p>
     * ��ԭʼ������ɸѡ�ɽ�С�ͽϴ�����������飬Ȼ��ݹ���������������顣
     * <p>
     * ���տ��������˼�룬���Ȱ�����ɸѡ�ɽ�С�ͽϴ�����������顣
     * <p>
     * �����������ѡȡһ������Ϊ��׼ֵ������ 7������ԭʼ������ͱ��ֳ������������顣ע�⣺����������ֱ����ԭʼ��������и��ֽ������������Ե������鱻�ָ������ʱ��ԭʼ�����������Ҳ���ı��ˡ�
     * <p>
     * ���������ڽ�С����������ѡ 2 ��Ϊ��׼ֵ���ڽϴ����������ѡ 8 ��Ϊ��׼ֵ�������ָ������顣
     * <p>
     * ������Ԫ�ظ������� 1 ����������л��֣����������������Ԫ�ظ�����Ϊ 1 ��ʱ��ԭʼ����Ҳ���ź����ˡ�
     * �㷨����
     * ʱ�临�Ӷ�
     * <p>
     * 1. �����������ѡ�����Ļ�׼ֵ���ǵ�ǰ��������м�����
     * <p>
     * �����ķָ�ܱ�֤����һ����ģ��СΪ n �����⣬�ܱ����ȷֽ��������ģ��СΪ n/2 �������⣨�鲢����Ҳ��������ͬ�Ļ��ַ�������ʱ�临�ӶȾ��ǣ�T(n) = 2��T(n/2) + O(n)��
     * <p>
     * �ѹ�ģ��СΪ n ������ֽ�� n/2 ������������ʱ���ͻ�׼ֵ������ n-1 �αȽϣ����ӶȾ��� O(n)������Ȼ������������£���������ĸ��Ӷ�Ҳ��O(nlogn)��
     * <p>
     * 2. ��������׼ֵѡ���������������������Сֵ
     * <p>
     * ÿ�ζ���������ֳ���������С�������飬����һ���ĳ���Ϊ 1������һ���ĳ���ֻ��ԭ�������� 1��
     * <p>
     * �ռ临�Ӷ�
     * <p>
     * �͹鲢����ͬ������������ÿ�εݹ�Ĺ����У�ֻ��Ҫ���� O(1) �Ĵ洢�ռ�����ɽ�������ʵ��ֱ�Ӷ�������޸ģ�
     * ����Ϊ�ݹ����Ϊ logn��������������ռ临�Ӷ���ȫȡ����ѹ��ջ�Ĵ�����������Ŀռ临�Ӷ��� O(logn)��
     *
     * @param nums
     * @param lo
     * @param hi
     */
    public static void quickSort(int[] nums, int lo, int hi) {
        if (lo > hi) return; // �ж��Ƿ�ֻʣ��һ��Ԫ�أ��ǣ���ֱ�ӷ���
        // ����partition�����ҵ�һ������Ļ�׼��
        int p = partition(nums, lo, hi);
        // �ݹ�ضԻ�׼�����ߺ��Ұ�ߵ�����������
        quickSort(nums, lo, p - 1);
        quickSort(nums, p + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        // ���ѡ��һ������Ϊ��׼ֵ��nums[hi]���ǻ�׼ֵ
        swap(nums, randomRange(lo, hi), hi);
        int i, j;
        // ��������ÿ�����ͻ�׼ֵ�Ƚϣ����Ȼ�׼ֵС����ŵ�ָ��i��ָ���λ�á�ѭ����Ϻ�iָ��֮ǰ�������Ȼ�׼ֵС
        for (i = lo, j = lo; j < hi; j++) {
            if (nums[j] <= nums[hi]) {
                swap(nums, i++, j);
            }
        }
        // ĩβ�Ļ�׼ֵ���õ�ָ��i��λ�ã�iָ��֮��������Ȼ�׼ֵ��
        swap(nums, i, j);
        // ����ָ��i����Ϊ��׼���λ��
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
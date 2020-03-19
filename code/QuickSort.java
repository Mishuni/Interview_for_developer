import java.util.*;

public class QuickSort {

	public static int partition(int[] arr, int left, int right) {

		int pivot = (left + right) / 2;
		
		// ���� �Ŵ� pivot�� ����, ū �Ŵ� ������
		while (left < right) {
			while (left <= right && arr[left] <= arr[pivot])
				++left;
			while (left <= right && arr[right] > arr[pivot])
				--right;

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				// ������ �˻簡 �� ���� ���� right=pivot
				// right�� arr[pivot]�� ���� ���� ���߱� ����
				if (right == pivot) {
					// left �� pivot�� swap �� ����̹Ƿ�
					// ���� ���� left�� ����
					return left;
				}
			}
		}
		// left�� �˻簡 �����µ�, right�� �� ���� ���
		// pivot�� �������� right���� �ٲٱ�
		if (right != pivot) {
			int temp = arr[right];
			arr[right] = arr[pivot];
			arr[pivot] = temp;
		}
		return right;

	}

	public static void quickSort(int[] ori, int left, int right) {

		if (left < right) {
			
			int newPivot = partition(ori, left, right);
			// ������ ���� �迭��
			quickSort(ori, left, newPivot - 1);
			// ������ ������ ����
			quickSort(ori, newPivot + 1, right);
			
		}
	}
	
	// ���� �����غ���
	public static void main(String[] args) {

		int[] a = { 1, 3, 56, 8, 9, 3, 2, 1, 23, 11, 10 };
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

	}
}
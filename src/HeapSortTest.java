import java.util.Scanner;

public class HeapSortTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] a = new int[in.nextInt()];
		for (int i = 0; i <= a.length - 1; i++) {
			a[i] = in.nextInt();
		}
		HeapSort(a);
		for (int i = 0; i <= a.length - 1; i++) {
			System.out.println(a[i]);
		}
	}

	public static void HeapSort(int[] array) {
		int heapsize = array.length - 1;
		BuildMaxHeap(array, heapsize);

		for (int i = array.length - 1; i >= 0; i--) {
			int tmp = array[i];
			array[i] = array[0];
			array[0] = tmp;
			heapsize--;
			siftDownMax(array, 0, heapsize);
		}
	}

	public static void BuildMaxHeap(int[] array, int heapsize) {
		for (int i = heapsize / 2; i >= 0; i--) {

			siftDownMax(array, i, heapsize);
		}
	}

	static void siftDownMax(int[] array, int pos, int heapsize) {
		int leftchild, rightchild, maxpos = 0, tmp;
		rightchild = getRightChild(pos);
		leftchild = getLeftChild(pos);
		if (rightchild > heapsize) {
			if (leftchild > heapsize) {
				return;
			} else {
				maxpos = leftchild;
			}

		} else {
			if (array[rightchild] < array[leftchild]) {
				maxpos = leftchild;

			} else if (array[leftchild] < array[rightchild]) {

				maxpos = rightchild;
			}

		}
		if (array[pos] < array[maxpos]) {
			tmp = array[maxpos];
			array[maxpos] = array[pos];
			array[pos] = tmp;
			siftDownMax(array, maxpos, heapsize);

		}

	}

	public static int getRightChild(int p) {
		return (p * 2) + 2;
	}

	public static int getLeftChild(int p) {
		return (p * 2) + 1;
	}

}

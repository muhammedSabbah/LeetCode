package com.coding.heap;


public class HeapCore {
	
	public static void swapElements(int[] elements, int start, int end) {
		int tmp = elements[start];
		elements[start] = elements[end];
		elements[end] = tmp;
	}

	public static void maxHeapify(int[] elements, int indx, int end) {
		int leftIndx = 2 * indx;
		int rightIndx = (2 * indx) + 1;
		int largeIndx = indx;
		if (leftIndx < end && elements[leftIndx] > elements[largeIndx]) {
			largeIndx = leftIndx;
		}
		if (rightIndx < end && elements[rightIndx] > elements[largeIndx]) {
			largeIndx = rightIndx;
		}
		if (largeIndx != indx) {
			swapElements(elements, indx, largeIndx);
			maxHeapify(elements, largeIndx, end);
		}
	}

	public static void buildHeap(int[] elements) {
		int length = elements.length;
		for (int i = length / 2; i >= 1; i--) {
			maxHeapify(elements, i, length);
		}
	}

	public static void heapSort(int[] elements) {
		buildHeap(elements);
		int len = elements.length;
		for (int indx = elements.length - 1; indx >= 2; indx--) {
			swapElements(elements, 1, indx);
			len--;
			maxHeapify(elements, 1, len);
		}
	}

	public static void main(String[] args) {

		int[] elements = new int[] { 0, 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };
		heapSort(elements);
		for (int i = 1; i < elements.length; i++) {
			System.out.print(elements[i] + " ");
		}
	}

}

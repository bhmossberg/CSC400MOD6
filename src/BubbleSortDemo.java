import java.util.ArrayList;
import java.util.List;

public class BubbleSortDemo {

	public static <T extends Comparable<? super T>> void bubbleSort(List<T> list) {
		int n = list.size();
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
					T temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
					swapped = true;
				}
			}
			if (!swapped) break;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("====Bubble Sort Demo====");
		System.out.println("String Objects");
		List<String> names = new ArrayList<>();
		names.add("Craig");
		names.add("Jimmy");
		names.add("Jay");
		names.add("David");
		names.add("Conan");
		System.out.println("Before: " + names);
		bubbleSort(names);
		System.out.println("After:  " + names);
		System.out.println();
		
		System.out.println("Integer Objects");		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(61);
		numbers.add(486);
		numbers.add(6);
		numbers.add(-5);
		numbers.add(23);
		numbers.add(3);
		numbers.add(2);
		numbers.add(123);
		System.out.println("Before: " + numbers);
		bubbleSort(numbers);
		System.out.println("After:  " + numbers);
	}
}
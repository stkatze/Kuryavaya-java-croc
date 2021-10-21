package task3;
import java.util.Scanner;

public class Main {
    static void printIntArr(int arr[]) 
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print("[" + i + "] = " + arr[i] + "\n");
        }
    }   
 
    public static void maxToEndMinToBeg(int arr[])
    {
        int minInd = 0;
        int maxInd = 0;
        for (int i=0; i < arr.length; i++)
        {
            if (arr[i] > arr[maxInd])
            {
                maxInd = i;
            } 
	    if (arr[i] < arr[minInd])
            {
                minInd = i;
            }
        }
   

	int first = arr[0];
	int last = arr[arr.length - 1];
	int max = arr[maxInd];
	int min = arr[minInd];

	arr[0] = min;
	arr[minInd] = first;
	if (!(first == max && last == min)) {
		if (first == max) {
			maxInd = minInd;
		}
		else if (last == min) {
			last = arr[minInd];
		}

		arr[maxInd] = last;
		arr[arr.length - 1] = max;
	}
    }


    public static int[] inputArr() {
	Scanner input = new Scanner(System.in); 
	System.out.println("Введите длину массива:");
	int size = input.nextInt(); 
	int arr[] = new int[size];
	System.out.println("Введите элементы массива через пробел:");
    	for (int i = 0; i < size; i++) {
    	       	arr[i] = input.nextInt(); 
	}
	return arr;
    }
    public static void main(String [] args)
    {
	int arr[] = inputArr();
        printIntArr(arr);
        maxToEndMinToBeg(arr);
        System.out.println("Результат:\n");
        printIntArr(arr);       
    }
}
 

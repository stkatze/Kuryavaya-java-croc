package task3;
import java.util.Scanner;

public class Main3 {
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
 
        int tmp = 0;
            
        tmp = arr[0];
        arr[0] = arr[minInd];
        arr[minInd] = tmp;
        
        tmp = arr[arr.length - 1];
        arr[arr.length - 1] = arr[maxInd];
        arr[maxInd] = tmp; 
    }

    public static void main(String [] args)
    {
    	   Scanner input = new Scanner(System.in); 
    	    System.out.println("Введите длину массива:");
    	    int size = input.nextInt(); 
    	    int arr[] = new int[size]; 
    	    System.out.println("Введите элементы массива через пробел:");
    	   
    	    for (int i = 0; i < size; i++) {
    	        arr[i] = input.nextInt(); 
    	    }
        printIntArr(arr);
        maxToEndMinToBeg(arr);
        System.out.println("Результат:\n");
        printIntArr(arr);       
    }
}
 
package task2;
import java.util.Scanner;

class Main2 {
    public static void main(String[] args)
    {
        Scanner scan= new Scanner(System.in);
       
        double bytes = 0;
        
        System.out.print("Введите количество байт.\n>>> ");
        bytes = scan.nextDouble();
        
        if (bytes < 0) {
            System.out.println("Ошибка: количество байт не может быть отрицательным!\n");
            return;
        }
        
        String answer = "";
        double calculation = 0;     
        String formatedCalculation = "";
 
        if (bytes < 1024) {
            answer = Double.toString(bytes) + " B";
        }
        else {
            int counter = 0;
            while (bytes >= 1024 && counter < 8) {
                bytes = bytes / 1024;
                counter++;
            }
            answer = String.format("%.1f", bytes);
            
            switch (counter)
            {
                case 1:
                    answer += " KiB";
                    break;
                case 2:
                    answer += " MiB";
                    break;
                case 3:
                    answer += " GiB";
                    break;
                case 4:
                    answer += " TiB";
                    break;
                case 5:
                    answer += " PiB";
                    break;
                case 6:
                    answer += " EiB";
                    break;
                case 7:
                    answer += " ZiB";
                    break;
                case 8: 
                    answer += " YiB";
                    break;
            }
        }
 
        System.out.println("Ваш ввод эквивалентен: " + answer);
        return;
    }
}
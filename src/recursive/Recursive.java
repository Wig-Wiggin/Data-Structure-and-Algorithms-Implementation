package recursive;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Recursive {

     static int factorial(int number) {
        if (number == 1) return 1;
        else {
            return number * factorial(number - 1);
        }
    }


     static void fibonacci(int number) {

        if (number < 0) return;

        if (number == 1) System.out.println(0);

        int x = 1;
        int y = 0;
        System.out.print("0 1 ");

        for (int i = 0; i < number - 2; i++) {
            int temp = x + y;
            y = x;
            x = temp;

            System.out.print(temp + " ");
        }
        System.out.println();
    }

     static void fibonacci(int x,int y,int number){
        if (number > 1) {
            int temp = x+y;
            System.out.print(temp+" ");
            fibonacci(y,temp,number-1);
        }
    }

     static int sumDigits(int number){
        if(number < 10){
            return number;
        }else {
            return (number%10) + sumDigits(number/10);
        }
    }

     static int power(int base,int expo){
        if(expo == 1)return base;

        return base * power(base,expo-1);
    }

     static int GCD(int x,int y){
        if(x % y == 0) return y;

        return x > y ? GCD(x%y,y) : GCD(y%x,x);
    }

     static void towerOfHanoi(int disk,char from,char to, char via){
        if(disk == 1){
            System.out.printf("Move disk 1 from rod %c to rod %c%n",from,to);
        }else {
            towerOfHanoi(disk-1,from,via,to);
            System.out.printf("Move disk %d from rod %c to rod %c%n",disk,from,via);
            towerOfHanoi(disk-1,via,to,from);
        }
    }

    private static  int sum(int[] arr, int pointer){
        if(pointer == arr.length-1) return arr[pointer];
        return arr[pointer] + sum(arr,++pointer);
    }

     static int sum(int[] arr){
        return sum(arr,0);
    }




}

package org.blbulyandavbulyan.exceptionshw.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = Integer.parseInt(sc.next());
        try{
            throwIfNumberIsNegative(number);
            System.out.println("Число корректно");
        }
        catch (InvalidNumberException e){
            System.out.println(e.getMessage());
        }
    }
    public static void throwIfNumberIsNegative(int n) throws InvalidNumberException {
        if(n < 0)throw new InvalidNumberException("Некорректное число");
    }
}

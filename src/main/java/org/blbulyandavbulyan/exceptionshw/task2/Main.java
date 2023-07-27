package org.blbulyandavbulyan.exceptionshw.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.print("Введите второе число: ");
        double b = Double.parseDouble(sc.nextLine());
        try{
            System.out.printf("Результат деления: %f", divide(a, b));
        } catch (DivisionByZeroException e) {
            System.out.println("Деление на ноль недопустимо");
        }
    }
    public static double divide(double a, double b) throws DivisionByZeroException {
        if(b == 0)throw new DivisionByZeroException();
        return a/b;
    }
}

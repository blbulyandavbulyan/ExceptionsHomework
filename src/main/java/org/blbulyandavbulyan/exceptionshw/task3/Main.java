package org.blbulyandavbulyan.exceptionshw.task3;

import org.blbulyandavbulyan.exceptionshw.task2.DivisionByZeroException;
import org.blbulyandavbulyan.exceptionshw.task3.exceptions.NumberOutOfRangeException;
import org.blbulyandavbulyan.exceptionshw.task3.exceptions.NumberSumException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = sc.nextInt();
        System.out.print("Введите второе число: ");
        int b = sc.nextInt();
        System.out.print("Введите третье число: ");
        int c = sc.nextInt();
        try{
            throwIfInvalid(a, b, c);
            System.out.println("Проверка пройдена успешно");
        } catch (DivisionByZeroException | NumberOutOfRangeException | NumberSumException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void throwIfInvalid(int a, int b, int c) throws DivisionByZeroException{
        if(a > 100 || b < 0)
            throw new NumberOutOfRangeException((a > 100 ? "Первое" : "Второе") + " вне допустимого диапазона");
        if (a + b < 10)
            throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        if(c == 0)
            throw new DivisionByZeroException("Деление на ноль недопустимо");
    }
}

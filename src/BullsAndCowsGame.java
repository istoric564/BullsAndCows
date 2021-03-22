

import java.util.*;


public class BullsAndCowsGame {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int[] computerNumbers = new int[4];
        int[] userAnswer = new int[4];
        int countBulls;
        int countCows;

        for (int i = 0; i < computerNumbers.length; i++) {
            computerNumbers[i] = (int) (Math.random()*8+1);
        }
        // Настройка рандомного значения компьютера.
        if(computerNumbers[0] == 0){
            computerNumbers[0]++;
        }
        for (int i = 0; i < computerNumbers.length; i++) {
            for (int j = i + 1; j < computerNumbers.length; j++) {
                if(computerNumbers[i] == computerNumbers[j]){
                    computerNumbers[j]++;
                }
            }
        }
        for (int computerNumber : computerNumbers) {
            System.out.print(computerNumber);
        }
        System.out.println(" Игра Быки и коровы");
        System.out.println(" Тебе нужно ввести четыре числа от 1 до 9 без повторяющихся чисел ");
        System.out.println(" У тебя безлимитное количество попыток. Удачи победитель :)");

        for(int userAttempts = 1; ; userAttempts++) {
            countBulls = 0;
            countCows = 0;
            System.out.println(userAttempts + ") Пожалуйста введите свое число: ");
            try{
                //        Заполнение массива пользователя
                for (int i = 0; i < userAnswer.length; i++) {
                    userAnswer[i] = scanner.nextInt();
                }
            } catch (NumberFormatException exception){
                System.err.println("Ошибка: введены не числовые символы");
//                Уменьшаем счетчик попыток
                userAttempts--;
                continue;
            }for (int k : userAnswer) {
                if ((k < 0 || k > 9)) {
                    System.out.println("Ошибка: введено число меньше 1 или больше 9");
//                Уменьшаем счетчик попыток
                    userAttempts--;
                }
            }
            try {
                for (int i = 0; i < 4; i++) {
                    for (int j = i +1; j < i; j++) {
                        if (userAnswer[i] == userAnswer[j]) {
                            System.out.println("Ошибка: введено число с дублем.");
                            userAttempts--;
                            throw new Exception();
                        }
                    }
                }
            }catch (Exception exception){
                continue;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < userAnswer.length; i++) {
                list.add(i,userAnswer[i]);
            }
//        Проверка значения быков.
            for (int i = 0; i < computerNumbers.length; i++) {
                int c = computerNumbers[i];
                if (c == userAnswer[i]) {
                    countBulls++;
                }else if (list.contains(computerNumbers[i])){
                    countCows++;
                }
            }
            System.out.println("Bulls: " + countBulls);
            System.out.println("Cows: " + countCows);
            if (countBulls == 4) {
                break;
            }
        }
        System.out.println("Ты победил, ура!");

    }
}


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracer= new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();
        while (true) {
            switch (userInput) {
                case 1: {
                    stepTracer.saveNumberOfSteps();
                    break;
                }
                case 2: {
                    stepTracer.printStatistics();
                    break;
                }
                case 3: {
                    stepTracer.saveGoal();
                    break;
                }
                case 0: {
                    System.out.println("Выход.");
                   return;
                }
                default: {
                    System.out.println("Извините, такой команды пока нет.");
                    break;
                }
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }
    private static void printMenu(){
        System.out.println("Что вы хотите сделать?\n"+"1 - Ввести количество шагов за определённый день\n" +
                "2 - Напечатать статистику за определённый месяц\n" +
                "3 - Изменить цель по количеству шагов в день\n" +
                "0 - Выйти из приложения");
    }
}
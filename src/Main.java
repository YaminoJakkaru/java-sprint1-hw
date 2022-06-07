import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracer= new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();
        while (true) {
            if(userInput==1){
                System.out.println("Выберете меяц: 0-11");
                int month=scanner.nextInt();
                if (month>11||month<0) {
                    System.out.println("Месяц введен неверно!");
                    continue;
                }
                System.out.println("Выберете день: 0-30");
                int day=scanner.nextInt();
                if(day>30||day<0){
                    System.out.println("День указан не верно!");
                    continue;
                }
                System.out.println("Введите количество шагов:");
                int steps=scanner.nextInt();
                if(steps<0){
                    System.out.println("Количество шагов указано неверно!");
                    continue;
                }
                stepTracer.saveNumberOfSteps(month,day,steps);

            }
            else if (userInput==2){
                System.out.println("Выберете меяц: 0-11");
                int month=scanner.nextInt();
                stepTracer.printStatistics(month);
            }
            else if(userInput==3){
                stepTracer.saveGoal();


            }
            else if(userInput==0){
                System.out.println("Выход.");
                break;
            }
            else{
                System.out.println("Извините, такой команды пока нет.");
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
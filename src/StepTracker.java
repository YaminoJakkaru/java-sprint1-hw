import java.util.Scanner;
public class StepTracker {
    int goal=10000;

    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    Scanner scanner= new Scanner(System.in);
  Converter converter = new Converter();

    void saveNumberOfSteps(){
        System.out.println("Выберете меяц: 0-11");
        int month=scanner.nextInt();
        if (month>11||month<0) {
            System.out.println("Месяц введен неверно!");
            return;
        }
        System.out.println("Выберете день: 0-30");
        int day=scanner.nextInt();
        if(day>30||day<0){
            System.out.println("День указан не верно!");
            return;
        }
        System.out.println("Введите количество шагов:");
        int steps=scanner.nextInt();
        if(steps<0){
            System.out.println("Количество шагов указано неверно!");
            return;
        }
            monthToData[month].setDays(day,steps);
        System.out.println("Значение сохраено!");
    }
    void printStatistics(){
        System.out.println("Выберете меяц: 0-11");
        int month=scanner.nextInt();
        if (month>11||month<0) {
            System.out.println("Месяц введен неверно!");
            return;
        }
        printTotalNumberOfSteps(month);
        System.out.println("Общее коничество шагов за месяц: "+findSumOfSteps(month));
        System.out.println("Максимальное пройденое количество шагов в месясе: "+findMaxNumberOfSteps(month));
        System.out.println("Среднее количество шагов: "+findSumOfSteps(month)/monthToData[month].days.length);
        System.out.println("Пройденая дистанция (в км): "+converter.convertToKm(findSumOfSteps(month)));
        System.out.println("Количесево сожжоных колорий: "+ converter.convertToKcal(findSumOfSteps(month)));
        printBestSeries(month);






    }
    void printTotalNumberOfSteps(int month){
        for(int j =0; j<monthToData[month].days.length; j++) {
            System.out.print(j+1+" день:"+monthToData[month].days[j]+",");
        }
        System.out.println(" ");
    }
    int findSumOfSteps(int month){
        int sumOfSteps=0;
        for(int j=0;j<monthToData[month].days.length;j++){
            sumOfSteps+=monthToData[month].days[j];
        }
        return sumOfSteps;
    }
    int findMaxNumberOfSteps( int month){
        int maxNumberOfSteps=0;
        for(int j=0;j<monthToData[month].days.length;j++){
            if(maxNumberOfSteps<monthToData[month].days[j])
                maxNumberOfSteps=monthToData[month].days[j];
        }
        return maxNumberOfSteps;

    }
    void saveGoal(){

        System.out.println("Введите новую цель:");
        int newGoal=scanner.nextInt();
        if(newGoal<0) {

            System.out.println("Количество шагов указано неверно!");
            System.out.println("Цель: "+ goal+ " шагов в день!");

        }
        else {
            goal=newGoal;
            System.out.println("Новая цель: "+ goal+ " шагов в день!");
        }

    }
    void printBestSeries(int month){
        int series=0;
        int bastSeries=0;
        for(int j=0;j<monthToData[month].days.length;j++){
            if(monthToData[month].days[j]>=goal){
                series++;
                if(bastSeries<series){
                    bastSeries=series;
                }

            }
            else{
                series=0;
            }
        }
        System.out.println("Лучшая серия: "+ bastSeries);

    }

}


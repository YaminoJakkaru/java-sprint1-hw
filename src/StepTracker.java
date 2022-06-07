import java.util.Scanner;
public class StepTracker {
    int goal=10000;

    int[][] stepsData;
    StepTracker(){
        stepsData= new int[12][30];
    }
    Scanner scanner= new Scanner(System.in);
    Converter convert = new Converter(75,50);

    void saveNumberOfSteps(int month, int day, int steps){
        stepsData[month][day]=steps;
        System.out.println("Значение сохраено!");
    }
    void printStatistics(int month){
        printTotalNumberOfSteps(month);
        System.out.println("Общее коничество шагов за месяц: "+findSumOfSteps(month));
        System.out.println("Максимальное пройденое количество шагов в месясе: "+findMaxNumberOfSteps(month));
        System.out.println("Среднее количество шагов: "+findSumOfSteps(month)/stepsData[month].length);
        System.out.println("Пройденая дистанция (в км): "+convert.convertToKm(findSumOfSteps(month)));
        System.out.println("Количесево сожжоных колорий: "+ convert.convertToKcal(findSumOfSteps(month)));
        printBastSeries(month);






    }
    void printTotalNumberOfSteps(int month){
        for(int j =0; j<stepsData[month].length; j++) {
            System.out.print(j+1+" день:"+stepsData[month][j]+",");
        }
        System.out.println(" ");
    }
    int findSumOfSteps(int month){
        int sumOfSteps=0;
        for(int j=0;j<stepsData[month].length;j++){
            sumOfSteps+=stepsData[month][j];
        }
        return sumOfSteps;
    }
    int findMaxNumberOfSteps( int month){
        int maxNumberOfSteps=0;
        for(int j=0;j<stepsData[month].length;j++){
            if(maxNumberOfSteps<stepsData[month][j])
                maxNumberOfSteps=stepsData[month][j];
        }
        return maxNumberOfSteps;

    }
    int saveGoal(){

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
        return goal;
    }
    void printBastSeries(int month){
        int series=0;
        int bastSeries=0;
        for(int j=0;j<stepsData[month].length;j++){
            if(stepsData[month][j]>=goal){
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


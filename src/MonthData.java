public class MonthData {
    int[] days;
    public MonthData() {
        days = new int[30];
    }
    void setDays(int day, int steps){
        days[day]= steps;
    }

}

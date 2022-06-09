public class Converter {
    final double CM=75;
    final double CAL=50;



    double convertToKm(int steps) {return steps*CM/100000;}
    double convertToKcal(int steps){
        return steps*CAL/1000;
    }
}

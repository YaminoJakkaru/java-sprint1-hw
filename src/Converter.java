public class Converter {
    double KmInStep;
    double KcalInStep;

    Converter(int km,int Kcal) {
        KmInStep =km ;
        KcalInStep=Kcal;


    }

    double convertToKm(int steps) {
        return steps*KmInStep/1000;
    }
    double convertToKcal(int steps){
        return steps*KcalInStep/1000;
    }
}

package com.example.myapplication;

public class Impact {



    private String vehicleType;

    public Impact() {
    }

    public static double ScoreCalculate(String vehicle, int distance) {
        double score=0;
         double plane=5;
         double train=1;
         double ship=4;
          double truck=3;
        if (distance>10000){
            if (vehicle.equals("plane")) {
                score=(plane+5)*10;
            }
            else if (vehicle.equals("car") || vehicle.equals("truck")) {
                score=(truck+5)*10;
            }
            else if (vehicle.equals("train")) {
                score=(train+5)*10;
            }
        }
        else if (distance<10000&& distance>5000){
            if (vehicle.equals("plane")) {
                score=(plane+3)*10;
            }
            else if (vehicle.equals("car") || vehicle.equals("truck")) {
                score=(truck+3)*10;
            }
            else if (vehicle.equals("train")) {
                score=(train+3)*10;
            }
            else if(vehicle.equals("ship")){
                score=(ship+3)*10;
            }
        }
        else if (distance<5000&& distance>1000){
            if (vehicle.equals("plane")) {
                score=(plane+2)*10;
            }
            else if (vehicle.equals("car") || vehicle.equals("truck")) {
                score=(truck+2)*10;
            }
            else if (vehicle.equals("train")) {
                score=(train+2)*10;
            }
            else if(vehicle.equals("ship")){
                score=(ship+2)*10;
            }
        }
        else if (distance<1000){
            if (vehicle.equals("plane")) {
                score=(plane+1)*10;
            }
            else if (vehicle.equals("car") || vehicle.equals("truck")) {
                score=(truck+1)*10;
            }
            else if (vehicle.equals("train")) {
                score=(train+1)*10;
            }
            else if(vehicle.equals("ship")){
                score=(ship+1)*10;
            }
        }
        return score;
    }


}

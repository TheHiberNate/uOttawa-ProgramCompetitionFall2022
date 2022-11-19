package com.example.myapplication;

public class Impact {
    private double plane=5;
    private double train=1;
    private double ship=4;
    private  double truck=3;


    private String vehicleType;

    public Impact() {
    }

    public   double GwpParSeconde(String vehicle, int distance) {
        double score=0;
        if (distance>10000){
            if (vehicle.equals("Airplane")) {
                score=(plane+5)*100;
            }
            else if (vehicle.equals("Car") || vehicle.equals("Truck")) {
                score=(truck+5)*100;
            }
            else if (vehicle.equals("Train")) {
                score=(train+5)*100;
            }
        }
        else if (distance<10000&& distance>5000){
            if (vehicle.equals("airplane")) {
                score=(plane+3)*100;
            }
            else if (vehicle.equals("car") || vehicle.equals("Truck")) {
                score=(truck+3)*100;
            }
            else if (vehicle.equals("train")) {
                score=(train+3)*100;
            }
            else if(vehicle.equals("ship")){
                score=(ship+3)*100;
            }
        }
        else if (distance<5000&& distance>1000){
            if (vehicle.equals("airplane")) {
                score=(plane+2)*100;
            }
            else if (vehicle.equals("car") || vehicle.equals("Truck")) {
                score=(truck+2)*100;
            }
            else if (vehicle.equals("train")) {
                score=(train+2)*100;
            }
            else if(vehicle.equals("ship")){
                score=(ship+2)*100;
            }
        }
        else if (distance<1000){
            if (vehicle.equals("airplane")) {
                score=(plane+1)*100;
            }
            else if (vehicle.equals("car") || vehicle.equals("Truck")) {
                score=(truck+1)*100;
            }
            else if (vehicle.equals("train")) {
                score=(train+1)*100;
            }
            else if(vehicle.equals("ship")){
                score=(ship+1)*100;
            }
        }
        return score;
    }


}

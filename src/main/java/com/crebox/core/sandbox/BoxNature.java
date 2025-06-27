package com.crebox.core.sandbox;

public class BoxNature {
    public double CO2AmountInAir;
    public double O2AmountInAir;
    private BoxManager boxManager;
    BoxNature(BoxManager boxManager){
        CO2AmountInAir=20000;
        O2AmountInAir=80000;
        this.boxManager=boxManager;
    }
    public double doPhotoSyn(double PhoAbility) {
        int boxTimeSecond= boxManager.getBoxTime()/1000;
        if(boxTimeSecond%24>12) {
            //on the night!!!
            return 0;
        }
        double AirTran=PhoAbility;
        double percentOfCO2= CO2AmountInAir / (CO2AmountInAir+O2AmountInAir);
        if(percentOfCO2<0.01)
            percentOfCO2=0;
        AirTran=AirTran*percentOfCO2;
        if(AirTran>CO2AmountInAir)
            AirTran=CO2AmountInAir;
        CO2AmountInAir=CO2AmountInAir-AirTran;
        O2AmountInAir=O2AmountInAir+AirTran;
        return AirTran;
    }
    public double doBreath(double EnergyBreathGet) {
        double percentOfO2= O2AmountInAir / (CO2AmountInAir+O2AmountInAir);
        if(percentOfO2<0.2)
            percentOfO2=0.2;
        double EnergyBreathCost=EnergyBreathGet/percentOfO2;
        if(EnergyBreathGet>O2AmountInAir)
            EnergyBreathGet=O2AmountInAir;
        O2AmountInAir-=EnergyBreathGet;
        CO2AmountInAir+=EnergyBreathGet;
        return EnergyBreathCost;
    }
    public double getNatureTemperature(BoxPos pos) {
        //从y=0开始，y越大于0越热，y越小于0越冷
        return (pos.y / 20.0) *1.0115;
    }
}

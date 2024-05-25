package top.crebox.boxcore.sandbox;

public class SandboxPos {
    public double x,y;
    public void movePosByAngle(double angle,double distance) {
        if(angle<0){
            angle+=360;
        }
        if(0<=angle && angle<=90) {
            x+=Math.cos(90-angle)*distance;
            y+=Math.sin(90-angle)*distance;
        }else if(90<=angle && angle<=180) {
            x+=Math.cos(angle-90)*distance;
            y-=Math.sin(angle-90)*distance;
        }else if(180<=angle && angle<=270) {
            x-=Math.cos(angle-180)*distance;
            y-=Math.sin(angle-180)*distance;
        }if(270<=angle && angle<=360) {
            x-=Math.cos(angle-270)*distance;
            y+=Math.sin(angle-270)*distance;
        }
    }
}

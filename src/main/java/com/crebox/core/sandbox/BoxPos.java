package com.crebox.core.sandbox;

public class BoxPos {
    public double x, y;
    public BoxPos() {
        this.x=0;
        this.y=0;
    }
    public BoxPos(double x,double y) {
        this.x=x;
        this.y=y;
    }
    /**
     * 根据源坐标移动当前位置
     * @param angleDeg 角度（0-360度），0度指向正右方（X轴正方向），90度指向上方（Y轴正方向）
     * @param step 移动的步长（距离）
     */
    public void move(double angleDeg, double step) {
        double angleRad = Math.toRadians(angleDeg);
        double dx = step * Math.cos(angleRad);
        double dy = step * Math.sin(angleRad);
        x += dx;
        y += dy;
    }
}

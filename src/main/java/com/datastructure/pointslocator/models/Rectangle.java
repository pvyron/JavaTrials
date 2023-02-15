package main.java.com.datastructure.pointslocator.models;

import main.java.com.datastructure.pointslocator.utils.CoordinatesValidator;

public class Rectangle {
    private final int xmin;
    private final int xmax;
    private final int ymin;
    private final int ymax;

    public Rectangle(int xmin, int xmax, int ymin, int ymax) throws Exception {
        if (!CoordinatesValidator.isInsideGrid(xmin)
        || !CoordinatesValidator.isInsideGrid(xmax)
        || !CoordinatesValidator.isInsideGrid(ymin)
        || !CoordinatesValidator.isInsideGrid(ymax)){
            throw new Exception("Location out of 100 x 100 grid");
        }

        if (xmax > xmin){
            this.xmin = xmin;
            this.xmax = xmax;
        } else{
            this.xmax = xmin;
            this.xmin = xmax;
        }

        if (ymax > ymin){
            this.ymin = ymin;
            this.ymax = ymax;
        } else{
            this.ymax = ymin;
            this.ymin = ymax;
        }
    }

    public int Xmax(){
        return  xmax;
    }

    public int Xmin(){
        return xmin;
    }

    public int Ymax(){
        return ymax;
    }

    public int Ymin(){
        return ymin;
    }

    public boolean contains(Point p) {
        if (p.X() > this.xmax || p.X() < this.xmin || p.Y() > this.ymax || p.Y() < this.ymax) {
            return false;
        }

        return true;
    }

    public boolean intersects(Rectangle that) {
        if (this.xmin > that.xmax || that.xmin > this.xmax || this.ymin > that.ymax || that.ymin > this.ymax) {
            return false;
        }

        return true;
    }

    public double distanceTo(Point p){
        return Math.sqrt(squareDistanceTo(p));
    }

    public int squareDistanceTo(Point p){
        if (contains(p)){
            return 0; // the closest rectangle's point to the input is its self, so 0
        }

        var dx = Math.min(Math.abs(xmax-p.X()), Math.abs(xmin-p.X()));
        var dy = Math.min(Math.abs(ymax-p.Y()), Math.abs(ymin-p.Y()));

        return (int)(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public String toString(){
        return "|" + xmin + "," + xmax + "| x |" + ymin + "," + ymax + "|";
    }
}

package main.java.com.datastructure.pointslocator.models;

import main.java.com.datastructure.pointslocator.utils.CoordinatesValidator;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) throws Exception {
        if (!CoordinatesValidator.isInsideGrid(x) || !CoordinatesValidator.isInsideGrid(y)){
            throw new Exception("Location out of 100 x 100 grid");
        }

        this.x = x;
        this.y = y;
    }

    public int X(){
        return x;
    }

    public int Y(){
        return y;
    }

    public double distanceTo(Point z){
        return Math.sqrt(squareDistanceTo(z));
    }

    public int squareDistanceTo(Point z){
        return (int) (Math.pow(z.X() - this.x, 2) + Math.pow(z.Y() - this.y, 2));
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
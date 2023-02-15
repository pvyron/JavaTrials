package main.java.com.datastructure.pointslocator;

import main.java.com.datastructure.pointslocator.models.Point;

public class App {
    public static void main(String[] args) {
        try{
            Point random = new Point(1, 2);

            System.out.println(random.toString());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
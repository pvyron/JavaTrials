package main.java.com.datastructure.pointslocator.utils;

public class CoordinatesValidator {
    private static int minBoundary = 0;
    private static int maxBoundary = 100;

    public static boolean isInsideGrid(int z){
        if (z < minBoundary || z > maxBoundary){
            return false;
        }

        return true;
    }
}

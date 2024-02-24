package com.cgvsu.protocurvefxapp;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Collections;

public class MaxAndMin {

    static double maxXvalue(ArrayList<Point2D> points){
        double max = Double.MIN_VALUE;
        for(Point2D element: points){
            if(max<element.getX()){
                max = element.getX();
            }
        }
        return max;
    }

    static double minXvalue(ArrayList<Point2D> points){
        double min = Double.MAX_VALUE;
        for(Point2D element: points){
            if(min>element.getX()){
                min = element.getX();
            }
        }
        return min;
    }

    static double maxXvalue2(ArrayList<Point2D> points){
        double max = Double.MIN_VALUE;
        for(Point2D element: points){
            if(max<element.getY()){
                max = element.getY();
            }
        }
        return max;
    }

    static double minXvalue2(ArrayList<Point2D> points){
        double min = Double.MAX_VALUE;
        for(Point2D element: points){
            if(min>element.getY()){
                min = element.getY();
            }
        }
        return min;
    }
}

package com.cgvsu.protocurvefxapp;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class Param {

    public ArrayList<Double> FindThirdParam (ArrayList<Point2D> points){
        int count = 0;
        double allDistance = 0;
        double t = 0;
        ArrayList<Double> distance = new ArrayList<>();
        ArrayList<Double> params = new ArrayList<>();
        double variableX = points.get(0).getX();
        double variableY = points.get(0).getY();
        for(Point2D point: points){
            double S = Math.sqrt(Math.pow(point.getX() - variableX,2) + Math.pow(point.getY() - variableY, 2));
            // distance.add(S);
            allDistance += S;
            variableX = point.getX();
            variableY = point.getY();
            t += S;
            distance.add(t);
        }
        for (Double element: distance){
            params.add(element/allDistance);
        }
        return params;
    }
}

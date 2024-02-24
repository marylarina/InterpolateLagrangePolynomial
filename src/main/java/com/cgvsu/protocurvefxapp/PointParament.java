package com.cgvsu.protocurvefxapp;

import javafx.geometry.Point2D;

public class PointParament {

    public double t;
    public double p;

    public PointParament(double t, double p){
        this.p = p;
        this.t = t;
    }

    public double getT(){return t;};
    public double getP(){return p;}
}

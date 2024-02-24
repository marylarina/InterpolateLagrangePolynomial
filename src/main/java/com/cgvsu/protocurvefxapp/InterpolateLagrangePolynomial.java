package com.cgvsu.protocurvefxapp;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class InterpolateLagrangePolynomial{

    private ArrayList<Point2D> points;
    private ArrayList<Point2D> tx;
    private ArrayList<Point2D> ty;
    private ArrayList<Double> param;

    public InterpolateLagrangePolynomial(ArrayList<Point2D> points){this.points=points;}

    public InterpolateLagrangePolynomial(/*ArrayList<Point2D> points*/ InterpolateLagrangePolynomial polynomial){
        //this.points = points;
        this(polynomial.points);
        this.param = CalculateParams(points);
        this.tx = getTx(points);
        this.ty = getTy(points);
    }

    public double getValue(double param) {
        double lagrangePol = 0;

        for (Point2D element1: points)
        {
            double basicsPol = 1;
            for (Point2D element2:points)
            {
                if (element2.getX() != element1.getX())
                {
                    basicsPol *= (param - element2.getX())/(element1.getX() - element2.getX());
                }
            }
            lagrangePol += basicsPol * element1.getY();
        }
        return lagrangePol;
    }



    private ArrayList<Double> CalculateParams(ArrayList<Point2D> points){
        double allDistance = 0;
        double t = 0;
        ArrayList<Double> distance = new ArrayList<>();
        ArrayList<Double> params = new ArrayList<>();
        double variableX = points.get(0).getX();
        double variableY = points.get(0).getY();
        for(Point2D point: points){
            double S = Math.sqrt(Math.pow(point.getX() - variableX,2) + Math.pow(point.getY() - variableY, 2));
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

    private ArrayList<Point2D> getTx(ArrayList<Point2D> points){
        ArrayList<Point2D> TandX = new ArrayList<>();
        for (int i=0; i< points.size(); i++){
            Point2D point = new Point2D(param.get(i), points.get(i).getX());
            TandX.add(point);
        }
        return TandX;
    }

    private ArrayList<Point2D> getTy(ArrayList<Point2D> points){
        ArrayList<Point2D> TandY = new ArrayList<>();
        for (int i=0; i< points.size(); i++){
            Point2D point = new Point2D(param.get(i), points.get(i).getY());
            TandY.add(point);
        }
        return TandY;
    }

    public double LagrangePolynomialX (double x)
    {
        double lagrangePol = 0;

        for (Point2D element1: tx)
        {
            double basicsPol = 1;
            for (Point2D element2:tx)
            {
                if (element2.getX() != element1.getX())
                {
                    basicsPol *= (x - element2.getX())/(element1.getX() - element2.getX());
                }
            }
            lagrangePol += basicsPol * element1.getY();
        }
        return lagrangePol;
    }

    public double LagrangePolynomialY (double x)
    {
        double lagrangePol = 0;

        for (Point2D element1: ty)
        {
            double basicsPol = 1;
            for (Point2D element2:ty)
            {
                if (element2.getX() != element1.getX())
                {
                    basicsPol *= (x - element2.getX())/(element1.getX() - element2.getX());
                }
            }
            lagrangePol += basicsPol * element1.getY();
        }
        return lagrangePol;
    }

    public Point2D getPoint(double x){
        return new Point2D(LagrangePolynomialX(x), LagrangePolynomialY(x));
    }

   /* static double LagrangePolynomial2 (double x, ArrayList<PointParament> points)
    {
        double lagrangePol = 0;

        for (Point2D element1: points)
        {
            double basicsPol = 1;
            for (Point2D element2:points)
            {
                if (element2.getY() != element1.getY())
                {
                    basicsPol *= (x - element2.getY())/(element1.getY() - element2.getY());
                }
            }
            lagrangePol += basicsPol * element1.getY();
        }
        return lagrangePol;
    }
    */
}

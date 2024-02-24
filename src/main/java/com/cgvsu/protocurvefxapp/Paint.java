package com.cgvsu.protocurvefxapp;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Paint{

     public static void paintSimple(ArrayList<Point2D> points, GraphicsContext graphicsContext, InterpolateLagrangePolynomial lagrange){
        for (Point2D element: points){
            final int POINT_RADIUS = 4;
            graphicsContext.fillOval(
                    element.getX() - POINT_RADIUS, element.getY() - POINT_RADIUS,
                    2 * POINT_RADIUS, 2 * POINT_RADIUS);
        }
        for (double k = MaxAndMin.minXvalue(points); k<= MaxAndMin.maxXvalue(points); k=k+0.5){
            double y = lagrange.getValue(k);
            graphicsContext.strokeLine(k, y, k-0.5, lagrange.getValue(k - 0.5));
        }
    }

    public static void paint(ArrayList<Point2D> points, GraphicsContext graphicsContext, InterpolateLagrangePolynomial lagrange){
        for (Point2D element: points){
            final int POINT_RADIUS = 4;
            graphicsContext.fillOval(
                    element.getX() - POINT_RADIUS, element.getY() - POINT_RADIUS,
                    2 * POINT_RADIUS, 2 * POINT_RADIUS);
        }
        for (double t = 0.001; t<= 1; t=t+0.001){
            Point2D point2D = lagrange.getPoint(t);
            Point2D previous = lagrange.getPoint(t-0.001);
            graphicsContext.strokeLine(point2D.getX(), point2D.getY(), previous.getX(), previous.getY());
        }
    }
}

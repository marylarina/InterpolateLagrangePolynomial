package com.cgvsu.protocurvefxapp;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class ProtoCurveController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    ArrayList<Point2D> points = new ArrayList<Point2D>();

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        canvas.setOnMouseClicked(event -> {
            switch (event.getButton()) {
                case PRIMARY -> handlePrimaryClick(canvas.getGraphicsContext2D(), event);
            }
        });
    }


    private void handlePrimaryClick(GraphicsContext graphicsContext, MouseEvent event) {
        final Point2D clickPoint = new Point2D(event.getX(), event.getY());

        int size = points.size();
        points.add(clickPoint);
        InterpolateLagrangePolynomial lagrange = new InterpolateLagrangePolynomial(points);
        InterpolateLagrangePolynomial l = new InterpolateLagrangePolynomial(lagrange);

        if (points.size() > size) {
            graphicsContext.clearRect(0, 0, 800, 600);
            final int POINT_RADIUS = 4;
            graphicsContext.fillOval(
                    clickPoint.getX() - POINT_RADIUS, clickPoint.getY() - POINT_RADIUS,
                    2 * POINT_RADIUS, 2 * POINT_RADIUS);
        }

        if (points.size() > 1) {
                Paint.paint(points, graphicsContext, l);
        }
    }
}
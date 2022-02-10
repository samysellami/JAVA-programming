package ru.makhmutov.task1.shapes;

public class Ellipse extends Shape {

    private double majorRadius;
    private double minorRadius;

    public Ellipse(double majorRadius, double minorRadius) {
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    @Override
    protected double calculatePerimeter() {
        return Math.PI * 2 * Math.sqrt((Math.pow(majorRadius, 2) + Math.pow(minorRadius, 2)) / 2);
    }

    @Override
    protected double calculateArea() {
        return majorRadius * minorRadius * Math.PI;
    }
}

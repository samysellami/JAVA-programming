package ru.makhmutov.task1.shapes;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    protected double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

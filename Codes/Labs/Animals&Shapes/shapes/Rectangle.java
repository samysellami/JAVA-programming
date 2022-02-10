package ru.makhmutov.task1.shapes;

public class Rectangle extends Shape {

    private double firstSideLength;
    private double secondSideLength;

    public Rectangle(double firstSideLength, double secondSideLength) {
        this.firstSideLength = firstSideLength;
        this.secondSideLength = secondSideLength;
    }

    @Override
    protected double calculatePerimeter() {
        return firstSideLength * 2 + secondSideLength * 2;
    }

    @Override
    protected double calculateArea() {
        return firstSideLength * secondSideLength;
    }
}

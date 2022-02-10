package ru.makhmutov.task1.shapes;

public class Square extends Shape {

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    protected double calculatePerimeter() {
        return sideLength * 4;
    }

    @Override
    protected double calculateArea() {
        return Math.pow(sideLength, 2);
    }
}

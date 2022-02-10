package ru.makhmutov.task1.shapes;

public class Triangle extends Shape {

    private double firstSideLength;
    private double secondSideLength;
    private double thirdSideLength;
    private double angleBetweenFirstAndSecondSides; // in degrees

    public Triangle(double firstSideLength, double secondSideLength,
                    double thirdSideLength, double angleBetweenFirstAndSecondSides) {
        this.firstSideLength = firstSideLength;
        this.secondSideLength = secondSideLength;
        this.thirdSideLength = thirdSideLength;
        this.angleBetweenFirstAndSecondSides = angleBetweenFirstAndSecondSides;
    }

    @Override
    protected double calculatePerimeter() {
        return firstSideLength + secondSideLength + thirdSideLength;
    }

    @Override
    protected double calculateArea() {
        return 0.5 * firstSideLength * secondSideLength
                * Math.sin(Math.toRadians(angleBetweenFirstAndSecondSides));
    }
}

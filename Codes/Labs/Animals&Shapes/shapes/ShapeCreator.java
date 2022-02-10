package ru.makhmutov.task1.shapes;

public class ShapeCreator {

    /**
     * The entry point of the Shapes program.
     * It allows creating array of different shapes
     * and demonstrate inheritance and polymorphism
     * principles
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Shape[] shapes = addShapes();
        displayShapeSizes(shapes);
    }

    /**
     * This method allows calculating perimeters and
     * areas of all array shapes
     * @param shapes the array of shapes
     */
    private static void displayShapeSizes(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() +
                    " area is " + shape.calculateArea() + ", " +
                    shape.getClass().getSimpleName() +
                    " perimeter is " + shape.calculatePerimeter());
        }
    }

    /**
     * This method allows adding shapes of different
     * types into the array
     *
     * @return the array of shapes
     */
    private static Shape[] addShapes() {
        Shape[] shapes = new Shape[5];

        Shape circle = new Circle(5);
        shapes[0] = circle;

        Shape square = new Square(3);
        shapes[1] = square;

        Shape rectangle = new Rectangle(5, 2);
        shapes[2] = rectangle;

        Shape ellipse = new Ellipse(3, 6);
        shapes[3] = ellipse;

        Shape triangle = new Triangle(2, 2, 2, 60);
        shapes[4] = triangle;

        return shapes;
    }
}

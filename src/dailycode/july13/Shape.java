package dailycode.july13;

// Abstract class
abstract class Shape {
    String color;
    Shape(String color) {
        this.color = color;
    }
    // Abstract method (no body)
    abstract double area();
    // Concrete method
    public String getColor() {
        return color;
    }
}
// Concrete subclass
class Circle extends Shape {
    double radius;
    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
// Another subclass
class Rectangle extends Shape {
    double length, width;
    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    @Override
    double area() {
        return length * width;
    }
}
// Main class
class TestAbstraction {
    public static void main(String[] args) {
        Shape s1 = new Circle("Red", 2.5);
        Shape s2 = new Rectangle("Blue", 4, 6);
        System.out.println(s1.getColor() + " Circle area: " + s1.area());
        System.out.println(s2.getColor() + " Rectangle area: " + s2.area());
    }
}

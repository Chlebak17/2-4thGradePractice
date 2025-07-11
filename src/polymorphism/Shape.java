package polymorphism;

public interface Shape {
    public int district();

    public int area();

}
class Square implements Shape{
    String name;
    int a;

    public Square(int a,String name) {
        this.a = a;
        this.name = name;
    }

    @Override
    public int district() {
        return a*4;
    }

    @Override
    public int area() {
        return a*a;
    }

    @Override
    public String toString() {
        return "Square " + name + " " + "(a=" + a + "cm)";
    }
}
class Rectangle implements Shape{

    int a;
    int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Rectangle(" + "a=" + a + "cm and b=" + b + "cm)";
    }

    @Override
    public int district() {
        return (2*a)+(2*b);
    }

    @Override
    public int area() {
        return a*b;
    }
}


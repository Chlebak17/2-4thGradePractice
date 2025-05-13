package polymorphism;

import java.util.*;

public class ShapeSorter {
    List<Shape> shapes = new ArrayList<>();

    final static Comparator<Shape> BY_AREA = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return Integer.compare(o1.area(), o2.area());
        }
    };

    final static Comparator<Shape> BY_CIRCUIT = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return Integer.compare(o1.district(),o2.district());
        }
    };



    public ShapeSorter(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void sortShapes(Comparator<Shape> comparator){
        Collections.sort(shapes,comparator);
        System.out.println("List is sorted...");
    }
}
class GeometryDash{
    public static void main(String[] args) {
        Square square = new Square(5,"Albert");
        Rectangle rectangle = new Rectangle(8,5);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(square);
        shapes.add(rectangle);

        ShapeSorter shapeSorter = new ShapeSorter(shapes);
        shapes.sort(ShapeSorter.BY_AREA);
        System.out.println(shapeSorter.shapes);

        shapes.sort(ShapeSorter.BY_AREA.reversed());
        System.out.println(shapeSorter.shapes);


    }
}
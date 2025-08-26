package polymorphism;

public class Main1 {
    public static void main(String[] args){
        Shapes shape = new Shapes();
        Shapes circle = new Circle();
        Shapes triangle = new Triangle();
        Shapes square = new Square();

        circle.area();

    }
}

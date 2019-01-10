package ru.job4j.pseudo;

public class Paint {
    public void draw(Shape shape) {
        System.out.print(shape.draw());
    }
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}

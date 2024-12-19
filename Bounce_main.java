import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Bounce_main {
	
	

    public static void main(String[] args) {
        ArrayList<Drawable> drawableList = new ArrayList<>();
        double totalArea = 0;

        try (Scanner scanner = new Scanner(new File("D:\\STUDY\\Oop with Java\\PROJECT_JAVA_OOP\\input.txt.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {

            int numShapes = scanner.nextInt();

            if (numShapes < 2) {
                System.out.println("ERROR:- you should put minimum 2 shapes");
                return;
            }

            for (int i = 0; i < numShapes; i++) {
                String shapetype = scanner.next();
                double l = scanner.nextDouble();

                if (shapetype.equalsIgnoreCase("circle")) {
                    Circle circle = new Circle("red",l);
                    drawableList.add(circle);
                    totalArea += circle.getArea();
                    writer.println(circle.toString()+"\n\n");
                } else if (shapetype.equalsIgnoreCase("cube")) {
                    Cube cube = new Cube("blue",l);
                    drawableList.add(cube);
                    totalArea += cube.getArea();
                    writer.println(cube.toString()+"\n\n");
                } else {
                    System.out.println("ERROR");
                }
            }

            writer.println("Total Area: " + totalArea);
            for (Drawable drawable : drawableList) {
                writer.println(drawable.howToDraw());
                }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
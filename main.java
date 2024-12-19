import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void ProcessShapesfromInputFile(String inputFilePath, String outputFilePath, List<Drawable> drawableList) {
        double totalArea = 0.0;

        try (Scanner scanner = new Scanner(new File(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            if (!scanner.hasNextInt()) {
                writer.println("ERROR : the input file must start with number of shapes.");
                return;
            }

            int numShapes = scanner.nextInt();

            if (numShapes < 2) {
                writer.println("ERROR : enter at least 2 shapes.");
                return;
            }

            int processedShapes = 0;
            
            if (processedShapes < numShapes) {
                writer.println("ERROR: The number of shapes processed does not match the number of shapes declared.");
                return;
            }

            
            while (scanner.hasNext()) {
                if (processedShapes >= numShapes) {
                    writer.println("ERROR : extra data found in the input file");
                    return;
                }

                if (!scanner.hasNext()) {
                    writer.println("ERROR: Missing data");
                    return;
                }

                String shapeType = scanner.next();

                if (!scanner.hasNextDouble()) {
                    writer.println("ERROR : Missing or invalid dimension for shape");
                    return;
                }

                double dimension = scanner.nextDouble();

                if (dimension <= 0) {
                    writer.println("ERROR : Dimension must be positive" );
                    return;
                }

                if (shapeType.equalsIgnoreCase("circle")) {
                    Circle circle = new Circle("red", dimension);
                    drawableList.add(circle);
                    totalArea += circle.getArea();
                    writer.println(circle.toString()+"\n************************************************\n");
                } else if (shapeType.equalsIgnoreCase("cube")) {
                    Cube cube = new Cube("blue", dimension);
                    drawableList.add(cube);
                    totalArea += cube.getArea();
                    writer.println(cube.toString()+"\n************************************************\n");
                } else {
                    writer.println("ERROR: Use 'circle' or 'cube' only");
                    return;
                }

                processedShapes++;
            }

            writer.println("Processing complete ");
            writer.println("Total Area: " + totalArea);

            for (Drawable drawable : drawableList) {
                writer.println(drawable.howToDraw());
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Input file not found at path: " + inputFilePath);
        } catch (IOException e) {
            System.out.println("ERROR: Unable to write to output file: " + outputFilePath);
        }
    }

    public static void main(String[] args) {
        ArrayList<Drawable> drawableList = new ArrayList<>();
        double totalArea = 0;

        if (args.length < 2) {
            System.out.println("ERROR: Invalid input\nthe Processing shapes inputs will be from input file and outputting results to output file.");
            ProcessShapesfromInputFile("D:\\STUDY\\Oop with Java\\PROJECT_JAVA_OOP\\input.txt.txt", "output.txt", drawableList);
            return;
        }
        if (!isNumeric(args[0]) || Integer.parseInt(args[0]) < 2) {
            System.out.println("ERROR: The first argument must be a number greater than or equal to 2.\nthe Processing shapes inputs will be from input file and outputting results to output file.");
            ProcessShapesfromInputFile("D:\\STUDY\\Oop with Java\\PROJECT_JAVA_OOP\\input.txt.txt", "output.txt", drawableList);
            return;
        }

        int numShapes = Integer.parseInt(args[0]);
        int index = 1;
        
        if (drawableList.size() != numShapes) {
            System.out.println("ERROR: The number of shapes processed does not match the number of shapes.\nthe Processing shapes inputs will be from input file and outputting results to output file.");
            ProcessShapesfromInputFile("D:\\STUDY\\Oop with Java\\PROJECT_JAVA_OOP\\input.txt.txt", "output.txt", drawableList);
            return ;
        } else {
            System.out.println("Processing complete.");
        }


        for (int i = 0; i < numShapes; i++) {
            if (index >= args.length - 1) {
                System.out.println("ERROR: Each shape must have a type and a dimension.\nthe Processing shapes inputs will be from input file and outputting results to output file.");
                ProcessShapesfromInputFile("D:\\STUDY\\Oop with Java\\PROJECT_JAVA_OOP\\input.txt.txt", "output.txt", drawableList);
                return;
            }

            String shapeType = args[index++];
            String dimensionInput = args[index++];

            if (!isNumeric(dimensionInput) && Double.parseDouble(dimensionInput) <= 0) {
                System.out.println("ERROR: Dimensions must be positive.\nthe Processing shapes inputs will be from input file and outputting results to output file.");
                ProcessShapesfromInputFile("D:\\STUDY\\Oop with Java\\PROJECT_JAVA_OOP\\input.txt.txt", "output.txt", drawableList);
                return;
            }

            double dimension = Double.parseDouble(dimensionInput);

            if (shapeType.equalsIgnoreCase("circle")) {
                Circle circle = new Circle("red", dimension);
                drawableList.add(circle);
                totalArea += circle.getArea();
            } else if (shapeType.equalsIgnoreCase("cube")) {
                Cube cube = new Cube("blue", dimension);
                drawableList.add(cube);
                totalArea += cube.getArea();
            } else {
                System.out.println("ERROR: Use 'circle' or 'cube' only.\nthe Processing shapes inputs will be from input file and outputting results to output file.");
                ProcessShapesfromInputFile("D:\\STUDY\\Oop with Java\\PROJECT_JAVA_OOP\\input.txt.txt", "output.txt", drawableList);
                return;
            }
        }

        System.out.println("Total Area: " + totalArea);
        for (Drawable drawable : drawableList) {
            System.out.println(drawable.howToDraw());
        }
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return false;
            }
        }
        return true;
    }
}

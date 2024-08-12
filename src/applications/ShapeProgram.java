package applications;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        List<Shape> shapes = new ArrayList<Shape>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Shape #" + i + " data: ");
            System.out.print(" RectangleorCircle(r/c)?");
            char choice = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED):");
            Color color = Color.valueOf(sc.next());
            if (choice == 'r') {
                System.out.print("Width: ");
                double widht = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                shapes.add (new Rectangle(color, widht, height));
            } else if (choice == 'c') {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
               shapes.add (new Circle(color, radius));
            }


        }

        System.out.println();
        System.out.println("SHAPE AREAS");
        for (Shape s : shapes) {
            System.out.println(String.format("%.2f", s.area()));
        }


        sc.close();
    }
}

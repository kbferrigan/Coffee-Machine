import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int length = scanner.nextInt(); 

        // creating an instance
        GeometricCuboid cuboid = new GeometricCuboid(width,height,length);

        System.out.println(cuboid.toString());

    }
}

public class Test {

    public static final String DEFAULT_APPLICATION_NAME = "MyDemoApp";
    public static final int MAX_IMAGE_SIZE_KB = 4096;

    public static String hello = "Hello"; // (1)

    public static void main(String args[]) {

        System.out.println(DEFAULT_APPLICATION_NAME); // (2)

        MAX_IMAGE_SIZE_KB = 2048; // (3)

        printHello(); // (4)
    }

    private void printHello() {
        System.out.println(hello); // (5)
    }
}
class GeometricCuboid {
    private int width;
    private int height;
    private int length;

    public GeometricCuboid(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cuboid(" +
                "w=" + width +
                ", h=" + height +
                ", l=" + length + ')';
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FedEx1 {

    public static void main(String[] args) throws FileNotFoundException {

        // Creating File Object for the given file.
        File file = new File("info.txt");
        // Creating Scanner to read the file, passing file object as input.
        Scanner in = new Scanner(file);

        // Reading the first line which contains all lengths
        String lengthsString = in.nextLine();
        // Splitting the line by space(" ") , to get an array of all the values in file.
        String boxLengths[] = lengthsString.split(" ");
        // create variable n for the number of boxes
        int n = boxLengths.length;

        // Since the array was split into strings, conversion to double type needed.
        double Lengths[] = new double[n];
        for (int i = 0; i < n; i++) {
            Lengths[i] = Double.parseDouble(boxLengths[i]);
        }

        // Same process for widths and heights.
        String widthsString = in.nextLine();
        String boxWidths[] = widthsString.split(" ");

        double Widths[] = new double[n];
        for (int i = 0; i < n; i++) {
            Widths[i] = Double.parseDouble(boxWidths[i]);
        }

        String heightsString = in.nextLine();
        String boxHeights[] = heightsString.split(" ");

        double Heights[] = new double[n];
        for (int i = 0; i < n; i++) {
            Heights[i] = Double.parseDouble(boxHeights[i]);
        }

        //  call the methods/functions.
        System.out.println("Number of boxes : " + n);
        getVolumeForEachBox(Lengths, Widths, Heights);
        System.out.println();
        getTotalVolume(Lengths, Widths, Heights);
        System.out.println();
        showLargestBoxData(Lengths, Widths, Heights);
        System.out.println();
        showSmallestBoxData(Lengths, Widths, Heights);

        in.close();
    }

    // Prints volume of each box.
    public static void getVolumeForEachBox(double[] l, double[] w, double[] h) {
        int numBoxes = l.length;
    //iterating through array to calculate and display volume
        for (int i = 0; i < numBoxes; i++) {
            double volume = l[i] * w[i] * h[i];

            System.out.println("Volume of box " + (i + 1) + " is " + volume);
        }
    }

    // Prints the sum of total volume for all the boxes.
    public static void getTotalVolume(double[] l, double[] w, double[] h) {

        int numBoxes = l.length;
        double totalVolume = 0;

        for (int i = 0; i < numBoxes; i++) {
            double volume = l[i] * w[i] * h[i];
            totalVolume += volume;
        }

        System.out.println("Volume Total: " + totalVolume);
    }

    // Prints length width and height for the box with largest volume.
    public static void showLargestBoxData(double[] l, double[] w, double[] h) {

        int numBoxes = l.length;
        // Setting maxVolume to be -1,
        //any box with non-negative volume, will be more than this.
        double maxVolume = -1;
//        System.out.println(maxVolume);
        double maxlength = 0;
        double maxwidth = 0;
        double maxheight = 0;

        for (int i = 0; i < numBoxes; i++) {
            double volume = l[i] * w[i] * h[i];
            // If the volume of this box is greater than the current max volume value will be replaced
            if (volume > maxVolume) {
                maxVolume = volume;
                maxlength = l[i];
                maxwidth = w[i];
                maxheight = h[i];
            }

        }
        System.out.println("Dimensions of Biggest Box");
        System.out.println("Volume of the biggest box is = " + maxVolume);
        System.out.println("Length of the biggest box is = " + maxlength);
        System.out.println("Width of the biggest box is = " + maxwidth);
        System.out.println("Height of the biggest box is = " + maxheight);
    }

    // Print length width and height for the box with the smallest volume.
    public static void showSmallestBoxData(double[] l, double[] w, double[] h) {

        int numBoxes = l.length;
        // Setting minVolume to be max double,
        //box volumes will be less than this.
        double minVolume = Double.MAX_VALUE;
        double minlength = 0;
        double minwidth = 0;
        double minheight = 0;

        for (int i = 0; i < numBoxes; i++) {
            double volume = l[i] * w[i] * h[i];
            // If the volume of this box is less than the current min volume, value will be replaced.
            if (volume < minVolume) {
                minVolume = volume;
                minlength = l[i];
                minwidth = w[i];
                minheight = h[i];
            }
        }
        System.out.println("Dimensions of Smallest Box");
        System.out.println("Volume of the smallest box is = " + minVolume);
        System.out.println("Length of the smallest box is = " + minlength);
        System.out.println("Width of the smallest box is = " + minwidth);
        System.out.println("Height of the smallest box is = " + minheight);
    }

}

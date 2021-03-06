import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;

	public class FedEx2 {

	    public static void main(String[] args) throws FileNotFoundException {

	        // Creating File Object for the given file.
	        File file = new File("info.txt");
	        // Creating Scanner to read the file, passing file object as input.
	        Scanner in = new Scanner(file);

	        // Reading the first line which will contain all lengths
	        String lengthsString = in.nextLine();
	        // Splitting the line by space (" ") , to create an array for all the values.
	        String boxLengths[] = lengthsString.split(" ");
	        // creating variable n for the Number of boxes
	        int n = boxLengths.length;

	        //  Number of rows will be 3, columns will be n.
	        double[][] boxes = new double[3][n];

	        // Since the array was split into strings,conversion to double type is needed.
	        // Adding all the lengths at row 0, so that will be fixed.
	        for (int i = 0; i < n; i++) {
	            boxes[0][i] = Double.parseDouble(boxLengths[i]);
	        }

	        // Same process as widths and heights.
	        // For widths, it would be row with index 1 
	        // and for heights it would be row with index 2.
	        String widthsString = in.nextLine();
	        String boxWidths[] = widthsString.split(" ");

	        for (int i = 0; i < n; i++) {
	            boxes[1][i] = Double.parseDouble(boxWidths[i]);
	        }

	        String heightsString = in.nextLine();
	        String boxHeights[] = heightsString.split(" ");

	        for (int i = 0; i < n; i++) {
	            boxes[2][i] = Double.parseDouble(boxHeights[i]);
	        }

	        //call the methods/functions.
	        System.out.println("Number of boxes : " + n);
	        getVolumeForEachBox(boxes);
	        System.out.println();
	        getTotalVolume(boxes);
	        System.out.println();
	        showLargestBoxData(boxes);
	        System.out.println();
	        showSmallestBoxData(boxes);

	        in.close(); //closing scanner
	    }

	    // Prints volume of each box.
	    public static void getVolumeForEachBox(double[][] boxes) {
	        // Number of boxes would be the length of entries for the entire row
	        int numBoxes = boxes[0].length;

	        for (int i = 0; i < numBoxes; i++) {
	            // create volume variable length would be at row 0, width row 01 and height in row 02
	            double volume = boxes[0][i] * boxes[1][i] * boxes[2][i];

	            System.out.println("Volume of box " + (i + 1) + " is " + volume);
	        }
	    }

	    // Prints the sum of volume of all the boxes.
	    public static void getTotalVolume(double[][] boxes) {

	        int numBoxes = boxes[0].length;
	        double totalVolume = 0;

	        for (int i = 0; i < numBoxes; i++) {
	            double volume = boxes[0][i] * boxes[1][i] * boxes[2][i];
	            totalVolume += volume;
	        }

	        System.out.println("Volume Total: " + totalVolume);
	    }

	    // Prints Length, width and height for the box with largest volume.
	    public static void showLargestBoxData(double[][] boxes) {

	        int numBoxes = boxes[0].length;
	        // Setting maxVolume to be -1, 
	        //any box with non-negative volume, it will be more than this.
	        double maxVolume = -1;
	        double maxlength = 0;
	        double maxwidth = 0;
	        double maxheight = 0;

	        for (int i = 0; i < numBoxes; i++) {
	            double volume = boxes[0][i] * boxes[1][i] * boxes[2][i];
	            // If the volume of this box is greater than the current max volume, value will be replaced
	            if (volume > maxVolume) {
	                maxVolume = volume;
	                maxlength = boxes[0][i];
	                maxwidth = boxes[1][i];
	                maxheight = boxes[2][i];
	            }

	        }
	        System.out.println("Dimensions of Biggest Box");
	        System.out.println("Length of the biggest box is = " + maxlength);
	        System.out.println("Width of the biggest box is = " + maxwidth);
	        System.out.println("Height of the biggest box is = " + maxheight);
	    }

	    // Prints length width and height of smallest box volume
	    public static void showSmallestBoxData(double[][] boxes) {

	        int numBoxes = boxes[0].length;
	        // Setting minVolume to be max double,
	        //box volumes will be less than this.
	        double minVolume = Double.MAX_VALUE;
	        double minlength = 0;
	        double minwidth = 0;
	        double minheight = 0;

	        for (int i = 0; i < numBoxes; i++) {
	            double volume = boxes[0][i] * boxes[1][i] * boxes[2][i];
	            // If the volume of this box is less than the current min volume, value will be replaced
	            if (volume < minVolume) {
	                minVolume = volume;
	                minlength = boxes[0][i];
	                minwidth = boxes[1][i];
	                minheight = boxes[2][i];
	            }
	        }
	        System.out.println("Dimensions of Smallest Box");
	        System.out.println("Length of the smallest box is = " + minlength);
	        System.out.println("Width of the smallest box is = " + minwidth);
	        System.out.println("Height of the smallest box is = " + minheight);
	    }

	}




public class FedEx02first {
	
	public static void main(String[] args){
		
		
//		getTotalVolume(null);
//		getVolumeForEachBox(null);
//		showLargestBoxData( null);
		showSmallestBoxData(null);
		
		
	}

	public static void getVolumeForEachBox( double[][]b){
	   double [][] boxes = { {2.0, 1.0, 2.0, 3.0}, 
	                {3.0, 2.0, 1.0, 5.0}, 
	                {3.0, 5.0, 6.0, 1.0} };
	   double sum=0;
	   double volume=0;
		for(int i=0;i< boxes[0].length;i++) {
        	volume = boxes[0][i];

        	for( int j= 1; j< (boxes[0].length - 1); j++){
        	volume = volume*boxes[j][i];
        	}

        	System.out.println("Volume of box " + "is " + volume);
        	sum += volume;
       }
		
		
	}
	public static void getTotalVolume( double[][] b){
        double [][] boxes = { {2.0, 1.0, 2.0, 3.0}, 
                {3.0, 2.0, 1.0, 5.0}, 
                {3.0, 5.0, 6.0, 1.0} };

        double sum=0;
        
        double volume=0;

        for(int i=0;i< boxes[0].length;i++) {
        	volume = boxes[0][i];

        	for( int j= 1; j< (boxes[0].length - 1); j++){
        	volume = volume*boxes[j][i];
        	}       	
        	sum += volume;
       }
        
        System.out.println("Volume Total: " + sum);
		
		

	}
		
	
	
	public static void showLargestBoxData( double[][]b){
		double [][] boxes = { {2.0, 1.0, 2.0, 3.0}, 
                				{3.0, 2.0, 1.0, 4.0}, 
                					{3.0, 5.0, 6.0, 1.0} };


		double volume=0;
		double BiggestBox =1;
        double length = 0;
        double width = 0;
        double height = 0;

		for(int i=0;i< boxes[0].length;i++) {
			volume = boxes[0][i];

			for( int j= 1; j< (boxes[0].length - 1); j++){

				volume = volume*boxes[j][i];
				
		
				if(volume > BiggestBox){
					BiggestBox=volume;
					length = boxes[0][i];
					width = boxes[1][i];
					height = boxes[2][i];
			}
		}
		
			}
		
		   System.out.println("length of the biggest box is = "   + length);
	       System.out.println("width of the biggest box is = "   + width);
	       System.out.println("height of the biggest box is = "   + height);
		
	}
	
	public static void showSmallestBoxData( double[][]b){
	
		double [][] boxes = { {2.0, 1.0, 2.0, 3.0}, 
                			  {3.0, 2.0, 1.0, 4.0}, 
                			  {3.0, 5.0, 6.0, 1.0} };


		double volume=0;
//		double BiggestBox =1;
//		double SmallestBox=boxes[0][0];
        double length = 0;
        double width = 0;
        double height = 0;

		for(int i=0;i< boxes[0].length;i++) {
			

		
			volume = boxes[0][i];
			double SmallestBox= volume;
//			System.out.println("Smallnumber1 " + SmallestBox);

			for( int j= 1; j< (boxes[0].length - 1); j++){
			
				volume = volume*boxes[j][i];
				SmallestBox++;

				System.out.println("Small " + SmallestBox);
//				
				if(SmallestBox < volume){
					SmallestBox=volume;
					length = boxes[0][j];
					width = boxes[1][j];
					height = boxes[2][j];
			}
		}
		
			}
		
		   System.out.println("length of the smallest box is = "   + length);
	       System.out.println("width of the smallest box is = "   + width);
	       System.out.println("height of the smallest box is = "   + height);
////		
		
		
	}


}

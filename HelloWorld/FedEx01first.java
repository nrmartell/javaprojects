
public class FedEx01first {
	double [] length = new double [3];
	double [] width;
	double [] height;
public static void main(String[] args){
		
		
//		getTotalVolume();
//		getVolumeForEachBox();
//		showLargestBoxData( null);
//		showSmallestBoxData();
		
		
	}
	

	
	public static void getVolumeForEachBox( double[]l, double[]w, double []h){
		  double  BoxLength [] = {2.0, 1.0, 2.0, 3.0};
		  double BoxWidth [] =  {3.0, 2.0, 1.0, 5.0};
		  double  BoxHeight[] = {3.0, 5.0, 6.0, 1.0};
			
	      double volume=0;
				
				for(int i=0;i< BoxLength.length;i++) {
		        	volume = BoxLength[i]*BoxWidth[i]*BoxHeight[i];

		          	System.out.println("Volume of box " + i + " is " + volume);


		}
		
		
	}
	
	public static void getTotalVolume(){
		double  BoxLength [] = {2.0, 1.0, 2.0, 3.0};
		  double BoxWidth [] =  {3.0, 2.0, 1.0, 5.0};
		  double  BoxHeight[] = {3.0, 5.0, 6.0, 1.0};
			
	      double volume=0;
	      double sum=0;
	      
				for(int i=0;i< BoxLength.length;i++) {
		        	volume = BoxLength[i]*BoxWidth[i]*BoxHeight[i];
		        	sum += volume;
		          	System.out.println("Volume of box " + i + " is " + volume);
		          	

		}
				 System.out.println("Volume Total: " + sum);
		
	}
	
	public void showLargestBoxData( double[]l, double[]w, double []h){
		  double  BoxLength [] = {2.0, 1.0, 2.0, 3.0};
		  double BoxWidth [] =  {3.0, 2.0, 1.0, 7.0};
		  double  BoxHeight[] = {3.0, 5.0, 14.0, 1.0};
		  double volume=0;
		  double BiggestBox =1;
		  double length = 0;
		  double width = 0;
		  double height = 0;
				
		for(int i=0;i< BoxLength.length;i++) {
			volume = BoxLength[i]*BoxWidth[i]*BoxHeight[i];

			if(volume > BiggestBox){
				BiggestBox=volume;
				length = BoxLength[i];
				width = BoxWidth[i];
				height = BoxHeight[i];
							
							
			}	          	

		}

		System.out.println("length of the biggest box is = "   + length);
		System.out.println("width of the biggest box is = "   + width);
	    System.out.println("height of the biggest box is = "   + height);
		
		
	}
	
	public static void showSmallestBoxData( ){
		  double  BoxLength [] = {2.0, 1.0, 2.0, 3.0};
		  double BoxWidth [] =  {3.0, 2.0, 1.0, 1.0};
		  double  BoxHeight[] = {3.0, 5.0, 4.0, 2.0};
		  double volume=0;
		  double length = 0;
		  double width = 0;
		  double height = 0;
		  double SmallestBox = BoxLength[0]*BoxWidth[0]*BoxHeight[0];	
		
		  for(int i=0;i< BoxLength.length;i++) {
			
			volume = BoxLength[i]*BoxWidth[i]*BoxHeight[i];
			
			SmallestBox--;
			
			if( SmallestBox > volume){
				SmallestBox=volume;
				length = BoxLength[i];
				width = BoxWidth[i];
				height = BoxHeight[i];				
			}


		}

		System.out.println("length of the smallest box is = "   + length);
		System.out.println("width of the smallest box is = "   + width);
	    System.out.println("height of the smallest box is = "   + height);
		
		
	}
	
		
		
}

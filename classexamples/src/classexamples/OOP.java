package classexamples;

public class OOP {
	private int RAM;
	private String Brand;
	private double processor;
	private int HDSpace;
	private boolean desktop;
	
	// 5 setters and getters
	public OOP(){
		RAM = 8;
		
		
	}
	
	public OOP(int RAM){
		this.RAM = RAM;
	}
	
	public void setRAM(int RAM){
		 this.RAM = RAM;
	}
	
	public int setRAM(){
		return this.RAM;
	}

}

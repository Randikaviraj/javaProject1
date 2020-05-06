import java.lang.Math; 

public interface FractalInterface{ //make a interface for implements through julia and mandlebrot
	private double[] powComplex(double x,double y){ //a private method to get the power of complex number
		double number1=x*x-(y*y);
		double number2=2*x*y;
		return new double[] {number1, number2};
	}

	default  boolean iterateCalculation(double x,double y,double cx,double cy,int noofits){ //default method to call from sub classes
		
		double result[];
		for(int i=0;i<noofits;i++){
			result=powComplex(x,y);
			if((Math.pow(result[0], 2)+Math.pow(result[1], 2))>16){return true;}
			x=result[0]+cx;
			y=result[1]+cy;
		}
		return false;
	}
	 public boolean fractalCalculation(int x,int y); //abstract method to override through dub classes
	
}
public  class Mandelbrot implements FractalInterface{ //Sub class Mandelbrot which implements FractalInterface
	private static double x=0d;
	private static double y=0d;
	private ValueZ temp;

	public Mandelbrot(){ //constrctor overloading
		temp=new ValueZ();
	}

	public Mandelbrot(double xrgnmax,double xrgnmin,double yrgnmax,double yrgnmin){ //constrctor overloading
		temp=new ValueZ(xrgnmax,xrgnmin,yrgnmax,yrgnmin);
	}



	public boolean fractalCalculation(int x,int y){ //overeride abstract method of FractalInterface
		
		double xx=temp.getRealPart(x);
		double yy=temp.getImaginPart(y) ;
		boolean result=iterateCalculation(Mandelbrot.x,Mandelbrot.y,xx,yy,1000);
		return result;
	}


	

	public boolean fractalCalculation(int x,int y,int noofits){ //overloading fractalCalculation method
		//ValueZ temp=new ValueZ(x,y,xrgnmax,xrgnmin,yrgnmax,yrgnmin);
		double xx=temp.getRealPart(x);
		double yy=temp.getImaginPart(y) ;
		boolean result=iterateCalculation(Mandelbrot.x,Mandelbrot.y,xx,yy,noofits);
		return result;
	}

}
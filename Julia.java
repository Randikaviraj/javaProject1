public class  Julia implements FractalInterface{ //A sub class julia which implements FractalInterface
	private double cx,cy;
	private int noofits;
	private ValueZ temp;

	public Julia(){ //construtor overloading
		this.cx=-0.4;
		this.cy=0.6;
		this.noofits=1000;
		temp=new ValueZ();
	}

	public Julia(double cx,double cy){ //construtor overloading
		this.cx=cx;
		this.cy=cy;
		this.noofits=1000;
		temp=new ValueZ();
	}

	public Julia(double cx,double cy,int noofits){//construtor overloading
		this.cx=cx;
		this.cy=cy;
		this.noofits=noofits;
		temp=new ValueZ();
	}

	
	
	public boolean fractalCalculation(int x,int y){ //override the abstract method fractalCalculation in interface
		
		double xx=temp.getRealPart(x);
		double yy=temp.getImaginPart(y);
		boolean result=iterateCalculation(xx,yy,this.cx,this.cy,this.noofits);
		return result;
	}



}
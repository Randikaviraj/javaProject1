public class ValueZ{ //A class for mapping points to the range complex values
	private double x,y,xrgnmax,xrgnmin,yrgnmax,yrgnmin;
	private static int width;
	private static int height;

	ValueZ(){ //constructor over loading
		
		this.xrgnmax=1d;
		this.xrgnmin=-1d;
		this.yrgnmax=1d;
		this.yrgnmin=-1d;
	}

	ValueZ(double xrgnmax,double xrgnmin,double yrgnmax,double yrgnmin){ //constructor over loading
		
		this.xrgnmax=xrgnmax;
		this.xrgnmin=xrgnmin;
		this.yrgnmax=yrgnmax;
		this.yrgnmin=yrgnmin;
	}

	public static void setWidth(int width){ //static setters for set width and height
		ValueZ.width=width;
	}

	public static void setHeight(int height){
		ValueZ.height=height;
	}

	public double getRealPart(int x){ //get the mapped real part of a point
		this.x=(double)x;
		if(this.x==ValueZ.width/2){
			return 0d;
		}
		else if(this.x<ValueZ.width/2){
			return (((ValueZ.width/2-this.x)*this.xrgnmin)/(width/2));
		}else{
			return(((this.x-ValueZ.width/2)*this.xrgnmax)/(width/2));
		}

	}

	public double getImaginPart(int y){ //get the mapped imaginary part of a point
		this.y=(double)y;
		if(this.y==ValueZ.width/2){
			return 0d;
		}
		else if(this.y<ValueZ.width/2){
			return (((ValueZ.width/2-this.y)*this.yrgnmin)/(width/2));
		}else{
			return(((this.y-ValueZ.width/2)*this.yrgnmax)/(width/2));
		}

	}
}
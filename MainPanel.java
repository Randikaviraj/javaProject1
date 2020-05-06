import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;


public class  MainPanel extends JPanel{ //extends to Jpanel class

	private int width, height;
	private String[] args; 
     

    public MainPanel(int width, int height,String[] args) { 
    ValueZ.setWidth(width); //set valuez class height width
    ValueZ.setHeight(height);
	// set the panel size 
	this.width  = width; 
	this.height = height;
	this.args=args; 
	setPreferredSize(new Dimension(width, height)); 
    }







    private static void printJulia(Julia instance,int width,int height,Graphics g){
    	boolean value;
    	for(int i=0;i<=width;i++){
	    		for (int j=0;j<=height;j++ ) {
	    			value=instance.fractalCalculation(i,j);
	    			if(value){printPoint((Graphics2D)g, Color.BLACK, i,j);}
	    		}
    		}
    }






    private static void handleJulia(String [] args,int width,int height,Graphics g){
    	int length=args.length;
    	if(length==1){
    		Julia instance=new Julia();
    		printJulia(instance,width,height,g);
    		
    	}else if (length==3) {
    		Julia instance=new Julia(Double.parseDouble(args[1]),Double.parseDouble(args[2]));
    		printJulia(instance,width,height,g);
    		
    	}else{
    		
    		Julia instance=new Julia(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Integer.parseInt(args[3]));
    		printJulia(instance,width,height,g);

    	}
    }








    private static void handleMandelbrot(String [] args,int width,int height,Graphics g){
    	int length=args.length;
    	Mandelbrot instance;
    	if(length==1){
    		instance=new Mandelbrot();
    	}else{
    		instance=new Mandelbrot(Double.parseDouble(args[2]),Double.parseDouble(args[1]),Double.parseDouble(args[4]),Double.parseDouble(args[3]));
    	}
    	
    	
    	boolean value;
    	for(int i=0;i<=width;i++){
	    		for (int j=0;j<=height;j++ ) {
	    			if(length==6){
    					value=instance.fractalCalculation(i,j,Integer.parseInt(args[5]));
    				}else{
    					value=instance.fractalCalculation(i,j);
    		
    				}

	    			if(value){printPoint((Graphics2D)g, Color.BLACK, i,j);}
	    		}
    		}
    }







    private static void printPoint(Graphics2D frame, Color c,int x,int y) { //printin point method

	frame.setColor(c); 
	frame.draw(new Line2D.Double(x, y,x, y)); 
    }






  public void paintComponent(Graphics g) { 
	// call paintComponent from parent class 
	super.paintComponent(g); 

	switch(args[0]){
		case "Julia":
			switch(this.args.length){
	    		case 1:
	    			handleJulia(this.args,this.width,this.height,g);
	    			break;
	    		case 3:
	    			handleJulia(this.args,this.width,this.height,g);
	    			break;
	    		case 4:
	    			handleJulia(this.args,this.width,this.height,g);
	    			break;
    		}
			
			break;
		case "Mandelbrot":
			switch(this.args.length){
	    		case 1:
	    			handleMandelbrot(this.args,this.width,this.height,g);
	    			break;
	    		case 5:
	    			handleMandelbrot(this.args,this.width,this.height,g);
	    			break;
	    		case 6:
	    			handleMandelbrot(this.args,this.width,this.height,g);
	    			break;
    		}

			
	 }
   }


    
}
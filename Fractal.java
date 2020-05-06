import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;

class Fractal extends Thread{ //extends to thread class
	public String [] args;

	public Fractal(String [] args){
		this.args=args;
	}
	
	public void run(){ //override run method in thread class
		// create a frame
		JFrame frame = new JFrame("Fractal"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		// set the content of the frame as one of this panel
		frame.setContentPane(new MainPanel(800, 800,this.args)); 

		frame.pack(); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); 
	}


	public static void main(String [] args) {
		Fractal ref;

		int len=args.length;
    	if(len==0){
    		System.out.println("Error enter Julia or Mandelbrot as arguments ");
    		return;	
    	}

    	if(args[0].equals("Julia")){ //compare args and select weather julia or mandelbrot
    		
    		if(len!=1 && len!=3 && len!=4 && len!=5 && len!=6){
    		System.out.println("Error enter correct number of arguments {Fractal Julia cx cy} ");
    		return;
    		}

    		ref=new Fractal(args); //create objeact of Fractal class wich is a sub class of Thread
			ref.start();//call the start function od Fractal which is inherit and open a new thread through main thread
    	}
    	else if (args[0].equals("Mandelbrot")) {

    		if(len!=1 && len!=5 && len!=6){
    		System.out.println("Error enter correct number of arguments {Fractal Mandelbrot arguments}");
    		return;
    		}

    		ref=new Fractal(args); //create objeact of Fractal class wich is a sub class of Thread
			ref.start(); //call the start function od Fractal which is inherit and open a new thread through main thread
    	}
    	else{
    		System.out.println("Error enter Julia or Mandelbrot as arguments ");
    		return;
    	}
    	
		
    }
}
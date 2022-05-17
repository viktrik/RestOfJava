import java.awt.Color;

import graphics.Canvas;

public class Program {
    // Canvas GUI instance providing the drawing area on which to plot the functions
    private static Canvas canvas;

    public static void main(String[] args) {
        
        // Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240] then 
        // open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX, pY) coords
        canvas = new Canvas();
        canvas.setRange(-360, -240, 360, 240);
        canvas.open();

        // Draw a short red diagonal on the canvas
        canvas.pause();
        canvas.setColor(Color.red);
        

        
       
        MyFunction sin = new MyFunction() {
        	public int calcY(int x) {
        		return (int)(200 * Math.sin(Math.PI * x/360));
        	}
        	
        	public Color getColor() {
        		return Color.MAGENTA;
        	}
        };
        
        MyFunction quadratic = new MyFunction() {
        	public int calcY(int x) {
        		return (int)((x-200) * (x + 200) / (250));
        	}
        	
        	public Color getColor() {
        		return Color.MAGENTA;
        	}
        };
        
        MyFunction log = new MyFunction() {
        	public int calcY(int x) {
        		return (int)(20 * Math.log(x));
        	}
        	
        	public Color getColor() {
        		return Color.MAGENTA;
        	}
        };
        
        MyFunction cubic = new MyFunction() {
        	public int calcY(int x) {
        		return (int)((Math.pow(x,  3) / 200000));
        	}
        	
        	public Color getColor() {
        		return Color.MAGENTA;
        	}
        };
        
        MyFunction stepFunction = new MyFunction() {
        	public int calcY(int x) {
        		return (x < -100) ? (-100) : (x > 100 ? (100) : (x));
        	}
        	
        	public Color getColor() {
        		return Color.MAGENTA;
        	}
        };
        
        
        
        plotFunctions(sin, quadratic, log, cubic, stepFunction);
        
        // Pause and close the canvas then terminate the program.
        canvas.pause();
        canvas.close();
        }
    
    public static void plotFunctions(MyFunction... x) {
    	for (int y = 0; y < x.length; y++) {
    		canvas.setColor(x[y].getColor());
    		for (int i = -360; i < 360; i++) {
    			canvas.plot(i,  x[y].calcY(i));
    		}
    	}
    }
}

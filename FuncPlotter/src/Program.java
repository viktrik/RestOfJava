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
        MyFunction fSin = (i)->{return (int)(200 * Math.sin(Math.PI * i/360));};
        MyFunction quadratic = (i)->{return (int)((i-200) * (i + 200) / (250));};
        MyFunction log = (i) -> {return (int) (20 * Math.log(i));};
        MyFunction cubic = (i) -> {return (int) ((Math.pow(i,  3) / 200000));};
        
        plotFunctions(fSin);
        plotFunctions(quadratic);
        plotFunctions(log);
        plotFunctions(cubic);
        // Pause and close the canvas then terminate the program.
        canvas.pause();
        canvas.close();
        }
    
    public static void plotFunctions(MyFunction x) {
    	for (int i = -360; i < 360; i++) {
    		canvas.plot(i,  x.calcY(i));
    	}
    }
}

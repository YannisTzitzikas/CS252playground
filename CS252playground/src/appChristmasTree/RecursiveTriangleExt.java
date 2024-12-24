package appChristmasTree;
/**
 * Author: Yannis Tzitzikas (http://www.ics.forth.gr)
 * Creation Date: Dec 23, 2015
 * Last update: Dec 2024
 */

import java.awt.Color;
import java.io.*;


import javax.swing.JOptionPane;



 class ChristmasTree {
	 static int N = 900; // canvas size
	 static Picture pic = new Picture(N, N);  // new picture object
	 static Pixel[][] pixels; // array for holding the pixels
	 static int MIN_RADIUS = 2 ; // gia tis xristougenniatikes mpales
	 static int MAX_RADIUS = 30; // gia tis xristougenniatikes mpales
	 
	 public static void StartRecursion(int N, Color col){
         recursiveTriangle(pixels[(N/2)-1][N-1],pixels[0][0],pixels[N-1][0], col);
    }
	 
	 

	 /* 
	Recursive fractal-like triangle.
	Params: three pixels (standing for the 3 corners of the triangle), color
	p1: upper point
	p2: leftmost point
	p3: rightmost point
	It divides the triangle to 3 other triangles, and it recursively calls itself for each one
    */
    private static void recursiveTriangle(Pixel p1,Pixel p2,Pixel p3, Color col){
    	if(p2.getX()+2>=p3.getX()) // stopping the recursion if the triangle is too small
			return;
        
    	//Colors three pixels: the three corners of the triangle
        //(p1+p2)/2
        pixels[(p1.getX()+p2.getX())/2][(p1.getY()+p2.getY())/2].setColor(col);
        //(p3+p2)/2
        pixels[(p3.getX()+p2.getX())/2][(p3.getY()+p2.getY())/2].setColor(col);
        //(p3+p1)/2
        pixels[(p3.getX()+p1.getX())/2][(p3.getY()+p1.getY())/2].setColor(col);
        
        /*
        // snow
        int Xsnow = (int) ((p1.getX()+p2.getX()+p3.getX())/3.2);
        int Ysnow = (int) ((p1.getY()+p3.getY()+p2.getY())/3.4);
        for (int k=0;k<12;k++)
        	  pixels[(Xsnow-k>0)?Xsnow-k:0][(Ysnow-k>0)?Ysnow-k:0].setColor(Color.yellow);
        */
        
        
        // drawing a circle (Christmas ball)
        if (Math.random() < 0.2) { // for not placing balls everywhere
	        int tmpRadius = p3.getX()    - p2.getX();
	        int centerX =  (p2.getX()+p3.getX())/2;
	        int centerY = (p1.getY()+p2.getY())/2;
	        Color c;
	        double randVal = Math.random();
	        if (randVal<0.4) 
	        	c = Color.red;
	        else if ((randVal>= 0.4) &&  (randVal<0.6))
	        	c = Color.GREEN;
	        else
	        	c = Color.blue;
	       	setPixelsCircle(tmpRadius,  centerX, centerY, c);
        } 
        
        // snowflakes
        // drawing a circle (Christmas ball)
        if (Math.random() < 0.2) { // for not placing snow everywhere
	        int tmpRadius = 6; // p3.getX()    - p2.getX();
	        int centerX =  (p2.getX()+p3.getX())/2;
	        int centerY = (p1.getY()+p2.getY())/2;
	        Color c=Color.white;
	        setPixelsCircle(tmpRadius,  centerX, centerY, c);
        }
        
        // recursive calls
        recursiveTriangle(  pixels[(p1.getX()+p2.getX())/2][(p1.getY()+p2.getY())/2],
                    pixels[p2.getX()][p2.getY()],
                    pixels[(p3.getX()+p2.getX())/2][(p3.getY()+p2.getY())/2],
                    col);
        
        recursiveTriangle(  pixels[p1.getX()][p1.getY()],
                    pixels[(p1.getX()+p2.getX())/2][(p1.getY()+p2.getY())/2],
                    pixels[(p1.getX()+p3.getX())/2][(p1.getY()+p3.getY())/2],
                    col);
        
        
        recursiveTriangle(  pixels[(p1.getX()+p3.getX())/2][(p1.getY()+p3.getY())/2],
                    pixels[(p3.getX()+p2.getX())/2][(p3.getY()+p2.getY())/2],
                    pixels[p3.getX()][p3.getY()],
                    col);
           
    }
   
    
    // creation of the pixel objects, assigning to them the same color
    public static void setBackgroundPixels(int N, Color col){
        for(int i=0;i<N;i++)     {
            for(int j=0;j<N;j++)      {
                pixels[i][j]=new Pixel(i,j, col);
            }
        }
    }

    
    
    // params:  radius, centerx, centery, color
    public static void setPixelsCircle(int radius, int centerX, int centerY, Color col){ 
     double x;
     double y; 
     double numOfRings=3; // how many rings to use for drawing a ball
     int numOfInternalCircles=10;
     
     for (int h = 0; h<numOfInternalCircles; h++) {
    	 
      radius = radius - 4;
    	 
      if ((radius >= MIN_RADIUS) && (radius < MAX_RADIUS))  {
	  
    	for (int j=0;j<numOfRings;j++)   {
	    	for (int i=0; i<=360; i++){	
	    		x =  (centerX + ((radius-j)* Math.cos(Math.toRadians((int)i))));
	    		y =  centerY + ((radius-j)* Math.sin(Math.toRadians((int)i)));
	    		if (x>0 && y>0 && x<N && y<N) { // fits in canvas		    		
	    			pixels[Math.abs((int)x)][Math.abs((int)y)].setColor(col);	
	    		}	
	    	}
    	}
    	
     }
     } // internal 

   }
    
    
  //---------------------------------------------
 // just setting the pixels from the array and displaying
 //---------------------------------------------
   
    public static void displayPicture() {
    	for(int i=0;i<N;i++)  {
          for(int j=0; j<N; j++) { 
                pic.set(pixels[i][j]);
            }
    	}
        pic.show();
      }
    
    
    
   
    public static void main(String[] args) {
    	pic.setOriginLowerLeft();   // setting the space of coordinates
	    pixels=new Pixel[N][N]; // array for holding the pixels
	    for (int i=0; i<2000;i++) {
		    setBackgroundPixels(N, Color.black); // background color
		    StartRecursion(N, Color.YELLOW); // drawing the Christmas tree
		    displayPicture() ;
		    try {   Thread.sleep(150); } catch (Exception e ) { }
		    
	    }
    }  
   }


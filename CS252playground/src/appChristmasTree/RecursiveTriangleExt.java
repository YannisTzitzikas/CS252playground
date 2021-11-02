package appChristmasTree;
/**
 * Author: Yannis Tzitzikas (http://www.ics.forth.gr)
 * Date: Dec 23, 2015
 */

import java.awt.Color;
import java.io.*;


import javax.swing.JOptionPane;



 class ChristmasTree {
	 static int N = 800; // canvas size
	 static Picture pic = new Picture(N, N);  // new picture object
	 static Pixel[][] pixels; // array for holding the pixels
	 static int MIN_RADIUS = 10 ; // gia tis xristougenniatikes mpales
	 static int MAX_RADIUS = 20; // gia tis xristougenniatikes mpales
	 
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
        
        
        
        // drawing a circle
        if (Math.random() < 0.2) { // for not placing balls everywhere
	        int tmpRadius = p3.getX()    - p2.getX();
	        int centerX =  (p2.getX()+p3.getX())/2;
	        int centerY = (p1.getY()+p2.getY())/2;
	        Color c = Color.red;
	        if (Math.random() < 0.3) {  // for getting red and blue balls randomly
	        	c = Color.blue;
	        }
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
      if ((radius >= MIN_RADIUS) && (radius < MAX_RADIUS))  {

    	for (int i=0; i<=360; i++){	
    		x =  centerX + (radius* Math.cos(Math.toRadians((int)i)));
    		y =  centerY + (radius* Math.sin(Math.toRadians((int)i)));
    		if (x>0 && y>0 && x<N && y<N) { // fits in canvas		    		
    			pixels[Math.abs((int)x)][Math.abs((int)y)].setColor(col);	
    		}	
    	}	
     }
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
		    setBackgroundPixels(N, Color.white); // background color
		    StartRecursion(N, Color.green); // drawing the Christmas tree
		    displayPicture() ;
		    try {   Thread.sleep(500); } catch (Exception e ) { }
		    
	    }
    }  
   }


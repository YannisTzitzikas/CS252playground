package week11_InnerClasses;

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

class MainProg {
  JFrame win;

  public MainProg( String title ) {
    win = new JFrame( title );

    win.addWindowListener(
      new WindowAdapter() {
        public void windowClosing( WindowEvent e ) {
          System.exit( 0 );
	}});
    win.setVisible(true);
  }

  public static void main( String args[] ) {
	MainProg x = new MainProg("Simple Example");
    }
  }

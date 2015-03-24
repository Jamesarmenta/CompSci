import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author jarmenta
 *
 *A method to initiate the getRgbValue method
 *
 * @param args 
 *
 * @see http://stackoverflow.com/questions/10880083/get-rgb-of-a-bufferedimage
 * @see http://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
 */
public class FinalProject {

	public static void main(String[] args) throws Exception {
				getRgbValue();
    }
	
	/**
	 * A method that creates an array of RGB values in source image,
	 * selects a random pixel's RGB Value and sends to createAndShowGUI method
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void getRgbValue() throws Exception {

		//Read input image file
	    BufferedImage image = ImageIO.read(
	         new File("src/input.jpg"));

	    //Get width & height of image
	    int w = image.getWidth();
	    int h = image.getHeight();

	    //create array of RGB values in image
	    int[] dataBuffInt = image.getRGB(0, 0, w, h, null, 0, w); 
	    //startX the starting X coordinate
	    //startY the starting Y coordinate
	    //w width of region
	    //h height of region
	    //rgbArray if not null, the rgb pixels are written here
	    //offset offset into the rgbArray
	    //scansize scanline stride for the rgbArray
	    
	    //multiply width & height to get total number of pixels in image
	    int wxh = (w * h)-1;

	    
	    // GET RANDOM *******************************
	    Random rand = new Random();

		int  r = rand.nextInt(wxh); //r is random pixel selected from image
		//wxh is the maximum 
		

		Color c = new Color(dataBuffInt[r]);
	    
		//Extract RGB values from selected pixel in array
	    int randomRed = c.getRed();
	    int randomGreen = c.getGreen();
	    int randomBlue = c.getBlue();
	    
	    createAndShowGUI(randomRed, randomGreen, randomBlue, r);
	}

	/** 
	 * 
	 * A method that converts the selected RGB values to a triadic palette
	 * and applies those values to a JPanel GUI
	 * 
	 * @param randomRed
	 * @param randomGreen
	 * @param randomBlue
	 * @param r
	 * 
	 * @see https://docs.oracle.com/javase/tutorial/uiswing/layout/flow.html
	 * @see http://stackoverflow.com/questions/8248152/jframe-removing-jpanels-and-adding-a-new-jpanel
	 * @see http://stackoverflow.com/questions/1346978/java-using-an-actionlistener-to-call-a-function-in-another-class-on-an-object-f
	 * @see https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TopLevelDemoProject/src/components/TopLevelDemo.java
	  */
private static void createAndShowGUI(int randomRed, int randomGreen, int randomBlue, int r) {
		
        //Create and set up the window.
        final JFrame frame = new JFrame("Color Palette Maker");
        frame.setLayout(new FlowLayout());
        
        //Create the restart button
        JButton restartbutton  = new JButton("Resample");
        restartbutton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
            	try {
            		//On buttom click, close existing window and re-run method
					frame.dispose();
            		getRgbValue();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
          });

        
        //Create color panel 1
        JPanel colorPanel1 = new JPanel();
        int panel1Red = 255-randomGreen/4;//Triadic Formula
        int panel1Green = 255-randomRed/4;
        int panel1Blue = 255-randomBlue/4;
        colorPanel1.setBackground(new Color(panel1Red, panel1Green, panel1Blue));
        colorPanel1.setPreferredSize(new Dimension(150, 500));
        //Add RGB Value on Panel
        JLabel jlabel1 = new JLabel("RGB:" + panel1Red + "," + panel1Green + "," + panel1Blue);
        jlabel1.setFont(new Font("Verdana",1,11));
        colorPanel1.add(jlabel1);
        
        //Create color panel 2
        JPanel colorPanel2 = new JPanel();
        int panel2Red = 255-randomGreen/2;//Triadic Formula
        int panel2Green = 255-randomRed/2;
        int panel2Blue = 255-randomBlue/2;
        colorPanel2.setBackground(new Color(panel2Red, panel2Green, panel2Blue));
        colorPanel2.setPreferredSize(new Dimension(150, 500));
        //Add RGB Value on Panel
        JLabel jlabel2 = new JLabel("RGB:" + panel2Red + "," + panel2Green + "," + panel2Blue);
        jlabel2.setFont(new Font("Verdana",1,11));
        colorPanel2.add(jlabel2);
        
        //Create color panel 3
        JPanel colorPanel3 = new JPanel();
        int panel3Red = randomRed;
        int panel3Green = randomGreen;
        int panel3Blue = randomBlue;
        colorPanel3.setBackground(new Color(panel3Red, panel3Green, panel3Blue));
        colorPanel3.setPreferredSize(new Dimension(150, 500));
        //Add RGB Value on Panel
        JLabel jlabelsample = new JLabel("Sampled Color");
        //Display which pixel was selected
        JLabel jlabelpixel = new JLabel("Pixel #" + r);
        JLabel jlabel3 = new JLabel("RGB:" + panel3Red + "," + panel3Green + "," + panel3Blue);
        jlabel3.setFont(new Font("Verdana",1,11));
        jlabelpixel.setFont(new Font("Verdana",1,11));
        jlabelsample.setFont(new Font("Verdana",1,11));
        colorPanel3.add(jlabelsample);
        colorPanel3.add(jlabelpixel);
        colorPanel3.add(jlabel3);
        
        //Create color panel 4
        JPanel colorPanel4 = new JPanel();
        int panel4Red = 255-randomBlue/2;//Triadic Formula
        int panel4Green = 255-randomGreen/2;
        int panel4Blue = 255-randomRed/2;
        colorPanel4.setBackground(new Color(panel4Red, panel4Green, panel4Blue));
        colorPanel4.setPreferredSize(new Dimension(150, 500));
        //Add RGB Value on Panel
        JLabel jlabel4 = new JLabel("RGB:" + panel4Red + "," + panel4Green + "," + panel4Blue);
        jlabel4.setFont(new Font("Verdana",1,11));
        colorPanel4.add(jlabel4);
        
        //Create color panel 5
        JPanel colorPanel5 = new JPanel();
        int panel5Red = 255-randomBlue/4;//Triadic Formula
        int panel5Green = 255-randomGreen/4;
        int panel5Blue = 255-randomRed/4;
        colorPanel5.setBackground(new Color(panel5Red, panel5Green, panel5Blue));
        colorPanel5.setPreferredSize(new Dimension(150, 500));
        //Add RGB Value on Panel
        JLabel jlabel5 = new JLabel("RGB:" + panel5Red + "," + panel5Green + "," + panel5Blue);
        jlabel5.setFont(new Font("Verdana",1,11));
        colorPanel5.add(jlabel5);
        
        //Apply color panels and button to the content pane.
        frame.setLayout(new FlowLayout());
        frame.add(colorPanel1);
        frame.add(colorPanel2);
        frame.add(colorPanel3);
        frame.add(colorPanel4);
        frame.add(colorPanel5);
        frame.add(restartbutton);
        
        frame.setVisible(true);

        // optional, but nice to have.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}


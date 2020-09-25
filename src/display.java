
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class display extends JPanel {

private JFrame frame;	
String title;
JPanel canvas;
int width,height;
public display(String title,int width,int height){
	this.title=title;
	this.width=width;
	this.height=height;
	createdisplay();
}
private void createdisplay() {
	frame=new JFrame(title);
	frame.setSize(width,height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	this.setPreferredSize(new Dimension(width,height));
	this.setMaximumSize(new Dimension(width,height));
	this.setMinimumSize(new Dimension(width,height));
	frame.add(this);
	frame.dispose();

	frame.setVisible(true);
	frame.pack();
	
}
int t=1;
public void paintComponent(Graphics G){
	super.paintComponent(G);
	

}
public display getCanvas(){
	return this;
}
public JFrame getframe(){
	return frame;
}
public Graphics getgraphics(){
	return this.getGraphics();
}
}
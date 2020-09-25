import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class game  implements Runnable  {
	public static display affichage;
	private int height;
	car car1,car2;
	JPanel display;
	ArrayList<car> red_car=new ArrayList<car>();
	ArrayList<car> blue_car=new ArrayList<car>();
    String title;
	boolean running;
	private Thread t;
	BufferedImage image,redlight,orangelight,greenlight,carimg,car2img,carimg2,car2img2;
	private  Graphics G =null;
	private int width;
	
	
//constructor
public game(String title,int width,int height){		
		this.width=width; 
		this.height=height;
		this.title=title;
        init();
	}

// buttons creation	
void button(){
	JFrame d=affichage.getframe();
	JPanel buttons=new JPanel(new FlowLayout());
    JButton Start= new JButton("Start");
    JButton add_red= new JButton("Add Red Car");
    JButton add_blue= new JButton("Add blue Car"); 
    buttons.add(Start);
    buttons.add(add_red);
    buttons.add(add_blue);
    d.add(buttons, BorderLayout.SOUTH);
    
	add_red.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  create_red_car();
         } });
	
	add_blue.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  create_blue_car();
       } });
	
	Start.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
            Start();       } });
    

}
int i=0;
	protected void create_red_car() {
		if(i==0){
		car1=new car(508,10,G,carimg,affichage,i);
		car1.red_move();
		car1.threaddrow(G);
		red_car.add(car1);
		i=1;
		}else
		if(i==1){
			car1=new car(548,555,G,carimg2,affichage,i);
			car1.red_move();
			car1.threaddrow(G);
			red_car.add(car1);
			i=0;}	
}
	
	int i2=0;
	protected void create_blue_car() {
		if(i2==0){
		car2=new car(10,310,G,car2img,affichage,i2);
		car2.blue_move();
          car2.threaddrow2(G);
		blue_car.add(car2);
		i2=1;
		} else if(i2==1){
			car2=new car(1000,346,G,car2img2,affichage,i2);
			car2.blue_move();
	          car2.threaddrow2(G);
			blue_car.add(car2);
			i2=0;
			}
}

	
	void render() throws InterruptedException{
	G.drawImage(image,0,0,null);
	Thread.currentThread().sleep(40);
	}

	public void run() {
		L.drawlight_thread(G);
		L2.drawlight2_thread(G);
	
		while(running){
;
				try {
					render();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch blockmpool
					e.printStackTrace();
				}
		}
	}
	
	light L2,L;
	public void lightcreation(){
	L=new light(600,220);
	L2=new light(400,400);
//thread t1 
	 Thread t1 = new Thread(){
		    public void run(){
		        try {
					L.greenlight();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		    }
		};
		
		
		//thread 2
		 Thread t2 = new Thread(){
			    public void run(){
			    	
			    	try {
						L.RedLight();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();			}
			    }
			};
			
			//thread t3 
			 Thread t3 = new Thread(){
				    public void run(){
				        L2.draw_light_road2();		    }
				};
t1.start();
t2.start();
t3.start();	
	}
	
	
private void init() {  
	affichage=new display(title,width,height);
	button();
	image=ImageLoader.load("background.png");
    lightcreation();
	carimg=ImageLoader.load("car.png");
	car2img=ImageLoader.load("car2.png");
	carimg2=ImageLoader.load("Rcar.png");
	car2img2=ImageLoader.load("bcar2.png");
	display=affichage.getCanvas(); 
    G=affichage.getCanvas().getGraphics();
	}

public  void Start(){
	if(!running) running=true;
	//executer objet de class en thread
	t=new Thread(this);
	t.start();
	
	
	}

}
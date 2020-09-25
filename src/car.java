import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class car  {
public game d;
int X;
int Y;
display display;
private final Graphics G;
BufferedImage Car;
Thread red_thread;   
int sens;
Thread blue_thread;
boolean red_moving=true;boolean blue_moving=true;


public car(int x,int y, Graphics g, BufferedImage car, display affichage,int sens){
	this.display=affichage;
	this.X=x;
	this.Y=y;
	this.sens=sens;
	this.G=g;
	 Car = car;
}


void threaddrow(final Graphics G){
	 Thread t=new Thread(new Runnable(){
		public void run(){			
			draw(G);
		
		}	
	});
	t.start();
	t=null;
	
}

void threaddrow2(final Graphics G){
	Thread t=new Thread(new Runnable(){
		public void run(){
			draw2(G);
		}
		
	});
	t.start();
	t=null;
}
   void draw(Graphics F){
	   while(red_moving){
            	F.drawImage(Car,this.X,this.Y,40,40,null); 
              }    }   
   
   void draw2(Graphics G){	
		while(blue_moving){
					G.drawImage(Car,this.X,this.Y,40,40,null);            
		}	}
   
   
void red_move(){
	  red_thread = new Thread(new Runnable(){
		public void run() {	
         red_mouving();			
		}	
	});
	  red_thread.start();
	  red_thread=null;
}

protected void red_mouving() {
	while(this.Y< display.getHeight()+60){
		try {
			red_thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	if(light.state==4){
if(this.sens==0){
		if (this.Y<270&&this.Y>260){ 
		}else this.Y+=1;}
if(this.sens==1){
	if (this.Y<400 &&  this.Y>390){ 
	}else this.Y-=1;}
	}
	
if(light.state!=4){
	if(this.sens==0){
	this.Y+=1;}
	if(this.sens==1) this.Y-=1;
}	}
	red_thread=null;
	red_moving=false;

}


void blue_move(){
		  blue_thread = new Thread(new Runnable(){
			public void run() {
				
	   blue_mouving();			
			}
		});
		 blue_thread.start();
		 blue_thread=null;
	}

private	 void blue_mouving() {
		while(this.X<display.getWidth()+60){
			try {
				blue_thread.sleep(9);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		if(light.state!=4){
			if(this.sens==0){
			if (this.X<450&&this.X>440){ 
			}else this.X+=1;}
			else if (this.sens==1){
				if (this.X<620&this.X>610){ } else this.X-=1;
				
			}
		}
	if(light.state==4){
		if(this.sens==0){
		this.X+=1;}else
		if(this.sens==1){
            this.X-=1;
		}
	}	}
	blue_thread=null;
	blue_moving=false;
	try {
		this.finalize();
	} catch (Throwable e) {
		e.printStackTrace();
	}
	}
 





}

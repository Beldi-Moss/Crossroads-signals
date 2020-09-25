import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class light {
	public static volatile int state=4;
	public static int state2=0;
	public Object red=new Object();
	int X,Y;
	BufferedImage image,redlight,orangelight,greenlight,carimg,road_light,road_light2,redlight2,orangelight2,greenlight2;
	Thread  drawlight_thread,drawlight_thread2;

	light(int x,int y){
		this.X=x;
		this.Y=y;
		light_image();		
	}

	private void light_image() {
		redlight=ImageLoader.load("xred.png");
		greenlight=ImageLoader.load("xgreen.png");
		orangelight=ImageLoader.load("xorange.png");	
		redlight2=ImageLoader.load("xred2.png");
		greenlight2=ImageLoader.load("xgreen2.png");
		orangelight2=ImageLoader.load("xorange2.png");
	}

	
void drawlight_thread(final Graphics G){	
	drawlight_thread=new Thread(new Runnable(){
		public void run(){
			while(true){
				drawlight(G);
			}		}
	});
	drawlight_thread.start();
}

void drawlight2_thread(final Graphics G){
	drawlight_thread2=new Thread(new Runnable(){
		public void run(){
			while(true){
				drawlight2(G);
			}		}
	});
	drawlight_thread2.start();
	}

	void drawlight(Graphics G){
						G.drawImage(road_light,this.X-150,this.Y+25,50,50,null);
						G.drawImage(road_light,this.X+5,this.Y+186,50,50,null);
		}
void drawlight2(Graphics G){
						G.drawImage(road_light2,this.X+207,this.Y-155,50,50,null);
						G.drawImage(road_light2,this.X+50,this.Y,50,50,null);
		}
	

	void RedLight() throws InterruptedException{
		synchronized(red){
		while(true){
			while(state!=4){
			red.wait();
			}
			if(state==4)
			{
				this.road_light=this.redlight;

			Thread.currentThread().sleep(3000);
            state2=1;
			Thread.currentThread().sleep(3000);
			state2=0;
			state=1;
			red.notify();}
}}}
	
	void greenlight() throws InterruptedException{
		synchronized(red){
		while (true) {if(state<=3){
			this.road_light=this.greenlight;
			Thread.currentThread().sleep(3000);
			this.road_light=this.orangelight;
     		state=2;
	    	Thread.currentThread().sleep(2500);
			state=4;
     		red.notify();	}

		while(state==4){
		red.wait();
		}	}}}
	
	
void  draw_light_road2(){
	while(true){
		if(state==4){
			if(state2==0){
			this.road_light2=greenlight2;
			}else if(state2==1){
			
			this.road_light2=orangelight2;
			}}else if(state!=4)

			this.road_light2=redlight2;
	
}
	
	}}

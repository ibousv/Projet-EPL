package ch.epfl.moocprog;
import static ch.epfl.moocprog.app.Context.getConfig;
import static ch.epfl.moocprog.config.Config.*;
import ch.epfl.moocprog.utils.Vec2d;

public final class ToricPosition {
	 double x;
     double y;
	Vec2d obj = new Vec2d(x,y);
	
	private static Vec2d clampedPosition(double x,double y) {
		Vec2d v = new Vec2d(x,y);
		while(x<0) {
			x+=getConfig().getInt(WORLD_WIDTH);
		}
		while(x>=0) {
			x-=getConfig().getInt(WORLD_WIDTH);
		}
		while(y<0) {
			y+=getConfig().getInt(WORLD_HEIGHT);
		}
		while(y>=0) {
			y+=getConfig().getInt(WORLD_HEIGHT);
		}
		return v;
	}
	
	public ToricPosition(double x,double y){
		clampedPosition( x, y);
	}
	
	public ToricPosition(Vec2d vec){
		clampedPosition( vec.getX(), vec.getY());
	}
	
	public ToricPosition(){
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public ToricPosition add(ToricPosition that) {
		
			return new ToricPosition(this.x + that.x, this.y + that.y);
	}
	
	public ToricPosition add(Vec2d vec) {
		return new ToricPosition(this.x + vec.getX(), this.y + vec.getY());
	}
	
	public Vec2d toVec2d() {
		 Vec2d v = new Vec2d(this.x,this.y);
		 return v;
	}
	
	public double distance(ToricPosition that) {
		double diffX = this.x - that.x;
		double diffY = this.y - this.y;
		 return  Math.sqrt(diffX*diffX  + diffY*diffY);
	}
	public Vec2d toricVector(ToricPosition that) {
		double[] d = new double[9];
		 d[0] = distance(add(that));
		 d[1] = distance(add(new ToricPosition(0,+getConfig().getInt(WORLD_HEIGHT))));
		 d[2] = distance(add(new ToricPosition(0,-getConfig().getInt(WORLD_HEIGHT))));
		 d[3] = distance(add(new ToricPosition(0,+getConfig().getInt(WORLD_WIDTH))));
		 d[4] = distance(add(new ToricPosition(0,-getConfig().getInt(WORLD_WIDTH))));
		 d[5] = distance(add(new ToricPosition(+getConfig().getInt(WORLD_WIDTH),+getConfig().getInt(WORLD_HEIGHT))));
		 d[6] = distance(add(new ToricPosition(+getConfig().getInt(WORLD_WIDTH),-getConfig().getInt(WORLD_HEIGHT))));
		 d[7] = distance(add(new ToricPosition(-getConfig().getInt(WORLD_WIDTH),+getConfig().getInt(WORLD_HEIGHT))));
		 d[8] = distance(add(new ToricPosition(-getConfig().getInt(WORLD_WIDTH),-getConfig().getInt(WORLD_HEIGHT))));
		double min = d[0];
		
		 for(double i : d) {
			 if(min>i) {
				 min = i;
			 }
		 }
		 
		 return new Vec2d(0,min);
	}
	
	 public double toricDistance(ToricPosition that) {
		 return toricVector(that).length();
	}
	 
	 public String toString() {
		 return this.toString();
	 }

}

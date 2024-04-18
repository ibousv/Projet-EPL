package ch.epfl.moocprog;

public class Positionable{
	ToricPosition position;
	public Positionable() {
		position = new ToricPosition(0.0,0.0);
	}
	
	public Positionable(ToricPosition that) {
		position.x = that.x;
		position.y = that.y;
	}
	
	public ToricPosition getPosition() {
		return position;
	}
	
	public void setPosition(ToricPosition position) {
		this.position.x = position.x;
		this.position.y = position.y;
	}
	
	public String toString(){
		return "Position :"+position.x+" ,"+position.y;
		
	}
}

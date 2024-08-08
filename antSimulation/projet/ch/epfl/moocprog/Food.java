package ch.epfl.moocprog;

public class Food extends Positionable{
	private double quantiteNourriture;
	
	public Food(ToricPosition t,double q) {
		super.position =t;
		
		if(q<0)
			quantiteNourriture = 0.0;
		else
			quantiteNourriture = q;
	}
	
	public double getQuantity() {
		return quantiteNourriture;
	}
	
	public double takeQuantity(double d) {
		if(d> quantiteNourriture) {
			System.out.println("Impossible de prélever la quantité.");
			
		}else if(d<0) {
			throw new IllegalArgumentException();
		}else 
			this.quantiteNourriture -= d;
			return d;
	}
	
	public String toString() {
		return this.toString()+"\n"+
				String.format("Quantity : %.2f", getQuantity());
	}
	
}

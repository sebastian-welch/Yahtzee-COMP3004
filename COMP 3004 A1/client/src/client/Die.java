package client;

public class Die {
	private int value;
	private boolean held;
	
	public Die(int val, boolean h){
		value = val;
		held = h;
	}
	
	public Die(){
		value = 0;
		held = false;
	}
	
	public int 	   getValue(){ return value;}
	public boolean getHeld() { return held;}
	
	public void setValue(int newVal) {value = newVal;} 
	public void setHeld(boolean newH){held = newH;}
}

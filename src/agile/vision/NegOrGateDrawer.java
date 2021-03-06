package agile.vision;

import java.awt.Graphics;

import agile.model.NegOrGate;
import agile.model.InputPin;
import agile.model.Lamp;
import agile.model.Source;

public class NegOrGateDrawer  extends GateDrawer{

	private NegOrGate negor;
	private InputPin pinA;
	private InputPin pinB;
	private Lamp lampA;
	
	public NegOrGateDrawer(){
		negor = new NegOrGate();
		gateName = "NEG-OR";
		lampA = new Lamp(0);
		pinA = negor.getInputPin(0);
		pinB = negor.getInputPin(1);
	}
	public void drawGate(Graphics g) {	
		
		g.drawLine(locationX+size*2, locationY+size*5, locationX+size*8, locationY+size*5);
		g.drawLine(locationX+size*2, locationY+size*10, locationX+size*8, locationY+size*10);
		g.drawArc(locationX+size*7, locationY+size*2, size*3, size*11, -100, 200);
		g.drawArc(locationX+size*3, locationY+size*2, size*13, size*11, -100, 200);
		g.drawArc(locationX+size*8, locationY+size*4, size*2, size*2, -20, 360);
		g.drawArc(locationX+size*8, locationY+size*9, size*2, size*2, -20, 360);
		g.drawLine(locationX+size*16,locationY+size*7,locationX+size*22,locationY+size*7);
		
		this.drawGround(g);
		this.drawGroundCarry(g);
	}
	
	@Override
	public boolean calculateOutputValue(Source sa,Source sb,Source sc,int index){
		
		pinA.setSource(sa);
		pinB.setSource(sb);
		
		negor.setPin(pinA, pinB);
		lampA.setPinLampSource(negor);
		if(index == 0){
			return lampA.isOn();
		}
		else{
			return false;
		}	}

}

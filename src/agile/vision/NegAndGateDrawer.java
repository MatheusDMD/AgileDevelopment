package agile.vision;

import java.awt.Graphics;

import agile.model.NegAndGate;
import agile.model.InputPin;
import agile.model.Lamp;
import agile.model.Source;

public class NegAndGateDrawer  extends GateDrawer{

	private NegAndGate negand;
	private InputPin pinA;
	private InputPin pinB;
	private Lamp lampA;
	
	public NegAndGateDrawer(){
		negand = new NegAndGate();
		gateName = "NEG-AND";
		lampA = new Lamp(0);
		pinA = negand.getInputPin(0);
		pinB = negand.getInputPin(1);
	}
	public void drawGate(Graphics g) {
		g.drawLine(locationX+size*2, locationY+size*5, locationX+size*8, locationY+size*5);
		g.drawLine(locationX+size*2, locationY+size*10, locationX+size*8, locationY+size*10);
		g.drawArc(locationX+size*8, locationY+size*4, size*2, size*2, -20, 360);
		g.drawArc(locationX+size*8, locationY+size*9, size*2, size*2, -20, 360);
		g.drawLine(locationX+size*10, locationY+size*2, locationX+size*10, locationY+size*12);
		g.drawArc(locationX+size*6, locationY+size*2, size*10, size*10, -100, 200);
		g.drawLine(locationX+size*16,locationY+size*7,locationX+size*22,locationY+size*7);
		
		this.drawGround(g);
		this.drawGroundCarry(g);
		

	}
	
	@Override
	public boolean calculateOutputValue(Source sa,Source sb,Source sc, int index){
		
		pinA.setSource(sa);
		pinB.setSource(sb);
		
		negand.setPin(pinA, pinB);
		lampA.setPinLampSource(negand);
		if(index == 0){
			return lampA.isOn();
		}
		else{
			return false;
		}	}

}

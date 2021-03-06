package agile.vision;

import java.awt.Graphics;

import agile.model.XnorGate;
import agile.model.InputPin;
import agile.model.Lamp;
import agile.model.Source;

public class XnorGateDrawer extends GateDrawer{

	private XnorGate xnor;
	private InputPin pinA;
	private InputPin pinB;
	private Lamp lampA;
	
	public XnorGateDrawer(){
		xnor = new XnorGate();
		gateName = "XNOR";
		lampA = new Lamp(0);
		pinA = xnor.getInputPin(0);
		pinB = xnor.getInputPin(1);
	}
	public void drawGate(Graphics g) {
		g.drawLine(locationX+size*2, locationY+size*5, locationX+size*10, locationY+size*5);
		g.drawLine(locationX+size*2, locationY+size*10, locationX+size*10, locationY+size*10);
		g.drawArc(locationX+size*7, locationY+size*2, size*3, size*11, -100, 200);
		g.drawArc(locationX+size*3, locationY+size*2, size*13, size*11, -100, 200);
		g.drawArc(locationX+size*6, locationY+size*2, size*3, size*11, -100, 200);
		g.drawLine(locationX+size*18,locationY+size*7,locationX+size*22,locationY+size*7);
		g.drawArc(locationX+size*16, locationY+size*6, size*2, size*2, -20, 360);
		
		this.drawGround(g);
		this.drawGroundCarry(g);
		
	}
	
	@Override
	public boolean calculateOutputValue(Source sa,Source sb,Source sc, int index){
		
		pinA.setSource(sa);
		pinB.setSource(sb);
		
		xnor.setPin(pinA, pinB);
		lampA.setPinLampSource(xnor);
		if(index == 0){
			return lampA.isOn();
		}
		else{
			return false;
		}	}

}

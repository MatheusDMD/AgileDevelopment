package agile.vision;

import java.awt.Graphics;

import agile.model.InputPin;
import agile.model.NotGate;
import agile.model.Source;

public class NotGateDrawer extends GateDrawer{
	
	private NotGate not;
	
	public NotGateDrawer(){
		not = new NotGate();
		gateName = "NOT";
	}
	public void drawGate(Graphics g){

		g.drawLine(locationX+size*10, locationY+size*4, locationX+size*16, locationY+size*7);
		g.drawLine(locationX+size*10, locationY+size*10, locationX+size*16, locationY+size*7);
		g.drawLine(locationX+size*10, locationY+size*4, locationX+size*10, locationY+size*10);
		g.drawLine(locationX+size*5, locationY+size*7, locationX+size*10, locationY+size*7);
		g.drawLine(locationX+size*18, locationY+size*7, locationX+size*23, locationY+size*7);
		g.drawArc(locationX+size*16, locationY+size*6, size*2, size*2, -20, 360);
		
		switch1.setBounds(locationX+size*4,locationY+size*6, switchSize.width, switchSize.height);
		lampA.setBounds(locationX+size*20,locationY+size*6, switchSize.width, switchSize.height);
		switch1.repaint();
		lampA.repaint();
		switch1.setVisible(true);
		switch2.setVisible(false);
		switch3.setVisible(false);
		lampA.setVisible(true);
		lampB.setVisible(false);
	}
	
	@Override
	public boolean calculateOutputValue(Source sa,Source sb,Source sc, int index){
		InputPin pin = not.getInputPin(0);
		pin.setSource(sa);
		not.setPin(pin);
		return not.getOutputValue(0);
	}

	
}

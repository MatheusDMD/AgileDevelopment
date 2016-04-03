package agile.vision;

import java.awt.Graphics;
import agile.model.FullAdderGate;
import agile.model.InputPin;
import agile.model.Source;

public class FullAdderGateDrawer extends GateDrawer{
	
	private FullAdderGate fa;
	
	public FullAdderGateDrawer(){
		fa = new FullAdderGate();
		gateName = "FULL-ADDER";
	}
	public void drawGate(Graphics g){
		
		g.drawLine(locationX+size*5, locationY+size*5, locationX+size*10, locationY+size*5);
		g.drawLine(locationX+size*5, locationY+size*10, locationX+size*10, locationY+size*10);
		g.drawLine(locationX+size*5, locationY+size*7, locationX+size*10, locationY+size*7);
		g.drawLine(locationX+size*10, locationY+size*3, locationX+size*10, locationY+size*12);
		g.drawLine(locationX+size*16, locationY+size*3, locationX+size*16, locationY+size*12);
		g.drawLine(locationX+size*10, locationY+size*3, locationX+size*16, locationY+size*3);
		g.drawLine(locationX+size*10, locationY+size*12, locationX+size*16, locationY+size*12);
		g.drawLine(locationX+size*16,locationY+size*5,locationX+size*22,locationY+size*5);
		g.drawLine(locationX+size*16,locationY+size*10,locationX+size*22,locationY+size*10);
		
		switch1.setBounds(locationX+size*4,locationY+size*4, switchSize.width, switchSize.height);
		switch2.setBounds(locationX+size*4,locationY+size*6, switchSize.width, switchSize.height);
		switch3.setBounds(locationX+size*4,locationY+size*9, switchSize.width, switchSize.height);
		lampA.setBounds(locationX+size*20,locationY+size*4, switchSize.width, switchSize.height);
		lampB.setBounds(locationX+size*20,locationY+size*9, switchSize.width, switchSize.height);
		switch1.setVisible(true);
		switch2.setVisible(true);
		switch3.setVisible(true);
		lampA.setVisible(true);
		lampB.setVisible(true);
	}
	
	@Override
	public boolean calculateOutputValue(Source sa,Source sb,Source sc, int index){
		InputPin pinA = fa.getInputPin(0);
		InputPin pinB = fa.getInputPin(1);
		InputPin pinC = fa.getInputPin(2);
		
		pinA.setSource(sa);
		pinB.setSource(sb);
		pinC.setSource(sc);
		
		fa.setPin(pinA, pinB, pinC);
		return fa.getOutputValue(index);
	}
}

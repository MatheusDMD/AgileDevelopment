package agile.vision;

import java.awt.Graphics;

public class OrGateDrawer extends GateDrawer{
	public OrGateDrawer(){
		gateName = "OR";
	}
	public void drawGate(Graphics g){	
		
		g.drawLine(locationX+size*5, locationY+size*5, locationX+size*10, locationY+size*5);
		g.drawLine(locationX+size*5, locationY+size*10, locationX+size*10, locationY+size*10);
		g.drawArc(locationX+size*7, locationY+size*2, size*3, size*11, -100, 200);
		g.drawArc(locationX+size*3, locationY+size*2, size*13, size*11, -100, 200);
		g.drawLine(locationX+size*16,locationY+size*7,locationX+size*22,locationY+size*7);
	}

}

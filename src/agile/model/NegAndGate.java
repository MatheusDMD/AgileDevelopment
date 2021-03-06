package agile.model;

public class NegAndGate extends LogicGate {
	
	private InputPin pinA;
	private InputPin pinB;
	private AndGate and;
	private NotGate not1;
	private NotGate not2;
	private InputPin pin1;
	private InputPin pin2;
	
	public NegAndGate(){
		and = new AndGate();
		not1 = new NotGate();
		not2 = new NotGate();
	
		pin1 = new InputPin(0);
		pin2 = new InputPin(0);
	}
	
	public void setPin(InputPin pinA, InputPin pinB){
		this.pinA = pinA;
		this.pinB = pinB;
	}
		
	public boolean getOutputValue(int index) {
		
		not1.setPin(pinA);
		not2.setPin(pinB);
				
		pin1.setSource(not1);
		pin2.setSource(not2);
		
		and.setPin(pin1, pin2);
		
		return and.getOutputValue(0);
	}

}

public class Car extends Vehicle {
	public void checkPollutionStatus() {
		setPollutionStatus(15, 0.5, 750);
		super.checkPollutionStatus();
	}
}
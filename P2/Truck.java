public class Truck extends Vehicle {
	public void checkPollutionStatus() {
		setPollutionStatus(25, 0.8, 1000);
		super.checkPollutionStatus();
	}
}
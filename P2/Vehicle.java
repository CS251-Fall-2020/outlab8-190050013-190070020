public class Vehicle {
	private String regNo;
	private String manufacturer;
	private String owner;
	private double co2;
	private double co;
	private double hc;
	private String pollutionStatus;
	public Vehicle() {
		co2 = -1;
		co = -1;
		hc = -1;
		pollutionStatus = "PENDING";
	}
	public void setValues(String rn, String man, String own) {
		regNo = rn;
		manufacturer = man;
		owner = own;
	}

	public void addPollutants(double carbono2, double carbono, double hcarbon) {
		co2 = carbono2;
		co = carbono;
		hc = hcarbon;
	}
	public void checkPollutionStatus() {
		System.out.println(pollutionStatus);
	}
	public String toString() {
		String s = "Reg No: " + regNo + "\nManufacturer: " + manufacturer + "\nOwner: " + owner + 
		"\nPollution Status: " + pollutionStatus;
		return s;
	}
	public void setPollutionStatus(double a, double b, double c) {
		if(co2==-1) pollutionStatus="PENDING";
		else if(co2<=a && co<=b && hc<=c) pollutionStatus="PASS";
		else pollutionStatus="FAIL"; 
	}
	public String getRegNo() {
		return regNo;
	}
}
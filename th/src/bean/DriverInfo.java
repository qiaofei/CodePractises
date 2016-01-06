package bean;

public class DriverInfo {
	private String driverTel;
	private String driverLisence;

	public DriverInfo(String driverTel, String driverLisence) {
		this.driverTel = driverTel;
		this.driverLisence = driverLisence;
	}

	public String getDriverTel() {
		return driverTel;
	}

	public void setDriverTel(String driverTel) {
		this.driverTel = driverTel;
	}

	public String getDriverLisence() {
		return driverLisence;
	}

	public void setDriverLisence(String driverLisence) {
		this.driverLisence = driverLisence;
	}

}

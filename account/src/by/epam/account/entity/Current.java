package by.epam.account.entity;

public class Current {
	private String numberOfCurrent;
	private double balance;
	public Current(String number, double b) {
		super();
		this.numberOfCurrent=number;
		this.balance=b;
		
	}
	public Current() {
	}
	public String getNumberOfCurrent() {
		return numberOfCurrent;
	}
	public void setNumberOfCurrent(String numberOfCurrent) {
		this.numberOfCurrent = numberOfCurrent;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((numberOfCurrent == null) ? 0 : numberOfCurrent.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Current other = (Current) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (numberOfCurrent == null) {
			if (other.numberOfCurrent != null)
				return false;
		} else if (!numberOfCurrent.equals(other.numberOfCurrent))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Current [numberOfCurrent=" + numberOfCurrent + ", balance=" + balance + "]";
	}
	
}

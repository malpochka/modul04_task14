package by.epam.account.entity;

public class Credit {
	private String numberOfCredit;
	private double balance;

	public Credit(String number, double b) {
		super();
		this.numberOfCredit = number;
		this.balance = b;
		if (this.balance < 0) {
			this.balance = b;
		} else {
			this.balance = 0;
			System.out.println("На балансе с типом счета credit не может быть больше 0.Выберите другой тип счета");
		}

	}

	public Credit() {
	}

	public String getNumberOfCredit() {
		return numberOfCredit;
	}

	public void setNumberOfCredit(String numberOfCredit) {
		this.numberOfCredit = numberOfCredit;
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
		result = prime * result + ((numberOfCredit == null) ? 0 : numberOfCredit.hashCode());
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
		Credit other = (Credit) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (numberOfCredit == null) {
			if (other.numberOfCredit != null)
				return false;
		} else if (!numberOfCredit.equals(other.numberOfCredit))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Credit [numberOfCredit=" + numberOfCredit + ", balance=" + balance + "]";
	}

}

package by.epam.account.entity;

public class Deposit {
private String numberOfDeposit;
private double balance;

public Deposit(String number, double b) {
	super();
	this.numberOfDeposit=number;
	this.balance=b;
	if(this.balance>0) {
		this.balance=b;
	}else {
		System.out.println("Выберите другой тип счета");
	}
	}
public Deposit() {
	
}

public String getNumberOfDeposit() {
	return numberOfDeposit;
}
public void setNumberOfDeposit(String numberOfDeposit) {
	this.numberOfDeposit = numberOfDeposit;
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
	result = prime * result + ((numberOfDeposit == null) ? 0 : numberOfDeposit.hashCode());
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
	Deposit other = (Deposit) obj;
	if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
		return false;
	if (numberOfDeposit == null) {
		if (other.numberOfDeposit != null)
			return false;
	} else if (!numberOfDeposit.equals(other.numberOfDeposit))
		return false;
	return true;
}
@Override
public String toString() {
	return "Deposit [numberOfDeposit=" + numberOfDeposit + ", balance=" + balance + "]";
}
}
package by.epam.account.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {
private String surname;
private String name;
private List<Deposit> deposit;
private List<Credit> credit;
private List<Current> current;
{
	deposit=new ArrayList<Deposit>();
	credit=new ArrayList<Credit>();
	current=new ArrayList<Current>();
}
public Client(String surname,String name) {
	super();
	this.surname=surname;
	this.name=name;
}
public Client() {
	
}
public void addDeposit(Deposit dep) {
	deposit.add(dep);
}
public void addCredit(Credit cred) {
	credit.add(cred);
}
public void addCurrent(Current cur) {
	current.add(cur);
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Deposit> getDeposit() {
	return deposit;
}
public void setDeposit(List<Deposit> deposit) {
	this.deposit = deposit;
}
public List<Credit> getCredit() {
	return credit;
}
public void setCredit(List<Credit> credit) {
	this.credit = credit;
}
public List<Current> getCurrent() {
	return current;
}
public void setCurrent(List<Current> current) {
	this.current = current;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((credit == null) ? 0 : credit.hashCode());
	result = prime * result + ((current == null) ? 0 : current.hashCode());
	result = prime * result + ((deposit == null) ? 0 : deposit.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
	Client other = (Client) obj;
	if (credit == null) {
		if (other.credit != null)
			return false;
	} else if (!credit.equals(other.credit))
		return false;
	if (current == null) {
		if (other.current != null)
			return false;
	} else if (!current.equals(other.current))
		return false;
	if (deposit == null) {
		if (other.deposit != null)
			return false;
	} else if (!deposit.equals(other.deposit))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (surname == null) {
		if (other.surname != null)
			return false;
	} else if (!surname.equals(other.surname))
		return false;
	return true;
}
@Override
public String toString() {
	return "Client [surname=" + surname + ", name=" + name + ", deposit=" + deposit + ", credit=" + credit
			+ ", current=" + current + "]";
}







}

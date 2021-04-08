package by.epam.account.view;

import java.util.List;

import by.epam.account.entity.*;

public class ClientView {
public void print(Client cl, String num) {
		
		for (int i = 0; i < cl.getCredit().size(); i++) {
			if (num.equalsIgnoreCase((cl.getCredit().get(i).getNumberOfCredit()))) {
				System.out.println("Баланс Вашего счета равен: " + cl.getCredit().get(i).getBalance());
			}
		}
		for (int i = 0; i < cl.getCurrent().size(); i++) {
			if (num.equals(cl.getCurrent().get(i).getNumberOfCurrent())) {
				System.out.println("Баланс Вашего счета равен: " + cl.getCurrent().get(i).getBalance());
			}
		}
		for (int i = 0; i < cl.getDeposit().size(); i++) {
			if (num.equals(cl.getDeposit().get(i).getNumberOfDeposit())) {
				System.out.println("Баланс Вашего счета равен: " + cl.getDeposit().get(i).getBalance());
			}
		}
	}


	public void printSortCredit(String message, List<Credit> credit) {

		System.out.println(message);
		
		for (int i = 0; i < credit.size(); i++) {
			System.out.println(credit.get(i));
		}
	}

	public void printSortDeposit(String message, List<Deposit> deposit) {

		System.out.println(message);
		
		for (int i = 0; i < deposit.size(); i++) {
			System.out.println(deposit.get(i));
		}
	}

	public void printSortCurrent(String message, List<Current> current) {

		System.out.println(message);
		
		for (int i = 0; i < current.size(); i++) {
			System.out.println(current.get(i));
		}
	}

	public void printSum(String message, double s) {
		
		System.out.println(message + s);
	}
}

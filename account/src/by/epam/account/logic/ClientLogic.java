package by.epam.account.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.epam.account.entity.*;

public class ClientLogic {
	public double enterFromConsole(String message) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(message);

		while (!sc.hasNextDouble()) {
			sc.next();
			System.out.println(message);
		}

		return sc.nextDouble();
	}

	public String enterFromConsole2(String message) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(message);

		while (!sc.hasNextLine()) {
			sc.next();
			System.out.println(message);
		}

		return sc.nextLine();
	}

	public double withdrawal(Client cl, double amount, String num) {
		double balance;
		balance = 0;

		for (int i = 0; i < cl.getCredit().size(); i++) {
			if (num.equalsIgnoreCase((cl.getCredit().get(i).getNumberOfCredit()))) {
				balance = cl.getCredit().get(i).getBalance();
			}
		}
		for (int i = 0; i < cl.getCurrent().size(); i++) {
			if (num.equals(cl.getCurrent().get(i).getNumberOfCurrent())) {
				if ((cl.getCurrent().get(i).getBalance() - amount) < -30) { // Возможность технического овердрафта
					System.out.println("Извините, недостаточно средств.");
					balance = cl.getCurrent().get(i).getBalance();
				} else {
					balance = cl.getCurrent().get(i).getBalance() - amount;
					System.out.println("Операция прошла успешно");
				}
			}
		}
		for (int i = 0; i < cl.getDeposit().size(); i++) {
			if (num.equals(cl.getDeposit().get(i).getNumberOfDeposit())) {
				if ((cl.getDeposit().get(i).getBalance() - amount) < 0) {

					System.out.println("Извините, недостаточно средств.");
					balance = cl.getDeposit().get(i).getBalance();
				} else {
					balance = cl.getDeposit().get(i).getBalance() - amount;
					System.out.println("Операция прошла успешно");
				}
			}
		}
		return balance;
	}

	public double check(ClientLogic l, double balance, Client cl) {
		double amountForUnlock;

		if (balance < 0) {

			System.out.println("Ваш счет заблокирован.Вам необходимо пополнить счет на сумму " + Math.abs(balance)
					+ " для разблокировки счета");
			amountForUnlock = l.enterFromConsole("Введите сумму на которую хотите пополнить счет");
			balance = balance + amountForUnlock;
			l.checkAfterUnlock(balance);
		}

		for (int i = 0; i < cl.getCurrent().size(); i++) {
			if (balance == cl.getCurrent().get(i).getBalance()) {
				System.out.println("Попробуйте еще раз");
			}
		}
		for (int i = 0; i < cl.getDeposit().size(); i++) {

			if ((balance == cl.getDeposit().get(i).getBalance())) {
				System.out.println("Попробуйте еще раз");
			}
		}
		return balance;
	}

	public void checkAfterUnlock(double balance) {

		if (balance < 0) {
			System.out.println("Ваш счет заблокирован");
		} else {
			System.out.println("Ваш счет разблокирован");
		}
	}

	public void changeBalance(Client cl, double balance, String numb) {
		for (int i = 0; i < cl.getCredit().size(); i++) {
			if (numb.equalsIgnoreCase((cl.getCredit().get(i).getNumberOfCredit()))) {
				cl.getCredit().get(i).setBalance(balance);
				;
			}
		}
		for (int i = 0; i < cl.getCurrent().size(); i++) {
			if (numb.equals(cl.getCurrent().get(i).getNumberOfCurrent())) {
				cl.getCurrent().get(i).setBalance(balance);
				;
			}
		}
		for (int i = 0; i < cl.getDeposit().size(); i++) {
			if (numb.equals(cl.getDeposit().get(i).getNumberOfDeposit())) {
				cl.getDeposit().get(i).setBalance(balance);
			}
		}

	}

	public List<Credit> sortOfCredit(List<Credit> list) {

		List<Credit> sortCredit = new ArrayList<Credit>();
		sortCredit.addAll(list);

		for (int i = 0; i < sortCredit.size() - 1; i++) {
			for (int j = i + 1; j < sortCredit.size(); j++) {

				if ((sortCredit.get(i).getBalance() < sortCredit.get(j).getBalance())) {
					Credit temp = sortCredit.get(i);
					sortCredit.set(i, sortCredit.get(j));
					sortCredit.set(j, temp);
				}
			}
		}
		return sortCredit;
	}

	public List<Deposit> sortOfDeposit(List<Deposit> list) {

		List<Deposit> sortDeposit = new ArrayList<Deposit>();
		sortDeposit.addAll(list);

		for (int i = 0; i < sortDeposit.size() - 1; i++) {
			for (int j = i + 1; j < sortDeposit.size(); j++)

				if ((sortDeposit.get(i).getBalance() > sortDeposit.get(j).getBalance())) {
					Deposit temp = sortDeposit.get(i);
					sortDeposit.set(i, sortDeposit.get(j));
					sortDeposit.set(j, temp);
				}
		}
		return sortDeposit;
	}

	public List<Current> sortOfCurrent(List<Current> list) {

		List<Current> sortCurrent = new ArrayList<Current>();
		sortCurrent.addAll(list);

		for (int i = 0; i < sortCurrent.size() - 1; i++) {
			for (int j = i + 1; j < sortCurrent.size(); j++)

				if ((sortCurrent.get(i).getBalance() > sortCurrent.get(j).getBalance())) {
					Current temp = sortCurrent.get(i);
					sortCurrent.set(i, sortCurrent.get(j));
					sortCurrent.set(j, temp);
				}
		}
		return sortCurrent;
	}

	public double sumTotal(Client client) {
		double sum1;
		double sum2;
		double sum3;

		sum1 = 0;
		sum2 = 0;
		sum3 = 0;

		for (int i = 0; i < client.getCredit().size(); i++) {
			sum1 = sum1 + (client.getCredit().get(i).getBalance());
		}
		for (int i = 0; i < client.getDeposit().size(); i++) {
			sum2 = sum2 + client.getDeposit().get(i).getBalance();
		}
		for (int i = 0; i < client.getCurrent().size(); i++) {
			sum3 = sum3 + client.getCurrent().get(i).getBalance();
		}
		return (sum1) + sum2 + sum3;
	}

	public double sumOfDebit(Client client) {
		double sum1;
		double sum2;

		sum1 = 0;
		sum2 = 0;

		for (int i = 0; i < client.getDeposit().size(); i++) {
			sum1 = sum1 + client.getDeposit().get(i).getBalance();
		}
		for (int i = 0; i < client.getCurrent().size(); i++) {
			sum2 = sum2 + client.getCurrent().get(i).getBalance();
		}
		return sum1 + sum2;
	}

	public double sumOfCredit(Client client) {
		double sum;
		sum = 0;
		for (int i = 0; i < client.getCredit().size(); i++) {
			sum = sum + (client.getCredit().get(i).getBalance());
		}
		return sum;
	}

}

package by.epam.account.main;

import java.util.List;

import by.epam.account.entity.*;
import by.epam.account.logic.*;
import by.epam.account.view.*;

/*Счета. Клиент может именть нескольео счетов в банке. Учитывать возможность блокировки/разблокировки
 * счета.Реализовать поиск и сортировку счетов.Вычисление общей суммы по счетам. Вычисление суммы по всем счетам,
 * имеющим положительный и отрицательный балансы отдельно.
 */

public class Main {

	public static void main(String[] args) {
		double balance;
		double amount;
		double sum;

		String numberOfAccount;

		Client client1 = new Client("Ипатова", "Анна");
		;
		ClientLogic logic = new ClientLogic();
		ClientView view = new ClientView();

		client1.addDeposit(new Deposit("256500001", 650.50));
		client1.addDeposit(new Deposit("256500002", 1200));
		client1.addCredit(new Credit("256600001", -2000));
		client1.addCredit(new Credit("256600002", -500));
		client1.addCurrent(new Current("256700001", 453.25));
		client1.addCurrent(new Current("256700002", 175.30));
		client1.addCurrent(new Current("256700003", 50));

		numberOfAccount = logic.enterFromConsole2("Введите номер счета:");
		amount = logic.enterFromConsole("Введите сумму снятия со счета:");

		balance = logic.withdrawal(client1, amount, numberOfAccount);

		balance = logic.check(logic, balance, client1);

		logic.changeBalance(client1, balance, numberOfAccount);
		view.print(client1, numberOfAccount);

		List<Credit> sorted;
		sorted = logic.sortOfCredit(client1.getCredit());

		view.printSortCredit("Список кредитов по возрастанию долга: ", sorted);

		List<Deposit> sort;
		sort = logic.sortOfDeposit(client1.getDeposit());

		view.printSortDeposit("Сортировка депозитов по возрастанию баланса", sort);

		List<Current> sorts;
		sorts = logic.sortOfCurrent(client1.getCurrent());

		view.printSortCurrent("Сортировка текущих счетов по возрастанию баланса", sorts);

		sum = logic.sumTotal(client1);
		view.printSum("Общая сумма по всем счетам равна: ", sum);

		sum = logic.sumOfDebit(client1);
		view.printSum("Положительный баланс равен:", sum);

		sum = logic.sumOfCredit(client1);
		view.printSum("Сумма долга равна: ", sum);

	}

}

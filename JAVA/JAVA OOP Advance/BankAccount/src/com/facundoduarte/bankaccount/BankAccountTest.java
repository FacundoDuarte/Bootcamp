package com.facundoduarte.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount b = new BankAccount(500, 0);
		BankAccount b2 = new BankAccount(1210, 4839);
		BankAccount b3 = new BankAccount(9000, 2391);
		BankAccount b4 = new BankAccount(999, 5781);

		try {
			System.out.println("Cuentas creadas: " + BankAccount.getNumberOfAccounts());
			System.out.println(b.getAccountNumber());
			System.out.println(b2.getAccountNumber());
			System.out.println(b3.getAccountNumber());
			System.out.println(b4.getAccountNumber());

			Thread.sleep(1000);
			b.deposit();
			System.out.println("El monto total en la cuenta de ahorro es:" + b.getSavingAmountBalance());
			System.out.println("El monto total en la cuenta corriente es:" + b.getCurrentAmountBalance());
			Thread.sleep(2000);
			b.withdraw();
			System.out.println("El monto total en la cuenta de ahorro es:" + b.getSavingAmountBalance());
			System.out.println("El monto total en la cuenta corriente es:" + b.getCurrentAmountBalance());
			System.out.println("Monto total de la cuenta:" + b.totalAmount());
			Thread.sleep(2000);
			System.out.println("El monto total de las cuentas es: " + (int) b.getTotalAmount());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

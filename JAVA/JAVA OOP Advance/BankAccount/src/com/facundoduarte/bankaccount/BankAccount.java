package com.facundoduarte.bankaccount;
import java.util.Scanner;
import java.util.Random;

public class BankAccount {


	private String accountNumber;
	private double currentAmountBalance;
	private double savingAmountBalance;
	private static int numberOfAccounts;
	private static double totalAmount;
	
	public BankAccount(double savingAmountBalance, double currentAmountBalance) {
			this.accountNumber = numberAccount();
			this.currentAmountBalance = currentAmountBalance;
			this.savingAmountBalance = savingAmountBalance;
			numberOfAccounts++;
			totalAmount += currentAmountBalance + savingAmountBalance;
	}
	
	private String numberAccount() {
	       Random random = new Random();
	        StringBuilder accountNumber = new StringBuilder();

	        for (int i = 0; i < 10; i++) {
	            accountNumber.append(random.nextInt(10));
	        }

	        return "Cuenta: " + accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCurrentAmountBalance() {
		return currentAmountBalance;
	}

	public void setCurrentAmountBalance(double currentAmountBalance) {
		this.currentAmountBalance = currentAmountBalance;
	}

	public double getSavingAmountBalance() {
		return savingAmountBalance;
	}

	public void setSavingAmountBalance(double savingAmountBalance) {
		this.savingAmountBalance = savingAmountBalance;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public static void setNumberOfAccounts(int numberOfAccounts) {
		BankAccount.numberOfAccounts = numberOfAccounts;
	}

	public static double getTotalAmount() {
		return totalAmount;
	}

	public static void setTotalAmount(double totalAmount) {
		BankAccount.totalAmount = totalAmount;
	}

	public void deposit() {
		int amountDeposit = 0;
		Scanner leer = new Scanner(System.in);
		
		System.out.println("En que cuenta deseas depositar:\n1- Cuenta de Ahorros\n2- Cuenta corriente");
		int opcion = leer.nextInt();
		switch (opcion) { 
	    case 1:
	    	System.out.println("Ingrese el monto a depositar: ");
	    	 amountDeposit = leer.nextInt();
	    	 setTotalAmount(getTotalAmount() + amountDeposit);
	    	 setSavingAmountBalance(getSavingAmountBalance() + amountDeposit);
	     break;
	    case 2:
	    	System.out.println("Ingrese el monto a depositar: ");
	    	 amountDeposit = leer.nextInt();
	    	 setTotalAmount(getTotalAmount() + amountDeposit);
	    	 setCurrentAmountBalance(getCurrentAmountBalance() + amountDeposit); 
	     break;
	    default:
	    	System.out.println("Opcion incorrecta");
	  }

	}
	
	public void withdraw() {
		int withdrawAmount = 0;
		Scanner leer = new Scanner(System.in);
		
		System.out.println("De que cuenta deseas retirar:\n1- Cuenta de Ahorros\n2- Cuenta corriente");
		int opcion = leer.nextInt();
		switch (opcion) { 
	    case 1:
	    	if(this.getSavingAmountBalance() > 0) {
	    		System.out.println("Ingrese el monto a retirar: ");
		    	withdrawAmount = leer.nextInt();
		    	if(getSavingAmountBalance() - withdrawAmount >= 0) {
		    		 setTotalAmount(getTotalAmount() - withdrawAmount);
			    	 setSavingAmountBalance(getSavingAmountBalance() - withdrawAmount);
		    	} else {
		    		System.out.println("Fondos insuficientes");
		    	}
		    	
	    	} else {
	    		System.out.println("Fondos insuficientes");
	    	}
	    
	     break;
	    case 2:
	    	if(this.getCurrentAmountBalance() > 0) {
	    		System.out.println("Ingrese el monto a retirar: ");
		    	withdrawAmount = leer.nextInt();
		    	if(getCurrentAmountBalance() - withdrawAmount >= 0) {
		    		setTotalAmount(getTotalAmount() - withdrawAmount);
			    	 setCurrentAmountBalance(getCurrentAmountBalance() - withdrawAmount); 
		    	} else{
		    		System.out.println("Fondos insuficientes");
		    	}
	    	} else {
	    		System.out.println("Fondos insuficientes");
	    	}
	    	 
	     break;
	    default:
	    	System.out.println("Opcion incorrecta");
	  }

	}
	public int totalAmount() {
		return (int) (this.getCurrentAmountBalance() + this.getSavingAmountBalance());
	}
	
}

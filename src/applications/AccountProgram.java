package applications;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class AccountProgram {
    public static void main(String[] args) {
        //aqui eu criei tres contas com construtores difretens.
        //a primeira com a superclasse que parou de funcinar logo em seguida qunado usei o protected
        // Account acc = new Account(1001, "Rafaz", 1000.00);
        Account acc1 = new SavingsAccount(1002, "Isaac", 1303.0,0.01);
        Account acc2 = new BusinessAccount(1003, "Lucas", 1904.0,500.00);

        List<Account> list = new ArrayList<Account>();

        list.add(acc1);
        list.add(acc2);
        list.add(new SavingsAccount(1001, "IsaacAssis", 1202.0,500.00));
        list.add(new BusinessAccount(1002, "LucasAssis", 1701.0,500.00));

        double sum = 0;

        for (Account acc : list) {
            sum += acc.getBalance();
        }
        System.out.printf("Total Balance: %.2f%n", sum);

        for (Account acc : list) {
            acc.deposit(10.0);
        }
        for (Account acc : list) {
            System.out.printf("Update Balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
        }
    }
}

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account acc = new Account(1001, "Bob", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        //UpCasting
        Account acc1 = bacc;
        Account acc2 = new SavingsAccount(1003, "John", 0.0, 0.1);
        Account acc3 = new BusinessAccount(1004, "Jane", 0.0, 500.0);

        //DownCasting
        //aqui em especifico tive que fazer um casting manual para aceitar
        BusinessAccount acc4 = (BusinessAccount) acc3;
        acc4.loan(400.0);

        // esse erro é pq estou tentando fazer uma BusinessAccount receber uma SavingsAccount
        //resolvendo com isntanceOf
        // BusinessAccount acc5 = (BusinessAccount)acc2;
        if (acc2 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc2;
            acc5.loan(220.0);
            System.out.println("Loan!!");
        }

        if (acc2 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc2;
            acc5.updateBalance();
            System.out.println("Update balance!");
        }

        //Aqui uma conta normal tendo a taxa de 5.0 do withdraw
        Account lucas = new Account(1005, "Lucas", 1000.0);
        lucas.withdraw(200.0);
        System.out.println(lucas.getBalance());

        //aqui uma SabingsAccount usando o metodo de SobEscrita: onde no caso do SavingsAccount n tem a taxa de 5.0
        Account rafa = new SavingsAccount(1006, "Rafa", 1000.0, 0.01);
        rafa.withdraw(200.0);
        System.out.println(rafa.getBalance());




    }
}
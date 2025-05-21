package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        bankAccount = new BankAccount("John Doe", 0.0);
    }

    @Test
    void validBalance(){
        assertDoesNotThrow(() -> {
            bankAccount = new BankAccount("John Doe", 25.0);
        });
    }

    @Test
    void invalidBalance(){
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount = new BankAccount("John Doe", -1.0);
        });
    }

    @Test
    void deposit15(){
        bankAccount.deposit(1.5);
        assertEquals(1.5, bankAccount.getBalance());
    }

    @Test
    void deposit25(){
        bankAccount.deposit(25.0);
        assertEquals(25.0, bankAccount.getBalance());
    }

    @Test
    void deposit0(){
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(0.0);
        });
    }

    @Test
    void depositNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-5.0);
        });
    }

    @Test
    void deposit25withdraw10(){
        bankAccount.deposit(25.0);
        bankAccount.withdraw(10.0);
        assertEquals(15.0, bankAccount.getBalance());
    }

    @Test
    void deposit25withdraw25(){
        bankAccount.deposit(25.0);
        bankAccount.withdraw(25.0);
        assertEquals(0.0, bankAccount.getBalance());
    }

    @Test
    void deposit25withdraw50(){
        bankAccount.deposit(25.0);

        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(50.0);
        });
    }

    @Test
    void withdraw10(){
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(10.0);
        });
    }

    @Test
    void withdrawNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-1.0);
        });
    }
}
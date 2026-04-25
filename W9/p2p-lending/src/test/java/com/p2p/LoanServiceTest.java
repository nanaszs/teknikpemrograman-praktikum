package com.p2p;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

public class LoanServiceTest {

    @Test //tc01
    void shouldRejectLoanWhenBorrowerNotVerified() {
        // Arrange
        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test //tc02
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        // Arrange
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, BigDecimal.ZERO);
        });
    }

    @Test //tc03
    void shouldApproveLoanWhenCreditScoreHigh() {
        // Arrange
        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test //tc04
    void shouldRejectLoanWhenCreditScoreLow() {
        // Arrange
        Borrower borrower = new Borrower(true, 400);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}
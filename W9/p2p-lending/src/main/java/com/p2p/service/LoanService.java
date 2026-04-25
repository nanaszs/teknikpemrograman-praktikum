package com.p2p.service;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

public class LoanService {
    private static final Logger logger = LogManager.getLogger(LoanService.class);
    private static final int CREDIT_SCORE_THRESHOLD = 600;

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        logger.info("Memulai createLoan - amount: {}", amount);
        validateBorrower(borrower);
        validateAmount(amount);

        Loan loan = new Loan();
        if (borrower.getCreditScore() >= CREDIT_SCORE_THRESHOLD) {
            logger.info("Credit score {} >= threshold, APPROVED", borrower.getCreditScore());
            loan.approve();
        } else {
            logger.warn("Credit score {} < threshold, REJECTED", borrower.getCreditScore());
            loan.reject();
        }
        return loan;
    }

    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.error("Borrower tidak terverifikasi");
            throw new IllegalArgumentException("Borrower not verified");
        }
        logger.info("Borrower verified OK");
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Amount tidak valid: {}", amount);
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        logger.info("Amount valid: {}", amount);
    }
}
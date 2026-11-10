package com.starbank.recommendationservice.repository;

public record UserMetrics(
        boolean hasDebit,
        boolean hasInvest,
        boolean hasCredit,
        long sumSavingDeposit,
        long sumDebitDeposit,
        long sumDebitWithdrawal
) {}
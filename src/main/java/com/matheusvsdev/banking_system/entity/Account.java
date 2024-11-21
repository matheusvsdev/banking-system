package com.matheusvsdev.banking_system.entity;

import java.math.BigDecimal;

public abstract class Account {

    public abstract void deposit(BigDecimal amount);
    public abstract void withdraw(BigDecimal amount);
}

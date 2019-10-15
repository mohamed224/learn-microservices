package com.mtrade.payment.dao;

import com.mtrade.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment,Integer> {
    public Payment findByOrderId(int id);
}

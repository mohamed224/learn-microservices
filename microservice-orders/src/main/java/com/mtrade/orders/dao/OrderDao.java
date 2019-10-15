package com.mtrade.orders.dao;

import com.mtrade.orders.model.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Orderr,Integer> {
}

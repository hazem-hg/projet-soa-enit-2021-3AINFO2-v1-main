package enit.payement.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.PersistenceException;
import javax.sql.DataSource;

import enit.payement.domain.entity.OrderToPay;


public class PayementService {

    @Autowired
    PaymentRepo paymentRepo;

    public OrderToPay save(OrderToPay orderToPay){
        paymentRepo.save(orderToPay);
        return orderToPay;
    }


}

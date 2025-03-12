package com.mdemiguels.spring_data_jdbc.repository;

import com.mdemiguels.spring_data_jdbc.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase(product, price) VALUES(?, ?)";

        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAll() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase purchase = new Purchase();
            purchase.setId(r.getInt("id"));
            purchase.setProduct(r.getString("product"));
            purchase.setPrice(r.getBigDecimal("price"));

            return purchase;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}

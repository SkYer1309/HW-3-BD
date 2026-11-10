package com.starbank.recommendationservice.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class RecommendationRepository {
    private final JdbcTemplate jdbcTemplate;

    public RecommendationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserMetrics getUserMetrics(UUID userId) {
        String sql = """
        SELECT 
            COUNT(CASE WHEN p.type = 'DEBIT' THEN 1 END) > 0 AS has_debit,
            COUNT(CASE WHEN p.type = 'INVEST' THEN 1 END) > 0 AS has_invest,
            COUNT(CASE WHEN p.type = 'CREDIT' THEN 1 END) > 0 AS has_credit,
            COALESCE(SUM(CASE WHEN p.type = 'SAVING' AND t.type = 'DEPOSIT' THEN t.amount ELSE 0 END), 0) AS sum_saving_deposit,
            COALESCE(SUM(CASE WHEN p.type = 'DEBIT' AND t.type = 'DEPOSIT' THEN t.amount ELSE 0 END), 0) AS sum_debit_deposit,
            COALESCE(SUM(CASE WHEN p.type = 'DEBIT' AND t.type = 'WITHDRAW' THEN t.amount ELSE 0 END), 0) AS sum_debit_withdrawal
        FROM transactions t
        JOIN products p ON t.product_id = p.id
        WHERE t.user_id = ?
        """;

        UserMetrics metrics = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new UserMetrics(
                rs.getBoolean("has_debit"),
                rs.getBoolean("has_invest"),
                rs.getBoolean("has_credit"),
                rs.getLong("sum_saving_deposit"),
                rs.getLong("sum_debit_deposit"),
                rs.getLong("sum_debit_withdrawal")
        ), userId);

        return metrics;
    }
}
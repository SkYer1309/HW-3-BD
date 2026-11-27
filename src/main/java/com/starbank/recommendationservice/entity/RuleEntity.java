package com.starbank.recommendationservice.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "recommendation_rules")
public class RuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(name = "product_text", nullable = false, columnDefinition = "text")
    private String productText;

    @Column(name = "rule_json", nullable = false, columnDefinition = "jsonb")
    private String ruleJson;

    // Конструкторы
    public RuleEntity() {}

    public RuleEntity(UUID id, String productName, UUID productId, String productText, String ruleJson) {
        this.id = id;
        this.productName = productName;
        this.productId = productId;
        this.productText = productText;
        this.ruleJson = ruleJson;
    }

    // Геттеры и сеттеры
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public UUID getProductId() { return productId; }
    public void setProductId(UUID productId) { this.productId = productId; }

    public String getProductText() { return productText; }
    public void setProductText(String productText) { this.productText = productText; }

    public String getRuleJson() { return ruleJson; }
    public void setRuleJson(String ruleJson) { this.ruleJson = ruleJson; }
}
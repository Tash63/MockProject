package com.MockProject.ProductFrontend.Model;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;

import jakarta.annotation.Generated;

/**
 * Product
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-19T15:45:08.537247200+02:00[Africa/Johannesburg]")
public class Product {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("monthlyFee")
    private Double monthlyFee;

    @JsonProperty("productName")
    private String productName;

    public Product id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */

    @Schema(name = "id", required = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product monthlyFee(Double monthlyFee) {
        this.monthlyFee = monthlyFee;
        return this;
    }

    /**
     * Get monthlyFee
     *
     * @return monthlyFee
     */

    @Schema(name = "monthlyFee", required = false)
    public Double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(Double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public Product productName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * Get productName
     *
     * @return productName
     */

    @Schema(name = "productName", required = false)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) &&
                Objects.equals(this.monthlyFee, product.monthlyFee) &&
                Objects.equals(this.productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monthlyFee, productName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Product {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    monthlyFee: ").append(toIndentedString(monthlyFee)).append("\n");
        sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


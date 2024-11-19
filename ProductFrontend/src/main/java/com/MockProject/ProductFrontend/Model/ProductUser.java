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
 * ProductUser
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-19T15:45:08.537247200+02:00[Africa/Johannesburg]")
public class ProductUser {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("uid")
  private Integer uid;

  @JsonProperty("selectedproduct")
  private Product selectedproduct;

  public ProductUser id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProductUser uid(Integer uid) {
    this.uid = uid;
    return this;
  }

  /**
   * Get uid
   * @return uid
  */
  
  @Schema(name = "uid", required = false)
  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public ProductUser selectedproduct(Product selectedproduct) {
    this.selectedproduct = selectedproduct;
    return this;
  }

  /**
   * Get selectedproduct
   * @return selectedproduct
  */
  @Valid 
  @Schema(name = "selectedproduct", required = false)
  public Product getSelectedproduct() {
    return selectedproduct;
  }

  public void setSelectedproduct(Product selectedproduct) {
    this.selectedproduct = selectedproduct;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductUser productUser = (ProductUser) o;
    return Objects.equals(this.id, productUser.id) &&
        Objects.equals(this.uid, productUser.uid) &&
        Objects.equals(this.selectedproduct, productUser.selectedproduct);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, uid, selectedproduct);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductUser {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    selectedproduct: ").append(toIndentedString(selectedproduct)).append("\n");
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


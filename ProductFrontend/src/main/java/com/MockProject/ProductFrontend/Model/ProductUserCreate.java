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
 * ProductUserCreate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-19T15:45:08.537247200+02:00[Africa/Johannesburg]")
public class ProductUserCreate {

    @JsonProperty("pid")
    private Long pid;

    @JsonProperty("uid")
    private Integer uid;

    public ProductUserCreate pid(Long pid) {
        this.pid = pid;
        return this;
    }

    /**
     * Get pid
     *
     * @return pid
     */

    @Schema(name = "pid", required = false)
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public ProductUserCreate uid(Integer uid) {
        this.uid = uid;
        return this;
    }

    /**
     * Get uid
     *
     * @return uid
     */

    @Schema(name = "uid", required = false)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductUserCreate productUserCreate = (ProductUserCreate) o;
        return Objects.equals(this.pid, productUserCreate.pid) &&
                Objects.equals(this.uid, productUserCreate.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, uid);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductUserCreate {\n");
        sb.append("    pid: ").append(toIndentedString(pid)).append("\n");
        sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
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


package com.MockProject.ProductBackend.Data.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductUserCreate {
    private Integer UID;
    private Long PID;
}

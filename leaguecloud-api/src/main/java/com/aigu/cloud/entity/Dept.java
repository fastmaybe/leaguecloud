package com.aigu.cloud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)

public class Dept implements Serializable {
    private Long deptno;

    private String name;

    private String db_source;

}

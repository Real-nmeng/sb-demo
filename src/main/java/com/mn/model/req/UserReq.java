package com.mn.model.req;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author mengna
 * @date 2020/11/25 19:15
 */

@Data
public class UserReq {

    private Integer id;

    private String name;

    private String description;

    private String mobile;

}

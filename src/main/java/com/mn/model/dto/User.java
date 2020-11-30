package com.mn.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author mengna
 * @date 2020/11/28 14:29
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class User {

    private Integer id;

    private String name;

    private String description;

    private String mobile;

}

package com.mn.model.req;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author mengna
 * @date 2020/11/25 19:15
 */
@Data
public class UserReq {

    @NotNull(message = "用户id不能为空")
    private Integer id;

    @NotBlank(message = "用户名称不能为空")
    private String name;

    private String description;

    private String mobile;

}

package com.mn.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mengna
 * @date 2020/11/30 11:29
 */
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="@group")
public class GroupUser implements Serializable {
//    @JsonBackReference
    @JsonIgnore
    public Group group;
    public Integer id;
    public String name;
    public String description;
    public String mobile;

    @Override
    public String toString() {
        return "GroupUser{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

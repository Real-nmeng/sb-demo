package com.mn.model.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mengna
 * @date 2020/11/30 11:29
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
@Data
public class GroupUser implements Serializable {
    @JsonManagedReference
    @JsonIgnore
    public Group group;
    public Integer id;
    public String name;
    public String description;
    public String mobile;
}

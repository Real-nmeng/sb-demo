package com.mn.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author mengna
 * @date 2020/11/30 11:29
 */
@Data
public class Group implements Serializable {
    public String groupId;
    public String groupTitle;
    @JsonBackReference
    public GroupUser groupUser;
}

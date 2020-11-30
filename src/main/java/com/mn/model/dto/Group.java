package com.mn.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mengna
 * @date 2020/11/30 11:29
 */
@Data
public class Group implements Serializable {
    public String groupId;
    public String groupTitle;
//    @JsonManagedReference
    public GroupUser groupUser;
}

package com.mn.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * 
 * @author cg1
 * @date 2020-11-26 10:42:15
 */
@Data
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id" ,columnDefinition= "int" )
	private Integer id;

	@Column(name = "name" ,columnDefinition= "varchar" )
	private String name;

	@Column(name = "description" ,columnDefinition= "varchar" )
	private String description;

	@Column(name = "mobile" ,columnDefinition= "varchar" )
	private String mobile;

}

package com.mint.store.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author LingXi
 */
@Data
@Entity
@Table(name = "grid_category")
public class GridCategory extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String img;

	private String name;

	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "root_category_id")
	private Integer rootCategoryId;

}

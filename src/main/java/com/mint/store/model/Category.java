package com.mint.store.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author LingXi
 */
@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	@Column(name = "is_root")
	private Boolean isRoot;

	@Column(name = "parent_id")
	private Integer parentId;

	private String img;

	private Integer index;

	private Integer online;

	private Integer level;


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name= "coupon_category",
	joinColumns = @JoinColumn(name = "category_id"),
	inverseJoinColumns = @JoinColumn(name = "coupon_id"))
	private List<Coupon> couponList;
}

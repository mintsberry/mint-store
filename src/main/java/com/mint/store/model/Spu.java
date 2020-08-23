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
@Table(name = "spu")
public class Spu extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String subtitle;

	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "root_category_id")
	private Integer rootCategoryId;

	private Integer online;

	private String price;

	@Column(name = "sketch_spec_id")
	private Integer sketchSpecId;

	@Column(name = "default_sku_id")
	private Integer defaultSkuId;

	private String img;

	@Column(name = "discount_price")
	private String discountPrice;

	private String description;

	private String tags;

	@OneToMany
	@JoinColumn(name = "spu_id")
	private List<Sku> skuList;

	@OneToMany
	@JoinColumn(name = "spu_id")
	private List<SpuImg> spuImgList;

	@OneToMany
	@JoinColumn(name = "spu_id")
	private List<SpuDetailImg> spuDetailImgList;
}

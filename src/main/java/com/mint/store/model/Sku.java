package com.mint.store.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mint.store.util.GenericAndJson;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * @author LingXi
 */
@Data
@Entity
@Table(name = "sku")
@Where(clause = "delete_time is null and online = 1")
public class Sku extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal price;

	@Column(name = "discount_price")
	private BigDecimal discountPrice;

	private Integer online;

	private String img;

	private String title;

	@Column(name = "spu_id")
	private Integer spuId;
//	@Convert(converter = ListAndJson.class)
	private String specs;

	private String code;

	private Integer stock;

	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "root_category_id")
	private Integer rootCategoryId;


	public List<Spec> getSpecs() {
		if (this.specs == null) {
			return Collections.emptyList();
		}
		return GenericAndJson.jsonToObject(this.specs, new TypeReference<List<Spec>>() {});
	}

	public void setSpecs(List<Spec> specs) {
		if (specs.isEmpty()) {
			return;
		}
		this.specs = GenericAndJson.objectToJson(specs);
	}
}

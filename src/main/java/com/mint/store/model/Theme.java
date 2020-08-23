package com.mint.store.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author LingXi
 */
@Data
@Entity
@Table(name = "theme")
public class Theme extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private String description;

	private String name;

	@Column(name = "tpl_name")
	private String tplName;

	@Column(name = "entrance_img")
	private String entranceImg;

	private String extend;

	@Column(name = "internal_top_img")
	private String internalTopImg;

	@Column(name = "title_img")
	private String titleImg;

	private Integer online;

}

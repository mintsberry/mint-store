package com.mint.store.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author LingXi
 */
@Data
@Entity
@Table(name = "banner_item")
public class BannerItem  extends BaseEntity  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String img;

	private String keyword;

	private Integer type;

	@Column(name = "banner_id")
	private Integer bannerId;

	private String name;

}

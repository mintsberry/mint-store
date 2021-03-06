package com.mint.store.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author LingXi
 */
@Data
@Entity
@Table(name = "spu_img")
public class SpuImg extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String img;

	@Column(name = "spu_id")
	private Integer spuId;

}

package com.mint.store.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author LingXi
 */
@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String openid;

	private String nickname;

	@Column(name = "unify_uid")
	private Integer unifyUid;

	private String email;

	private String password;

	private String mobile;

	@Column(name = "wx_profile")
	private String wxProfile;


}

package kr.co.yapp.recruit.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author seungchanbaeg
 * 2018.03.10
 * 지원자
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Email(message = "*연락받으실 이메일주소를 기입해주세요")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
//	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*본인 지원서의 PIN 넘버를 입력해주세요")
	private String pin;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}

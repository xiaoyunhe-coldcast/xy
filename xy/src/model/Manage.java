package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Manage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "manage", catalog = "xy")
public class Manage implements java.io.Serializable {

	// Fields

	private Integer manageid;
	private String name;
	private String password;
	private Integer level;
	private String descript;
	private String bz;

	// Constructors

	/** default constructor */
	public Manage() {
	}

	/** full constructor */
	public Manage(String name, String password, Integer level, String descript,
			String bz) {
		this.name = name;
		this.password = password;
		this.level = level;
		this.descript = descript;
		this.bz = bz;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "manageid", unique = true, nullable = false)
	public Integer getManageid() {
		return this.manageid;
	}

	public void setManageid(Integer manageid) {
		this.manageid = manageid;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "descript", length = 20)
	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Column(name = "bz", length = 20)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
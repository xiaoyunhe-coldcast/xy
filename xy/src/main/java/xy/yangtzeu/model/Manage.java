package xy.yangtzeu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 管理员实体类
 * @author 肖云鹤
 * 2016-03-30
 */
@Entity
@Table(name="manage")
public class Manage implements Serializable{

	private static final long serialVersionUID = -6852794423371020822L;
	
	/** 管理员主键  **/
	private Integer manageid;
	
	/** 姓名  **/
	private String name;
	
	/** 密码  **/
	private String password;
	
	/** 权限等级  **/
	private Integer  level;
	
	/** 权限描述  **/
	private String descript;
	
	/** 备注  **/
	private String bz;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

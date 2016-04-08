package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Boss entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "boss", catalog = "xy")
public class Boss implements java.io.Serializable {

	// Fields

	private Integer bossid;
	private String name;
	private String realname;
	private String password;
	private String tel;
	private String adresse;
	private String bz;
	private Set<Storage> storages = new HashSet<Storage>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);

	// Constructors

	/** default constructor */
	public Boss() {
	}

	/** full constructor */
	public Boss(String name, String realname, String password, String tel,
			String adresse, String bz, Set<Storage> storages,
			Set<Orders> orderses) {
		this.name = name;
		this.realname = realname;
		this.password = password;
		this.tel = tel;
		this.adresse = adresse;
		this.bz = bz;
		this.storages = storages;
		this.orderses = orderses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bossid", unique = true, nullable = false)
	public Integer getBossid() {
		return this.bossid;
	}

	public void setBossid(Integer bossid) {
		this.bossid = bossid;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "realname", length = 20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "tel", length = 11)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "adresse", length = 20)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "bz", length = 20)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "boss")
	public Set<Storage> getStorages() {
		return this.storages;
	}

	public void setStorages(Set<Storage> storages) {
		this.storages = storages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "boss")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}
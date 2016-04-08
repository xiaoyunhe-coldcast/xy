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
 * Buyer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "buyer", catalog = "xy")
public class Buyer implements java.io.Serializable {

	// Fields

	private Integer buyerid;
	private String buyername;
	private String realname;
	private String buyerpsw;
	private String email;
	private String sex;
	private String address;
	private String telephone;
	private Integer buyerjf;
	private String buyerpic;
	private Integer status;
	private String bz;
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public Buyer() {
	}

	/** full constructor */
	public Buyer(String buyername, String realname, String buyerpsw,
			String email, String sex, String address, String telephone,
			Integer buyerjf, String buyerpic, Integer status, String bz,
			Set<Orders> orderses, Set<Comment> comments) {
		this.buyername = buyername;
		this.realname = realname;
		this.buyerpsw = buyerpsw;
		this.email = email;
		this.sex = sex;
		this.address = address;
		this.telephone = telephone;
		this.buyerjf = buyerjf;
		this.buyerpic = buyerpic;
		this.status = status;
		this.bz = bz;
		this.orderses = orderses;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "buyerid", unique = true, nullable = false)
	public Integer getBuyerid() {
		return this.buyerid;
	}

	public void setBuyerid(Integer buyerid) {
		this.buyerid = buyerid;
	}

	@Column(name = "buyername", length = 20)
	public String getBuyername() {
		return this.buyername;
	}

	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}

	@Column(name = "realname", length = 20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "buyerpsw", length = 20)
	public String getBuyerpsw() {
		return this.buyerpsw;
	}

	public void setBuyerpsw(String buyerpsw) {
		this.buyerpsw = buyerpsw;
	}

	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "sex", length = 4)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "address", length = 20)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "telephone", length = 11)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "buyerjf")
	public Integer getBuyerjf() {
		return this.buyerjf;
	}

	public void setBuyerjf(Integer buyerjf) {
		this.buyerjf = buyerjf;
	}

	@Column(name = "buyerpic", length = 30)
	public String getBuyerpic() {
		return this.buyerpic;
	}

	public void setBuyerpic(String buyerpic) {
		this.buyerpic = buyerpic;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "bz", length = 20)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
package xy.yangtzeu.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 卖家实体类
 * @author 肖云鹤
 *2016-03-30
 */
@Entity
@Table(name="boss")
@NamedQueries(@NamedQuery(name="queryBossByName",query="from Boss b where b.name=?1"))
public class Boss implements Serializable{

	private static final long serialVersionUID = 3885254560067637915L;
	
	/** 卖家主键  **/
	private Integer bossid;
	
	/** 卖家账号  **/
	private String name;
	
	/** 真实姓名   **/
	private String realname;
	
	/** 密码  **/
	private String password;
	
	/** 联系方式 **/
	private String tel;
	
	/** 发货地址 **/
	private String adresse;
	
	/** 备注 **/
	private String bz;
	
	/** 订单 **/
	private Set <Orders> orderses = new HashSet<Orders>(0);
	/** 商品  **/
	private Set <Goods> goodss = new HashSet<Goods>(0);
	
	/** 库存  **/
	private Set <Storage> storages = new HashSet<Storage>(0);
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "boss")
	public Set<Goods> getGoodss() {
		return goodss;
	}

	public void setGoodss(Set<Goods> goodss) {
		this.goodss = goodss;
	}
}

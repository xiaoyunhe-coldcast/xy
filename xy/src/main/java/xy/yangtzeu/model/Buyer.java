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
 * 买家实体类
 * @author 肖云鹤 
 * 2016-03-25
 */
@Entity
@Table(name="buyer")
@NamedQueries(@NamedQuery(name="queryBuyerByName",query="from Buyer b where b.buyername=?1"))
public class Buyer implements Serializable{

	private static final long serialVersionUID = 8214482970229216628L;
	
	/** 用户标示  **/
	private Integer buyerid;
	
	/** 用户名  **/
	private String buyername;
	
	/** 真实姓名  **/
	private String realname;
	
	/** 用户密码  **/
	private String buyerpsw;
	
	/** 用户邮箱  **/
	private String email;
	
	/** 用户性别  **/
	private String sex;
	
	/** 用户收货地址 **/
	private String address;
	
	/** 用户联系方式 **/
	private String telephone;
	
	/** 用户积分 **/
	private int buyerjf;
	
	/** 用户头像   **/
	private String buyerpic;
	
	/** 备注信息  **/
	private String bz;
	
	/** 状态信息  **/
	private  Integer status;
	
	/** 账户余额 **/
	private Double money; 
	
//	/** 订单 **/
//	private Set <Orders> orderses = new HashSet<Orders>(0);
//	
//	/** 评论  **/
//	private Set <Comment> comments =  new HashSet<Comment>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

//	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "buyer")
//	public Set<Orders> getOrderses() {
//		return this.orderses;
//	}
//
//	public void setOrderses(Set<Orders> orderses) {
//		this.orderses = orderses;
//	}
//
//	@OneToMany(cascade = CascadeType.MERGE,  mappedBy = "buyer")
//	public Set<Comment> getComments() {
//		return this.comments;
//	}
//
//	public void setComments(Set<Comment> comments) {
//		this.comments = comments;
//	}
	
	@Column(name = "money")
	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	public void setBuyerjf(int buyerjf) {
		this.buyerjf = buyerjf;
	}

	@Override
	public String toString() {
		return "Buyer [buyerid=" + buyerid + ", buyername=" + buyername + ", realname=" + realname + ", buyerpsw="
				+ buyerpsw + ", email=" + email + ", sex=" + sex + ", address=" + address + ", telephone=" + telephone
				+ ", buyerjf=" + buyerjf + ", buyerpic=" + buyerpic + ", bz=" + bz + ", status=" + status + ", money="
				+ money + "]";
	}

	public Buyer(Buyer bean) {
		super();
		this.buyername = bean.getBuyername();
		this.realname = bean.getRealname();
		this.buyerpsw = bean.getBuyerpsw();
		this.email = bean.getEmail();
		this.sex = bean.getSex();
		this.address = bean.getAddress();
		this.telephone = bean.getTelephone();
		this.buyerpic = bean.getBuyerpic();
		this.bz = bean.getBz();
		this.status = bean.getStatus();
		this.money = bean.getMoney();
	}
	
	public Buyer(){
		super();
	}
}

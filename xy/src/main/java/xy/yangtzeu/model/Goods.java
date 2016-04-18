package xy.yangtzeu.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * 商品实体类
 * @author 肖云鹤
 * 2016-03-30 
 */
@Entity
@Table(name="goods")
@NamedQueries({@NamedQuery(name="queryGoodsBytype",query="from Goods b where b.type=?1")})
public class Goods implements Serializable{
	
	private static final long serialVersionUID = 4837499902401177206L;
	
	/** 商品主键  **/
	private Integer goodsid;
	
	/** 卖家实体  **/
	private Boss boss;
	
	/** 商品名称  **/
	private String name;
	
//	/** 生产日期  **/
//	private Date date;
	
	/** 商品描述  **/
	private String description;
	
	/** 商品价格  **/
	private Double price;
	
	/** 商品图片  **/
	private String picture;
	
	/** 生产地  **/
	private String address;
	
	/** 备注  **/
	private String bz;
	
	/** 库存  **/
	private Storage storage;
	
	/** 类别  ***/
	private Integer type;
	
//	/** 商品评论  **/
//	private Set <Comment> comments = new HashSet<Comment>(0);
//	
//	/** 商品订单 **/
//	private Set <Orders> orderses =  new HashSet<Orders>(0);
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goodsid", unique = true, nullable = false)
	public Integer getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	@ManyToOne
	@JoinColumn(name = "bossid")
	public Boss getBoss() {
		return this.boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Temporal(TemporalType.DATE)
//	@Column(name = "date", length = 0)
//	public Date getDate() {
//		return this.date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}

	@Column(name = "description", length = 50)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "picture", length = 50)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "address", length = 20)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "bz", length = 50)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

//	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "goods")
//	public Set<Orders> getOrderses() {
//		return this.orderses;
//	}
//
//	public void setOrderses(Set<Orders> orderses) {
//		this.orderses = orderses;
//	}

//	@OneToMany( mappedBy = "goods")
//	public Set<Comment> getComments() {
//		return this.comments;
//	}
//
//	public void setComments(Set<Comment> comments) {
//		this.comments = comments;
//	}
	
	@ManyToOne
	@JoinColumn(name = "storageid")
	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Goods [goodsid=" + goodsid + ", boss=" + boss + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", picture=" + picture + ", address=" + address + ", bz=" + bz + ", storage="
				+ storage + ", type=" + type + "]";
	}
}

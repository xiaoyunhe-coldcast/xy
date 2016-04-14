package xy.yangtzeu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 购物车实体类
 * @author 肖云鹤
 * 2016-03-30
 */
@Entity
@Table(name="orders")
@NamedQueries(@NamedQuery(name="queryBybuyerid",query="from Orders b where b.buyer.buyerid=?1"))
public class Orders implements Serializable{

	private static final long serialVersionUID = -1788230570855026531L;
	
	/** 购物车主键  **/
	private Integer orderid;
	
	/** 买家实体  **/
	private Buyer buyer;
	
	/** 商品实体  **/
	private Goods goods;
	
	/** 卖家实体  **/
	private Boss boss;
	
	/**  订单状态  **/
	private Integer status;
	
	/** 下单时间   **/
	private Date date;
	
	/** 总计  **/
	private Double total;
	
	/** 商品数量  **/
	private Integer num;
	
	/** 备注  **/
	private String bz;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid", unique = true, nullable = false)
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "goodsid")
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@ManyToOne
	@JoinColumn(name = "bossid")
	public Boss getBoss() {
		return this.boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "buyerid")
	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "total", precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "bz", length = 20)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 库存实体类
 * @author 肖云鹤
 * 2016-03-30
 */
@Entity
@Table(name="storage")
public class Storage implements Serializable{

	private static final long serialVersionUID = -3341026841155828147L;
	
	/** 库存主键  **/
	private Integer storageid;
	
	/** 卖家实体  **/
	private Boss boss;
	
	/** 进价  **/
	private Double inprice;
	
	/** 售价  **/
	private Double soldprice;
	
	/**  库存  **/
	private Integer count;
	
	/** 备注  **/
	private String bz;
	
	/** 商品实体  **/
	private Set<Goods> goodset = new HashSet<Goods>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "storageid", unique = true, nullable = false)
	public Integer getStorageid() {
		return this.storageid;
	}

	public void setStorageid(Integer storageid) {
		this.storageid = storageid;
	}

	@ManyToOne
	@JoinColumn(name = "bossid")
	public Boss getBoss() {
		return this.boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

	@Column(name = "inprice", precision = 22, scale = 0)
	public Double getInprice() {
		return this.inprice;
	}

	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}

	@Column(name = "soldprice", precision = 22, scale = 0)
	public Double getSoldprice() {
		return this.soldprice;
	}

	public void setSoldprice(Double soldprice) {
		this.soldprice = soldprice;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "bz", length = 20)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "storage")
	public Set<Goods> getGoodset() {
		return goodset;
	}

	public void setGoodset(Set<Goods> goodset) {
		this.goodset = goodset;
	}
}

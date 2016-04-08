package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Storage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "storage", catalog = "xy")
public class Storage implements java.io.Serializable {

	// Fields

	private Integer storageid;
	private Boss boss;
	private Double inprice;
	private Double soldprice;
	private Integer count;
	private String bz;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** full constructor */
	public Storage(Boss boss, Double inprice, Double soldprice, Integer count,
			String bz) {
		this.boss = boss;
		this.inprice = inprice;
		this.soldprice = soldprice;
		this.count = count;
		this.bz = bz;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "storageid", unique = true, nullable = false)
	public Integer getStorageid() {
		return this.storageid;
	}

	public void setStorageid(Integer storageid) {
		this.storageid = storageid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
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

}
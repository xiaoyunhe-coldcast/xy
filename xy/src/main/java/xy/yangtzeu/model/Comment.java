package xy.yangtzeu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 商品评论实体
 * @author 肖云鹤
 * 2016-03-30
 */
@Entity
@Table(name="comment")
public class Comment implements Serializable{

	private static final long serialVersionUID = -3805063298444545448L;
	
	/** 评论主键  **/
	private Integer comid;
	
	/** 评论人  **/
	private Buyer Buyer;
	
	/** 评论对象  **/
	private Goods goods;
	
	/** 评论内容 **/
	private String content;
	
	/** 评论时间 **/
	private Date date;
	
	/** 评论星级  **/
	private int score;
	
	/** 备注  **/
	private String bz;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getComid() {
		return comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}
	      
	@JoinColumn(name="buyerid")  
	public Buyer getBuyer() {
		return Buyer;
	}

	public void setBuyer(Buyer buyer) {
		Buyer = buyer;
	}
	     
	@JoinColumn(name="goodsid") 
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}
}

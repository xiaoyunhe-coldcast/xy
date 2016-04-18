package xy.yangtzeu.model;

import java.io.Serializable;
import java.util.Date;

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

/**
 * 商品评论实体
 * @author 肖云鹤
 * 2016-03-30
 */
@Entity
@Table(name="comment")
@NamedQueries({@NamedQuery(name="combuyer",query="from Comment c where c.buyer.buyerid=?1")})
public class Comment implements Serializable{

	private static final long serialVersionUID = -3805063298444545448L;
	
	/** 评论主键  **/
	private Integer comid;
	
	/** 评论人  **/
	private Buyer buyer;
	
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
	@ManyToOne
	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	     
	@JoinColumn(name="goodsid") 
	@ManyToOne
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

	@Override
	public String toString() {
		return "Comment [comid=" + comid + ", buyer=" + buyer.toString() + ", goods=" + goods.toString() + ", content=" + content + ", date="
				+ date + ", score=" + score + ", bz=" + bz + "]";
	}
	
	
}

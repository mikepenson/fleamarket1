package cn.melonydi.fleamarket.model;

import java.util.Date;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Goodstype goodstype;
	private Integer sid;
	private User user;
	private String goodsName;
	private Date releaseDate;
	private Integer count;
	private Integer price;
	private Integer hit;
	private String usetime;
	private String address;
	private String descriptionUrl;
	private String tag;
	private String bizType;
	private String imgUrl;

	// Constructors

	/** default constructor */
	public Goods() {
	}
	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getHit() {
		return this.hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public String getUsetime() {
		return this.usetime;
	}

	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescriptionUrl() {
		return this.descriptionUrl;
	}

	public void setDescriptionUrl(String descriptionUrl) {
		this.descriptionUrl = descriptionUrl;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBizType() {
		return this.bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Goodstype getGoodstype() {
		return goodstype;
	}

	public void setGoodstype(Goodstype goodstype) {
		this.goodstype = goodstype;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
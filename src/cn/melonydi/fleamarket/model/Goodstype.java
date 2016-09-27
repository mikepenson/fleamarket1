package cn.melonydi.fleamarket.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Goodstype entity. @author MyEclipse Persistence Tools
 */

public class Goodstype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String goodsTypeName;
	//子类别不需要排序，所以选择Set结构
	List<Subtype> subtypes=new ArrayList<Subtype>();

	// Constructors


	/** default constructor */
	public Goodstype() {
	}
	
	

	@Override
	public String toString() {
		return "Goodstype [id=" + id + ", goodsTypeName=" + goodsTypeName
				+ ", subtypes=" + subtypes + "]";
	}



	public Goodstype(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}



	public Goodstype(Integer id, String goodsTypeName, List<Subtype> subtypes) {
		super();
		this.id = id;
		this.goodsTypeName = goodsTypeName;
		this.subtypes = subtypes;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsTypeName() {
		return this.goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	public List<Subtype> getSubtypes() {
		return subtypes;
	}

	public void setSubtypes(List<Subtype> subtypes) {
		this.subtypes = subtypes;
	}

	
}
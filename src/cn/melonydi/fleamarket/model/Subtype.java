package cn.melonydi.fleamarket.model;

/**
 * Subtype entity. @author MyEclipse Persistence Tools
 */

public class Subtype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer gid;
	private String subTypeName;

	// Constructors

	/** default constructor */
	public Subtype() {
	}

	public Subtype(Integer gid, String subTypeName) {
		this.gid = gid;
		this.subTypeName = subTypeName;
	}

	public Subtype(Integer id, Integer gid, String subTypeName) {
		this.id = id;
		this.gid=gid;
		this.subTypeName = subTypeName;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubTypeName() {
		return this.subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

}
package cn.melonydi.fleamarket.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Usercollect entity. @author MyEclipse Persistence Tools
 */

public class Usercollect implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private Integer gid;
	private Timestamp collectDate;

	// Constructors

	/** default constructor */
	public Usercollect() {
	}

	/** full constructor */
	public Usercollect(Integer uid, Integer gid, Timestamp collectDate,User user) {
		this.setUid(uid);
		this.gid = gid;
		this.collectDate = collectDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Timestamp getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Timestamp collectDate) {
		this.collectDate = collectDate;
	}

	

}
package cn.melonydi.fleamarket.model;

import java.util.ArrayList;
import java.util.List;

public class EasyTreeData {
	public Integer id;
	public String text;
	public String state;
	public List<EasyTreeData> children;
	
	// 构造函数
	public EasyTreeData() {
		this.children=new ArrayList<EasyTreeData>();
		this.state="open";
	}
	
	public EasyTreeData(Integer id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public EasyTreeData(Integer id, String text, String state,
			List<EasyTreeData> children) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.children = children;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<EasyTreeData> getChildren() {
		return children;
	}

	public void setChildren(List<EasyTreeData> children) {
		this.children = children;
	}
	
	
}

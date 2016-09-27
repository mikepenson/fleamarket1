package cn.melonydi.fleamarket.action;


import java.io.ByteArrayInputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.melonydi.fleamarket.model.Subtype;

@Controller
@Scope("prototype")
public class SubtypeAction extends BaseAction<Subtype> {
	
	public void save() {
		//System.out.println("gid:"+model.getGid());
		subtypeService.save(new Subtype(model.getGid(),model.getSubTypeName()));
	}
	
	public String delete() {
		subtypeService.delete(model.getId());
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void update() {
		System.out.println("id:"+model.getId()+","+"gid:"+model.getGid()+","+"subtypeName:"+model.getSubTypeName());
		subtypeService.update(new Subtype(model.getId(), model.getGid(), model.getSubTypeName()));
	}
	
	public String queryByGid() {
		jsonList=subtypeService.queryByGid(model.getGid());
		return "jsonList";
	}
}

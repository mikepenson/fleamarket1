package cn.melonydi.fleamarket.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.melonydi.fleamarket.model.EasyTreeData;
import cn.melonydi.fleamarket.model.Goodstype;
import cn.melonydi.fleamarket.model.Subtype;

@Controller
@Scope("prototype")
public class GoodstypeAction extends BaseAction<Goodstype> {
	
	public String queryOneToManySubtype() {
		// 整体列表
		List<EasyTreeData> treeList=new ArrayList<EasyTreeData>();
		 // 类别列表
		List<EasyTreeData> typeList=new ArrayList<EasyTreeData>();
		
		List<Goodstype> list=goodstypeService.query();
		for (Goodstype goodstype : list) {
			// 子类型列表
			List<EasyTreeData> subList=new ArrayList<EasyTreeData>();
			//  如果类别下没有子类别，则设置state=open
			if (goodstype.getSubtypes().size()==0) {
				typeList.add(new EasyTreeData(goodstype.getId(),goodstype.getGoodsTypeName(), "open", subList));
				continue;
			}
			
			for (Subtype subtype : goodstype.getSubtypes()) {
				EasyTreeData subData=new EasyTreeData(subtype.getId(), subtype.getSubTypeName());
				subList.add(subData);
			}
			typeList.add(new EasyTreeData(goodstype.getId(),goodstype.getGoodsTypeName(), "closed", subList));
		}
		
		treeList.add(new EasyTreeData(0, "所有类别", "open", typeList));
		
		ActionContext.getContext().getValueStack().push(treeList);
		return "treeList";
	}
	
	public void save() {
		//System.out.println("goodstypeName:"+model.getGoodsTypeName());
		goodstypeService.save(new Goodstype(model.getGoodsTypeName()));
	}
	
	public String delete() {
		goodstypeService.delete(model.getId());
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void update() {
		goodstypeService.update(model.getId(),model.getGoodsTypeName());
	}
	
	public String query() {
		jsonList=goodstypeService.query();
		return "jsonList";
	}
}

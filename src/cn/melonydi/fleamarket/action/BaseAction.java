package cn.melonydi.fleamarket.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import cn.melonydi.fleamarket.model.FileImage;
import cn.melonydi.fleamarket.service.AdminService;
import cn.melonydi.fleamarket.service.GoodsService;
import cn.melonydi.fleamarket.service.GoodstypeService;
import cn.melonydi.fleamarket.service.SubtypeService;
import cn.melonydi.fleamarket.service.UserService;
import cn.melonydi.fleamarket.util.FileUpload;
import cn.melonydi.fleamarket.util.VerifyCode;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 *  Struts执行流程：先创建Action，在调用拦截器，拦截器访问成功再调用Action的方法
 *	在项目启动的时候，Struts过滤器已经把相应的内置对象和内置对象对应的Map存储到了ActionContext和值栈中了
 *	如果实现了相应的***Aware接口，就会从ActionContext中获取相应的Map进行传入，实现了拦截器为:servletConfig
 *
 *	servletConfig：如下代码，判断实现了什么接口就会实现相应的对象
 *	 if (action instanceof ServletRequestAware) {
            HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
            ((ServletRequestAware) action).setServletRequest(request);
    }

    if (action instanceof ServletResponseAware) {
        HttpServletResponse response = (HttpServletResponse) context.get(HTTP_RESPONSE);
        ((ServletResponseAware) action).setServletResponse(response);
    }

    if (action instanceof ParameterAware) {
        ((ParameterAware) action).setParameters((Map)context.getParameters());
    }

    if (action instanceof ApplicationAware) {
        ((ApplicationAware) action).setApplication(context.getApplication());
    }
 * @param <T>
 *	
 */
@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T>{
	
	protected T model;
	
	//page和rows和分页有关，pageMap存放查询的数据，然后打包成json格式用的  
    //page和rows实现get和set方法，pageMap只需要实现get方法即可，因为pageMap不是接收前台参数的，是让struts获取的
	protected Integer page;
	protected Integer rows;
	
	protected String veryCode;
	
	public String getVeryCode() {
		return veryCode;
	}
	
	public void setVeryCode(String veryCode) {
		this.veryCode = veryCode;
	}

	protected FileImage fileImage;
	
	// 多个id
	protected String ids;
	
	protected List<T> jsonList=null;
	
	protected Map<String,Object> jsonMap;
	
	//流是用来想前台返回数据的，这个数据是让struts获取的，然后通过流的形式传到前台，所以实现get方法即可
	protected InputStream inputStream;
	

	@Resource
	protected AdminService adminService;
	@Resource
	protected UserService userService;
	@Resource
	protected GoodstypeService goodstypeService;
	@Resource
	protected SubtypeService subtypeService;
	@Resource
	protected GoodsService goodsService;
	
	@Resource
	protected FileUpload fileUpload;
	@Resource
	protected VerifyCode verifyCode;
	
	
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	@Override
	public T getModel() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class)type.getActualTypeArguments()[0];
		try {
			model=(T)clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException();
		}
		return model;
	}
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public Integer getRows() {
		return rows;
	}



	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}



	public InputStream getInputStream() {
		return inputStream;
	}
	
	public List<T> getJsonList() {
		return jsonList;
	}

	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}
	
}

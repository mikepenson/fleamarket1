package cn.melonydi.fleamarket.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.melonydi.fleamarket.util.GoodsTimerTask;
/**
 * 用于项目启动时候数据初始化
 * @author mike
 */
public class InitDataListener implements ServletContextListener {
	
	private ApplicationContext context;
	
	private GoodsTimerTask goodsTimerTask;
	

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// 解决方案1：不可取，会把spring配置文件加载两次
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-*.xml");
//		productService=(ProductService)context.getBean("productService");
//		System.out.println("productService:    "+productService);
		// 2: 解决方案2：直接到ServletContext中获取Spring配置文件:此方案的key不容易记住
//		ApplicationContext context=
//				(ApplicationContext)event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		productService=(ProductService)context.getBean("productService");
//		System.out.println("productService:    "+productService);
		// 3: 通过工具类加载即可
		context=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		goodsTimerTask=(GoodsTimerTask)context.getBean("goodsTimerTask");
		// 把内置交给productTimerTask
		goodsTimerTask.setApplication(event.getServletContext());
		// 通过设置定时器，让首页的数据每隔1分钟同步一次(配置为守护线程，随着tomcat的停止而停止)
		new Timer(true).schedule(goodsTimerTask, 0, 1000*60*1);
	}

}

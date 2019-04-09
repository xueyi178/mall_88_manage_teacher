package com.atguigu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 1、获取当前应用的目录
 * @author admin
 *
 */
public class ServiceStartupListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		String path = application.getContextPath();
		application.setAttribute("PATH", path);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}

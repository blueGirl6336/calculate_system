package com.cesystem.filter;

import java.io.IOException;  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

public class SecurityServlet extends HttpServlet implements Filter {  
    private static final long serialVersionUID = 1L;

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
           HttpServletRequest request=(HttpServletRequest)arg0;
           HttpServletResponse response  =(HttpServletResponse) arg1;
           HttpSession session = request.getSession(true);
//           String usercode = (String) request.getRemoteUser();// 登录人
//           String user_role = (String)session.getAttribute("role");//登录人角色
           String url = request.getRequestURI().substring(request.getContextPath().length());
           if(url.equals("/") || url.equals("/pages/login.jsp") || url.equals("/pages/message.jsp") || 
        		   url.equals("/notice/getAllUseful.do") || url.equals("/users/login.do")/* || 
        		   url.equals("http://192.168.56.1:8080/bootstrap/bootstrap.css") || 
        		   url.equals("http://192.168.56.1:8080/bootstrap/metisMenu.min.css") || 
        		   url.equals("http://192.168.56.1:8080/bootstrap/sb-admin-2.css") || 
        		   url.equals("http://192.168.56.1:8080/bootstrap/font-awesome.min.css") || 
        		   url.equals("http://192.168.56.1:8080/bootstrap/bootstrap-datetimepicker.min.css") || 
        		   url.equals("http://192.168.56.1:8080/js/jquery/jquery-ui-1.7.2.custom.css") || 
        		   url.equals("http://192.168.56.1:8080/js/jqgrid/ui.jqgrid.css") || 
        		   url.equals("http://192.168.56.1:8080/pages/css/frame.css") || 
        		   url.equals("http://192.168.56.1:8080/pages/css/rank.css") || 
        		   url.equals("http://192.168.56.1:8080/pages/css/message.css") || 
        		   url.equals("http://192.168.56.1:8080/js/jquery/jquery-2.0.3.min.js") || 
        		   url.equals("http://192.168.56.1:8080/js/jqgrid/jquery.jqGrid.min.js ")*/) 
           {
                //判断是否为广告或者登录界面
        	   arg2.doFilter(arg0, arg1);
        	   System.out.println(1 + url);
               return;
            }
           else
           {
        	   //如果访问的不是那两个界面，则先判断用户是否已经登录
        	   if(session == null || session.getAttribute("studentId") == null 
        			   || session.getAttribute("studentId").equals(""))
        	   {
        		   System.out.println(2 + url);
        		   response.sendRedirect("/ce_system/pages/login.jsp");
        		   return ;
        	   }
        	   else
        	   {
        		   System.out.println(3);
        		   arg2.doFilter(arg0, arg1);
                   return;
        	   }
           }
    }
    public void init(FilterConfig arg0) throws ServletException {
    }

}

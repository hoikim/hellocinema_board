/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-07 06:33:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cinema.admin.model.vo.*;

public final class local_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/manager_header.jsp", Long.valueOf(1525674032194L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.cinema.admin.model.vo");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Manager managerSession = (Manager)session.getAttribute("managerSession");
	System.out.println("유저 로긴 세션 확인 "+managerSession);
	String path = request.getContextPath();

	
	String MovieListPath = path+"/movie/showMovieList.do";
	String LocaManaging = path+"/manager/local?type=list";
	
	Cookie[] cookies = request.getCookies();
	
	boolean saveId = false;
	String userIdSaved = "";
	
   	if(cookies !=null){
   		System.out.println("--------------------------------");
   		System.out.println("브라우져가 전송한 쿠키목록");
   		System.out.println("--------------------------------");
		for(Cookie c : cookies ){
			String key = c.getName();
			String value = c.getValue();
	   		System.out.println("쿠키가요 ===> " + key + " : " + value );
	   		
	   		//아이디저장 쿠키검사
	   		if("saveId".equals(key)){
	   			saveId = true;
	   			userIdSaved = value;
	   		}else{
	   			
	   		}
		}   		
   		System.out.println("--------------------------------");
   	}
   	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Hello MVC</title>\r\n");
      out.write("<script src=\"");
      out.print(path );
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(path );
      out.write("/css/style.css\" />\r\n");
      out.write("<script>\r\n");
      out.write("function fn_login_pop(){\r\n");
      out.write("\t$(\".login_pop\").toggle();\r\n");
      out.write("\tconsole.log($(\".login_pop\"));\r\n");
      out.write("}\r\n");
      out.write("function fn_login(){\r\n");
      out.write("\t$id = $(\"#id\").val();\r\n");
      out.write("\t$pw = $(\"#pw\").val();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tconsole.log($id);\r\n");
      out.write("\tconsole.log($pw);\r\n");
      out.write("\t\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.print(path );
      out.write("/login/userlogin\", \r\n");
      out.write("\t\tdata : {id : $id, pw : $pw},\r\n");
      out.write("\t\ttype : \"post\", \r\n");
      out.write("\t\tdataType : \"html\",\r\n");
      out.write("\t\tsuccess : function(data){\r\n");
      out.write("\t\t\tconsole.log(data);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror :function(jqxhr, textStatus, errorThrown){\r\n");
      out.write("\t\t\tconsole.log(\"ajax처리실패!!\");\r\n");
      out.write("\t\t\tconsole.log(jqxhr);\r\n");
      out.write("\t\t\tconsole.log(textStatus);\r\n");
      out.write("\t\t\tconsole.log(errorThrown);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tcomplete: function(){\r\n");
      out.write("\t\t\tconsole.log(\"ajax 어찌됬던 종료!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("header{}\r\n");
      out.write("nav{}\r\n");
      out.write("nav > ul {overflow:hidden;}\r\n");
      out.write("nav > ul > li{float:left; }\r\n");
      out.write("nav > ul > li a{padding:40px; display:inline-block;}\r\n");
      out.write("nav > ul > li a:hover{background:#333; color:#fff;}\r\n");
      out.write(".login_pop{\r\n");
      out.write("\tdisplay:none;\r\n");
      out.write("\twidth:500px;\r\n");
      out.write("\theight:500px;\r\n");
      out.write("\tborder:1px solid #ececec; position:absolute;\r\n");
      out.write("\tbackground:#ececec;\r\n");
      out.write("\tright:0px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<header>\r\n");
      out.write("\t<div class=\"wrap\">\r\n");
      out.write("\t\t<h1><a href=\"");
      out.print( path);
      out.write("\">로고</a></h1>\r\n");
      out.write("\t\t<nav>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"/cinema/manager/manager.jsp\">매니저</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/cinema/menu?m=local\">지역</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/cinema/manager/theater.jsp\">영화관</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/cinema/manager/movie.jsp\">영화</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/cinema/manager/room.jsp\">M상영관 </a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/cinema/manager/schedule.jsp\">M스케쥴</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/cinema/manager/ticket.jsp\">예매</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
 if(managerSession == null) {
      out.write("\r\n");
      out.write("\t\t<div class=\"login_pop\">\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"id\" id=\"id\"/>\r\n");
      out.write("\t\t\t<input type=\"password\" name=\"pw\" id=\"pw\" />\r\n");
      out.write("\t\t\t<input type=\"checkbox\" name=\"saveId\" id=\"saveId\" />\r\n");
      out.write("\t\t\t<button onclick=\"fn_login()\">로그인</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t");
      out.print( managerSession.getName() );
      out.write(" 님, 안녕하세요.\r\n");
      out.write("\t\t\t<button onclick=\"fn_login()\">내정보보기</button>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</header>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<section id=\"container\">\r\n");
      out.write("\t<section id=\"content\">\r\n");
      out.write("\t<div class=\"wrap\">");
      out.write("\r\n");
      out.write("    ");

    
    String localPath = request.getContextPath()+"/manager/local";
    
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title> </title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<button onclick=\"fn_showList()\">검색</button>\r\n");
      out.write("<button onclick=\"fn_insert()\">삽입</button>\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(localPath );
      out.write("\" method=\"post\">\r\n");
      out.write("\t<input type=\"text\" name=\"localCode\" id =\"localCode\"/>\r\n");
      out.write("\t<input type=\"text\" name=\"localName\" id=\"localName\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"type\" value=\"insert\"/>\r\n");
      out.write("\t<button type=\"submit\">전송</button>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"viewList\">\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function fn_insert(){\r\n");
      out.write("\t$localCode = $(\"#localCode\").val();\r\n");
      out.write("\t$localName = $(\"#localName\").val();\r\n");
      out.write("\t\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.print(path );
      out.write("\",\r\n");
      out.write("\t\tdataType:\"html\",\r\n");
      out.write("\t\ttype: \"post\",\r\n");
      out.write("\t\tdata : { type : \"insert\", localCode : $localCode, localName : $localName},\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t \tconsole.log(data);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}, \terror : function(jqxhr, textStatus, errorThrown){\r\n");
      out.write("\t\t\tconsole.log(\"ajax처리실패!!\");\r\n");
      out.write("\t\t\tconsole.log(jqxhr);\r\n");
      out.write("\t\t\tconsole.log(textStatus);\r\n");
      out.write("\t\t\tconsole.log(errorThrown);\r\n");
      out.write("\t}, complete : function(){\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t});\t\r\n");
      out.write("}\r\n");
      out.write("function fn_showList(){\r\n");
      out.write("$.ajax({\r\n");
      out.write("\turl : \"");
      out.print(localPath );
      out.write("\",\r\n");
      out.write("\tdataType:\"html\",\r\n");
      out.write("\ttype: \"post\",\r\n");
      out.write("\tdata : { type : \"list\"},\r\n");
      out.write("\tsuccess:function(data){\r\n");
      out.write(" \tconsole.log(data);\r\n");
      out.write(" \t\r\n");
      out.write(" \t$(\"#viewList\").html(data);\r\n");
      out.write(" \t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}, \terror : function(jqxhr, textStatus, errorThrown){\r\n");
      out.write("\t\tconsole.log(\"ajax처리실패!!\");\r\n");
      out.write("\t\tconsole.log(jqxhr);\r\n");
      out.write("\t\tconsole.log(textStatus);\r\n");
      out.write("\t\tconsole.log(errorThrown);\r\n");
      out.write("}, complete : function(){\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("}\r\n");
      out.write("fn_showList();\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-21 00:28:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cinema.board.model.vo.Board;
import com.cinema.admin.model.vo.*;

public final class boardDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/manager_header.jsp", Long.valueOf(1526815146982L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.cinema.admin.model.vo");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.cinema.board.model.vo.Board");
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
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

    	Board b = (Board)request.getAttribute("selectBoard");
    	Board bb = (Board)request.getAttribute("selectBoardBefore");
    	Board ba = (Board)request.getAttribute("selectBoardAfter");
    	String arr[]= new String[2] ;
    	if(b.getTinfo()==null){
    		arr[0]="전체";
    	} else{
    		if(b.getTinfo().contains("/")){
		    	arr = b.getTinfo().split("/");
    		}else{
    			arr[0] = b.getTinfo();
    		}
    	}
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Manager managerSession = (Manager)session.getAttribute("managerSession");
	System.out.println("유저 로긴 세션 확인 "+managerSession);
	String path = request.getContextPath();

	
	String MovieListPath = path+"/movie/showMovieList.do";
	String LocaManaging = path+"/manager/local?type=list";
	
	
	String movie = path+"/manager/movie";
	String manager = path+"/manager/manager";
	String local = path+"/manager/local";
	String theater = path+"/manager/theater";
	String seat = path+"/manager/seat";
	String room = path+"/manager/room";
	String schedule = path+"/manager/schedule";
	String ticket = path+"/manager/ticket";
	String price = path+"/manager/price";
	String board = path+"/board/boardView";

	
	
	
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
      out.write("<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/cinema/css/jquery.datetimepicker.min.css\">\r\n");
      out.write("<script src=\"/cinema/js/jquery.datetimepicker.full.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("function fn_logout(){\r\n");
      out.write("\tlocation.href=\"");
      out.print(path );
      out.write("/manager/logout\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("header{ border-bottom:3px solid #1986ff; position:relative; }\r\n");
      out.write("header h2{float:left;}\r\n");
      out.write("header h2 a{padding:10px; display:inline-block;}\r\n");
      out.write("nav{overflow:hidden;}\r\n");
      out.write("nav::after{content:\"\"; clear:both;}\r\n");
      out.write("nav > ul {float:left; margin-left:20px; overflow:hidden;}\r\n");
      out.write("nav > ul > li{float:left; border-left:1px solid #ececec; border-right:1px solid #ececec; min-width:80px; text-align:center;}\r\n");
      out.write("nav > ul > li a{padding:20px 10px; display:inline-block; width:100%;}\r\n");
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
      out.write("\t\t<h2><a href=\"");
      out.print( path);
      out.write("\">MVCINEMA</a></h2>\r\n");
      out.write("\t\t<nav>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(movie );
      out.write("\">영화</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(manager );
      out.write("\">매니저</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(local );
      out.write("\">지역</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(theater );
      out.write("\">영화관</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(seat );
      out.write("\">M좌석 </a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(room );
      out.write("\">M상영관 </a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(schedule );
      out.write("\">M스케쥴</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(ticket );
      out.write("\">M예매</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(price );
      out.write("\">가격</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print(board );
      out.write("\">게시판</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</header>\r\n");
      out.write("<script>\r\n");
      out.write("function showTheaterName(tid){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.print(theater );
      out.write("\",\r\n");
      out.write("\t\tdataType:\"json\",\r\n");
      out.write("\t\ttype: \"post\",\r\n");
      out.write("\t\tdata : { type : \"selectTheater\", theaterNo : tid},\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\tif(data.name == undefined){\t \r\n");
      out.write("\t \t\t\t$(\".theater_where\").html(\"\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t \t\t\t$(\".theater_where\").html(data.name);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
 if(managerSession != null) { 
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\tshowTheaterName(");
      out.print( managerSession.getTid() );
      out.write(");\r\n");
      out.write("})\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<section id=\"container\">\r\n");
      out.write("\t<section id=\"content\">\r\n");
      out.write("\t\t<div class=\"manager_inforBox\">\r\n");
      out.write("\t\t\t<div class=\"wrap\">\r\n");
      out.write("\t\t\t");
 if(managerSession != null) {
      out.write("\r\n");
      out.write("\t\t\t<span class=\"theater_where\"></span>  ");
      out.print( managerSession.getName() );
      out.write(" 님, 안녕하세요.\r\n");
      out.write("\t\t\t<span onclick=\"fn_logout()\">로그아웃</span>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<div class=\"wrap\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\ttable, tr, th, td{\r\n");
      out.write("\t\tborder: 1px solid black;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/board/boardDetail?bdid=");
      out.print(b.getBdid() );
      out.write("\" method='post'>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"uPage\" value='update'/>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"수정\" />\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<input type=\"button\" value=\"목록\" onclick='fn_list()'/>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction fn_list(){\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/board/boardView\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan='1'>제목</th>\r\n");
      out.write("\t\t\t<td colspan='3'>");
      out.print((b.getTitle()==null?"제목없음":b.getTitle() ));
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>영화관</th>\r\n");
      out.write("\t\t\t<td>");
      out.print(arr[0]);
      out.write("\r\n");
      out.write("\t\t\t");
if(!"null".equals(arr[1])) {
      out.write("\r\n");
      out.write("\t\t\t");
if(arr[1]!=null) {
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/");
      out.print(arr[1]);
      out.write("\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<th>등록일</th>\r\n");
      out.write("\t\t\t<td>");
      out.print(b.getRegdate() );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan='1'>첨부파일</th>\r\n");
      out.write("\t\t\t<td colspan='3'>\r\n");
      out.write("\t\t\t\t");
if(b.getImg()==null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t등록된 첨부 파일이 없습니다.\r\n");
      out.write("\t\t\t\t");
} else{
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      out.print(b.getImg() );
      out.write("\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan='1'>내용</th>\r\n");
      out.write("\t\t\t<td colspan='3'>\r\n");
      out.write("\t\t\t\t");
      out.print(b.getContent() );
      out.write("\r\n");
      out.write("\t\t\t\t");
if(b.getImg()!=null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/upload/board/");
      out.print(b.getImg() );
      out.write("\" alt=\"attachFile\" style=\"max-width: 500px;\"/>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");
if(bb.getTitle()==null){ 
      out.write("\r\n");
      out.write("\t\t<p>이전글 : 이전글이 없습니다.</p>\r\n");
      out.write("\t");
}else{
      out.write("\r\n");
      out.write("\t\t<p onclick=\"fn_next('");
      out.print(bb.getBdid());
      out.write("')\">이전글 : ");
      out.print(bb.getTitle() );
      out.write("</p>\r\n");
      out.write("\t");
} 
      out.write('\r');
      out.write('\n');
      out.write('	');
if(ba.getTitle()==null){ 
      out.write("\r\n");
      out.write("\t\t<p>다음글 : 다음글이 없습니다.</p>\r\n");
      out.write("\t");
}else{
      out.write("\r\n");
      out.write("\t\t<p onclick=\"fn_next('");
      out.print(ba.getBdid());
      out.write("')\">다음글 : ");
      out.print(ba.getTitle() );
      out.write("</p>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction fn_next(bdid){\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/board/boardDetail?bdid=\"+ bdid;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
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
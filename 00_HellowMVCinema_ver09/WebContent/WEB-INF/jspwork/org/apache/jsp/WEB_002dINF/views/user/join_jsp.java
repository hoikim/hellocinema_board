/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-05-12 15:20:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.cinema.user.model.vo.*;
import com.cinema.admin.model.vo.*;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1526138329720L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1526053174629L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.cinema.user.model.vo");
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

	User userSession = (User)session.getAttribute("userSession");
	System.out.println("유저 로긴 세션 확인 ");
	String path = request.getContextPath();

	
	String MovieListPath = path+"/movie/showMovieList.do";
	String JoinUser = path+"/user/join";
	
	
	
	String Managerlogin ="/managerLogin";
	
	
	//관리자가 아닌경우 
	Manager sessionManager = (Manager)request.getSession(true).getAttribute("managerSession");
	
	
	String view="";
	if(sessionManager != null) {
		Managerlogin = path + "/manager/movie";
	}else{
		Managerlogin = path + "/managerLogin";
	}

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
      out.write("\t$saveId = $(\"#saveId\").val();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.print(path );
      out.write("/login/userlogin\", \r\n");
      out.write("\t\tdata : {id : $id, pw : $pw, saveId : $saveId},\r\n");
      out.write("\t\ttype : \"post\", \r\n");
      out.write("\t\tdataType : \"html\",\r\n");
      out.write("\t\tsuccess : function(data){\r\n");
      out.write("\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\tlocation.href=\"/cinema\";\r\n");
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
      out.write("function fn_join(){\r\n");
      out.write("\tlocation.href=\"");
      out.print(JoinUser);
      out.write("\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function fn_manager_login(){\r\n");
      out.write("\tlocation.href=\"");
      out.print(Managerlogin);
      out.write("\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("header{ border-bottom:3px solid #333; position:relative; }\r\n");
      out.write("header h1{float:left;}\r\n");
      out.write("header h1 a{padding:10px; display:inline-block;}\r\n");
      out.write("nav{overflow:hidden;}\r\n");
      out.write("nav::after{content:\"\"; clear:both;}\r\n");
      out.write("nav > ul {float:left; margin-left:50px; overflow:hidden;}\r\n");
      out.write("nav > ul > li{float:left; border-left:1px solid #ececec; border-right:1px solid #ececec; min-width:100px; text-align:center;}\r\n");
      out.write("nav > ul > li a{padding:20px; display:inline-block; width:100%;}\r\n");
      out.write("nav > ul > li a:hover{background:#333; color:#fff;}\r\n");
      out.write(".login_pop{\r\n");
      out.write("\tdisplay:none;\r\n");
      out.write("\twidth:300px;\r\n");
      out.write("\theight:280px;\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\tbackground:#fff;\r\n");
      out.write("\tright:145px;\r\n");
      out.write("\ttop:61px;\r\n");
      out.write("\tborder-top:2px solid #ff1969;\r\n");
      out.write("}\r\n");
      out.write(".login_pop input{\r\n");
      out.write("\tmargin-bottom:10px;\r\n");
      out.write("\tborder-radius:2px;\r\n");
      out.write("\tborder-style:none;\r\n");
      out.write("\tborder:1px solid #ececec;\r\n");
      out.write("\toutline:none;\r\n");
      out.write("\tfont-size:14px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write(".login_section{\r\n");
      out.write("\tpadding:20px;\r\n");
      out.write("\toverflow:hidden; \r\n");
      out.write("\tposition:relative;\r\n");
      out.write("}\r\n");
      out.write(".login_section h3{\r\n");
      out.write("display:block;\r\n");
      out.write("padding:15px 0px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write(".login_pop input:focus{\r\n");
      out.write("border:1px solid #ff1969}\r\n");
      out.write("#id{-webkit-appearance :none; width:100%;}\r\n");
      out.write("#pw{-webkit-appearance :none; width:100%;}\r\n");
      out.write(".login_adversting {position:absolute; bottom:0px; height:60px;}\r\n");
      out.write(".login_adversting img{ width:100%;}\r\n");
      out.write(".input_section{float:left; width:60%;}\r\n");
      out.write(".login_btn_section{margin-left:10px; float:right; width:35%; }\r\n");
      out.write(".btn_login{height:86px; width:100%;}\r\n");
      out.write(".login_saveId{clear:both; font-size:12px; padding-top:10px; }\r\n");
      out.write(".login_saveId span{cursor:pointer;}\r\n");
      out.write("#saveId{vertical-align: top; }\r\n");
      out.write(".user_logged{padding:0px 10px; font-size:12px; height:60px; border-right:none;}\r\n");
      out.write(".user_logged span{display:inline-block; padding:21px 0px; }\r\n");
      out.write(".logout_btn{cursor:pointer;}\r\n");
      out.write("</style>\r\n");
      out.write("<header>\r\n");
      out.write("\t<div class=\"wrap\">\r\n");
      out.write("\t\t<h1><a href=\"");
      out.print( path);
      out.write("\">로고</a></h1>\r\n");
      out.write("\t\t<nav>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.print( MovieListPath );
      out.write("\">영화</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"\">추천영화</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"\">영화관</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"\">이벤트</a></li>\r\n");
      out.write("\t\t\t\t");
 if(userSession == null) {
      out.write("\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:fn_login_pop()\" >로그인</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"javascript:fn_manager_login()\">관리자</a></li>\t\t\t\r\n");
      out.write("\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t<li class=\"user_logged\">\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<span>");
      out.print( userSession.getName() );
      out.write("님, 안녕하세요.</span> &nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<span class=\"my_infor\" onclick=\"fn_showInfo()\">내정보보기</span> &nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<span class=\"logout_btn\" onclick=\"fn_logout()\">로그아웃</span>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"login_pop\">\r\n");
      out.write("\t\t<div class=\"login_section\">\r\n");
      out.write("\t\t");
 if(userSession == null) {
      out.write("\r\n");
      out.write("\t\t\t<h3>MVCINEMA 로그인</h3>\r\n");
      out.write("\t\t\t<div class=\"input_section\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"id\" id=\"id\" placeholder=\"아이디\" value =\"");
      out.print( saveId ? userIdSaved : "" );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"password\" name=\"pw\" id=\"pw\" placeholder=\"비밀번호\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"login_btn_section\">\r\n");
      out.write("\t\t\t\t<button onclick=\"fn_login()\" class=\"btn_login\">로그인</button>\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"login_saveId\">\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"saveId\" id=\"saveId\" ");
      out.print( saveId ? "checked":"" );
      out.write(" />\r\n");
      out.write("\t\t\t\t<label for=\"saveId\">아이디 저장</label>\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp; <span onclick=\"fn_join()\">회원가입</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t");
      out.print( userSession.getName() );
      out.write(" 님, 안녕하세요.\r\n");
      out.write("\t\t\t<button onclick=\"fn_login()\">내정보보기</button>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"login_adversting\">\r\n");
      out.write("\t\t\t<img src=\"/cinema/data/adversting.jpg\" alt=\"\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</header>\r\n");
      out.write("<script>\r\n");
      out.write("function fn_logout(){\r\n");
      out.write("\t\r\n");
      out.write("\tlocation.href=\"/cinema/user/logout\";\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<section id=\"container\">\r\n");
      out.write("\t<section id=\"content\">\r\n");
      out.write("\t<div class=\"wrap\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function fn_checkIdDuplicate(){\r\n");
      out.write("\tvar userId = $(\"#user_Id\").val().trim();\r\n");
      out.write("\tif(userId.length<4){\r\n");
      out.write("\t\talert(\"아이디는 4글자 이상 가능합니다.\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar url = \"");
      out.print( request.getContextPath() );
      out.write("/user/checkIdDuplicate\";\r\n");
      out.write("\tvar title = \"checkIdDuplicate\";\r\n");
      out.write("\tvar status = \"left=350px, top=100px, width=300px, height=200px\";\r\n");
      out.write("\t//window.open(url,title,status);\r\n");
      out.write("\tvar popup = window.open(url, title, status);\r\n");
      out.write("\t\r\n");
      out.write("\tvar checkIdDuplicateFrm = document.checkIdDuplicateFrm;\r\n");
      out.write("\tcheckIdDuplicateFrm.userId.value=userId;\r\n");
      out.write("\t\r\n");
      out.write("\t//팝업과 form연결\r\n");
      out.write("\t\r\n");
      out.write("\tcheckIdDuplicateFrm.target = title;\r\n");
      out.write("\tcheckIdDuplicateFrm.action = url;\r\n");
      out.write("\tcheckIdDuplicateFrm.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function fn_enrollValidate(){\r\n");
      out.write("    \r\n");
      out.write("\t$userId = $(\"#user_Id\");\r\n");
      out.write("\t$passWord = $(\"#pass_Word\");\r\n");
      out.write("\t$passWordChk = $(\"#pass_WordChk\");\r\n");
      out.write("\t$userName = $(\"#userName\");\r\n");
      out.write("\t$age = $(\"#age\");\r\n");
      out.write("\t$email = $(\"#email\");\r\n");
      out.write("\t$phone = $(\"#phone\");\r\n");
      out.write("\t$address =$(\"#address\");\r\n");
      out.write("\t$gender =$(\"input[name=gender]\");\r\n");
      out.write("\t$hobby = $(\"input[name=hobby]\");\r\n");
      out.write("\t//빈객체 체크\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tif($userName.val() ==\"\"){\r\n");
      out.write("\t\tconsole.log(\"이름을 입력해주세요\");\r\n");
      out.write("\t\t$userName.focus();\r\n");
      out.write("\t\treturn false;\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif($phone.val() == \"\"){\r\n");
      out.write("\t\tconsole.log(\"전화번호를 입력해주세요.\")\r\n");
      out.write("\t\t$phone.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif($address.val() == \"\"){\r\n");
      out.write("\t\tconsole.log(\"주소를 입력해주세요.\")\r\n");
      out.write("\t\t$phone.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function regExpVaildation(regExp, el, msg) {\r\n");
      out.write("    if(regExp.test(el.val())){\r\n");
      out.write("        return;\r\n");
      out.write("    }else{\r\n");
      out.write("\t    console.log(msg);\r\n");
      out.write("        console.log(el.val());\r\n");
      out.write("        console.log(regExp.test(el.val()));\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("    var regType = /^[A-Za-z0-9]{6,12}$/g;\r\n");
      out.write("\t$userId = $(\"#user_Id\");\r\n");
      out.write("\t$passWord = $(\"#pass_Word\");\r\n");
      out.write("\t$passWordChk = $(\"#pass_WordChk\");\r\n");
      out.write("\t$userName = $(\"#userName\");\r\n");
      out.write("\t$age = $(\"#age\");\r\n");
      out.write("\t$email = $(\"#email\");\r\n");
      out.write("\t$phone = $(\"#phone\");\r\n");
      out.write("\t$address =$(\"#address\");\r\n");
      out.write("\t$gender =$(\"input[name=gender]\");\r\n");
      out.write("\t$hobby = $(\"input[name=hobby]\");\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$passWord.keyup(function(e){\r\n");
      out.write("\t\tregExpVaildation(regType, $passWord, \"영문 숫자만 허용 6~12자리\");\r\n");
      out.write("\t});\r\n");
      out.write("\t//패스워드 체크\r\n");
      out.write("\t$passWordChk.keyup(function(e){\r\n");
      out.write("\t\t$pw_val = $(\"#pass_Word\").val();\r\n");
      out.write("\t\t$pwchk_val = $(\"#pass_WordChk\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\tif(($pwchk_val==\"\")||($pw_val != $pwchk_val)){\r\n");
      out.write("\t\t\tconsole.log(\"맞지않아\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tconsole.log(\"맞아부렁\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write(" \r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<!-- 아이디중복체크폼 -->\r\n");
      out.write("<form name=\"checkIdDuplicateFrm\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"userId\" />\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#cinema_container *{box-sizing: border-box; outline:none;}\r\n");
      out.write("#cinema_container{background:#fff; padding:0px;}\r\n");
      out.write("#cinema_container table{border-collapse: collapse; padding:0p; border-top:3px solid #503396; width:100%}\r\n");
      out.write("#cinema_container table th, #cinema_container table td{padding:10px; border-bottom:1px solid #ccc; }\r\n");
      out.write("#cinema_container th{background:#ececec; text-align:left;}\r\n");
      out.write("#cinema_container table th{width:13%;}\r\n");
      out.write("#cinema_container input{padding:10px; width:100%;}\r\n");
      out.write("#cinema_container input[type='button']{background:#ddd; border:none;}\r\n");
      out.write("\r\n");
      out.write("#cinema_container table .birth_tr td{padding:10px 0px;}\r\n");
      out.write("#cinema_container table .birth_tr td input{text-align:center;}\r\n");
      out.write("#cinema_container table .birth_tr .birth{width:80px; padding:10px;}\r\n");
      out.write("#cinema_container table .birth_tr td:first-of-type{padding-right:0px;}\r\n");
      out.write("#cinema_container table .birth_tr td:nth-of-type(3){padding:10px 0px }\r\n");
      out.write("#cinema_container table .birth_tr td:nth-of-type(5){padding-left: 0px}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("#cinema_container table .phone_tr td{padding:10px 0px; text-align:center;}\r\n");
      out.write("#cinema_container table .phone_tr td input{text-align:center;;}\r\n");
      out.write("#cinema_container table .phone_tr .phone{width:80px; padding:10px;}\r\n");
      out.write("#cinema_container table .phone_tr td:first-of-type{padding-right:0px; width:90px;}\r\n");
      out.write("#cinema_container table .phone_tr td:nth-of-type(3){padding:10px 0px; }\r\n");
      out.write("#cinema_container table .phone_tr td:nth-of-type(5){padding-left: 0px}\r\n");
      out.write("\r\n");
      out.write(".submit_tr button{ background :#503396; border:none; padding:20px; color:#fff; font-size:18px;}\r\n");
      out.write(".submit_tr .cancle_btn{background:#ddd; color:#898989;}\r\n");
      out.write(".submit_btn{ background :#503396; border:none; padding:20px; color:#fff; font-size:18px;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<section id=\"cinema_container\">\r\n");
      out.write("\t<form action=\"");
      out.print( request.getContextPath() );
      out.write("/user/joinend\" method=\"post\" onsubmit=\"return sValidation();\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"phone\" />\r\n");
      out.write("\t<input type=\"hidden\" name=\"birth\" />\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>아이디</th>\r\n");
      out.write("\t\t\t\t<td colspan=\"6\"><input type=\"text\" name=\"id\"/> </td>\r\n");
      out.write("\t\t\t\t<td><input type=\"button\" value=\"중복검사\" /></td>\r\n");
      out.write("\t\t\t\t<td><span>영문이나 숫자 혹은 그 조합 8~12자리</span></td>\r\n");
      out.write("\t\t\t</tr>\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>비밀번호</th>\r\n");
      out.write("\t\t\t\t<td colspan=\"6\"><input type=\"password\" name=\"pw\" id=\"hpwd\" /></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td><span>영문, 숫자, 특수문자 중 2가지 이상 조합 10자리 이상</span></td>\r\n");
      out.write("\t\t\t</tr>\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>비밀번호 확인</th>\r\n");
      out.write("\t\t\t\t<td colspan=\"6\"><input type=\"password\" name=\"pwchk\" id=\"hpwd_chk\" /></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>이름</th>\r\n");
      out.write("\t\t\t\t<td colspan=\"6\"><input type=\"text\" name=\"name\" /> </td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\t\r\n");
      out.write("\t\t\t<tr class=\"birth_tr\">\r\n");
      out.write("\t\t\t\t<th>생년월일</th>\r\n");
      out.write("\t\t\t\t<td class=\"birth\"><input type=\"number\"  min=0  placeholder=\"1960\"/></td>\r\n");
      out.write("\t\t\t\t<td>-</td>\r\n");
      out.write("\t\t\t\t<td class=\"birth\"><input type=\"number\" min=0 placeholder=\"12\"/></td>\r\n");
      out.write("\t\t\t\t<td>-</td>\r\n");
      out.write("\t\t\t\t<td class=\"birth\"><input type=\"number\" min=0 placeholder=\"01\"/></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\r\n");
      out.write("\t\t\t<tr class=\"phone_tr\">\r\n");
      out.write("\t\t\t\t<th>휴대폰</th>\r\n");
      out.write("\t\t\t\t<td class=\"phone\"><input type=\"number\"  min=0 placeholder=\"010\"/></td>\r\n");
      out.write("\t\t\t\t<td>-</td>\r\n");
      out.write("\t\t\t\t<td class=\"phone\"><input type=\"number\" min=0 placeholder=\"1234\"/></td>\r\n");
      out.write("\t\t\t\t<td>-</td>\r\n");
      out.write("\t\t\t\t<td class=\"phone\"><input type=\"number\" min=0 placeholder=\"5678\"/></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>이메일</th>\r\n");
      out.write("\t\t\t\t<td colspan=\"6\"><input type=\"email\" name=\"email\"/> </td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr class=\"submit_tr\">\r\n");
      out.write("\t\t\t\t<td colspan=\"9\" style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t<button class=\"cancle_btn\">취소하기</button>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" class=\"submit_btn\" value=\"가입하기\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function sValidation(){\r\n");
      out.write("\t$year = $(\".birth_tr input\").eq(0).val();\r\n");
      out.write("\t$month = $(\".birth_tr input\").eq(1).val();\r\n");
      out.write("\t$date = $(\".birth_tr input\").eq(2).val();\r\n");
      out.write("\t\r\n");
      out.write("\t$birth = $(\"input[name=birth]\");\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tif($month.length < 2){\r\n");
      out.write("\t\t$month = \"0\"+ $month; \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif($date.length < 2){\r\n");
      out.write("\t\t$date = \"0\"+ $date;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$birth.val($year+$month+$date);\r\n");
      out.write("\t\r\n");
      out.write("\t$first = $(\".phone_tr input\").eq(0).val();\r\n");
      out.write("\t$second = $(\".phone_tr input\").eq(1).val();\r\n");
      out.write("\t$last= $(\".phone_tr input\").eq(2).val();\r\n");
      out.write("\t\r\n");
      out.write("\t$phone_number = $(\"input[name=phone]\");\r\n");
      out.write("\t\r\n");
      out.write("\t$phone_number.val($first+$second+$last);\r\n");
      out.write("\tconsole.log($phone_number.val());\r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\t\t</div> <!-- wrap -->\r\n");
      out.write("   \t</section>\r\n");
      out.write("</section> \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t<div class=\"wrap\">\r\n");
      out.write("\t\t\t홈페이지\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</div>");
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

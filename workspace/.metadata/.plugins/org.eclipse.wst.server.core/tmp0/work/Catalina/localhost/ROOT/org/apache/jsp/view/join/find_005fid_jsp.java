/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2023-04-19 00:29:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.join;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class find_005fid_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head></head>\r\n");
      out.write("<meta charset=\"UTF-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/main.css\" />\r\n");
      out.write("\r\n");
      out.write("<!--브라우저 스타일 초기화-->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css\" />\r\n");
      out.write("<!--Google Fonts - 나눔고딕-->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" />\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("<!-- Jquery -->\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js\"></script>\r\n");
      out.write("<!-- BootStrap-->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"../js/js_omn.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/css_omn.css\">\r\n");
      out.write("<script\r\n");
      out.write("   src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(function() {\r\n");
      out.write("		\r\n");
      out.write("		$('#uname').on('keyup', function() {\r\n");
      out.write("			namevalue = $(this).val().trim();\r\n");
      out.write("			namereg = /^[가-힣]{2,10}$/;\r\n");
      out.write("			\r\n");
      out.write("			regcheck(namereg, namevalue, this);\r\n");
      out.write("			\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		$('#memRegno1').on('keyup', function() {\r\n");
      out.write("			hpvalue = $(this).val().trim();\r\n");
      out.write("			hpreg = /^[0-9]{6}$/;\r\n");
      out.write("			\r\n");
      out.write("			regcheck(hpreg, hpvalue, this);\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		$('#memRegno2').on('keyup', function() {\r\n");
      out.write("			hpvalue = $(this).val().trim();\r\n");
      out.write("			hpreg = /^[0-9]{7}$/;\r\n");
      out.write("			\r\n");
      out.write("			regcheck(hpreg, hpvalue, this);\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		regcheck = function(reg, value, ele) {\r\n");
      out.write("			if(!(reg.test(value))) {\r\n");
      out.write("				$(ele).css('border', '2px solid red');\r\n");
      out.write("			} else {\r\n");
      out.write("				$(ele).css('border', '2px solid skyblue');\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$(\"#send\").on('click',function(){\r\n");
      out.write("			if($('#uname').val() == \"\"){\r\n");
      out.write("				alert(\"이름을 입력해주세요\");\r\n");
      out.write("				return false;\r\n");
      out.write("			} else if($('#memRegno1').val() == \"\"){\r\n");
      out.write("				alert(\"주민등록번호 앞자리를 입력해주세요\");\r\n");
      out.write("				return false;\r\n");
      out.write("			} else if($('#memRegno2').val() == \"\"){\r\n");
      out.write("				alert(\"주민등록번호 뒷자리를 입력해주세요\");\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			unamevalue = $('#uname').val().trim();\r\n");
      out.write("			memRegno1value = $('#memRegno1').val().trim();\r\n");
      out.write("			memRegno2value = $('#memRegno2').val().trim();\r\n");
      out.write("			\r\n");
      out.write("			param =\r\n");
      out.write("				{\r\n");
      out.write("					client_name : unamevalue\r\n");
      out.write("					,mem_regno1 : memRegno1value\r\n");
      out.write("					,mem_regno2 : memRegno2value\r\n");
      out.write("				}\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url : '");
      out.print(request.getContextPath());
      out.write("/findId.do',\r\n");
      out.write("				data : param,\r\n");
      out.write("				type : 'post',\r\n");
      out.write("				success : function(data) {\r\n");
      out.write("					if(data.id == null) {\r\n");
      out.write("						alert(\"회원정보가 일치하지 않습니다.\");\r\n");
      out.write("					} else if ($(\"#id\").css(\"display\") == \"none\"){\r\n");
      out.write("						$(\"#id\").show();\r\n");
      out.write("						$(\"#id\").text(\"회원님의 아이디는 \" + data.id + \"입니다\");\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error : function(xhr) {\r\n");
      out.write("					alert(\"상태 : \" + xhr.status)\r\n");
      out.write("				},\r\n");
      out.write("				dataType : 'json'\r\n");
      out.write("			})\r\n");
      out.write("		})\r\n");
      out.write("	})\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write(".idbtn {\r\n");
      out.write("	text-align : center;\r\n");
      out.write("}\r\n");
      out.write(".idbtn1 {\r\n");
      out.write("	display : inline-block;\r\n");
      out.write("}\r\n");
      out.write("#id {\r\n");
      out.write("	padding : 2em 2em; \r\n");
      out.write("	margin : 2em 10px; \r\n");
      out.write("	font-weight : bold; \r\n");
      out.write("	color : #565656; \r\n");
      out.write("	background : #E4FCFF; \r\n");
      out.write("	box-shadow : 0px 0px 0px 10px #E4FCFF; \r\n");
      out.write("	border : dashed 2px #1DC1D6; \r\n");
      out.write("	border-radius : 8px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<div class=\"container\"><br>\r\n");
      out.write("	<h2>아이디 찾기</h2>\r\n");
      out.write("	<h5>정보를 입력해주세요</h5><br>\r\n");
      out.write("	<form class=\"needs-validation\">\r\n");
      out.write("		<div class=\"form-group\">\r\n");
      out.write("			<label for=\"uname\">이름</label>\r\n");
      out.write("			<input type=\"text\" class=\"form-control\" id=\"uname\" name=\"mem_name\" required>\r\n");
      out.write("		</div><br>\r\n");
      out.write("		<div class=\"row g-2\">\r\n");
      out.write("			<div class=\"col-sm-6\">\r\n");
      out.write("				<label for=\"memRegno1\">주민등록번호</label>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" id=\"memRegno1\" name=\"mem_regno1\" required>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"col-sm\">\r\n");
      out.write("				<label for=\"memRegno2\"></label>\r\n");
      out.write("				<input type=\"password\" class=\"form-control\" id=\"memRegno2\" name=\"mem_regno2\" required>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div><br><br>\r\n");
      out.write("		<div class=\"idbtn\">\r\n");
      out.write("		<button type=\"button\" id=\"send\" class=\"btn btn-primary idbtn1\">아이디 찾기</button>\r\n");
      out.write("		<button type=\"button\" id=\"login\" class=\"btn btn-primary idbtn1\" onclick=\"location.href='/login.do'\">로그인하러 가기</button>\r\n");
      out.write("		<span id=\"joinspan\"></span>\r\n");
      out.write("		</div>\r\n");
      out.write("	</form><br>\r\n");
      out.write("	<div id=\"id\" style=\"display : none;\"></div>\r\n");
      out.write("</div>\r\n");
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

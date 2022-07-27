package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calculate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Math Form</h1>\n");
      out.write("        <form action=\"cal\">\n");
      out.write("            Enter number 1: <input type=\"text\" name=\"num1\"/><br>\n");
      out.write("            Enter number 2: <input type=\"text\" name=\"num2\"/><br>\n");
      out.write("            Select operator:\n");
      out.write("            <input type=\"radio\" name=\"op\" value=\"+\" checked/>+\n");
      out.write("            <input type=\"radio\" name=\"op\" value=\"-\"/>-\n");
      out.write("            <input type=\"radio\" name=\"op\" value=\"x\"/>x\n");
      out.write("            <input type=\"radio\" name=\"op\" value=\":\"/>:<br>\n");
      out.write("            <input type=\"submit\" value=\"Caculate\"/>\n");
      out.write("        </form>\n");
      out.write("        <h2>Xu ly hoan toan bang JSP</h2>\n");
      out.write("        ");
 
            String n1_raw=request.getParameter("num1");
            String n2_raw=request.getParameter("num2");
            String op=request.getParameter("op");
            double n1=0, n2=0;
            String res="";
            try{
                n1=Double.parseDouble(n1_raw);
                n2=Double.parseDouble(n2_raw);
                switch(op){
                    case "+": res=n1+" + "+n2+" = "+(n1+n2);
                        break;
                    case "-": res=n1+" - "+n2+" = "+(n1-n2);
                        break;
                    case "x": res=n1+" x "+n2+" = "+(n1*n2);
                        break;
                    case ":": 
                        if(n2==0)
                            res= "divide by zero";
                        else
                            res=n1+" : "+n2+" = "+(n1/n2);
                        break;
                }  
            }catch(NumberFormatException ex){
                
            }
        
      out.write("\n");
      out.write("        <h2>");
      out.print( n1 );
      out.write(' ');
      out.print(op);
      out.write(' ');
      out.print( n2);
      out.write(" = ");
      out.print(res);
      out.write("</h2>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

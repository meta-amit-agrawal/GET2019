<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCalculateTriangleProxyid" scope="session" class="com.metacube.soap.service.CalculateTriangleProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCalculateTriangleProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCalculateTriangleProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCalculateTriangleProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.metacube.soap.service.CalculateTriangle getCalculateTriangle10mtemp = sampleCalculateTriangleProxyid.getCalculateTriangle();
if(getCalculateTriangle10mtemp == null){
%>
<%=getCalculateTriangle10mtemp %>
<%
}else{
        if(getCalculateTriangle10mtemp!= null){
        String tempreturnp11 = getCalculateTriangle10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String sideA_1id=  request.getParameter("sideA16");
        double sideA_1idTemp  = Double.parseDouble(sideA_1id);
        String sideB_2id=  request.getParameter("sideB18");
        double sideB_2idTemp  = Double.parseDouble(sideB_2id);
        String sideC_3id=  request.getParameter("sideC20");
        double sideC_3idTemp  = Double.parseDouble(sideC_3id);
        double areaOfTriagle13mtemp = sampleCalculateTriangleProxyid.areaOfTriagle(sideA_1idTemp,sideB_2idTemp,sideC_3idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(areaOfTriagle13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 22:
        gotMethod = true;
        String sideA_4id=  request.getParameter("sideA25");
        double sideA_4idTemp  = Double.parseDouble(sideA_4id);
        String sideB_5id=  request.getParameter("sideB27");
        double sideB_5idTemp  = Double.parseDouble(sideB_5id);
        String sideC_6id=  request.getParameter("sideC29");
        double sideC_6idTemp  = Double.parseDouble(sideC_6id);
        double perimeterOfTriangle22mtemp = sampleCalculateTriangleProxyid.perimeterOfTriangle(sideA_4idTemp,sideB_5idTemp,sideC_6idTemp);
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(perimeterOfTriangle22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>
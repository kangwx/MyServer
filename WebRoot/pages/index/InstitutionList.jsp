<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教育机构列表页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	--> 
<META http-equiv=Content-Type content="text/html; charset=utf-8"><LINK 
href="pages/index/YHChannelApply.files/Style.css" type=text/css rel=stylesheet><LINK 
href="pages/index/YHChannelApply.files/Manage.css" type=text/css rel=stylesheet>
<SCRIPT language=javascript src="pages/index/YHChannelApply.files/FrameDiv.js"></SCRIPT>

<SCRIPT language=javascript src="pages/index/YHChannelApply.files/Common.js"></SCRIPT>

<SCRIPT language=javascript>
        function selectallbox()
        {
            var list = document.getElementsByName('setlist');
            var listAllValue='';
             if(document.getElementById('checkAll').checked)
             {
                  for(var i=0;i<list.length;i++)
                  {
                    list[i].checked = true;
                    if(listAllValue=='')
                        listAllValue=list[i].value;
                    else
                        listAllValue = listAllValue + ',' + list[i].value;
                  }
                  document.getElementById('boxListValue').value=listAllValue;
             }
             else 
             {
                  for(var i=0;i<list.length;i++)
                  {
                    list[i].checked = false;
                  }
                  document.getElementById('boxListValue').value='';
             }
         } 
    </SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR></HEAD>
<BODY>
<FORM id=form1 name=form1 
action=YHChannelApply.aspx?pages=4&amp;item=&amp;client=&amp;flag=0&amp;start=&amp;end=&amp;channel= 
method=post>
<SCRIPT type=text/javascript>
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</SCRIPT>

<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15><IMG src="pages/index/YHChannelApply.files/new_019.jpg" border=0></TD>
    <TD width="100%" background=pages/index/YHChannelApply.files/new_020.jpg height=20></TD>
    <TD width=15><IMG src="pages/index/YHChannelApply.files/new_021.jpg" 
  border=0></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15 background=pages/index/YHChannelApply.files/new_022.jpg><IMG 
      src="pages/index/YHChannelApply.files/new_022.jpg" border=0> </TD>
    <TD vAlign=top width="100%" bgColor=#ffffff>
      <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
        <TR>
          <TD class=manageHead>当前位置：管理首页 &gt; 管理中心 &gt; 教育机构管理页面</TD></TR>
        <TR>
          <TD height=2></TD></TR></TABLE>
      <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" 
      align=center border=0>
        <TBODY>
        <TR>
          <TD height=25>
            <TABLE cellSpacing=0 cellPadding=2 border=0>
              <TBODY>
              <TR>
                <TD>筛选数据：</TD>
                <TD><SELECT id=sClient 
                  name=sClient> <OPTION value="" selected>所有区域</OPTION> 
                    <OPTION value=lenovo>南山区</OPTION> <OPTION 
                    value=lenovoshop>罗湖区</OPTION> <OPTION 
                    value=letao>福田区</OPTION> </SELECT></TD>
                <TD><SELECT id=sFlag 
                  name=sFlag> <OPTION value=0 selected>全部状态</OPTION> <OPTION 
                    value=1>新申请</OPTION> <OPTION value=2>审核通过</OPTION> <OPTION 
                    value=3>审核未通过</OPTION></SELECT></TD>
                <TD>渠道商</TD>
                <TD><INPUT class=textbox id=sChannel2 style="WIDTH: 80px" 
                  maxLength=50 name=sChannel2></TD>
                <TD>起始日期</TD>
                <TD><INPUT class=textbox id=sStart2 style="WIDTH: 70px" 
                  name=sStart2></TD>
                <TD>截止日期</TD>
                <TD><INPUT class=textbox id=sEnd2 style="WIDTH: 70px" 
                  name=sEnd2></TD>
                <TD><INPUT class=button id=sButton2 type=submit value=" 筛选 " name=sButton2></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD>
            <TABLE id=grid 
            style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" 
            cellSpacing=1 cellPadding=2 rules=all border=0>
              <TBODY>
              <TR 
              style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                <TD>教育机构名称</TD>
                <TD>年龄段</TD>
                <TD>区域</TD>
                <TD>特色</TD>
                <TD>简介</TD>
                <TD>修改时间</TD>
                <TD>操作</TD></TR>
              <TR 
              style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                <TD>longlikai1</TD>
                <TD><A href="#" target=_blank>金币网</A></TD>
                <TD><IMG alt=申请通过 src="pages/index/YHChannelApply.files/start.gif" 
                  border=0> </TD>
                <TD>惠普基地</TD>
                <TD>2008-12-18 15:48:36</TD>
                <TD><A 
                  href="#">查看</A> 
                </TD>
                <TD><INPUT id=setlist onClick="check(this,'boxListValue');" 
                  type=checkbox value=65 name=setlist> </TD></TR>
             </TBODY></TABLE></TD></TR>
        <TR>
          <TD align=right height=25><INPUT id=boxListValue type=hidden 
            name=boxListValue> <INPUT class=button id=button1 type=submit value=批量审核通过 name=button1> 
<INPUT class=button id=button2 type=submit value=批量拒绝申请 name=button2> 
            <INPUT onclick=selectallbox(); type=checkbox name=checkAll> 
            全选&nbsp;&nbsp;&nbsp; </TD></TR>
        <TR>
          <TD><SPAN id=pagelink>
            <DIV 
            style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">[<B>84</B>]条记录 
            [6]页 当前是[46-60]条 [<A 
            href="#">前一页</A>] 
            <A class="" 
            href="#">1</A> 
            <A class="" 
            href="#">2</A> 
            <A class="" 
            href="#">3</A> 
            <B>4</B> <A class="" 
            href="#">5</A> 
            <A class="" 
            href="#">6</A> 
            [<A class="" 
            href="#">后一页</A>] 
            <SELECT><OPTION 
              value=1>第1页</OPTION><OPTION value=2>第2页</OPTION><OPTION 
              value=3>第3页</OPTION><OPTION value=4 selected>第4页</OPTION><OPTION 
              value=5>第5页</OPTION><OPTION 
            value=6>第6页</OPTION></SELECT></DIV></SPAN></TD></TR></TBODY></TABLE></TD>
    <TD width=15 background=pages/index/YHChannelApply.files/new_023.jpg><IMG 
      src="pages/index/YHChannelApply.files/new_023.jpg" border=0> </TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
  <TBODY>
  <TR>
    <TD width=15><IMG src="pages/index/YHChannelApply.files/new_024.jpg" border=0></TD>
    <TD align=middle width="100%" background=pages/index/YHChannelApply.files/new_025.jpg 
    height=15></TD>
    <TD width=15><IMG src="pages/index/YHChannelApply.files/new_026.jpg" 
  border=0></TD></TR></TBODY></TABLE>
</FORM></BODY></HTML>


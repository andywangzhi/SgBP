<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="45%" align="center">
              <s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_di[session._CUR_USER_LANG_]"/><s:property value="paging.currentIndex" /><s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_page[session._CUR_USER_LANG_]"/>/<s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_all[session._CUR_USER_LANG_]"/><s:property value="paging.totalPages"/><s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_page[session._CUR_USER_LANG_]"/>,<s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_show[session._CUR_USER_LANG_]"/><s:property value="paging.pageSize" /><s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_count[session._CUR_USER_LANG_]"/> 
        </td>
        <td width="15%"><s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_di[session._CUR_USER_LANG_]"/>
             <select name="form.queryListSO.curPage" id="currentIndex" onchange="pageSubmit(this.value);">
                <%
                 String selected="";
                 int totalPages = Integer.parseInt(request.getAttribute("paging.totalPages").toString());
                 int currentIndex = Integer.parseInt(request.getAttribute("paging.currentIndex").toString());
                  for(int nowpage=1; nowpage<=totalPages; nowpage++)
                  {
                    if (currentIndex==nowpage){
                     selected="selected";
                    }else{
                     selected="";
                    }
                %>
                    <option value="<%=nowpage%>" <%=selected%> ><%=nowpage%></option>
                <%
                  }
                %>   
             </select>              
              <s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_page[session._CUR_USER_LANG_]"/></td>
        <td width="10%" class="alink"><a href="javascript:pageSubmit(1);" /><s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_first[session._CUR_USER_LANG_]"/></a></td>
        <td width="10%" class="alink"><a href="javascript:pageSubmit(<s:property value="paging.currentIndex-1" />);" /><s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_pre[session._CUR_USER_LANG_]"/></a></td>
        <td width="10%" class="alink"><a href="javascript:pageSubmit(<s:property value="paging.currentIndex+1" />);" /><s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_next[session._CUR_USER_LANG_]"/></a></td>
        <td width="10%" class="alink"><a href="javascript:pageSubmit(<s:property value="paging.totalPages"/>);" /><s:property value="#application._WEB_SYS_RESOURCE_KEY_.page_last[session._CUR_USER_LANG_]"/></a></td>
      </tr>
   </table>

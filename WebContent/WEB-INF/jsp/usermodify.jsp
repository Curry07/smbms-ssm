<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user/modifyUser.html">
<%--         <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user/modifyUser.html" enctype="multipart/form-data"> --%>
        	<!-- 用户的id  -->
			<input type="hidden" name="id" value="${user.id }"/>
			 <div>
                    <label for="userName">用户编码：</label>
                    <input type="text" value="${user.userCode }" readonly="readonly"> 
             </div>
			 <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${user.userName }"> 
					<font color="red"></font>
             </div>
			 <div>
                    <label >用户性别：</label>
                    <select name="gender" id="gender">
                        <%-- <c:if test="${user.gender == 2} }">selected</c:if> --%>
                        <option value="2" <c:if test="${user.gender == 2} }">selected</c:if>>男</option>
                        <option value="1" <c:if test="${user.gender == 1} }">selected</c:if>>女</option>
						<%-- <c:choose>
							<c:when test="${user.gender == 1 }">
								<option value="1" selected="selected">男</option>
					    		<option value="2">女</option>
							</c:when>
							<c:otherwise>
								<option value="1">男</option>
					    		<option value="2" selected="selected">女</option>
							</c:otherwise>
						</c:choose> --%>
					 </select>
             </div>
			 <div>
                    <label for="data">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" value="<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/>"
					readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
              </div>
			
		       <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="${user.phone }"> 
                    <font color="red"></font>
               </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="address" value="${user.address }">
                </div>
				<div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<input type="hidden" value="${user.userRole }" id="rid" />
					<select name="userRole" id="userRole">
						<option value="1" <c:if test="${user.userRole == 1 }">selected</c:if> >系统管理员</option>
						<option value="2" <c:if test="${user.userRole == 2 }">selected</c:if> >经理</option>
						<option value="3" <c:if test="${user.userRole == 3 }">selected</c:if> >普通用户</option>
		    		</select>
        			<font color="red"></font>
                </div>
                <div>
                	<label for="m_idPicPath">证件照：</label>
                	<%-- <c:choose>
	            		<c:when test="${user.idPicPath == null || user.idPicPath == ''}">
	            	 		<input type="hidden" id="errorinfo" value="${uploadFileError}"/>
                   			<input type="file" name="attachs" id="m_idPicPath"/>
                    		<font color="red"></font>
	            		</c:when>
	            		<c:otherwise>
	            			<img src="${user.idPicPath}"/>
	            		</c:otherwise>
           			</c:choose> --%>
                </div>
               <div>
               	   <label for="m_workPicPath">工作证照片：</label>
	               <%-- <c:choose>
	            		<c:when test="${user.workPicPath == null || user.workPicPath == ''}">
	            	 		<input type="hidden" id="errorinfo_wp" value="${uploadWpError}"/>
                   			<input type="file" name="attachs" id="m_workPicPath"/>
                    		<font color="red"></font>
	            		</c:when>
	               		<c:otherwise>
	            			<img src="${user.workPicPath}"/>
	                    </c:otherwise>
	                </c:choose> --%>
                </div>
			 <div class="providerAddBtn">
                    <input type="button" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/usermodify.js"></script>

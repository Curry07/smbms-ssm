﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <%-- <form id="userForm" name="userForm" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/user/useraddsave.html"> --%>
            <form id="userForm" name="userForm" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/auth/user/useraddsave">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户编码：</label>
                    <input type="text" name="userCode" id="userCode" value=""> 
					<!-- 放置提示信息 -->
                    <form:errors path="userCode"/> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="">
					<font color="red"></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userPassword" id="userPassword" value=""> 
                    <form:errors path="userPassword"/>
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					<select name="gender" id="gender">
					    <option value="2" selected="selected">男</option>
					    <option value="1">女</option>
					 </select>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"><form:errors path="birthday"/></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   <input name="address" id="address"  value="">
                </div>
                <div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
				    <!-- <select name="userRole" id="userRole"></select> -->
				    <!-- 后期我们学习了SpringMVC如何处理AJAX之后  再更改 -->
				    <select name="userRole" id="userRole">
						<option value="1">系统管理员</option>
						<option value="2">经理</option>
						<option value="3" selected="selected">普通用户</option>
				    </select>
		            <font color="red"></font>
                </div>
                <!-- name保持一致  会以数组发送-->
                <div>
                	<input type="hidden" id="idPicPathError" value="${idPicPathError}"/>
                	<label for="a_idPicPath">证件照：</label>
                	<input type="file" name="attchs" id="a_idPicPath"/>
		            <font color="red"></font>
                </div>
               <%--  <div>
                	<input type="hidden" id="workPicPathError" value="${workPicPathError}"/>
                	<label for="workPicPath">工作证照：</label>
                	<input type="file" name="attchs" id="workPicPath"/>
		            <font color="red"></font>
                </div> --%>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>
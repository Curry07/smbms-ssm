var userObj;

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteUser(obj){
	window.location.href=path+"/user/delete/"+obj.attr("userid");
	/*$.ajax({
		type:"GET",
		url:path+"/jsp/user.do",
		data:{method:"deluser",uid:obj.attr("userid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除用户【"+obj.attr("username")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，用户【"+obj.attr("username")+"】不存在");
				changeDLGContent("对不起，用户【"+obj.attr("username")+"】不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});*/
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//通过jquery的class选择器（数组）
	//对每个class为viewUser的元素进行动作绑定（click）
	
	// 点击列表的用户行时 在页面下方显示简单的信息
	$(".userView").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		$.ajax({
			//rest风格  获取参数值时利用注解@pathViable进行
			url:path+"/auth/user/userView/"+obj.attr("userid"),
		    //data:{id:obj.attr("userid")},
			type:"Get",
			dataType:"json",
			success:function(result){
				// alert(result.flag);
					/*$("#userInfo").css("display","block");
					$("#v_userCode").val(result.userCode);
					$("#v_userName").val(result.userName);
					if(result.gender==1){
						$("#v_gender").val("女");
					}else if(result.gender==2){
						$("#v_gender").val("男");
					}
					$("#v_birthday").val(result.birthday);
					$("#v_phone").val(result.phone);
					$("#v_userRoleName").val(result.userRoleName);
					$("#v_address").val(result.address);*/
					
				if(result.flag=="success"){
					$("#userInfo").css("display","block");
					$("#v_userCode").val(result.user.userCode);
					$("#v_userName").val(result.user.userName);
					if(result.user.gender==1){
						$("#v_gender").val("女");
					}else if(result.user.gender==2){
						$("#v_gender").val("男");
					}
					$("#v_birthday").val(result.user.birthday);
					$("#v_phone").val(result.user.phone);
					$("#v_userRoleName").val(result.user.userRoleName);
					$("#v_address").val(result.user.address);
					
				}else{
					alert("服务器忙，请重试！");
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				alert("服务器失败！！！")
			}   
		});
		
	});
	/**
	 * bind、live、delegate
	 * on
	 */
	$(".viewUser").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		// 以前：path+"/user/view?id=xxx"
		window.location.href=path+"/user/view/"+ obj.attr("userid");
	});
	
	$(".modifyUser").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/user/toModify/"+ obj.attr("userid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteUser(userObj);
	});

	$(".deleteUser").on("click",function(){
		userObj = $(this);
		changeDLGContent("你确定要删除用户【"+userObj.attr("username")+"】吗？");
		openYesOrNoDLG();
	});
	
	/*$(".deleteUser").on("click",function(){
		var obj = $(this);
		if(confirm("你确定要删除用户【"+obj.attr("username")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/jsp/user.do",
				data:{method:"deluser",uid:obj.attr("userid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除用户【"+obj.attr("username")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，用户【"+obj.attr("username")+"】不存在");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
});
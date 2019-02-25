<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		 $("#modify").click(function () {
			 		var id =$("input[name='id']").val();
			 		var name =$("input[name='name']").val();
			 		var sex =$("input[name='sex']").val();
			 		var stuClass =$("select[name='stuClass']").val();
	           $.ajax({
	        	  	url:"/student/modifyStudent",
	        	   	type: "PUT",
	                data:{ id:id,name:name,sex:sex,stuClass:stuClass},
	                dataType:"json",
	                async:"true",
	                success: function (res) {
	                	if(res.result==1){
	                		window.location="/student/getAll";
	                	}
						
	                }
	
	           })
	        })
	
	})
</script>
</head>

<body>
		
		
		<c:forEach items="${allStudent }" var="student" >
			<input type="hidden" name="id" value="${student.id }"/><br/>
			姓名：<input type="text" name="name" value="${student.name }"/><br/>
			性别：<input type="text" name="sex" value="${student.sex }"/><br/>
			<select name="stuClass" id="stuClass" >
				<c:forEach items="${allClasses }" var="clas">
					<option value="${clas.id }" <c:if test="${student.stuClass== clas.id}">selected="selected"</c:if> >${clas.className }</option>
				</c:forEach>
			</select>
			
		</c:forEach>
			
		<button id="modify" type="button">提交</button><br/>
</body>
</html>
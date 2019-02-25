<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js""></script>
<script type="text/javascript">
	function addStudent(){
		window.location="/student/showBeforeAdd";
	}
		function deleteAjax(ids){
			var id = ids;
			$.ajax({
				url:"/student/deleteStudent/"+id,
				type:"DELETE",
				dataType:"json",
                async:"true",
				success:function(res){
					if(res.result==1){
						window.location="/student/getAll";
					}
				}
				
			})
		}
		
</script>
</head>

<body>
	<form action="/student/getByName" method="Get" >
	姓名：<input type="text" name="name">
		<input type="submit" value="查询"> 
	<button type="button" id="addStudnet" onclick="addStudent()"  >新增</button>
	</form>
<table width="300" border="1px" bgcolor="grey">
		<thead>
			<tr><th>id</th><th>name</th><th>sex</th><th>class</th><th colspan="2">操作</th></tr>
			
		</thead>
		
		<c:forEach items="${allStudent }" var="student" >
			<tr>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td>${student.sex }</td>
				<td>${student.clas.className }</td>
				<td><a href="/student/modifyStudentShow/${student.id}">修改</a></td>
				<td><button type="button" id="deleteStudent" onclick="deleteAjax('${student.id }')">删除</button></td>
			</tr>
		</c:forEach>
		
</table>
</body>
</html>
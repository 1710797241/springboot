<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>
		
		<form action="/student/addStudent" method="post">
		
		
			姓名：<input type="text" name="name" value="${student.name }"/><br/>
			性别：<input type="text" name="sex" value="${student.sex }"/><br/>
			<select name="stuClass" id="stuClass" >
				<c:forEach items="${allClasses }" var="clas">
					<option value="${clas.id }" >${clas.className }</option>
				</c:forEach>
			</select>
			<input type="submit" value="新增"/>
			</form>
			
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<tags:mainlayout>

<jsp:attribute name="breadcrumb"><a href=".">Home</a></jsp:attribute>

<jsp:body>

<table class="itemlist">
		
	<tr>
		<th>Report name</th><th>Date</th>	
	</tr>
	
	<c:forEach items="${reports}" var="report">
		<tr>
			<td>
				<a href="${pageContext.request.contextPath}/expense/${report.id}">${report.name}</a>
			</td>
			<td>	
				<fmt:formatDate value="${report.reportDate }" pattern="dd MMM yyyy"/></a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td>
			<br/><br/>
			<form action="" method="post">
				<input type="button" name="New Expense Report" value="New Expense Report" onclick="location.href='${pageContext.request.contextPath}/expense/new'"/>
			</form>
		</td>
	</tr>
</table>

</jsp:body>

</tags:mainlayout>
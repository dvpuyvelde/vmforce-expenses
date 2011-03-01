<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<tags:mainlayout>




<jsp:attribute name="breadcrumb"><a href=".">Home</a></jsp:attribute>
<jsp:body>

<script>
$(document).ready(function() {

	$( "#reportDatepicker" ).datepicker({
			altField: "#reportDateHidden",
			altFormat: "yy-mm-dd",
			dateFormat: "dd M yy"
		});
});
</script>


<form:form commandName="expensereport">
<form:hidden path="id"/>
<table class="itemlist">
	<tr>
		<th><br/></th><th></th>	
	</tr>
	<tr>
		<td width="150px"><br/></td>
		<td width="250px"></td>
	</tr>
	<tr>
		<td>Report Name</td>
		<td><form:input path="name"/></td>
	</tr>
	<tr>
		<td>Date</td>
		<td>
			<input type="text" value="<fmt:formatDate value="${expensereport.reportDate }" pattern="dd MMM yyyy"/>" id="reportDatepicker"/>
			<form:hidden id="reportDateHidden" path="reportDate"/> <!-- saved in yyyy-MM-dd format -->
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" value="Save"/>
			<c:if test="${expensereport.id != null}">
				<input type="button" value="Delete" onclick="location.href='${ pageContext.request.contextPath }/expense/${expensereport.id}/delete'"/>
			</c:if>
		</td>
	</tr>
</table>
</form:form>

<c:if test="${expensereport.id != null}">
<table class="itemlist">
	<tr>
		<th>Date</th>
		<th>Description</th>
		<th>Amount</th>
		<th></th>
	</tr>
	<c:forEach items="${expensereport.lines}" var="line">
		<tr>			
			<td><fmt:formatDate value="${line.expenseDate }" pattern="dd MMMM yyyy"/></td>
			<td>${line.description }</td>
			<td>${line.amount }</td>
			<td><a href="${pageContext.request.contextPath}/expenselines/${line.id}/delete"/>Del</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="2"></td>
		<td colspan="2">
			<input type="button" name="Add Expense" value="Add Expense" onclick="location.href='${pageContext.request.contextPath}/expenselines/${expensereport.id}'"/>
		</td>
	</tr>
</table>
</c:if>


</jsp:body>

</tags:mainlayout>
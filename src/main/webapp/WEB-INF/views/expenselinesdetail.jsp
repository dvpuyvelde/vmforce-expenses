<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<tags:mainlayout>

<jsp:attribute name="breadcrumb"><a href="${pageContext.request.contextPath}">Home</a></jsp:attribute>
<jsp:body>

<script>
$(document).ready(function() {

	$( "#expenseDatepicker" ).datepicker({
			altField: "#expenseDateHidden",
			altFormat: "yy-mm-dd",
			dateFormat: "dd M yy"
		});
});
</script>


	<h3>${er.name}</h3>
	<table class="itemlist">
	<tr>		
		<th>Date</th>
		<th>Description</th>
		<th>Amount</th>
	</tr>
	<c:forEach items="${ lines }" var="line">
		<tr>
			<!-- <td>${line.id}</td>
			<td>${line.name}</td> -->
			<td><fmt:formatDate value="${line.expenseDate}" pattern="dd MMM yyyy"/></td>
			<td>${line.description}</td>
			<td>${line.amount}</td>			
		</tr>
	</c:forEach>
	</table>
	
	<h3>Add expense</h3>
	
	<form:form commandName="newline">
		<table class="itemlist">
			<tr>
				<th><br/></th><th></th>
			</tr>
<!--			<tr>-->
<!--				<td>-->
<!--					Name : -->
<!--				</td>-->
<!--				<td>-->
<!--					<form:input path="name"/>-->
<!--				</td>-->
<!--			</tr>-->
			<tr>
				<td>
					Date : 
				</td>
				<td>
					<input type="text" value="" id="expenseDatepicker"/>
					<form:hidden id="expenseDateHidden" path="expenseDate"/>
				</td>
			</tr>
			<tr>
				<td>
					Description : 
				</td>
				<td>
					<form:input path="description"/>
				</td>
			</tr>			
			<tr>
				<td>
					Amount : 
				</td>
				<td>
					<form:input path="amount"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save"/></td>
			</tr>
		</table>		
	</form:form>

</jsp:body>

</tags:mainlayout>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="breadcrumb" required="false" rtexprvalue="true"%>
<%@ attribute name="hidesearch" required="false" rtexprvalue="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>Expenses</title>
	<link href="${pageContext.request.contextPath}/resources/layout.css" rel="stylesheet" type="text/css" />
	<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/themes/base/jquery-ui.css" rel="Stylesheet" />	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js"></script>

</head>
<body>
<table>
	<tr>
		<td colspan="2">
			<div id="header">
				<div id="app_title">Expense Reports</div>
			</div>
<!--			<form action="" method="get">-->
<!--				<div id="navigation">${breadcrumb}</div>-->
<!--			</form>-->
		</td>
	</tr>
	<tr>
		<td valign="top">
			<div id="leftbar">
				<div id="nav"><a href="${pageContext.request.contextPath}/expense/">View All</td></div>
			</div>
		</td>
		<td valign="top">
			<div id="content"><jsp:doBody /></div>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<div id="footer">
				
			</div>
		</td>
	</tr>
</table>
</body>
</html>

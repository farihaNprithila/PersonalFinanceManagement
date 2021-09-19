<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%--
  @author Prithila
  @since 9/20/2021
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bank Transaction Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>

<body>
<div class="p-3" align="center">
    <h4>Transaction List</h4>
    <div class="w-75 p-3 table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Transaction Id</th>
                <th scope="col">Account Number</th>
                <th scope="col">Transaction Type</th>
                <th scope="col">Amount</th>
                <th scope="col">Transaction Date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="banktransactions" items="${banktransaction}" varStatus="status">
                <tr>
                    <td><c:out value="${banktransactions.id}"/></td>
                    <td><c:out value="${banktransactions.accountNumber}"/></td>
                    <td><c:out value="${banktransactions.transactionType}"/></td>
                    <td><c:out value="${banktransactions.amount}"/></td>
                    <td><c:out value="${banktransactions.transactionDate}"/></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary float-left" href="/addtransaction">Add New Transaction</a>
    </div>
</div>
</body>
</html>
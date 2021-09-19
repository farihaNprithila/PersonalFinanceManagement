<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%--
  @author Prithila
  @since 9/20/2021
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Transaction</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>

<body>
<div class="mt-lg-5 col-md-12" align="center">
    <div class="w-50 p-3 rounded" style="background-color: #eee;">
        <form:form method="POST" action="/addtransaction" modelAttribute="addtransaction">
        <div class="form-row" align="center">
            <div class="col-md mb-3">
                <form:label for="accountNumber" path="accountNumber">Account Number</form:label>
                <form:input path="accountNumber" type="text" class="form-control"
                            placeholder="Enter Account Number"/>
            </div>
        </div>
        <p>Transaction Type</p>
        <div class="form-row" align="center">
            <div class="form-check" align="center">
                <input class="form-check-input" type="radio" name="transactionType" id="transactionType"
                       value="Debit" checked>
                <form:label class="form-check-label" for="transactionType" path="transactionType">
                    Debit
                </form:label>
            </div>
            <div class="form-check" align="center">
                <input class="form-check-input" type="radio" name="transactionType" id="transactionType"
                       value="Credit">
                <form:label class="form-check-label" for="transactionType" path="transactionType">
                    Credit
                </form:label>
            </div>
        </div>
        <div class="form-row" align="center">
            <div class="col-md mb-3">
                <form:label for="amount" path="amount">Amount</form:label>
                <form:input path="amount" type="number" class="form-control" placeholder="Enter Amount"/>
            </div>
        </div>
    </div>
    <input type="hidden" id="task" name="task" value="add">
    <button class="btn btn-primary" type="submit">Submit</button>
    </form:form>
</div>
</div>
</body>
</html>
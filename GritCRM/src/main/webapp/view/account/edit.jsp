<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/fragments/header.jsp" %>
<%@ include file="/WEB-INF/fragments/navbar.jsp" %>

<h2>Create or edit account</h2>

<form method="POST" action="/account">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name" value="${name}">
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">Address</label>
        <input type="text" class="form-control" id="address" name="address" value="${address}">
    </div>
    <div class="mb-3">
        <label for="country" class="form-label">Country</label>
        <input type="text" class="form-control" id="country" name="country" value="${country}">
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
    <a href="/account" class="btn btn-secondary">Cancel</a>
</form>

<%@include file="/WEB-INF/fragments/footer.jsp" %>
<%@tag language="java" pageEncoding="utf-8" %>

<%@attribute name="title" required="true" %>
<%@attribute name="subtitle" required="false" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel='stylesheet' href='/assets/css/style.css'>
        <meta content="text/html;charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <div class="container">
        <h2>${subtitle}</h2>
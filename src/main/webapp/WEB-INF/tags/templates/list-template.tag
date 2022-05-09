<%@tag language="java" pageEncoding="utf-8" %>

<%@attribute name="title" required="true" %>

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <link rel='stylesheet' href='/webjars/bootstrap/3.3.7/css/bootstrap.min.css'>
        <meta content="text/html;charset=UTF-8">
    </head>
    <body>
        <div class="container">
            <jsp:doBody />
        </div>
        <script src="/assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="/assets/js/scripts.js"></script>
    </body>
</html>
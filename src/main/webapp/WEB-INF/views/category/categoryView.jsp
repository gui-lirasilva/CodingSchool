<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${categoryDto.name} | Cursos online de tecnologia</title>
    <link rel="stylesheet" href="../../../assets/css/categoryView.css">
</head>
<body>
<section class="category-banner__wrapper">
    <div class="container category-banner">
            <span class="category-banner__icon">
                <img src="${categoryDto.iconPath}">
            </span>
        <h1 class="category-banner__title">${categoryDto.name}</h1>
    </div>
</section>
<main class="container">
    <div class="subcategories">
        <p class="subcategories__label">O que você quer aprender?</p>
        <ul class="subcategories__list">
            <c:forEach items="${categoryDto.subcategories}" var="subcategory">
                <li class="subcategories__item">
                    <a href="#${subcategory.name}" class="subcategories__link">
                        <span class="subcategories__name">${subcategory.name}</span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="subcategory">
        <c:forEach items="${categoryDto.subcategories}" var="subcategory" varStatus="loop">
            <h2 id="${subcategory.name}" class="subcategory__name">${subcategory.name}</h2>
            <ul class="courses__list">
                <c:forEach items="${subcategory.courses}" var="course">
                    <li class="course-card">
                        <h3 class="course-card__name">${course.name}</h3>
                        <p class="course-card__hours">${course.estimatedTime}</p>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>
    </div>
</main>
</body>
</html>
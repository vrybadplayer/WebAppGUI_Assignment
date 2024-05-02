<%-- 
    Document   : Products
    Created on : Apr 10, 2024, 7:48:19 PM
    Author     : ASUS
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap">
        <link rel="stylesheet" href="products.css">
        <title>Products</title>
        <%@page import="domain.Product" %>
        <%@page import="domain.Customer"%>
        <jsp:useBean id="customer" scope="session" class="domain.Customer" />
    </head>
    <body>    

        <%
            int prodId = Integer.parseInt(request.getParameter("productId"));
            int picNo = Integer.parseInt(request.getParameter("picNo"));
            String category = request.getParameter("category");
            Product prod = Product.SearchProduct(prodId);
            String custID = (String) session.getAttribute("custID");
%>

        <div class="main-container">
            <span class="course-title"><%= prod.getName()%></span>
            <div class="flex-row-ffc">
                <div class="overview-box">
                    <span class="course-title-1"><%= prod.getName()%><br>Full Walkthrough<br><br><br></span>
                    <div class="organizer-contributor">
                        <span class="by">by </span><span class="organizer"><%= prod.getOrganizer()%></span><span class="by-2">, </span><span class="contributor"><%= prod.getContributor()%></span>
                    </div>
                    <div class="flex-row-aad">
                        <div class="category-logo"></div>
                        <span class="category"><%= prod.getCategory()%></span>
                    </div>
                    <div class="flex-row-b">
                        <div class="experience-level-logo"></div>
                        <span class="experience"><%= prod.getLevel()%></span>
                    </div>
                    <div class="flex-row-ae">
                        <div class="skills-logo"></div>
                        <span class="title">Skills Gained:</span>
                    </div>

                    <%
                        String skills = prod.getSkills();
                        String[] skillsArr = skills.split(", ");
                    %>

                    <span class="skill"><%= skillsArr[0]%></span><span class="skill2"><%= skillsArr[1]%></span>

                    <div class="flex-row-ccb">
                        <div class="duration-logo"></div>
                        <span class="duration"><%= prod.getDuration()%> weeks</span>
                    </div>

                    <div class="flex-row">
                        <div class="price-logo"></div>
                        <span class="price">RM <%= prod.getPrice()%></span>
                    </div>

                    <div class="button">
                        <form method="post" action="ProductsServlet">
                            <input type="hidden" name="prodId" value="<%= prod.getId()%>">
                            <input type="hidden" name="custId" value="<%= custID%>">
                            <input type="hidden" name="picNo" value="<%= picNo%>">
                            <input type="hidden" name="category" value="<%= category%>">
                            <button class="add-to-cart" type="submit">Add To Cart</button>
                        </form>
                    </div>

                </div>
                <span class="synopsis"><%= prod.getSynopsis()%></span>
                <div class="box">


                    <span class="review-amount">(<% out.println(prod.getReviews());%> reviews)</span><span class="rating-score"><%= prod.getRating()%></span>

                    <%
                        if (prod.getRating() >= 1) {
                            out.println("<div class=\"star-7\"></div>");
                        }
                        if (prod.getRating() >= 2) {
                            out.println("<div class=\"star-6\"></div>");
                        }
                        if (prod.getRating() >= 3) {
                            out.println("<div class=\"star-5\"></div>");
                        }
                        if (prod.getRating() >= 4) {
                            out.println("<div class=\"star-4\"></div>");
                        }
                        if (prod.getRating() >= 4.5) {
                            out.println("<div class=\"star\"></div>");
                        }
                    %>

                </div>

                <%
                    out.println("<div class=\"course-image\">");
                    out.println("<img src=\"./assets/courseImages/" + category + picNo + ".jpg\" alt=\"Product Image\">");
                    out.println("</div>");
                %>

            </div>
            <div class="background"></div>
            <div class="flex-row-abc">
                <div class="divider"></div>

                <span class="objective"><%= prod.getObjective()%>

                </span><span class="module-list">

                    <%
                        String modules = prod.getModules();
                        String[] modulesArr = modules.split(", ");

                        for (int i = 0; i < modulesArr.length; ++i) {
                            out.println(modulesArr[i] + "<br>");
                        }
                    %>

                </span>

                <div class="button-8">
                    <form method="post" action="ProductsServlet">
                        <input type="hidden" name="prodId" value="<%= prod.getId()%>">
                        <input type="hidden" name="custId" value="<%= custID%>">
                        <input type="hidden" name="picNo" value="<%= picNo%>">
                        <input type="hidden" name="category" value="<%= category%>">
                        <button class="join-course-now">Join Course Now</button>
                    </form>
                </div>
            </div>
            <div class="flex-row-f">
                <span class="modules">Modules</span><span class="objectives">Objectives</span>
            </div>
        </div>
    </body>
</html>
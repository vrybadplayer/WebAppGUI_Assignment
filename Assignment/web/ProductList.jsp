
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Product List</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap" />
        <link rel="stylesheet" href="ProductList.css" />

        <!-- 
        1) Search Category needs change
        --->

        <%@page import="domain.Product" %>
        <%@page import="java.util.ArrayList"%>

        <%
            ArrayList<Product> productList = Product.SearchCategory("Web Development");
            int totalProducts = productList.size();
            //Get How Many Rows
            int rows = totalProducts / 3;
            int productNo = 0;
            if (totalProducts % 3 != 0) {
                ++rows;
            }
        %>

    </head>
    <body>
        <div class="main-container">
            <div class="background">
                <span class="category-name">Category: <%= productList.get(0).getCategory()%></span>
                <%
                    for (int i = 0; i < rows; ++i) {
                        out.println("<div class=\"flex-row-fcb\">");
                        for (int maxInRow = 0; maxInRow < 3; ++maxInRow) {
                            if (productNo < totalProducts) {
                                out.println("<div class=\"box\">");
                                out.println("<a href=\"Products.jsp?productId=" + productList.get(productNo).getId() + "\" class=\"box\">");
                                //Change image address to properly named images later
                                out.println("    <div class=\"course-image\"><img src=\"./assets/images/c8f455020c0075dd7e7431d44fff4bb388618a7a.png\" alt=\"Product Image\"></div>"); 
                                out.println("    <span class=\"course-title\">" + productList.get(productNo).getName() + "</span>");
                                out.println("    <span class=\"reviews\">" + productList.get(productNo).getReviews() + " Reviews</span>");
                                out.println("    <span class=\"description\">" + productList.get(productNo).getSynopsis() + "</span>");
                                out.println("    <span class=\"price\">RM" + productList.get(productNo).getPrice() + "</span>");
                                out.println("</a>");
                                out.println("</div>");
                                ++productNo;
                            }
                        }
                        out.println("</div>");
                    }

                %>
            </div>
        </div>
    </body>
</html>

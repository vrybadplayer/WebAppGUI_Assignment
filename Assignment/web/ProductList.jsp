
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
            ArrayList<Product> productList = Product.SearchCategory("Language");
            int totalProducts = productList.size();
            //Get How Many Rows
            int rows = totalProducts / 3;
            int productNo = 0;
            if (totalProducts % 3 != 0) {
                ++rows;
            }
            String getCategory = productList.get(0).getCategory();
            String categoryImage;
            if (getCategory.equals("Language"))
                categoryImage = "language";
            else if (getCategory.equals("Design"))
                categoryImage = "design";
            else if (getCategory.equals("Accounting"))
                categoryImage = "accounting";
            else if (getCategory.equals("Information Technology"))
                categoryImage = "it";
            else if (getCategory.equals("Business"))
                categoryImage = "business";
            else {
                categoryImage = "";
            }
        %>

    </head>
    <body>
        <div class="main-container">
            <div class="background">
                <span class="category-name">Category: <%= productList.get(0).getCategory()%></span>
                <%
                    int picNo = 1;
                    for (int i = 0; i < rows; ++i) {
                        out.println("<div class=\"flex-row-fcb\">");
                        for (int maxInRow = 0; maxInRow < 3; ++maxInRow) {
                            if (productNo < totalProducts) {
                                out.println("<div class=\"box\">");
                                out.println("<a href=\"Products.jsp?productId=" + productList.get(productNo).getId() + "&picNo=" + picNo + "&category=" + categoryImage + "\" class=\"box\">");
                                //Change image address to properly named images later
                                out.println("    <div class=\"course-image\"><img src=\"./assets/courseImages/" + categoryImage + picNo + ".jpg\" alt=\"Product Image\"></div>");
                                out.println("    <span class=\"course-title\">" + productList.get(productNo).getName() + "</span>");
                                out.println("    <span class=\"reviews\">" + productList.get(productNo).getReviews() + " Reviews</span>");
                                out.println("    <span class=\"description\">" + productList.get(productNo).getSynopsis() + "</span>");
                                out.println("    <span class=\"price\">RM" + productList.get(productNo).getPrice() + "</span>");
                                out.println("</a>");
                                out.println("</div>");
                                ++productNo;
                                ++picNo;
                                if (picNo == 11) {
                                    picNo = 1;
                                }
                            }
                        }
                        out.println("</div>");
                    }

                %>
            </div>
        </div>
    </body>
</html>

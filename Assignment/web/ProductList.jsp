
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Product List</title>
        <link rel="stylesheet" href="main_1.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap" />
        <link rel="stylesheet" href="ProductList.css" />

        <%@page import="domain.Product" %>
        <%@page import="java.util.ArrayList"%>

        <%
            ArrayList<Product> productList = Product.SearchCategory(request.getParameter("Category"));
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
            else if (getCategory.equals("InformationTechnology"))
                categoryImage = "it";
            else if (getCategory.equals("Business"))
                categoryImage = "business";
            else {
                categoryImage = "";
            }
        %>

    </head>
    <body>


        <div class="navDropDown">
            <header>

                <div class="logo">
                    <img src="Images2/icon.png" alt="icon" class="logoImg">
                    <a href="#" class="logoText">SmartLearn<span>.</span></a>
                </div>

                <input type="checkbox" name="" id="toggler">
                <label for="toggler" class="fas fa-bars"></label>

                <form class="searchBar">
                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    <input type="text" placeholder="Search.." name="search">
                </form>



                <nav class="navbar">
                    <a href="#home">Home</a>
                    <a href="#" class="courseLink">Explore</a>
                    <a href="#">Staff Portal</a>
                    <div class="cart">
                        <a href="#"><img src="Images2/shopBag.svg" alt="cart"></a>
                    </div> 
                    <div class="loginBtn">
                        <a href="#">Login</a>
                    </div>              

                </nav>

            </header>

            <div class="dropdown">
                <div class="courses">
                    <ul>
                        <li>
                            <h2>Design</h2>
                            <a href="ProductList.jsp?Category=Design">Digital Animation          </a><br>
                            <a href="ProductList.jsp?Category=Design">Illustration     </a><br>
                            <a href="ProductList.jsp?Category=Design">Digital Media Design       </a><br>
                            <a href="ProductList.jsp?Category=Design">Interior Design       </a><br>
                            <a href="ProductList.jsp?Category=Design">Advertising & Graphic Design        </a><br>
                            <a href="ProductList.jsp?Category=Design">Fashion Design      </a><br>
                        </li>
                    </ul>
                </div>
                <div class="courses">
                    <ul>
                        <li>
                            <h2>Business</h2>
                            <a href="ProductList.jsp?Category=Design">Design           </a><br>
                            <a href="ProductList.jsp?Category=InformationTechnology">Technologies     </a><br>
                            <a href="ProductList.jsp?Category=Accounting">Accounting       </a><br>
                            <a href="ProductList.jsp?Category=Business">Business         </a><br>
                            <a href="ProductList.jsp?Category=Language">Language         </a><br>
                        </li>
                    </ul>
                </div>
                <div class="courses">
                    <ul>
                        <li>
                            <h2>Accounting</h2>
                            <a href="ProductList.jsp?Category=Design">Design           </a><br>
                            <a href="ProductList.jsp?Category=InformationTechnology">Technologies     </a><br>
                            <a href="ProductList.jsp?Category=Accounting">Accounting       </a><br>
                            <a href="ProductList.jsp?Category=Business">Business         </a><br>
                            <a href="ProductList.jsp?Category=Language">Language         </a><br>
                        </li>
                    </ul>
                </div>
                <div class="courses">
                    <ul>
                        <li>
                            <h2>Technologies</h2>
                            <a href="ProductList.jsp?Category=Design">Design           </a><br>
                            <a href="ProductList.jsp?Category=InformationTechnology">Technologies     </a><br>
                            <a href="ProductList.jsp?Category=Accounting">Accounting       </a><br>
                            <a href="ProductList.jsp?Category=Business">Business         </a><br>
                            <a href="ProductList.jsp?Category=Language">Language         </a><br>
                        </li>
                    </ul>
                </div>

                <div class="courses">
                    <ul>
                        <li>
                            <h2>Language</h2>
                            <a href="ProductList.jsp?Category=Design">Design           </a><br>
                            <a href="ProductList.jsp?Category=InformationTechnology">Technologies     </a><br>
                            <a href="ProductList.jsp?Category=Accounting">Accounting       </a><br>
                            <a href="ProductList.jsp?Category=Business">Business         </a><br>
                            <a href="ProductList.jsp?Category=Language">Language         </a><br>
                        </li>
                    </ul>
                </div>


            </div>
        </div>
        <script src="main.js"></script>

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

        <footer>
            <div class="footBg">
                <div class="footLinks">
                    <div class="footerL1">
                        <ul>
                            <li>
                                <h2>SmartLearn</h2>
                                <a href="#">About Us</a><br>
                                <a href="#">Careers</a><br>
                            </li>
                        </ul>
                    </div>

                    <div class="footerL2">
                        <ul>
                            <li>
                                <h2>More</h2>
                                <a href="#">FAQ</a><br>
                                <a href="#">Term & Conditions</a><br>
                            </li>
                        </ul>
                    </div>


                </div>



                <div class="line"></div>

                <div class="footLinks2">
                    <p>@2024 SmartLearn Inc. All rights reserved.</p>
                    <div class="space"></div>
                    <div class="favicon">
                        <a href=""><i class="fa-brands fa-facebook"></i></a>
                        <a href=""><i class="fa-brands fa-instagram"></i></a>
                        <a href=""><i class="fa-brands fa-twitter"></i></a>
                        <a href=""><i class="fa-brands fa-youtube"></i></a>
                    </div>


                </div>
            </div>   
        </footer>
    </body>
</html>

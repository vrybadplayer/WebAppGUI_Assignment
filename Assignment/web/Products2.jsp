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
        <link rel="stylesheet" href="main_1.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap">
        <link rel="stylesheet" href="products.css">
        <title>Products</title>
        <%@page import="domain.Product" %>
        <%@page import="java.util.Random" %>
        <%@page import="domain.Customer"%>
        <jsp:useBean id="customer" scope="session" class="domain.Customer" />

        <script>
            function togglePopup() {
                document.getElementById("popup-1").classList.toggle("active");
            }

            window.onload = function () {
                togglePopup();
            };

            function closePopup() {
                var popup = document.getElementById("popup-1");
                popup.classList.add("deactivate");
                popup.classList.remove("active");
            }
        </script>

    </head>
    <body>    

        <%
            int prodId = Integer.parseInt(request.getParameter("prodId"));
            int picNo = Integer.parseInt(request.getParameter("picNo"));
            String category = request.getParameter("category");
            String custID = (String) session.getAttribute("custID");
            Product prod = Product.SearchProduct(prodId);
        %>

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




        <div class="popup" id="popup-1">
            <div class="overlay">
                <div class="content">
                    <button class="close-btn" onclick="closePopup()">&times;</button>
                    <h1>Notice</h1>
                    <p>Your item has been successfully added to cart.</p>
                </div>
            </div>    
        </div>

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

                    <!-- In the button, initialize/get the cust and prod id's which is to be passed to Servlet -->

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

                    <%
                        Random rand = new Random();
                        int randNum = rand.nextInt(1000);
                    %>
                    
                    <a href="reviews.jsp?ProdID=<%=prodId%>">
                        <span class="review-amount">(<% out.println(prod.getReviews());%> reviews)</span><span class="rating-score"><%= prod.getRating()%></span>
                    </a>
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
                        <button class="join-course-now" onclick="togglePopup()">Join Course Now</button>
                    </form>
                </div>

            </div>
            <div class="flex-row-f">
                <span class="modules">Modules</span><span class="objectives">Objectives</span>
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
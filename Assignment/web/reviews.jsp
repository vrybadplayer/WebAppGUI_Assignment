<%@page import="dataAccess.reviewsDA"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Customer"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Reviews</title>
        <link rel="stylesheet" href="main_1.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap" />
        <link rel="stylesheet" href="reviews.css" />
        <%

            int ProdID = Integer.parseInt(request.getParameter("ProdID"));
            int CustID = (Integer) session.getAttribute("custID");
            Customer customer = Customer.SearchCustomer(CustID);
            ArrayList<reviewsDA> reviewList = reviewsDA.GetReviews(ProdID);
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

            <!-- Add Review Button -->
            <form action="reviewForm.jsp">
                <input type="hidden" name="ProdID" value="<%=ProdID%>">
                <button class="button" type="submit">
                    <span class="leave-a-review">Leave A Review</span>
                </button>
            </form>

            <!-- Reviews Div  Boxes-->

            <!-- Loop display for Blocks -->
            <%
                for (int i = 0; i < reviewList.size(); ++i) {
                    out.println("<div class=\"frame\">");
                    out.println("<span class=\"username\">" + customer.getCustName() + "</span>");
                    out.println("<div class=\"flex-row-bf\">");

                    if (reviewList.get(i).getRating() >= 1) {
                        out.println("<div class=\"star\"></div>");
                    }
                    if (reviewList.get(i).getRating() >= 2) {
                        out.println("<div class=\"star-1\"></div>");
                    }
                    if (reviewList.get(i).getRating() >= 3) {
                        out.println("<div class=\"star-2\"></div>");
                    }
                    if (reviewList.get(i).getRating() >= 4) {
                        out.println("<div class=\"star-3\"></div>");
                    }
                    if (reviewList.get(i).getRating() >= 4.5) {
                        out.println("<div class=\"star-4\"></div>");
                    }

                    out.println("</div>");
                    out.println("<span class=\"comment\">" + reviewList.get(i).getComment() + "</span>");
                    out.println("</div>");
                }

            %>


            <div class="background"></div>
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

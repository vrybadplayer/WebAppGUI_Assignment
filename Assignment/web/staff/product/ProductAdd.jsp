<%-- 
    Document   : ProductAdd
    Created on : 5 May 2024, 10:49:19 AM
    Author     : sumsn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Adding Products</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    </head>
    <body>
        <%
            try {
                HttpSession currentSession = request.getSession(false);
                String privilege = (String) session.getAttribute("privilege");
                //System.out.println("Privilege: " + privilege); 
                if (!privilege.equals("Staff") && !privilege.equals("admin")) {
                    response.sendRedirect("../../staffLogin.jsp");
                }
            } catch (NullPointerException ex) {
                response.sendRedirect("../../customerlogin.jsp");
            }
        %>
        <!--Staff Header-->
        <div style="width: 1523px; height: 87px; padding-top: 17px; padding-bottom: 18px; padding-right: 9px; background:linear-gradient(to top, #a18cd1 0%, #fbc2eb 100%); box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); justify-content: flex-start; align-items: center; gap: 803px; display: inline-flex">
            <img src="../../SmartLearnLogo.png" alt="logo" style="width:80px; height:80px; margin-left:30px">
            <div style="color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; margin-left: -798px">Smart Learn</div>
            <div style="margin-left:-309px;align-self: stretch; justify-content: flex-end; align-items: center; gap: 94px; display: inline-flex">
                <a href="placeholder.html" style="width: 52px; color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word;text-decoration:none">Sales</a>
                <a href = "../../manager/StaffHomepage.jsp" style="color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word; text-decoration:none">Staff</a>
                <a href="ProductAdd.jsp" style="color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word; text-decoration:none">Courses</a>
                <a href="placeholder.html" style="color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word;text-decoration:none">Customers</a>
                <div style="height: 23px; padding-left: 24px; padding-right: 24px; padding-top: 14px; padding-bottom: 14px; background: #DEEFF5; box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05); border-radius: 15px; justify-content: center; align-items: center; gap: 8px; display: flex">
                    <a href="placeholder.html" style="color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word;text-decoration:none">Welcome</a>
                </div>
            </div>
        </div>

        <!--Product Side Bar-->
        <div style="width: 248px; height: 1082px; position: absolute; background: linear-gradient(to top, #fbc2eb 0%, #a6c1ee 100%); border-right: 1px #E0E0E0 solid">
            <div style="height: 172px; left: 8px; top: 78px; position: absolute; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 4px; display: inline-flex">
                <div style="margin-left:-8px;width:216px;align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <div style="width: 208px; height: 24px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 24px; word-wrap: break-word">Product Management</div>
                </div>
                <div style="margin-left:-8px;width:216px;align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex;background: linear-gradient(to top, #cfd9df 0%, #e2ebf0 100%)">
                    <img src = "images/listing.png" alt = "recruitStaff" style = "width:28px; height:28px">
                    <a href="ProductAdd.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration: none">Listing</a>
                </div>
                <div style="margin-left:-8px;width:216px;align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src = "images/delist.png" alt = "deactivate" style = "width:28px; height:28px">
                    <a href = "productDelete.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word;text-decoration:none">Delisting</a>
                </div>
            </div>
            <div style="left: 24px; top: 24px; position: absolute; color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 30px; word-wrap: break-word">Tasks</div>
            <div style="margin-top:-36px;margin-left:-8px;width: 216px; height: 40px; padding-left: 16px; padding-right: 16px; left: 8px; top: 250px; position: absolute; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                <img src = "images/update.png" alt = "updateDetails" style = "width:28px; height:28px">
                <a href="ProductUpdateHome.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration:none">Update Courses</a>
            </div>
        </div>

        <!--Listing Title-->
        <div style="width: 516px; height: 44px"></div>
        <div style="width: 516px; color: black; font-size: 40px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 44px; word-wrap: break-word; margin-left: 765px; font-family: Ubuntu, sans-serif">Listing Courses</div>

        <!--Listing Form ADD FORM HERE -->
        <form method ="POST" action="../../AddNewProducts">
            <div style="width: 995px; height: 783px; position: relative; background: linear-gradient(to top, #fbc2eb 0%, #a6c1ee 100%); box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 79px; overflow: hidden; border: 1px rgba(106, 53, 156, 0.70) solid; margin-left: 440px; padding-top:18px; padding-left: 12px">
                <div style = "margin-bottom: 23px">
                    <div style="width: 73px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                    </div>
                </div>
                <!--course name-->
                <input type="text" name="CourseName" style="width: 342px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 137px; top: 89px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">


                <div style = "margin-top:71px; display:inline-flex; flex-direction: column; margin-left: 32px">
                    <div style="width: 295px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 295px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Description:</div>
                    </div>
                </div>

                <div style = "margin-left: 540px; margin-top: -23px">
                    <div style="width: 295px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 295px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Experience Level:</div>
                    </div>
                </div>

                <div style = "margin-left: 540px; margin-top:58px">
                    <div style="width: 55px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 295px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Organizer:</div>
                    </div>
                </div>

                <div style = "margin-top:62px; margin-left:540px">
                    <div style="width: 295px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 295px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Contributor:</div>
                    </div>
                </div>
                <!--description-->
                <input type="text" name="Synopsis" style="width: 447px; height: 200px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 32px; top: 181px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid;margin-bottom:5px">

                <!--Skills Gained-->
                <div style = "margin-top: 76px; margin-left: 23px">
                    <div style="width: 171px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 171px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Skills Gained (?, ?, ...):</div>
                    </div>
                </div>

                <div style = "margin-left: 540px; margin-top:-45px">
                    <div style="width: 295px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 295px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Objective of the course:</div>
                    </div>
                </div>
                <!--Organizer Input-->
                <input type="text" name="Organizer" style="width: 310px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 538px; top: 263px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">

                <!-- Skills Gained Input -->
                <input type="text" name="SkillsGained" style="width: 447px; height: 50px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 31px; top: 424px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid;margin-top:23px">

                <!--Course Modules-->
                <div style = "margin-top: 123px; margin-left:23px">
                    <div style="width: 238px; height: 48px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 238px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Course Modules<br/>(?, ?, ?, .....)</div>
                    </div>
                </div>
                <input type="text" name="Modules" style="width: 447px; height: 100px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 31px; top: 564px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid;margin-top: 33px">

                <!--Category input-->
                <input type="text" name="Category" style="width: 202px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 618px; top: 88px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">

                <!--Experience Level-->
                <input type="text" name="ExperienceLevel" style="width: 197px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 538px; top: 181px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">

                <!--Contributor-->
                <input type="text" name="Contributor" style="width: 310px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 538px; top: 348px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">

                <!--Objective-->
                <input type="text" name="Objective" style="width: 310px; height: 50px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 538px; top: 427px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">
                <div style="left: 523px; top: 29px; position: absolute"></div>
                <div style="width: 154px; left: 430px; top: 29px; position: absolute; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Duration (Weeks): </div>
                <!--Duration Input-->
                <input type="text" name="Duration" style="width: 221px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 569px; top: 26px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">
                <div style="width: 120px; left: 19px; top: 93px; position: absolute; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Course Name:</div>
                <div style="left: 533px; top: 93px; position: absolute; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                    <div style="width: 88px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Category:</div>
                </div>

                <button type="submit" style="margin-top: 80px; margin-left: 780px; width: 86px; height: 40px; padding-left: 16px; padding-right: 16px; background: #DEEFF5; border-radius: 8px; justify-content: center; align-items: center; gap: 8px; display: inline-flex; font-family: Ubuntu, sans-serif;">Submit</button>

            </div>
            <div style="width: 120px; height: 24px"></div>

        </form>

    </body>
</html>

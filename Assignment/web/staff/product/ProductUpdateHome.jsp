<%-- 
    Document   : ProductUpdateHome
    Created on : 5 May 2024, 1:57:36 PM
    Author     : sumsn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Courses</title>
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
                <div style="margin-left:-8px;width:216px;align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src ="images/homeIcon.png" alt = "homeIcon" style = "width:28px; height:28px">
                    <a href = "productManage.html" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration: none;">Home</a>
                </div>
                <div style="margin-left:-8px;width:216px;align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src = "images/listing.png" alt = "recruitStaff" style = "width:28px; height:28px">
                    <a href="ProductAdd.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration: none">Listing</a>
                </div>
                <div style="margin-left:-8px;width:216px;align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src = "images/delist.png" alt = "deactivate" style = "width:28px; height:28px">
                    <a href = "productDelete.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word;text-decoration:none">Delisting</a>
                </div>
            </div>
            <div style="left: 24px; top: 24px; position: absolute; color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 30px; word-wrap: break-word">Tasks</div>
            <div style="margin-left:-8px;width: 216px; height: 40px; padding-left: 16px; padding-right: 16px; left: 8px; top: 250px; position: absolute; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex;background: linear-gradient(to top, #cfd9df 0%, #e2ebf0 100%)">
                <img src = "images/update.png" alt = "updateDetails" style = "width:28px; height:28px">
                <a href="ProductUpdateHome.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration:none">Update Courses</a>
            </div>
        </div>

        <!--Listing Title-->
        <div style="width: 516px; height: 44px"></div>
        <div style="width: 516px; color: black; font-size: 40px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 44px; word-wrap: break-word; margin-left: 765px; font-family: Ubuntu, sans-serif">Update Courses</div>

        <!--Listing Form-->
        <form method="GET" action="../../UpdateProduct">
            <div style="width: 995px; height: 783px; position: relative; background: linear-gradient(to top, #fbc2eb 0%, #a6c1ee 100%); box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 79px; overflow: hidden; border: 1px rgba(106, 53, 156, 0.70) solid; margin-left: 440px; padding-top:18px; padding-left: 12px">
                <div style = "margin-bottom: 23px">
                    <div style="width: 73px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 92px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; margin-left: 34px; margin-top:18px">Product ID: </div>
                    </div>
                </div>
                <!--id-->
                <input type="text" name="ProdID" style="width: 235px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 137px; top: 29px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">
                <button style="margin-top: 10px; margin-left: 170px; width: 86px; height: 40px; padding-left: 16px; padding-right: 16px; background: #DEEFF5; border-radius: 8px; justify-content: center; align-items: center; gap: 8px; display: inline-flex; font-family: Ubuntu, sans-serif;">Submit</button>
            </div>
        </form>
        <div style="width: 120px; height: 24px"></div>
    </body>
</html>
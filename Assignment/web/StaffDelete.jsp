<%-- 
    Document   : StaffDelete
    Created on : 20 Apr 2024, 10:24:14 AM
    Author     : sumsn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Staff" %>
<%@page import="java.util.ArrayList" %>
<%@page import="dataAccess.StaffDA" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
        <title>Delete Staff</title>
    </head>
    <body>
        <!--Staff Header-->
        <div style="width: 1806px; height: 87px; padding-top: 17px; padding-bottom: 18px; padding-right: 9px; background: #B589D6; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); justify-content: flex-start; align-items: center; gap: 803px; display: inline-flex">
            <img src="StaffImages/smartLearnLogo.png" alt="logo" style="width:80px; height:80px; margin-left:30px">
            <div style="color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; margin-left: -798px">Smart Learn</div>
            <div style="align-self: stretch; justify-content: flex-end; align-items: center; gap: 94px; display: inline-flex">
                <div style="width: 52px; color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word">Sales</div>
                <a href = "StaffHomepage.jsp" style="color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word; text-decoration:none">Staff</a>
                <div style="color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word; text-decoration:none">Courses</div>
                <div style="color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word">Customers</div>
                <div style="height: 52px; padding-left: 24px; padding-right: 24px; padding-top: 14px; padding-bottom: 14px; background: #4D0F83; box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05); border-radius: 8px; justify-content: center; align-items: center; gap: 8px; display: flex">
                    <div style="color: white; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Welcome</div>
                </div>
            </div>
        </div>
        
        <!--Side Bar-->
        <div style="width: 248px; height: 819px; position: absolute; background: white; border-right: 1px #E0E0E0 solid">
            <div style="height: 172px; left: 8px; top: 78px; position: absolute; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 4px; display: inline-flex">
                <div style="align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <div style="width: 208px; height: 24px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 24px; word-wrap: break-word">Staff Management</div>
                </div>
                <div style="align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; background: white; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src ="StaffImages\homeIcon.jpg" alt = "homeIcon" style = "width:28px; height:28px">
                    <a href="StaffHomepage.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration:none">Home</a>
                </div>
                <div style="align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; background: white; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src = "StaffImages\staffRecruit.png" alt = "recruitStaff" style = "width:28px; height:28px">
                    <a href = "staffAdd.html" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration: none">Recruitment</a>
                </div>
                <div style="align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; background: #B589D6; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src = "StaffImages\removeAcc.png" alt = "deactivate" style = "width:28px; height:28px">
                    <a href = "StaffDelete.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word;text-decoration:none">Deactivation</a>
                </div>
            </div>
            <div style="left: 24px; top: 24px; position: absolute; color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 30px; word-wrap: break-word">Tasks</div>
            <div style="width: 208px; height: 40px; padding-left: 16px; padding-right: 16px; left: 8px; top: 250px; position: absolute; background: white; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                <img src = "StaffImages/updateAcc.png" alt = "updateDetails" style = "width:28px; height:28px">
                <a href = "StaffUpdate.jsp" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration:none">Update Details</a>
            </div>
        </div>
        
        <!--Search Queries-->
        <form action="StaffDelete.jsp" method="post">
            <div style="width: 1242px; height: 125px; position: relative; margin-left: 250px;">
                <button name="confirmSearch" value="confirmSearch" style="height: 40px; padding-top: 8px; padding-bottom: 8px; padding-left: 12px; padding-right: 16px; left: 485px; top: 70px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid; justify-content: flex-start; align-items: center; gap: 12px; display: inline-flex; margin-left:20px">
                    <div style="width: 24px; height: 24px; padding-left: 6px; padding-right: 2px; padding-top: 3px; padding-bottom: 3px; justify-content: center; align-items: center; display: flex">
                        <img src = "StaffImages\filter.png" alt = "filter" style = "width:28px; height:28px">
                    </div>
                    <div style="color: #828282; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 400; line-height: 24px; word-wrap: break-word">search</div>
                </button>
                <div style="width: 405px; height: 40px; padding-top: 8px; padding-bottom: 8px; padding-left: 16px; padding-right: 5px; left: 64px; top: 70px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid; justify-content: flex-start; align-items: center; gap: 12px; display: inline-flex">
                    <img src = "StaffImages\searchStaff.png" alt = "searchStaff" style = "width:28px; height:28px">
                    <input type="text" name="staffid" id="staffid" style="flex: 1 1 0; color: #828282; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 400; line-height: 24px; word-wrap: break-word; outline:none; border:none">
                </div>
                <div style="left: 64px; top: 24px; position: absolute; color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 30px; word-wrap: break-word">Search Staff</div>
            </div>
            
            <!--Contents-->
            <%
                int pageNumber = 0;

                if (request.getParameter("next") != null) {
                    //pageNumber += 1;
                    pageNumber = Integer.parseInt(session.getAttribute("currentPage").toString()) + 1; //get from tht current page instead of resetting to 0 when refreshed
                }

                if (request.getParameter("prev") != null) {
                    if (Integer.parseInt(session.getAttribute("currentPage").toString()) > 0) {
                        pageNumber = Integer.parseInt(session.getAttribute("currentPage").toString()) - 1;
                    }else{
                    pageNumber = 0;
                }
                }
                session.setAttribute("currentPage", pageNumber);
                StaffDA staffDA = new StaffDA();
                ArrayList<Staff> staffList = staffDA.getRecords((pageNumber) * 10);

                Staff individualStaff = new Staff();

                try {
                    int id = Integer.parseInt(request.getParameter("staffid"));
                    if (request.getParameter("staffid") != null) {
                        individualStaff = staffDA.getIdRecords(id);
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            %>
            <div style="width: 1234px; height: 957px; flex-direction: column; justify-content: flex-start; align-items: flex-start; display: inline-flex; padding-left: 280px">
                <div style="height: 56px; padding-right: 85px; justify-content: flex-start; align-items: center; gap: 20px; display: inline-flex">
                    <div style="width: 80px; color: #828282; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; margin-right:30px">ID</div>
                    <div style="width: 504px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Name</div>
                    <div style="width: 158px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; margin-left: -58px; margin-right: 30px">Role</div>
                    <div style="width: 96px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; margin-right:60px">Email</div>
                    <div style="width: 63px; text-align: right; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; margin-right:60px; margin-left:-35px">D.O.B</div>
                    <div style="width: 84px; text-align: center; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Phone</div>
                </div> 
                <%
                    if (request.getParameter("confirmSearch") != null) {
                        if (!request.getParameter("staffid").equals("")) {
                            try {
                %>
                <div style="align-self: stretch; height: 56px; border-top: 1px #E0E0E0 solid; justify-content: flex-start; align-items: center; gap: 67px; display: inline-flex">
                    <div style="position:relative; margin-right:62px; top:-15px;">
                        <a href="DeleteStaffDetails.jsp?searchid=<%= individualStaff.getStaffid()%>" style="width: 70px; color: #828282; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; position:absolute"><%= individualStaff.getStaffid()%></a>
                    </div>
                    <div style="position:relative; top:-5px;">
                        <div style="width: 391px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word;"><%= individualStaff.getStaffname()%></div>
                    </div>
                    <div style="position:relative;top:-15px; margin-right:69px">
                        <div style="padding-right: 54px; justify-content: flex-start; align-items: center; display: flex">
                            <div style="align-self: stretch; padding-left: 8px; padding-right: 8px; padding-top: 6px; padding-bottom: 6px; background: white; border-radius: 8px; border: 1px #E0E0E0 solid; justify-content: center; align-items: center; gap: 8px; display: inline-flex;position:absolute">
                                <div style="color: black; font-size: 12px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 16px; word-wrap: break-word;"><%= individualStaff.getRole()%></div>
                            </div>
                        </div>
                    </div>
                    <div style="position:relative; top:-15px; margin-right:98px"> 
                        <div style="padding-right: 21px; justify-content: flex-start; align-items: center; display: flex">
                            <div style="align-self: stretch; padding-left: 8px; padding-right: 8px; padding-top: 6px; padding-bottom: 6px; background: white; border-radius: 8px; border: 1px #E0E0E0 solid; justify-content: center; align-items: center; gap: 8px; display: inline-flex; position:absolute">
                                <div style="color: black; font-size: 12px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 16px; word-wrap: break-word;"><%= individualStaff.getStaffemail()%></div>
                            </div>
                        </div>
                    </div>
                    <div style="position:relative; top:-15px;margin-right:36px">
                        <div style="width: 48px; text-align: right; color: #828282; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 400; line-height: 24px; word-wrap: break-word;position:absolute"><%= individualStaff.getStaffdob()%></div>
                    </div>
                    <div style="width: 84px; height: 28px; padding-left: 28px; padding-right: 28px; justify-content: center; align-items: center; display: flex">
                        <div style="flex: 1 1 0; align-self: stretch; background: #F7F7F7; border-radius: 1000px; overflow: hidden; justify-content: center; align-items: center; display: inline-flex">
                            <div style="color: black; font-size: 12px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 16px; word-wrap: break-word"><%= individualStaff.getStaffphonenumber()%></div>
                        </div>
                    </div>
                </div>
                <%           } catch (NullPointerException ex) { %>
                <div style="width: 522px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Staff ID does not exist!</div>
                <%      }
                } else { %>
                <div style="width: 522px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Staff ID cannot be empty string!</div>
                <%  }
                } else {
                    for (Staff staff : staffList) {
                %>
                <div style="align-self: stretch; height: 56px; border-top: 1px #E0E0E0 solid; justify-content: flex-start; align-items: center; gap: 67px; display: inline-flex">
                    <form action="DeleteStaffDetails.jsp">
                        <button name="searchid" value="<%= staff.getStaffid()%>" style="width: 60px; color: #828282; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word"><%= staff.getStaffid()%></button>
                    </form>
                    <div style="position: relative; top:-15px;padding-right:421px">
                        <div style="width: 412px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; position:absolute"><%= staff.getStaffname()%></div>

                    </div>
                    <div style="position:relative; top:-20px; padding-right:98px">
                        <div style="padding-right: 54px; justify-content: flex-start; align-items: center;justify-content: center; align-items: center; gap: 8px; display: inline-flex;">
                            <div style="align-self: stretch; padding-left: 8px; padding-right: 8px; padding-top: 6px; padding-bottom: 6px; background: white; border-radius: 8px; border: 1px #E0E0E0 solid; position:absolute; display:flex">
                                <div style="color: black; font-size: 12px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 16px; word-wrap: break-word;"><%= staff.getRole()%></div>
                            </div>
                        </div>
                    </div>
                    <div style="position:relative; top: -20px; ">
                        <div style="padding-right: 54px; justify-content: flex-start; align-items: center;justify-content: center; align-items: center; gap: 8px; display: inline-flex;">
                            <div style="align-self: stretch; padding-left: 8px; padding-right: 8px; padding-top: 6px; padding-bottom: 6px; background: white; border-radius: 8px; border: 1px #E0E0E0 solid; position:absolute; ">
                                <div style="color: black; font-size: 12px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 16px; word-wrap: break-word;"><%= staff.getStaffemail()%></div>
                            </div>
                        </div>
                    </div>
                    <div style="display:flex">
                        <div style="width: 48px; text-align: right; color: #828282; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 400; line-height: 24px; word-wrap: break-word;"><%= staff.getStaffdob()%></div>
                    </div>
                    <div style="position:relative;">
                        <div style="width: 84px; height: 28px; padding-left: 28px; padding-right: 28px; justify-content: center; align-items: center; display: flex">
                            <div style="flex: 1 1 0; align-self: stretch; background: #F7F7F7; border-radius: 1000px; overflow: hidden; justify-content: center; align-items: center; display: inline-flex; position:absolute">
                                <div style="color: black; font-size: 12px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 16px; word-wrap: break-word"><%= staff.getStaffphonenumber()%></div>
                            </div>
                        </div>
                    </div>
                </div>
                <% }
                    }%>

                <!--Buttons-->
                <input type="hidden" name="currentPage" value="<%= pageNumber%>">
                <button name="prev" value="prev" style="width: 60px; height: 45px; padding-left: 24px; padding-right: 24px; padding-top: 14px; padding-bottom: 14px; background: #4D0F83; box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05); border-radius: 8px; justify-content: center; align-items: center; gap: 8px; display: inline-flex; position:relative; right: -1064px; bottom:-23px;color: white; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Prev <</button>
                <button name="next" value="next" style="width: 60px; height: 45px; padding-left: 24px; padding-right: 24px; padding-top: 14px; padding-bottom: 14px; background: #4D0F83; box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05); border-radius: 8px; justify-content: center; align-items: center; gap: 8px; display: inline-flex; position:relative; right: -1134px; bottom:21px;color: white; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Next ></button>
        </form>
    </div>
    </body>
</html>

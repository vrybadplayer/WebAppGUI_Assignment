<%@page import="domain.Product"%>
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
        <!--Staff Header-->
        <div style="width: 1879px; height: 87px; padding-top: 17px; padding-bottom: 18px; padding-right: 9px; background: #D3D3D3; box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); justify-content: flex-start; align-items: center; gap: 803px; display: inline-flex">
            <div style="color: #4D0F83; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word; margin-left: 30px">Smart Learn w/ Logo</Smart></div>
            <div style="align-self: stretch; justify-content: flex-end; align-items: center; gap: 94px; display: inline-flex">
                <div style="width: 52px; color: #4D0F83; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word">Sales</div>
                <a href = "../StaffPages/staffManage.html" style="color: #4D0F83; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word; text-decoration:none">Staff</a>
                <a href = "productManage.html" style="color: #4D0F83; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word; text-decoration:none">Courses</a>
                <div style="color: #4D0F83; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 30px; word-wrap: break-word">Customers</div>
                <div style="height: 52px; padding-left: 24px; padding-right: 24px; padding-top: 14px; padding-bottom: 14px; background: #4D0F83; box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.05); border-radius: 8px; justify-content: center; align-items: center; gap: 8px; display: flex">
                    <div style="color: #D3D3D3; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Welcome</div>
                </div>
            </div>
        </div>

        <!--Product Side Bar-->
        <div style="width: 248px; height: 1082px; position: absolute; background: white; border-right: 1px #E0E0E0 solid">
            <div style="height: 172px; left: 8px; top: 78px; position: absolute; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 4px; display: inline-flex">
                <div style="align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <div style="width: 208px; height: 24px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 24px; word-wrap: break-word">Product Management</div>
                </div>
                <div style="align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; background: white; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src ="../StaffPages/images/homeIcon.jpg" alt = "homeIcon" style = "width:28px; height:28px">
                    <a href = "productManage.html" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration: none;">Home</a>
                </div>
                <div style="align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; background: white; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src = "images/listing.png" alt = "recruitStaff" style = "width:28px; height:28px">
                    <a href = "productAdd.html" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration: none">Listing</a>
                </div>
                <div style="align-self: stretch; height: 40px; padding-left: 16px; padding-right: 16px; background: white; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                    <img src = "images/delist.png" alt = "deactivate" style = "width:28px; height:28px">
                    <a href = "productDelete.html" style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word;text-decoration:none">Delisting</a>
                </div>
            </div>
            <div style="left: 24px; top: 24px; position: absolute; color: black; font-size: 20px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 30px; word-wrap: break-word">Tasks</div>
            <div style="width: 208px; height: 40px; padding-left: 16px; padding-right: 16px; left: 8px; top: 250px; position: absolute; background: #B589D6; border-radius: 8px; justify-content: flex-start; align-items: center; gap: 16px; display: inline-flex">
                <img src = "images/update.png" alt = "updateDetails" style = "width:28px; height:28px">
                <div style="flex: 1 1 0; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word; text-decoration:none">Update Course</div>
            </div>
        </div>

        <!--Listing Title-->
        <div style="width: 516px; height: 44px"></div>
        <div style="width: 516px; color: black; font-size: 40px; font-family: Ubuntu, sans-serif; font-weight: 600; line-height: 44px; word-wrap: break-word; margin-left: 765px; font-family: Ubuntu, sans-serif">Update Course</div>


        <%
            int ProdID = Integer.parseInt(request.getParameter("ProdID"));
            Product prod = Product.SearchProduct(ProdID);
        %>

        <!--Listing Form ADD FORM HERE -->
        <form method ="POST" action="UpdateProduct">
            <input type="hidden" name="ProdID" value="<%= prod.getId()%>">
            <div style="width: 995px; height: 783px; position: relative; background: rgba(106, 53, 156, 0.70); box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25); border-radius: 79px; overflow: hidden; border: 1px rgba(106, 53, 156, 0.70) solid; margin-left: 440px; padding-top:18px; padding-left: 12px">
                <div style = "margin-bottom: 23px">
                    <div style="width: 73px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                    </div>
                </div>
                <!--course name-->
                <input type="text" value="<% prod.getName(); %>" name="CourseName" style="width: 342px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 137px; top: 89px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">
                <!--<div style="height: 31px; left: 118px; top: 213px; position: absolute"></div>-->

                <div style = "margin-top:71px; display:inline-flex; flex-direction: column; margin-left: 32px">
                    <div style="width: 295px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 295px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Description:</div>
                    </div>
                </div>

                <div style="position: absolute; left: 0; margin-top: 71px; display: inline-flex; flex-direction: column; margin-left: 32px;">
                    <div style="width: 295px; height: 24px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex;">
                        <div style="margin-left: 10px; margin-top: 160px; margin-right: 260px; width: 295px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word;">Price:</div>
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
                <input type="text" name="Synopsis" style="width: 447px; height: 80px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 32px; top: 181px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid;margin-bottom:5px">


                <!--Price-->
                <input type="text" name="Price" style="width: 447px; height: 40px; padding-left: 16px; padding-right: 16px; padding-top: 8px; margin-top: 160px; padding-bottom: 8px; left: 32px; top: 181px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid;margin-bottom:5px">


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
                <input type="text" value="<% prod.getOrganizer(); %>" name="Organizer" style="width: 310px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 538px; top: 263px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">

                <!-- Skills Gained Input -->
                <input type="text" value="<% prod.getSkills(); %>" name="SkillsGained" style="width: 447px; height: 50px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 31px; top: 424px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid;margin-top:23px">

                <!--Course Modules-->
                <div style = "margin-top: 123px; margin-left:23px">
                    <div style="width: 238px; height: 48px; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                        <div style="width: 238px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Course Modules<br/>(?, ?, ?, .....)</div>
                    </div>
                </div>
                <input type="text" value="<% prod.getModules(); %>" name="Modules" style="width: 447px; height: 100px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 31px; top: 564px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid;margin-top: 33px">

                <!--Category input-->
                <input type="text" value="<% prod.getCategory(); %>" name="Category" style="width: 202px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 618px; top: 88px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">

                <!--Experience Level-->
                <input type="text" value="<% prod.getLevel(); %>" name="ExperienceLevel" style="width: 197px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 538px; top: 181px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">

                <!--Contributor-->
                <input type="text" value="<% prod.getContributor(); %>" name="Contributor" style="width: 310px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 538px; top: 348px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">

                <!--Objective-->
                <input type="text" value="<% prod.getObjective(); %>" name="Objective" style="width: 310px; height: 50px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 538px; top: 427px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">
                <div style="left: 523px; top: 29px; position: absolute"></div>
                <div style="width: 154px; left: 430px; top: 29px; position: absolute; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Duration (Weeks): </div>
                <!--Duration Input-->
                <input type="text" value="<% prod.getDuration();%>" name="Duration" style="width: 221px; height: 23px; padding-left: 16px; padding-right: 16px; padding-top: 8px; padding-bottom: 8px; left: 569px; top: 26px; position: absolute; background: white; border-radius: 8px; border: 1px #E0E0E0 solid">
                <div style="width: 120px; left: 19px; top: 93px; position: absolute; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Course Name:</div>
                <div style="left: 533px; top: 93px; position: absolute; flex-direction: column; justify-content: flex-start; align-items: flex-start; gap: 8px; display: inline-flex">
                    <div style="width: 88px; color: black; font-size: 16px; font-family: Ubuntu, sans-serif; font-weight: 500; line-height: 24px; word-wrap: break-word">Category:</div>
                </div>

                <button type="submit" style="margin-top: 80px; margin-left: 780px; width: 86px; height: 40px; padding-left: 16px; padding-right: 16px; background: rgba(106, 53, 156, 0.70); border-radius: 8px; justify-content: center; align-items: center; gap: 8px; display: inline-flex; font-family: Ubuntu, sans-serif;">Submit</button>

            </div>
            <div style="width: 120px; height: 24px"></div>

        </form>

    </body>
</html>
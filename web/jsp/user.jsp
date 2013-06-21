<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 07/06/13
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/JavaScript" src="/js/user.js"></script>
</head>
<body>
<form id="registration">
<h1>User Registration</h1>
<div id="contents" class="block">
    <div id="page_1">
    <div class="sub-title-top">
        <div class="sub-left-top">
            <h2>User Details:</h2>
            <div class="sub-title">
                <div class="sub-left">
                    Username:
                </div>
                <div class="sub-right">
                    <input type="text" name="username" id="username" placeholder="Username"/>
                </div>
                <div class="clear-both"></div>
            </div>
            <div class="sub-title">
                <div class="sub-left">
                    Password:
                </div>
                <div class="sub-right">
                    <input type="password" name="password" id="password"  placeholder="Password"/>
                </div>
                <div class="clear-both"></div>
            </div>
            <div class="sub-title">
                <div class="sub-left">
                    Confirm Password:
                </div>
                <div class="sub-right">
                    <input type="password" name="cpassword" id="c_password"  placeholder="Confirm Password"/>
                </div>
                <div class="clear-both"></div>
            </div>
            <div class="sub-title">
                <div class="sub-left">
                    First Name;
                </div>
                <div class="sub-right">
                    <input type="text" name="firstname" id="firstname" placeholder="Name"/>
                </div>
                <div class="clear-both"></div>
            </div>
            <div class="sub-title">
                <div class="sub-left">
                    Last Name:
                </div>
                <div class="sub-right">
                    <input type="text" name="lastname" id="lastname"  placeholder="Surname"/>
                </div>
                <div class="clear-both"></div>
            </div>
            <div class="sub-title">
                <div class="sub-left">
                    Email
                </div>
                <div class="sub-right">
                    <input type="text" name="email" id="email"  placeholder="Email"/>
                </div>
                <div class="clear-both"></div>
            </div>
            <div class="sub-title">
                <div class="sub-left">
                    Mobile
                </div>
                <div class="sub-right">
                    <input type="text" name="mphone" id="mphone"  placeholder="Mobile Phone"/>
                </div>
                <div class="clear-both"></div>
            </div>
            <div class="sub-title">
                <div class="sub-left">
                    <p><button id="next" type="button" class="btn btn-primary btn-large">Next &raquo;</button></p>
                </div>
                <div class="sub-right">

                </div>
                <div class="clear-both"></div>
            </div>
        </div>
        <div class="sub-right-top" align="center">
            <img src="/img/profile.png" style="width: 75%; height:75%;"/>
        </div>
        <div class="clear-both"></div>
    </div>
</div>
    <div id="page_2">
        <div class="sub-title-top">
            <div class="sub-left-top">
                <h2>Company Details:</h2>
                <div class="sub-title">
                    <div class="sub-left">
                        Company Name:
                    </div>
                    <div class="sub-right">
                        <input type="text" name="cname" id="cname"/>
                    </div>
                    <div class="clear-both"></div>
                </div>
                <div class="sub-title">
                    <div class="sub-left">
                        Company Telephone:
                    </div>
                    <div class="sub-right">
                        <input type="text" name="cphone" id="cphone"/>
                    </div>
                    <div class="clear-both"></div>
                </div>
                <div class="sub-title">

                    <div class="sub-left">
                        <p><button id="prev2" type="button" class="btn btn-primary btn-large">&laquo;Prev</button></p>
                    </div>
                    <div class="sub-right">
                        <p><button id="next2" type="button" class="btn btn-primary btn-large">Next&raquo;</button></p>
                    </div>
                    <div class="clear-both"></div>
                </div>
            </div>
            <div class="sub-right-top" align="center">
                <img src="/img/company.png" style="width: 75%; height: 75%; right: 0"/>
            </div>
            <div class="clear-both"></div>
        </div>
</div>
    <div id="page_3">
        <div class="sub-title-top">
            <div class="sub-left-top">
                <h2>Address Details:</h2>
                <div class="sub-title">
                    <div class="sub-left">
                        Address Title:
                    </div>
                    <div class="sub-right">
                        <input type="text" name="addressname" id="addressname"/>
                    </div>
                    <div class="clear-both"></div>
                </div>
                <div class="sub-title">
                    <div class="sub-left">
                        Address Line 1:
                    </div>
                    <div class="sub-right">
                        <input type="text" name="line1" id="line1"/>
                    </div>
                    <div class="clear-both"></div>
                </div>
                <div class="sub-title">
                    <div class="sub-left">
                        Address Line 2:
                    </div>
                    <div class="sub-right">
                        <input type="text" name="line2" id="line2"/>
                    </div>
                    <div class="clear-both"></div>
                </div>
                <div class="sub-title">
                    <div class="sub-left">
                        City:
                    </div>
                    <div class="sub-right">
                        <input type="text" name="city" id="city"/>
                    </div>
                    <div class="clear-both"></div>
                </div>
                <div class="sub-title">
                    <div class="sub-left">
                        Postcode:
                    </div>
                    <div class="sub-right">
                        <input type="text" name="postcode" id="postcode"/>
                    </div>
                    <div class="clear-both"></div>
                </div>
                <div class="sub-title">

                    <div class="sub-left">
                        <p><button id="prev3" type="button" class="btn btn-primary btn-large">&laquo;Prev</button></p>
                    </div>
                    <div class="sub-right">
                        <p><button id="register"  class="btn btn-primary btn-large">Register</button></p>
                    </div>
                    <div class="clear-both"></div>
                </div>
            </div>
            <div class="sub-right-top" align="center">
                <img src="/img/home.png" style="width: 75%; height: 75%; right: 0"/>
            </div>
            <div class="clear-both"></div>
        </div>
    </div>
    <div id="success">
        <h2>Success</h2>
        <p>Please activate your account, the activation link has been sent to your provided email.</p>
        <p><a href="index.jsp" class="btn btn-primary btn-large">Home</a></p>
    </div>

</div>
</form>
</body>
</html>
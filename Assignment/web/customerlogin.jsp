<!DOCTYPE html>
<html lang="en">
    <meta charset="UTF-8">
    <title>Login SmartLearn</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/customerlogin.css">

    <body>
        <section class="h-100 gradient-form" style="background-color: #eee;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-xl-10">
                        <div class="card rounded-3 text-black">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="card-body p-md-5 mx-md-4">

                                        <div class="text-center">
                                            <img src="SmartLearnLogo.png" style="width: 100px;" alt="logo"><br>
                                            <h4 class="mt-1 mb-5 pb-1">SmartLearn</h4>
                                        </div>

                                        <form action="CustomerLogin" method="POST">
                                            <p>Please login to your account</p>
                                            <div data-mdb-input-init class="form-outline mb-4">
                                                <label class="form-label" for="username">Username:</label>
                                                <input type="text" id="username" name="username" class="form-control" placeholder="Username"/>
                                            </div>
                                            <div data-mdb-input-init class="form-outline mb-4">
                                                <label class="form-label" for="password">Password:</label>
                                                <input type="password" id="password" name="password" class="form-control" placeholder="Password"/>
                                            </div>
                                            <div class="text-center pt-1 mb-5 pb-1">
                                                <button data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Log
                                                    in</button>
                                                <a class="text-muted" href="CustForgotPassword.jsp">Forgot password?</a>
                                            </div>
                                            <div class="d-flex align-items-center justify-content-center pb-4">
                                                <p class="mb-0 me-2">Don't have an account?&emsp;</p></t>
                                                <a href= "customerregister.jsp">
                                                    <button type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-danger">Create new</button>
                                                </a>
                                            </div>         
                                        </form>

                                    </div>
                                </div>
                                <div class="col-lg-6 d-flex align-items-center gradient-custom-2">
                                    <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                                        <h4 class="mb-4">Join us to unlock your potential and advance your personal and professional growth with ease.</h4>
                                        <p class="small mb-0">SmartLearn is a leading online platform that provides high-quality, interactive courses to learners worldwide. Our mission is to make learning accessible and convenient for everyone, empowering individuals to acquire new skills and advance their careers from anywhere in the world.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>

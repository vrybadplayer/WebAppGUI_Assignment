<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.3/components/password-resets/password-reset-10/assets/css/password-reset-10.css">

<section class="bg-light py-3 py-md-5 py-xl-8">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5 col-xxl-4">
                <div class="mb-5">
                    <div class="text-center mb-4">
                        <a href="index.html">
                            <img src="SmartLearnLogo.png" alt="SmartLearn Logo" width="130" height="110">
                        </a>
                    </div>
                    <h4 class="text-center mb-4">Forgot your password?</h4>
                </div>
                <div class="card border border-light-subtle rounded-4">
                    <div class="card-body p-3 p-md-4 p-xl-5">
                        <form action="CustForgotPassword" method="post">
                            <p class="text-center mb-4">Provide the IC number associated with your account's username to reset your password.</p>
                            <div class="row gy-3 overflow-hidden">
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="username" id="username" placeholder="Username" required>
                                        <label for="username" class="form-label">Username</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="icNumber" id="icNumber" placeholder="IC number" required>
                                        <label for="icNumber" class="form-label">IC number</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="d-grid">
                                        <button class="btn btn-primary btn-lg" type="submit">Verify</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="d-flex gap-2 gap-md-4 flex-column flex-md-row justify-content-md-center mt-4">
                    <a href="customerlogin.jsp" class="link-secondary text-decoration-none">Login</a>
                    <a href="customerregister.jsp" class="link-secondary text-decoration-none">Register</a>
                </div>
            </div>
        </div>
    </div>
</section>
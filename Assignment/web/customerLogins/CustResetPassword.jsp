<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.3/components/password-resets/password-reset-10/assets/css/password-reset-10.css">

<section class="bg-light py-3 py-md-5 py-xl-8">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5 col-xxl-4">
                <div class="mb-5">
                    <div class="text-center mb-4">
                    </div>
                </div>
                <div class="card border border-light-subtle rounded-4">
                    <div class="card-body p-3 p-md-4 p-xl-5">
                        <form action="CustResetPassword" method="post">
                            <p class="text-center mb-4">Please enter a new password. <br>It must be at least 12 characters long and contain a combination of uppercase letters, lowercase letters, and numbers.</p>
                            <div class="row gy-3 overflow-hidden">
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" name="password" id="password" placeholder="New password" required>
                                        <label for="password" class="form-label">New Password</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="Confirm password" required>
                                        <label for="confirmPassword" class="form-label">Confirm Password</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="d-grid">
                                        <button class="btn btn-primary btn-lg" type="submit">Reset Password</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
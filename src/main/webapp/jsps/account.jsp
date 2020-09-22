<html>
<head>

</head>
<body>

<div class="dropdown">
    <button class="btn btn-secondary" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        LOGIN/REGISTRATION
    </button>
    <div class="dropdown-menu" style="padding: 30px" aria-labelledby="dropdownMenuButton">
        <form>
            <div class="row">
            <label for="inputMail">Email address</label>
            <input type="email" class="form-control" id="inputMail" placeholder="Enter email"/>
            </div>
            <div class="row">
            <label for="inputPass">Password</label>
            <input type="password" class="form-control" id="inputPass" placeholder="Enter password"/>
            </div>
            <div class="row">
            <button type="submit" class="btn btn-primary" style="margin-top: 30px;">Submit</button>
            </div>
        </form>
    </div>
</div>
<script>
    $.ajax({
        type: 'POST',
        url: '/auth.jsp',
        data: formData
    })
</script>
</body>
</html>
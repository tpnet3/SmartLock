<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="include/_header.jsp">
    <jsp:param name="_title" value="About us" />
    <jsp:param name="_nav" value="about_us" />
</jsp:include>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">About Us
            </h1>
            <ol class="breadcrumb">
                <li><a href="Main.html">Home</a>
                </li>
                <li class="active">About us</li>
            </ol>
        </div>
    </div>
    <!-- /.row -->

    <!-- Image Header -->
    <div class="row">
        <div class="col-lg-12">
            <img class="img-responsive" src="/html/img/img.jpg" alt="">
        </div>
    </div>
    <!-- /.row -->

    <!-- Service Panels -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Services</h2>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="panel panel-default text-center">
                <div class="panel-heading">
                    <span class="fa-stack fa-5x">
                          <i class="fa fa-circle fa-stack-2x"></i>
                           <i class="fa fa-lock fa-stack-1x fa-inverse"></i>
                    </span>
                </div>
                <div class="panel-body">
                    <h4>Service One</h4>
                    <p>Protect your program from being illegally downloaded.</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="panel panel-default text-center">
                <div class="panel-heading">
                    <span class="fa-stack fa-5x">
                          <i class="fa fa-circle fa-stack-2x"></i>
                         <i class="fa fa-key fa-stack-1x fa-inverse"></i>

                    </span>
                </div>
                <div class="panel-body">
                    <h4>Service Two</h4>
                    <p>Download many original programs with only one account.</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="panel panel-default text-center">
                <div class="panel-heading">
                    <span class="fa-stack fa-5x">
                          <i class="fa fa-circle fa-stack-2x"></i>
                          <i class="fa fa-users fa-stack-1x fa-inverse"></i>
                    </span>
                </div>
                <div class="panel-body">
                    <h4>Service Three</h4>
                    <p>Manage members available for your program.</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="panel panel-default text-center">
                <div class="panel-heading">
                    <span class="fa-stack fa-5x">
                          <i class="fa fa-circle fa-stack-2x"></i>
                          <i class="fa fa-cloud-download fa-stack-1x fa-inverse"></i>
                    </span>
                </div>
                <div class="panel-body">
                    <h4>Service Four</h4>
                    <p>Download programs safely.</p>
                    <br>
                </div>
            </div>
        </div>
    </div>

    <!-- Service Tabs -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">More Information</h2>
        </div>
        <div class="col-lg-12">

            <ul id="myTab" class="nav nav-tabs nav-justified">
                <li class="active"><a href="#service-one" data-toggle="tab"><i class="fa fa-lock"></i> Service One</a>
                </li>
                <li class=""><a href="#service-two" data-toggle="tab"><i class="fa fa-key"></i> Service Two</a>
                </li>
                <li class=""><a href="#service-three" data-toggle="tab"><i class="fa fa-users"></i> Service Three</a>
                </li>
                <li class=""><a href="#service-four" data-toggle="tab"><i class="fa fa-cloud-download"></i> Service Four</a>
                </li>
            </ul>

            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="service-one">
                    <h4>Safe Lock</h4>
                    <p>Upload your program in a secured way. You only need to upload the program, and we will do the securing.
                    In this way, you don't have to worry about your program being downloaded and used illegally.
                    Other unauthorized users won't be able to run your program until you provide the license. </p>
                </div>
                <div class="tab-pane fade" id="service-two">
                    <h4>Unique License</h4>
                    <p>Now you don't need to type in license code every time you want to install a program you bought.
                    By using Smart Lock, you only need a single license for every program you buy.
                    Logging into your account will allow you to download all the programs that you are available for.
                    Get yourself a convenient license for your programs!</p>
                </div>
                <div class="tab-pane fade" id="service-three">
                    <h4>Management</h4>
                    <p>Manage your programs yourself. You can keep track of statistics of your program being downloaded.
                    You can also accept or reject requests for licenses to download your program. Statistics of the licenses
                    that you accepted will be provided for you. Control members that are allowed to use your program.</p>
                </div>
                <div class="tab-pane fade" id="service-four">
                    <h4>Safe Download</h4>
                    <p>Download your programs safely. Programs uploaded from the manager will be safely stored in our server,
                    ad you can safely download the programs directly from the server. </p>
                </div>
            </div>

        </div>
    </div>

    <div class="row">
    <div class="col-lg-12">
            <h2 class="page-header">Contact Us</h2>
        </div>
        <!-- Map Column -->
        <div class="col-md-8">
            <!-- Embedded Google Map -->
            <iframe width="100%" height="400px" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3167.1210711880253!2d127.01707631497453!3d37.45786323810262!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zMzfCsDI3JzI4LjMiTiAxMjfCsDAxJzA5LjMiRQ!5e0!3m2!1sen!2skr!4v1498477845178"></iframe>
        </div>
        <!-- Contact Details Column -->
        <div class="col-md-4">
            <h3>Contact Details</h3>
            <p>
                542 Umyeon-dong<br>Seocho-gu, Seoul<br>
            </p>
            <p><i class="fa fa-phone"></i>
                <abbr title="Phone">P</abbr>: (02) 971-0321</p>
            <p><i class="fa fa-envelope-o"></i>
                <abbr title="Email">E</abbr>: <a href="">name@example.com</a>
            </p>
            <p><i class="fa fa-fax"></i>
                <abbr title="Fax">Fax</abbr>: (02) 527-0321</p>
        </div>
    </div>

    <hr>

    <!-- Footer -->
    <jsp:include page="include/_footer_content.jsp" />

</div>
<!-- /.container -->

<jsp:include page="include/_jslib.jsp" />
<jsp:include page="include/_footer.jsp" />

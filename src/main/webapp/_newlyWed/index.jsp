<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>姻緣聚繪</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css ">

<!-- Custom styles for this template -->
<link href="css/modern-business.css" rel="stylesheet">
<link rel="stylesheet" href="css/marryMa.css">

</head>

<body>

	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-light bg-pink fixed-top">
		<div class="container">
			<img src="./Image/2020-08-11/2020-08-11_v1.0.png" width="50"
				style="display: inline;"> <a class="navbar-brand"
				href="index.html">姻緣聚繪</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">婚禮佈置</a></li>
					<li class="nav-item"><a class="nav-link" href="#">婚禮攝影</a></li>
					<li class="nav-item"><a class="nav-link" href="#">新娘秘書</a></li>
					<li class="nav-item"><a class="nav-link" href="#">婚禮主持</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownCart"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							小物商城 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="#">商品列表</a> <a
								class="dropdown-item" href="#">喜愛商品</a> <a class="dropdown-item"
								href="blog-post.html">購物車</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							社群分享 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownBlog">
							<a class="dropdown-item" href="#">分享討論區</a> <a
								class="dropdown-item" href="#">商家評價</a>
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownPages"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							平台說明 </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownPages">
							<a class="dropdown-item" href="#">關於本站</a> <a
								class="dropdown-item" href="#">最新公告</a> <a class="dropdown-item"
								href="#">服務條款</a> <a class="dropdown-item" href="#">隱私權說明</a> <a
								class="dropdown-item" href="#">免責聲明</a> <a class="dropdown-item"
								href="#">問題回報</a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="#">會員登入</a></li>
					<li class="nav-item"><a class="nav-link" href="#">註冊</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<header>
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<!-- Slide One - Set the background image for this slide in the line below -->
				<div class="carousel-item active"
					style="background-image: url('./Image/carousel4.jpg')">
					<div class="carousel-caption d-none d-md-block">
						<form action="">
							<h1>Lorem ipsum dolor .</h1>
							<div class="email-box">
								<i class="far fa-heart"></i> <input class="tbox" type="email"
									name="" value="" placeholder="Search what you want ">
								<button class="btn" type="button" name="button">Subscribe</button>
							</div>
						</form>
						<h3>First Slide</h3>
						<p>This is a description for the first slide.</p>
					</div>
				</div>
				<!-- Slide Two - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('./Image/carousel.jpg')">
					<div class="carousel-caption d-none d-md-block">
						<h3>Second Slide</h3>
						<p>This is a description for the second slide.</p>
					</div>
				</div>

				<!-- Slide Three - Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('./Image/carsousel2.jpg')">
					<div class="carousel-caption d-none d-md-block">
						<h3>Third Slide</h3>
						<p>This is a description for the third slide.</p>
					</div>
				</div>
				<!-- Slide 4- Set the background image for this slide in the line below -->
				<div class="carousel-item"
					style="background-image: url('./Image/carousel3.webp')">
					<div class="carousel-caption d-none d-md-block">
						<h3>Fourth Slide</h3>
						<p>This is a description for the fourth slide.</p>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</header>

	<!-- Page Content -->
	<div class="container">

		<h1 class="my-4">
			<img src="./icon/wedding-rings.png" width="45">優惠店家
		</h1>

		<!-- Marketing Icons Section -->
		<div class="row">
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">方案名</h4>
					<div class="card-body">
						<img src="./Image/155819198781535900_auto_450x337.jpg" width="300">
						<p class="card-text">方案簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">方案名</h4>
					<div class="card-body">
						<img src="./Image/155819198781535900_auto_450x337.jpg" width="300">
						<p class="card-text">方案簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">方案名</h4>
					<div class="card-body">
						<img src="./Image/155819198781535900_auto_450x337.jpg" width="300">
						<p class="card-text">方案簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

		<!-- Portfolio Section -->
		<img src="./icon/wedding-rings.png" width="45">
		<h2>婚禮佈置</h2>

		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家A</a>
						</h4>
						<p class="card-text">店家簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Amet numquam aspernatur eum quasi
							sapiente nesciunt? Voluptatibus sit, repellat sequi itaque
							deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil,
							dolorem!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家B</a>
						</h4>
						<p class="card-text">店家簡介:Lorem ipsum dolor sit amet,
							consectetur adipiscing elit. Nam viverra euismod odio, gravida
							pellentesque urna varius vitae.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家C</a>
						</h4>
						<p class="card-text">店家簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Quos quisquam, error quod sed
							cumque, odio distinctio velit nostrum temporibus necessitatibus
							et facere atque iure perspiciatis mollitia recusandae vero vel
							quam!</p>
					</div>
				</div>
			</div>
		</div>
		<!-- Portfolio Section -->
		<img src="./icon/wedding-rings.png" width="45">
		<h2>婚禮攝影</h2>

		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家A</a>
						</h4>
						<p class="card-text">店家簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Amet numquam aspernatur eum quasi
							sapiente nesciunt? Voluptatibus sit, repellat sequi itaque
							deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil,
							dolorem!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家B</a>
						</h4>
						<p class="card-text">店家簡介:Lorem ipsum dolor sit amet,
							consectetur adipiscing elit. Nam viverra euismod odio, gravida
							pellentesque urna varius vitae.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家C</a>
						</h4>
						<p class="card-text">店家簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Quos quisquam, error quod sed
							cumque, odio distinctio velit nostrum temporibus necessitatibus
							et facere atque iure perspiciatis mollitia recusandae vero vel
							quam!</p>
					</div>
				</div>
			</div>
		</div>
		<!-- Portfolio Section -->
		<img src="./icon/wedding-rings.png" width="45">
		<h2>新娘秘書</h2>

		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家A</a>
						</h4>
						<p class="card-text">店家簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Amet numquam aspernatur eum quasi
							sapiente nesciunt? Voluptatibus sit, repellat sequi itaque
							deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil,
							dolorem!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家B</a>
						</h4>
						<p class="card-text">店家簡介:Lorem ipsum dolor sit amet,
							consectetur adipiscing elit. Nam viverra euismod odio, gravida
							pellentesque urna varius vitae.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家C</a>
						</h4>
						<p class="card-text">店家簡介: Lorem ipsum dolor sit amet,
							consectetur adipisicing elit. Quos quisquam, error quod sed
							cumque, odio distinctio velit nostrum temporibus necessitatibus
							et facere atque iure perspiciatis mollitia recusandae vero vel
							quam!</p>
					</div>
				</div>
			</div>
		</div>

		<img src="./icon/wedding-rings.png" width="45">
		<h2>婚禮主持</h2>

		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家A</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Amet numquam aspernatur eum quasi sapiente
							nesciunt? Voluptatibus sit, repellat sequi itaque deserunt,
							dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家B</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Nam viverra euismod odio, gravida pellentesque
							urna varius vitae.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">店家C</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Quos quisquam, error quod sed cumque, odio
							distinctio velit nostrum temporibus necessitatibus et facere
							atque iure perspiciatis mollitia recusandae vero vel quam!</p>
					</div>
				</div>
			</div>

		</div>
		<!-- /.row -->


		<!-- Related Projects Row -->
		<h3 class="my-4">
			<img src="./icon/3253474-wedding/png/014-present.png" width="45">小物商城
		</h3>

		<div class="row">

			<div class="col-md-3 col-sm-6 mb-4">
				<a href="#"> <img class="img-fluid"
					src="http://placehold.it/500x300" alt="">
				</a>
			</div>

			<div class="col-md-3 col-sm-6 mb-4">
				<a href="#"> <img class="img-fluid"
					src="http://placehold.it/500x300" alt="">
				</a>
			</div>

			<div class="col-md-3 col-sm-6 mb-4">
				<a href="#"> <img class="img-fluid"
					src="http://placehold.it/500x300" alt="">
				</a>
			</div>

			<div class="col-md-3 col-sm-6 mb-4">
				<a href="#"> <img class="img-fluid"
					src="http://placehold.it/500x300" alt="">
				</a>
			</div>

		</div>

		<hr>

		<!-- Call to Action Section -->
		<div class="row mb-4">
			<div class="col-md-8">
				<p>姻緣聚繪: 搜尋方式最多元、快速回覆零時差、優質店家把關</p>
			</div>
			<div class="col-md-4">
				<a class="btn btn-lg btn-secondary btn-block" href="#">我要註冊</a>
			</div>
		</div>

	</div>
	<!-- /.container -->


	<!-- Footer -->
	<footer class="py-5 bg-pink">
		<div class="container">
			<p class="m-0 text-center text-dark">Copyright &copy; Your
				Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/marry.js"></script>
</body>

</html>

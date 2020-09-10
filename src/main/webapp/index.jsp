<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>姻緣聚繪</title>
  </head>
  <body>
    <jsp:include page="/fragment/topMVC.jsp" />
    <!-- Navigation -->

    <header>
      <div
        id="carouselExampleIndicators"
        class="carousel slide"
        data-ride="carousel"
      >
        <ol class="carousel-indicators">
          <li
            data-target="#carouselExampleIndicators"
            data-slide-to="0"
            class="active"
          ></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <!-- Slide One - Set the background image for this slide in the line below -->
          <div
            class="carousel-item active"
            style="
              background-image: url('${pageContext.request.contextPath}/data/Image/carousel4.jpg');
            "
          >
            <div class="carousel-caption d-none d-md-block">
              <h3>First Slide</h3>
              <p>This is a description for the first slide.</p>
            </div>
          </div>
          <!-- Slide Two - Set the background image for this slide in the line below -->
          <div
            class="carousel-item"
            style="
              background-image: url('${pageContext.request.contextPath}/data/Image/carousel.jpg');
            "
          >
            <div class="carousel-caption d-none d-md-block">
              <h3>Second Slide</h3>
              <p>This is a description for the second slide.</p>
            </div>
          </div>

          <!-- Slide Three - Set the background image for this slide in the line below -->
          <div
            class="carousel-item"
            style="
              background-image: url('${pageContext.request.contextPath}/data/Image/carsousel2.jpg');
            "
          >
            <div class="carousel-caption d-none d-md-block">
              <h3>Third Slide</h3>
              <p>This is a description for the third slide.</p>
            </div>
          </div>
          <!-- Slide 4- Set the background image for this slide in the line below -->
          <div
            class="carousel-item"
            style="
              background-image: url('${pageContext.request.contextPath}/data/Image/carousel3.webp');
            "
          >
            <div class="carousel-caption d-none d-md-block">
              <h3>Fourth Slide</h3>
              <p>This is a description for the fourth slide.</p>
            </div>
          </div>
        </div>
        <a
          class="carousel-control-prev"
          href="#carouselExampleIndicators"
          role="button"
          data-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a
          class="carousel-control-next"
          href="#carouselExampleIndicators"
          role="button"
          data-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </header>

    <!-- Page Content -->
    <div class="container">
      <h1 class="my-4">
        <img
          src="${pageContext.request.contextPath}/data/icon/wedding-rings.png"
          width="45"
        />優惠店家
      </h1>

      <!-- Marketing Icons Section -->
      <div class="row">
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">方案名</h4>
            <div class="card-body">
              <img
                src="${pageContext.request.contextPath}/data/Image/155819198781535900_auto_450x337.jpg"
                width="300"
              />
              <p class="card-text">
                方案簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Sapiente esse necessitatibus neque.
              </p>
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
              <img
                src="${pageContext.request.contextPath}/data/Image/155819198781535900_auto_450x337.jpg"
                width="300"
              />
              <p class="card-text">
                方案簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Sapiente esse necessitatibus neque.
              </p>
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
              <img
                src="${pageContext.request.contextPath}/data/Image/155819198781535900_auto_450x337.jpg"
                width="300"
              />
              <p class="card-text">
                方案簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Sapiente esse necessitatibus neque.
              </p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Learn More</a>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->

      <!-- Portfolio Section -->
      <img
        src="${pageContext.request.contextPath}/data/icon/wedding-rings.png"
        width="45"
      />
      <h2>婚禮佈置</h2>

      <div class="row">
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家A</a>
              </h4>
              <p class="card-text">
                店家簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Amet numquam aspernatur eum quasi sapiente nesciunt?
                Voluptatibus sit, repellat sequi itaque deserunt, dolores in,
                nesciunt, illum tempora ex quae? Nihil, dolorem!
              </p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家B</a>
              </h4>
              <p class="card-text">
                店家簡介:Lorem ipsum dolor sit amet, consectetur adipiscing
                elit. Nam viverra euismod odio, gravida pellentesque urna varius
                vitae.
              </p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家C</a>
              </h4>
              <p class="card-text">
                店家簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Quos quisquam, error quod sed cumque, odio distinctio
                velit nostrum temporibus necessitatibus et facere atque iure
                perspiciatis mollitia recusandae vero vel quam!
              </p>
            </div>
          </div>
        </div>
      </div>
      <!-- Portfolio Section -->
      <img
        src="${pageContext.request.contextPath}/data/icon/wedding-rings.png"
        width="45"
      />
      <h2>婚禮攝影</h2>

      <div class="row">
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家A</a>
              </h4>
              <p class="card-text">
                店家簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Amet numquam aspernatur eum quasi sapiente nesciunt?
                Voluptatibus sit, repellat sequi itaque deserunt, dolores in,
                nesciunt, illum tempora ex quae? Nihil, dolorem!
              </p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家B</a>
              </h4>
              <p class="card-text">
                店家簡介:Lorem ipsum dolor sit amet, consectetur adipiscing
                elit. Nam viverra euismod odio, gravida pellentesque urna varius
                vitae.
              </p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家C</a>
              </h4>
              <p class="card-text">
                店家簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Quos quisquam, error quod sed cumque, odio distinctio
                velit nostrum temporibus necessitatibus et facere atque iure
                perspiciatis mollitia recusandae vero vel quam!
              </p>
            </div>
          </div>
        </div>
      </div>
      <!-- Portfolio Section -->
      <img
        src="${pageContext.request.contextPath}/data/icon/wedding-rings.png"
        width="45"
      />
      <h2>新娘秘書</h2>

      <div class="row">
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家A</a>
              </h4>
              <p class="card-text">
                店家簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Amet numquam aspernatur eum quasi sapiente nesciunt?
                Voluptatibus sit, repellat sequi itaque deserunt, dolores in,
                nesciunt, illum tempora ex quae? Nihil, dolorem!
              </p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家B</a>
              </h4>
              <p class="card-text">
                店家簡介:Lorem ipsum dolor sit amet, consectetur adipiscing
                elit. Nam viverra euismod odio, gravida pellentesque urna varius
                vitae.
              </p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家C</a>
              </h4>
              <p class="card-text">
                店家簡介: Lorem ipsum dolor sit amet, consectetur adipisicing
                elit. Quos quisquam, error quod sed cumque, odio distinctio
                velit nostrum temporibus necessitatibus et facere atque iure
                perspiciatis mollitia recusandae vero vel quam!
              </p>
            </div>
          </div>
        </div>
      </div>

      <img
        src="${pageContext.request.contextPath}/data/icon/wedding-rings.png"
        width="45"
      />
      <h2>婚禮主持</h2>

      <div class="row">
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家A</a>
              </h4>
              <p class="card-text">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet
                numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus
                sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum
                tempora ex quae? Nihil, dolorem!
              </p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家B</a>
              </h4>
              <p class="card-text">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam
                viverra euismod odio, gravida pellentesque urna varius vitae.
              </p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"
              ><img
                class="card-img-top"
                src="http://placehold.it/700x400"
                alt=""
            /></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">店家C</a>
              </h4>
              <p class="card-text">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos
                quisquam, error quod sed cumque, odio distinctio velit nostrum
                temporibus necessitatibus et facere atque iure perspiciatis
                mollitia recusandae vero vel quam!
              </p>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->

      <!-- Related Projects Row -->
      <h3 class="my-4">
        <img
          src="${pageContext.request.contextPath}/data/icon/3253474-wedding/png/014-present.png"
          width="45"
        />小物商城
      </h3>

      <div class="row">
        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="" />
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="" />
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="" />
          </a>
        </div>

        <div class="col-md-3 col-sm-6 mb-4">
          <a href="#">
            <img class="img-fluid" src="http://placehold.it/500x300" alt="" />
          </a>
        </div>
      </div>

      <hr />

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
        <p class="m-0 text-center text-dark">
          Copyright &copy; Your Website 2020
        </p>
      </div>
      <!-- /.container -->
    </footer>
  </body>
</html>

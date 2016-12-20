<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Category"%>
<%@ page import="model.CategoryList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DataWarehouse &mdash; searching for movie</title>

<%  String path = request.getContextPath(); %>
<% 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700|Roboto:300,400'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/modernizr-2.6.2.min.js"></script>
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
<link href="css/styles.css" rel="stylesheet" media="screen">
<script>
	function get() {
		htmlobj = $.ajax({
			url : "/M.asp?mail=" + $("#mail").val() + "&name="
					+ $("#name").val() + "&nr=" + $("#message").val(),
			async : false
		});
		if (htmlobj.responseText == "1") {
			alert("Success!");
		}
	}
</script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
	<div class="box-wrap">
		<header role="banner" id="fh5co-header">
		<div class="container">
			<nav class="navbar navbar-default">
			<div class="row animate-box">
				<div class="col-md-12">
					<ul class="nav text-center">
						<li class="active"><a href="/DataWarehouse/Homepage"><span>Homepage</span></a></li>
						<li><a href="#intro">Searchpage</a></li>
						<li><a href="#members">Members</a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
		</header>
		<!-- END: header -->

		<section id="slider" class="animate-box">
		<div class="container">
			<div id="mainSlider" class="carousel slide">
				<div class="carousel-inner">
					<div class="active item">
						<div class="slide1 nBg">
							<div class="row-fluid">
								<div class="span6">
									<h2 class="titleone">
										Query and Statistics based on TIME </br>
									</h2>
									<p>
										1.How many movies are there in a particular year?<br>
										2.How many movies are there in a particular month in the
										particular year?<br> 3.How many movies are there in a
										particular quarter in the particular year?<br> 4.How many
										new movies were put on shelf last Thuesday?
									</p>
									<a class="big-grn-btn" href="#work">Search on time
										immediately</a>
								</div>
								<div class="span6">
									<img src="img/big-slider/time.jpg" alt="image alt text" />
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="slide1 nBg">
							<div class="row-fluid">
								<div class="span6">
									<h2 class="titleone">
										Query and Statistics based on MOVIE TITLE <br>
									</h2>
									<p>
										1.How many editions does a particular movie have? <br> <br>
										<br> <br> <br> <br>
									</p>
									<a class="big-grn-btn" href="#work">Search on title
										immediately</a>
								</div>
								<div class="span6">
									<img src="img/big-slider/title.jpg" alt="image alt text" />
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="slide1 nBg">
							<div class="row-fluid">
								<div class="span6">
									<h2 class="titleone">
										Query and Statistics based on DIRECTOR <br>
									</h2>
									<p>
										1.How many movies has a particular director already made? <br>
										<br> <br> <br> <br> <br>
									</p>
									<a class="big-grn-btn" href="#work">Search on director
										immediately</a>
								</div>
								<div class="span6">
									<img src="img/big-slider/director.jpg" alt="image alt text" />
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="slide1 nBg">
							<div class="row-fluid">
								<div class="span6">
									<h2 class="titleone">Query and Statistics based on ACTOR</h2>
									<p>
										1.How many movies does a particular actor play the leading
										role? <br> 2.How many movies does a particular actor
										participate in? <br> <br> <br> <br> <br>
									</p>
									<a class="big-grn-btn" href="#work">Search on actor
										immediately</a>
								</div>
								<div class="span6">
									<img src="img/big-slider/actor.jpg" alt="image alt text" />
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="slide1 nBg">
							<div class="row-fluid">
								<div class="span6">
									<h2 class="titleone">
										Query and Statistics based on MOVIE CATEGORY <br>
									</h2>
									<p>
										1.How many action movies are there in the record? <br>
										2.How many adventure movies are there in the record? <br>
										<br> <br> <br> <br>
									</p>
									<a class="big-grn-btn" href="#work">Search on category
										immediately</a>
								</div>
								<div class="span6">
									<img src="img/big-slider/type.jpg" alt="image alt text" />
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="slide1 nBg">
							<div class="row-fluid">
								<div class="span6">
									<h2 class="titleone">
										Comprehensive Query and Statistics <br>
									</h2>
									<p>
										Search on other elements <br> <br> <br> <br>
										<br> <br>
									</p>
									<a class="big-grn-btn" href="#work">Search integratedly</a>
								</div>
								<div class="span6">
									<img src="img/big-slider/compre.jpg" alt="image alt text" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<a class="carousel-control left" href="#mainSlider"
					data-slide="prev">&lsaquo;</a><a class="carousel-control right"
					href="#mainSlider" data-slide="next">&rsaquo;</a>
				<ol class="carousel-indicators">
					<li data-target="#mainSlider" data-slide-to="0" class="active"></li>
					<li data-target="#mainSlider" data-slide-to="1"></li>
					<li data-target="#mainSlider" data-slide-to="2"></li>
					<li data-target="#mainSlider" data-slide-to="3"></li>
					<li data-target="#mainSlider" data-slide-to="4"></li>
					<li data-target="#mainSlider" data-slide-to="5"></li>
				</ol>
			</div>
		</div>
		<div class="slider-pag-bg"></div>
		</section>



		<section id="intro">
		<div class="container">
			<div class="row">
				<div
					class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 text-center">
					<div class="intro animate-box">
						<h1>We offer six different modes on movie searching:</h1>
						<h2>TIME & TITLE & DIRECTOR & ACTOR & CATEGORY &
							COMPREHENSIVE SEARCHING</h2>
					</div>
				</div>
			</div>
		</div>
		</section>

		<section id="work">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="fh5co-grid animate-box"
						style="background-image: url(img/1.jpg);">
						<a class="image-popup text-center">
							<div class="work-title">
								<h2>SEARCH ON TIME</h2>
								<div id="main_demo">
								<form type = "POST" action= "<%=path%>/SearchByTime">

									<select id="year" name="year" class="sel2">
										<option value="2012">YEAR 2012</option>
										<option value="2011">2011</option>
										<option value="2010">2010</option>
										<option value="2009">2009</option>
										<option value="2008">2008</option>
										<option value="2007">2007</option>
										<option value="2006">2006</option>
										<option value="2005">2005</option>
										<option value="2004">2004</option>
										<option value="2003">2003</option>
										<option value="2002">2002</option>
										<option value="2001">2001</option>
										<option value="2000">2000</option>
										<option value="1999">1999</option>
										<option value="1998">1998</option>
										<option value="1997">1997</option>
									</select> <select id="month" name="month" class="sel2"
										onchange="getMonth(this.id, 'season')">
										<option value="0">MONTH ALL</option>
										<option value="1">JANUARY</option>
										<option value="2">FEBRUARY</option>
										<option value="3">MARCH</option>
										<option value="4">APRIL</option>
										<option value="5">MAY</option>
										<option value="6">JUNE</option>
										<option value="7">JULY</option>
										<option value="8">AUGUST</option>
										<option value="9">SEPTEMBER</option>
										<option value="10">OCTOBER</option>
										<option value="11">NOVEMBER</option>
										<option value="12">DECEMBER</option>
									</select> <select id="weekday" name="weekday" class="sel2">
										<option value="0">WEEKDAY ALL</option>
										<option value="1">MONDAY</option>
										<option value="2">TUESDAY</option>
										<option value="3">WEDNESDAY</option>
										<option value="4">THURSDAY</option>
										<option value="5">FRIDAY</option>
										<option value="6">SATURDAY</option>
										<option value="7">SUNDAY</option>
									</select> <select id="season" name="season" class="sel2"
										onchange="getSeason('month', this.id)">
										<option value="0">SEASON ALL</option>
										<option value="1">SPRING</option>
										<option value="2">SUMMER</option>
										<option value="3">AUTUMN</option>
										<option value="4">WINTER</option>
									</select>
								</div>
								</br>
								<input type="submit" class="btn btn-primary" value="Go!">
								</form>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="fh5co-grid animate-box"
						style="background-image: url(img/5.jpg);">
						<a class="image-popup text-center">
							<div class="work-title">
								<h2>SEARCH ON TITLE</h2>
								<form type = "POST" action= "<%=path%>/SearchByName">
									<input id="title" name="title" type="text"
										placeholder="movie title" required="required"> </br>
									</br>
									<input type="submit" class="btn btn-primary" value="Go!">
								</form>
								<!-- <span>Illustration, Print</span> -->
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="fh5co-grid animate-box"
						style="background-image: url(img/3.jpg);">
						<a class="image-popup text-center">
							<div class="work-title">
								<h2>SEARCH ON DIRECTOR</h2>
								<form type = "POST" action= "<%=path%>/SearchByDirector">
									<input id="director" name="director" type="text"
										placeholder="director name" required="required"> </br>
									</br>
									<input type="submit" class="btn btn-primary" value="Go!">
								</form>
								<!-- <span>Illustration, Print</span> -->
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="fh5co-grid animate-box"
						style="background-image: url(img/2.jpg);">
						<a class="image-popup text-center">
							<div class="work-title">
								<h2>SEARCH ON ACTOR</h2>
								<form type = "POST" action= "<%=path%>/SearchByActor">
									<div id="main_demo">
											<select id="type" name="type" class="sel2">
											  <option value="starring">Starring</option>
											  <option value="supporting">Supporting</option>
											</select>
											</div>
									<input id="actor" name="actor" type="text"
										placeholder="actor name" required="required"> </br>
									</br>
									<input type="submit" class="btn btn-primary" value="Go!">
								</form>
								<!-- <span>Illustration, Print</span> -->
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="fh5co-grid animate-box"
						style="background-image: url(img/4.jpg);">
						<a class="image-popup text-center">
							<div class="work-title">
								<h2>SEARCH ON CATEGORY</h2>
								<form type = "POST" action= "<%=path%>/SearchByCategory">
								<div id="main_demo">
									<select id="category" name="category" class="sel2">
										<%! ArrayList<CategoryList> category_list = new ArrayList<CategoryList>();%>
										<% 
										session = request.getSession(false);
										if (session != null) {
											Object o = session.getAttribute("CategoryList");
											if (o != null)
												category_list = (ArrayList<CategoryList>) o;
										}
										for (int i = 0; i < category_list.size(); i++) {
										%>
										<option value="<%= category_list.get(i).CategoryId %>"><%= category_list.get(i).CategoryName %></option>
										<% } %>
										<%--
										<option value="1">Action & Adventure</option>
										<option value="2">Anime</option>
										<option value="3">Bollywood</option>
										<option value="4">Comedy</option>
										<option value="5">Documentary</option>
										<option value="6">Drama</option>
										<option value="7">Educational</option>
										<option value="8">Exercise & Fitness</option>
										<option value="9">Faith & Spirituality</option>
										<option value="10">Fantasy</option>
										<option value="11">Foreign</option>
										<option value="12">Horror</option>
										<option value="13">Kids & Family</option>
										<option value="14">LGBT</option>
										<option value="15">Military & War</option>
										<option value="16">Music Videos & Concerts</option>
										<option value="17">Musicals</option>
										<option value="18">Mystery & Thrillers</option>
										<option value="19">Performing Arts</option>
										<option value="20">Reality TV</option>
										<option value="21">Romance</option>
										<option value="22">Science Fiction</option>
										<option value="23">Soap Operas</option>
										<option value="24">Special Interests</option>
										<option value="25">Sports</option>
										<option value="26">TV Game Shows</option>
										<option value="27">TV News Programming</option>
										<option value="28">TV Talk Shows</option>
										<option value="29">Westerns</option>
										 --%>
									</select>
								</div>
								</br>
								<input type="submit" class="btn btn-primary" value="Go!">
								</form>

									<!-- <span>Illustration, Print</span> -->
							</div>
						</a>
					</div>
				</div>

				<div class="col-md-12">
					<div class="fh5co-grid2 animate-box"
						style="background-image: url(img/7.jpg);">
						<a class="image-popup text-center">
								<div class="work-title2">
									<h2>COMPREHENSIVE SEARCHING</h2>
							
							<div id="main_demo">
							
							
							<form type = "POST" action= "<%=path%>/SearchComprehensive">
							
								<button type="button" class="btn btn-primary" onclick="compreGo()">Add primary elements</button>
								<button type="button" class="btn btn-primary" onclick="compreGo2()">Add other elements</button>
								<input type="submit" class="btn btn-primary" value="Go!"></input>
								
											
											<br></br>
										 <div id="a" class="seniorsearch">
										 <div id="div_attribute1_0" style="float:left">
										 <select name="attribute1_0" id="attribute1_0" class="sel1" onchange="getSenior(this.id)">
										  <option value="0">SELECT ELEMENT</option>
										  <option value="1">TIME</option>
										  <option value="2">TITLE</option>
										  <option value="3">DIRECTOR</option>
										  <option value="4">ACTOR</option>
										  <option value="5">CATEGORY</option>
										 </select>
										 </div>

										 </div>
								</form>
										 
									</div></br>

								</div>
					</a>
				</div>
			</div>

		</div>
	</div>
	</section>

	<section id="members">


	<div class="container">
		<div class="row">
			<div
				class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 text-center">
				<div class="intro animate-box">
					<h1>GROUP MEMBERS:</h1>
					<h3>
						Wang Guansong</br>Wang Jiahui</br>Zhang Yinjia</br>Xiang AnYing</br>
					</h3>
				</div>
			</div>
		</div>
	</div>

	</section>


	</div>

	<script src="js/jquery.waypoints.min.js"></script>

	<script src="js/main.js"></script>

	<script src="js/index.js"></script>

</body>
</html>
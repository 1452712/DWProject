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
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,300,700|Roboto:300,400'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=path%>/css/animate.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/modernizr-2.6.2.min.js"></script>
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	media="screen">
<link href="css/styles.css" rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css" href="css/jquery.selectlist.css">
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
						<li class="active"><a href="index.html"><span>Homepage</span></a></li>
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
						style="background-image: url(images/1.jpg);">
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
									</select> <select id="season" name="season" class="sel2">
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
						<a class="image-popup text-center"> <!-- <div class="work-title"> -->
							</br>
						</br>
						</br>
							<h2>COMPREHENSIVE SEARCHING</h2>
							
							<form type = "POST" action= "<%=path%>/SearchComprehensive">
							<div id="main_demo">
								<!-- <select id="senior" name="senior">
											<option value="0">SELECT ELEMENT</option>
											<option value="1">TIME</option>
											<option value="2">TITLE</option>
											<option value="3">DIRECTOR</option>
											<option value="4">ACTOR</option>
											<option value="5">CATEGORY</option>
										</select> -->
								<form action="somepage.asp" name=theForm">
									<select name="senior" id="senior" class="sel1"
										onchange="getSenior(this.id)">
										<option value="0">SELECT ELEMENT</option>
										<option value="1">TIME</option>
										<option value="2">TITLE</option>
										<option value="3">DIRECTOR</option>
										<option value="4">ACTOR</option>
										<option value="5">CATEGORY</option>
									</select>
								</form>
								<div id="a"></div>
							</div>
							</br>

							<button type="button" class="btn btn-primary"
								onclick="compreGo()">Add elements</button> </br> </br>
							<input type="submit" class="btn btn-primary" value="Go!">
							</form>
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
					<h2>
						Wang Guansong</br> Wang Jiahui</br> Zhang Yinjia</br> Xiang AnYing</br>
					</h2>
				</div>
			</div>
		</div>
	</div>

	</section>


	</div>

	<script src="js/jquery.waypoints.min.js"></script>

	<script src="js/main.js"></script>

	<script language="JavaScript" type="text/javascript">
		var i = 0;
		function getSenior(v) {

			var sltSenior = document.getElementById(v);

			//判断是输入还是下拉框
			//如果是下拉框，则新建立下拉框
			if (sltSenior.selectedIndex == 5) {
				var myDiv = document.createElement("div");

				var div2 = document.getElementById("a");
				div2.appendChild(myDiv);

				myDiv.id = "myDiv" + i;
				var div = document.getElementById(myDiv.id);
				var mySelect = document.createElement("select");
				mySelect.id = "mySelect1" + i;
				mySelect.setAttribute('class', 'sel2');
				mySelect.setAttribute('name', mySelect.id);
				div.appendChild(mySelect);
				var obj = document.getElementById(mySelect.id);
				obj.options.add(new Option("Action & Adventure", "0"));
				obj.options.add(new Option("Anime", "1"));
				obj.options.add(new Option("Bollywood", "2"));
				obj.options.add(new Option("Comedy", "3"));
				obj.options.add(new Option("Documentary", "4"));
				obj.options.add(new Option("Drama", "5"));
				obj.options.add(new Option("Educational", "6"));
				obj.options.add(new Option("Exercise & Fitness", "7"));
				obj.options.add(new Option("Faith & Spirituality", "8"));
				obj.options.add(new Option("Fantasy", "9"));
				obj.options.add(new Option("Foreign", "10"));
				obj.options.add(new Option("Horror", "11"));
				obj.options.add(new Option("Kids & Family", "12"));
				obj.options.add(new Option("LGBT", "13"));
				obj.options.add(new Option("Military & War", "14"));
				obj.options.add(new Option("Music Videos & Concerts", "15"));
				obj.options.add(new Option("Musicals", "16"));
				obj.options.add(new Option("Mystery & Thrillers", "17"));
				obj.options.add(new Option("Performing Arts", "18"));
				obj.options.add(new Option("Reality TV", "19"));
				obj.options.add(new Option("Romance", "20"));
				obj.options.add(new Option("Science Fiction", "21"));
				obj.options.add(new Option("Soap Operas", "22"));
				obj.options.add(new Option("Special Interests", "23"));
				obj.options.add(new Option("Sports", "24"));
				obj.options.add(new Option("TV Game Shows", "25"));
				obj.options.add(new Option("TV News Programming", "26"));
				obj.options.add(new Option("TV Talk Shows", "27"));
				obj.options.add(new Option("Westerns", "28"));

				var br = document.createElement("br");
				div.appendChild(br);
				i = i + 1;

			}
			if (sltSenior.selectedIndex == 1) {
				var myDiv = document.createElement("div");

				var div2 = document.getElementById("a");
				div2.appendChild(myDiv);

				myDiv.id = "myDiv" + i;
				var div = document.getElementById(myDiv.id);
				var mySelect = document.createElement("select");
				mySelect.id = "mySelect2" + i;
				mySelect.setAttribute('class', 'sel2');
				mySelect.setAttribute('name', mySelect.id);

				div.appendChild(mySelect);
				var obj = document.getElementById(mySelect.id);
				obj.options.add(new Option("YEAR 2012", "0"));
				obj.options.add(new Option("2011", "1"));
				obj.options.add(new Option("2010", "2"));
				obj.options.add(new Option("2009", "3"));
				obj.options.add(new Option("2008", "4"));
				obj.options.add(new Option("2007", "5"));
				obj.options.add(new Option("2006", "6"));
				obj.options.add(new Option("2005", "7"));
				obj.options.add(new Option("2004", "8"));
				obj.options.add(new Option("2003", "9"));
				obj.options.add(new Option("2002", "10"));
				obj.options.add(new Option("2001", "11"));
				obj.options.add(new Option("2000", "12"));
				obj.options.add(new Option("1999", "13"));
				obj.options.add(new Option("1998", "14"));
				obj.options.add(new Option("1997", "15"));

				var br = document.createElement("br");
				div.appendChild(br);
				i = i + 1;

				myDiv.id = "myDiv" + i;
				var div = document.getElementById(myDiv.id);
				var mySelectM = document.createElement("select");
				mySelectM.id = "mySelect2" + i;
				mySelectM.setAttribute('class', 'sel2');
				mySelectM.setAttribute('name', mySelectM.id);

				div.appendChild(mySelectM);
				var obj = document.getElementById(mySelectM.id);
				obj.options.add(new Option("MONTH ALL", "0"));
				obj.options.add(new Option("JANUARY", "1"));
				obj.options.add(new Option("FEBRUARY", "2"));
				obj.options.add(new Option("MARCH", "3"));
				obj.options.add(new Option("APRIL", "4"));
				obj.options.add(new Option("MAY", "5"));
				obj.options.add(new Option("JUNE", "6"));
				obj.options.add(new Option("JULY", "7"));
				obj.options.add(new Option("AUGUST", "8"));
				obj.options.add(new Option("SEPTEMBER", "9"));
				obj.options.add(new Option("OCTOBER", "10"));
				obj.options.add(new Option("NOVEMBER", "11"));
				obj.options.add(new Option("DECEMBER", "12"));

				var br = document.createElement("br");
				div.appendChild(br);
				i = i + 1;

				myDiv.id = "myDiv" + i;
				var div = document.getElementById(myDiv.id);
				var mySelect = document.createElement("select");
				mySelect.setAttribute('class', 'sel2');
				mySelect.setAttribute('name', mySelect.id);

				mySelect.id = "mySelect2" + i;
				div.appendChild(mySelect);
				var obj = document.getElementById(mySelect.id);
				obj.options.add(new Option("WEAKDAY All", "0"));
				obj.options.add(new Option("MONDAY", "1"));
				obj.options.add(new Option("THUESDAY", "2"));
				obj.options.add(new Option("WEDNESDAY", "3"));
				obj.options.add(new Option("THUESDAY", "4"));
				obj.options.add(new Option("FRIDAY", "5"));
				obj.options.add(new Option("SATURDAY", "6"));
				obj.options.add(new Option("SUNDAY", "7"));

				var br = document.createElement("br");
				div.appendChild(br);
				i = i + 1;

				myDiv.id = "myDiv" + i;
				var div = document.getElementById(myDiv.id);
				var mySelect = document.createElement("select");
				mySelect.id = "mySelect2" + i;
				mySelect.setAttribute('class', 'sel2');
				mySelect.setAttribute('name', mySelect.id);

				div.appendChild(mySelect);
				var obj = document.getElementById(mySelect.id);
				obj.options.add(new Option("SEASON ALL", "0"));
				obj.options.add(new Option("SPRING", "1"));
				obj.options.add(new Option("SUMMER", "2"));
				obj.options.add(new Option("AUTUMN", "3"));
				obj.options.add(new Option("WINTER", "4"));

				var br = document.createElement("br");
				div.appendChild(br);
				i = i + 1;

				var j = i - 4;
				j = j + 1;
				jj = j + 2;

				mySelectM.addEventListener('change', function() {
					return getMonth.apply(this, [ "mySelect2" + j,
							"mySelect2" + jj ]);
				});

			}
			if (sltSenior.selectedIndex == 2) {
				var myDiv = document.createElement("div");

				var div2 = document.getElementById("a");
				div2.appendChild(myDiv);

				myDiv.id = "myDiv" + i;
				var div = document.getElementById(myDiv.id);

				var input = document.createElement("input");
				input.setAttribute('type', 'text');
				input.setAttribute('required', 'required');
				input.setAttribute('name', myDiv.id);
				input.value = "";
				div.appendChild(input);
				var br = document.createElement("br");
				div.appendChild(br);
				i = i + 1;
			}
			if (sltSenior.selectedIndex == 3) {
				var myDiv = document.createElement("div");

				var div2 = document.getElementById("a");
				div2.appendChild(myDiv);

				myDiv.id = "myDiv" + i;
				var div = document.getElementById(myDiv.id);

				var input = document.createElement("input");
				input.setAttribute('type', 'text');
				input.setAttribute('required', 'required');
				input.setAttribute('name', myDiv.id);
				input.value = "";
				div.appendChild(input);
				var br = document.createElement("br");
				div.appendChild(br);
				i = i + 1;
			}
			if (sltSenior.selectedIndex == 4) {
				var myDiv = document.createElement("div");

				var div2 = document.getElementById("a");
				div2.appendChild(myDiv);

				myDiv.id = "myDiv" + i;
				var div = document.getElementById(myDiv.id);

				var input = document.createElement("input");
				input.setAttribute('type', 'text');
				input.setAttribute('required', 'required');
				input.setAttribute('name', myDiv.id);
				input.value = "";
				div.appendChild(input);
				var br = document.createElement("br");
				div.appendChild(br);
				i = i + 1;
			}

			//如果是输入框，则新建立输入框。
		}

		var ii = 100;

		function compreGo() {
			var myDiv = document.createElement("div");

			var div2 = document.getElementById("a");
			div2.appendChild(myDiv);

			myDiv.id = "myDiv" + ii;
			var div = document.getElementById(myDiv.id);

			var mySelect = document.createElement("select");
			mySelect.id = "mySelect" + ii;

			mySelect.setAttribute('class', 'sel1');
			mySelect.setAttribute('name', mySelect.id);

			mySelect.addEventListener('change', function() {
				return getSenior.apply(this, [ mySelect.id ]);
			});

			// mySelect.addEventListener('change', getSenior);
			div.appendChild(mySelect);
			var obj = document.getElementById(mySelect.id);
			obj.options.add(new Option("SELECT ELEMENT", "0"));
			obj.options.add(new Option("TIME", "1"));
			obj.options.add(new Option("TITLE", "2"));
			obj.options.add(new Option("DIRECTOR", "3"));
			obj.options.add(new Option("ACTOR", "4"));
			obj.options.add(new Option("CATEGORY", "5"));

			var br = document.createElement("br");
			div.appendChild(br);
			ii = ii + 1;
		}
	</script>


	<script language="JavaScript" type="text/javascript">
		function getMonth(vm, vs) {
			// var y = document.getElementById('year').selectedIndex;
			var m = document.getElementById(vm).selectedIndex;
			// var w = document.getElementById('weakday').selectedIndex;
			// var s = document.getElementById('season').selectedIndex;

			if (m != 0) {
				document.getElementById(vs).disabled = 'disabled';
				if (m == 5 || m == 4 || m == 3) {
					document.getElementById(vs).selectedIndex = 1;
				}
				if (m == 8 || m == 7 || m == 6) {
					document.getElementById(vs).selectedIndex = 2;
				}
				if (m == 11 || m == 10 || m == 9) {
					document.getElementById(vs).selectedIndex = 3;
				}
				if (m == 2 || m == 1 || m == 12) {
					document.getElementById(vs).selectedIndex = 4;
				}
			}
			;
		}
	</script>

</body>
</html>
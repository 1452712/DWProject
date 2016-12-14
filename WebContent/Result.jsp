<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%!int Count = 0;
	long DBTime = 0;
	long DWTime = 0;
	String SearchCondition = new String();%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.bullet {
	font: 10px sans-serif;
}

.bullet .marker {
	stroke: #FF0000;
	stroke-width: 4px;
}

.bullet .tick line {
	stroke: #666;
	stroke-width: .5px;
}

.bullet .range.s0 {
	fill: #FFEFD5;
}

.bullet .range.s1 {
	fill: #FFE4C4;
}

.bullet .range.s2 {
	fill: #FFD39B;
}

.bullet .measure.s0 {
	fill: #FFF68F;
}

.bullet .measure.s1 {
	fill: #FFFF00;
}

.bullet .title {
	font-size: 14px;
	font-weight: bold;
}

.bullet .subtitle {
	font-size: 12px;
	fill: #999;
}
</style>
<link rel="stylesheet" type="text/css" href="css/styles.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />

<title>Result Dashboard</title>
</head>
<body>
<%
		session = request.getSession(false);
		if (session != null) {
			Object o = session.getAttribute("Count");
			if (o != null)
				Count = (Integer) o;

			o = session.getAttribute("DBTime");
			if (o != null)
				DBTime = (Long) o;

			o = session.getAttribute("DWTime");
			if (o != null)
				DWTime = (Long) o;

			o = session.getAttribute("SearchCondition");
			if (o != null)
				SearchCondition = (String) o;

		}
	%>
	<div align="center">
		<br> <font size=10px>Searching Condition: <%=SearchCondition%></font>
		<br> <br> <font size=10px>Output: <%=Count%></font> <br>
		<%-- TEST: show the time --%>
		DBTime: <%=DBTime %><br/>
		DWTime: <%=DWTime %><br/>
		<br>
	</div>


	<script src="//d3js.org/d3.v3.min.js"></script>
	<script src="js/bullet.js"></script>

	<script>
		var margin = {
			top : 5,
			right : 40,
			bottom : 20,
			left : 120
		}, width = 960 - margin.left - margin.right, height = 50 - margin.top
				- margin.bottom;

		var chart = d3.bullet().width(width).height(height);

		d3
				.json("",
						function(error, data) {
							var data1 = <%=DWTime%>;
							var data2 = <%=DBTime%>;
							var large = data1;
							if (data1 > data2) {
								large = data1;
							} else {
								large = data2;
							}
							data = [ {
								"title" : "Relational",
								"subtitle" : data1 + "ms",
								"ranges" : [ data1, large, 2000 ],
								"measures" : [ data1, large ],
								"markers" : [ data1 ]
							}, {
								"title" : "Distributed",
								"subtitle" : data2 + "ms",
								"ranges" : [ data2, large, 2000 ],
								"measures" : [ data2, large ],
								"markers" : [ data2 ]
							} ]

							var svg = d3.select("body").selectAll("svg").data(
									data).enter().append("svg").attr("class",
									"bullet").attr("width",
									width + margin.left + margin.right).attr(
									"height",
									height + margin.top + margin.bottom)
									.append("g").attr(
											"transform",
											"translate(" + margin.left + ","
													+ margin.top + ")").call(
											chart);

							var title = svg.append("g").style("text-anchor",
									"end").attr("transform",
									"translate(-6," + height / 2 + ")");

							title.append("text").attr("class", "title").text(
									function(d) {
										return d.title;
									});

							title.append("text").attr("class", "subtitle")
									.attr("dy", "1em").text(function(d) {
										return d.subtitle;
									});

						});
	</script>


</body>
</html>
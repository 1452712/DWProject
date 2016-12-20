var flag = 1;
var i = 0;

function getSenior(v){
 
 var sltSenior=document.getElementById(v);



 //判断是输入还是下拉框
 //如果是下拉框，则新建立下拉框
 if(sltSenior.selectedIndex == 5) { 
 	if(flag == 1) {
	 	var myDiv = document.createElement("div");
	 	myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i;   

	    mySelect.setAttribute('class', 'sel2'); 
	    mySelect.setAttribute('name', mySelect.id); 
	    mySelect.setAttribute('id', mySelect.id); 

	    div.appendChild(mySelect); 

		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("Action & Adventure","0")); 
		obj.options.add(new Option("Anime","1"));
		obj.options.add(new Option("Bollywood","2")); 
		obj.options.add(new Option("Comedy","3"));
		obj.options.add(new Option("Documentary","4")); 
		obj.options.add(new Option("Drama","5"));
		obj.options.add(new Option("Educational","6")); 
		obj.options.add(new Option("Exercise & Fitness","7"));
		obj.options.add(new Option("Faith & Spirituality","8")); 
		obj.options.add(new Option("Fantasy","9"));
		obj.options.add(new Option("Foreign","10")); 
		obj.options.add(new Option("Horror","11"));
		obj.options.add(new Option("Kids & Family","12")); 
		obj.options.add(new Option("LGBT","13"));
		obj.options.add(new Option("Military & War","14")); 
		obj.options.add(new Option("Music Videos & Concerts","15"));
		obj.options.add(new Option("Musicals","16")); 
		obj.options.add(new Option("Mystery & Thrillers","17"));
		obj.options.add(new Option("Performing Arts","18")); 
		obj.options.add(new Option("Reality TV","19"));
		obj.options.add(new Option("Romance","20")); 
		obj.options.add(new Option("Science Fiction","21"));
		obj.options.add(new Option("Soap Operas","22")); 
		obj.options.add(new Option("Special Interests","23"));
		obj.options.add(new Option("Sports","24")); 
		obj.options.add(new Option("TV Game Shows","25"));
		obj.options.add(new Option("TV News Programming","26")); 
		obj.options.add(new Option("TV Talk Shows","27"));
		obj.options.add(new Option("Westerns","28")); 

		var br = document.createElement("br");
		div.appendChild(br); 
		i = i + 1;

		flag = 0;
	}
	else {
		var divbg = document.getElementById("a");

		i = i - 1;
		var removeid = "div_value1_" + i;

		divbg.removeChild(document.getElementById(removeid));


		var myDiv = document.createElement("div");
	 	myDiv.setAttribute('style', 'float:left'); 

	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i;   

	    mySelect.setAttribute('class', 'sel2'); 
	    mySelect.setAttribute('name', mySelect.id); 
	    mySelect.setAttribute('id', mySelect.id); 

	    div.appendChild(mySelect); 
	    
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("Action & Adventure","0")); 
		obj.options.add(new Option("Anime","1"));
		obj.options.add(new Option("Bollywood","2")); 
		obj.options.add(new Option("Comedy","3"));
		obj.options.add(new Option("Documentary","4")); 
		obj.options.add(new Option("Drama","5"));
		obj.options.add(new Option("Educational","6")); 
		obj.options.add(new Option("Exercise & Fitness","7"));
		obj.options.add(new Option("Faith & Spirituality","8")); 
		obj.options.add(new Option("Fantasy","9"));
		obj.options.add(new Option("Foreign","10")); 
		obj.options.add(new Option("Horror","11"));
		obj.options.add(new Option("Kids & Family","12")); 
		obj.options.add(new Option("LGBT","13"));
		obj.options.add(new Option("Military & War","14")); 
		obj.options.add(new Option("Music Videos & Concerts","15"));
		obj.options.add(new Option("Musicals","16")); 
		obj.options.add(new Option("Mystery & Thrillers","17"));
		obj.options.add(new Option("Performing Arts","18")); 
		obj.options.add(new Option("Reality TV","19"));
		obj.options.add(new Option("Romance","20")); 
		obj.options.add(new Option("Science Fiction","21"));
		obj.options.add(new Option("Soap Operas","22")); 
		obj.options.add(new Option("Special Interests","23"));
		obj.options.add(new Option("Sports","24")); 
		obj.options.add(new Option("TV Game Shows","25"));
		obj.options.add(new Option("TV News Programming","26")); 
		obj.options.add(new Option("TV Talk Shows","27"));
		obj.options.add(new Option("Westerns","28")); 

		var br = document.createElement("br");
		div.appendChild(br); 
		i = i + 1;

	}

 }
 if(sltSenior.selectedIndex == 1) {
 	if(flag == 1) {
	 	var myDiv = document.createElement("div");
		myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

	    myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var ii = 0;
	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_" + ii;  

		mySelect.setAttribute('class', 'sel2'); 
		mySelect.setAttribute('name', mySelect.id);
		mySelect.setAttribute('id', mySelect.id);

	    div.appendChild(mySelect); 
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("YEAR 2012","0")); 
		obj.options.add(new Option("2011","1"));
		obj.options.add(new Option("2010","2"));
		obj.options.add(new Option("2009","3"));
		obj.options.add(new Option("2008","4"));
		obj.options.add(new Option("2007","5"));
		obj.options.add(new Option("2006","6"));
		obj.options.add(new Option("2005","7"));
		obj.options.add(new Option("2004","8"));
		obj.options.add(new Option("2003","9"));
		obj.options.add(new Option("2002","10"));
		obj.options.add(new Option("2001","11"));
		obj.options.add(new Option("2000","12"));
		obj.options.add(new Option("1999","13"));
		obj.options.add(new Option("1998","14"));
		obj.options.add(new Option("1997","15"));

		var br = document.createElement("br");
		div.appendChild(br); 
		ii = ii + 1;


	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_" + ii; 
		mySelect.setAttribute('class', 'sel2'); 
		mySelect.setAttribute('name', mySelect.id);
		mySelect.setAttribute('id', mySelect.id);

	    div.appendChild(mySelect); 
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("MONTH ALL","0")); 
		obj.options.add(new Option("JANUARY","1"));
		obj.options.add(new Option("FEBRUARY","2"));
		obj.options.add(new Option("MARCH","3"));
		obj.options.add(new Option("APRIL","4"));
		obj.options.add(new Option("MAY","5"));
		obj.options.add(new Option("JUNE","6"));
		obj.options.add(new Option("JULY","7"));
		obj.options.add(new Option("AUGUST","8"));
		obj.options.add(new Option("SEPTEMBER","9"));
		obj.options.add(new Option("OCTOBER","10"));
		obj.options.add(new Option("NOVEMBER","11"));
		obj.options.add(new Option("DECEMBER","12"));

		var br = document.createElement("br");
		div.appendChild(br); 
		ii = ii + 1;

	
	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_" + ii;   

	    mySelect.setAttribute('class', 'sel2'); 
	    mySelect.setAttribute('name', mySelect.id);
	    mySelect.setAttribute('id', mySelect.id);
	    
	    div.appendChild(mySelect); 
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("WEAKDAY All","0")); 
		obj.options.add(new Option("MONDAY","1"));
		obj.options.add(new Option("THUESDAY","2"));
		obj.options.add(new Option("WEDNESDAY","3"));
		obj.options.add(new Option("THUESDAY","4"));
		obj.options.add(new Option("FRIDAY","5"));
		obj.options.add(new Option("SATURDAY","6"));
		obj.options.add(new Option("SUNDAY","7"));

		var br = document.createElement("br");
		div.appendChild(br); 
		ii = ii + 1;

		
	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_" + ii; 

	    mySelect.setAttribute('class', 'sel2'); 
	    mySelect.setAttribute('name', mySelect.id);
	    mySelect.setAttribute('id', mySelect.id);

	    div.appendChild(mySelect); 
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("SEASON ALL","0")); 
		obj.options.add(new Option("SPRING","1"));
		obj.options.add(new Option("SUMMER","2"));
		obj.options.add(new Option("AUTUMN","3"));
		obj.options.add(new Option("WINTER","4"));


		var br = document.createElement("br");
		div.appendChild(br); 

		i = i + 1;

		flag = 0;


		var j = i - 1;

		var monthobj=document.getElementById("value1_" + j + "_" + 1); 
		monthobj.addEventListener('change',function(){
		return getMonth.apply(this,["value1_" + j + "_" + 1, "value1_" + j + "_" + 3]);
		});

		var seasonobj=document.getElementById("value1_" + j + "_" + 3); 
		seasonobj.addEventListener('change',function(){
		return getSeason.apply(this,["value1_" + j + "_" + 1, "value1_" + j + "_" + 3]);
		});
	}
	else {
		var divbg = document.getElementById("a");

		i = i - 1;
		var removeid = "div_value1_" + i;

		divbg.removeChild(document.getElementById(removeid));


	 	var myDiv = document.createElement("div");
		myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

	    myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var ii = 0;
	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_" + ii;  

		mySelect.setAttribute('class', 'sel2'); 
		mySelect.setAttribute('name', mySelect.id);
		mySelect.setAttribute('id', mySelect.id);

	    div.appendChild(mySelect); 
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("YEAR 2012","0")); 
		obj.options.add(new Option("2011","1"));
		obj.options.add(new Option("2010","2"));
		obj.options.add(new Option("2009","3"));
		obj.options.add(new Option("2008","4"));
		obj.options.add(new Option("2007","5"));
		obj.options.add(new Option("2006","6"));
		obj.options.add(new Option("2005","7"));
		obj.options.add(new Option("2004","8"));
		obj.options.add(new Option("2003","9"));
		obj.options.add(new Option("2002","10"));
		obj.options.add(new Option("2001","11"));
		obj.options.add(new Option("2000","12"));
		obj.options.add(new Option("1999","13"));
		obj.options.add(new Option("1998","14"));
		obj.options.add(new Option("1997","15"));

		var br = document.createElement("br");
		div.appendChild(br); 
		ii = ii + 1;


	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_" + ii; 
		mySelect.setAttribute('class', 'sel2'); 
		mySelect.setAttribute('name', mySelect.id);
		mySelect.setAttribute('id', mySelect.id);

	    div.appendChild(mySelect); 
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("MONTH ALL","0")); 
		obj.options.add(new Option("JANUARY","1"));
		obj.options.add(new Option("FEBRUARY","2"));
		obj.options.add(new Option("MARCH","3"));
		obj.options.add(new Option("APRIL","4"));
		obj.options.add(new Option("MAY","5"));
		obj.options.add(new Option("JUNE","6"));
		obj.options.add(new Option("JULY","7"));
		obj.options.add(new Option("AUGUST","8"));
		obj.options.add(new Option("SEPTEMBER","9"));
		obj.options.add(new Option("OCTOBER","10"));
		obj.options.add(new Option("NOVEMBER","11"));
		obj.options.add(new Option("DECEMBER","12"));

		var br = document.createElement("br");
		div.appendChild(br); 
		ii = ii + 1;

	
	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_" + ii;   

	    mySelect.setAttribute('class', 'sel2'); 
	    mySelect.setAttribute('name', mySelect.id);
	    mySelect.setAttribute('id', mySelect.id);
	    
	    div.appendChild(mySelect); 
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("WEAKDAY All","0")); 
		obj.options.add(new Option("MONDAY","1"));
		obj.options.add(new Option("THUESDAY","2"));
		obj.options.add(new Option("WEDNESDAY","3"));
		obj.options.add(new Option("THUESDAY","4"));
		obj.options.add(new Option("FRIDAY","5"));
		obj.options.add(new Option("SATURDAY","6"));
		obj.options.add(new Option("SUNDAY","7"));

		var br = document.createElement("br");
		div.appendChild(br); 
		ii = ii + 1;

		
	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_" + ii; 

	    mySelect.setAttribute('class', 'sel2'); 
	    mySelect.setAttribute('name', mySelect.id);
	    mySelect.setAttribute('id', mySelect.id);

	    div.appendChild(mySelect); 
		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("SEASON ALL","0")); 
		obj.options.add(new Option("SPRING","1"));
		obj.options.add(new Option("SUMMER","2"));
		obj.options.add(new Option("AUTUMN","3"));
		obj.options.add(new Option("WINTER","4"));


		var br = document.createElement("br");
		div.appendChild(br); 

		i = i + 1;


		var j = i - 1;

		var monthobj=document.getElementById("value1_" + j + "_" + 1); 
		monthobj.addEventListener('change',function(){
		return getMonth.apply(this,["value1_" + j + "_" + 1, "value1_" + j + "_" + 3]);
		});

		var seasonobj=document.getElementById("value1_" + j + "_" + 3); 
		seasonobj.addEventListener('change',function(){
		return getSeason.apply(this,["value1_" + j + "_" + 1, "value1_" + j + "_" + 3]);
		});

	}

 }
  if(sltSenior.selectedIndex == 2) {
  	if(flag == 1) {
	  	var myDiv = document.createElement("div");
	  	myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var myInput = document.createElement("input"); 
	    myInput.id = "value1_" + i;   

	    myInput.setAttribute('type', 'text');  
	    myInput.setAttribute('required', 'required');
	    myInput.setAttribute('name', myInput.id);
	    myInput.setAttribute('id', myInput.id);

	    div.appendChild(myInput);  
		var br = document.createElement("br");
		div.appendChild(br); 
		i = i + 1;

		flag = 0;
	}
	else {
		var divbg = document.getElementById("a");

		i = i - 1;
		var removeid = "div_value1_" + i;

		divbg.removeChild(document.getElementById(removeid));


	  	var myDiv = document.createElement("div");
	  	myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var myInput = document.createElement("input"); 
	    myInput.id = "value1_" + i;   

	    myInput.setAttribute('type', 'text');  
	    myInput.setAttribute('required', 'required');
	    myInput.setAttribute('name', myInput.id);
	    myInput.setAttribute('id', myInput.id);

	    div.appendChild(myInput);  
		var br = document.createElement("br");
		div.appendChild(br); 
		i = i + 1;
	}
 }
   if(sltSenior.selectedIndex == 3) {
   	if(flag == 1) {
	   	var myDiv = document.createElement("div");
	   	myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var myInput = document.createElement("input"); 
	    myInput.id = "value1_" + i;   

	    myInput.setAttribute('type', 'text');  
	    myInput.setAttribute('required', 'required');
	    myInput.setAttribute('name', myInput.id);
	    myInput.setAttribute('id', myInput.id);

	    div.appendChild(myInput);  
		var br = document.createElement("br");
		div.appendChild(br); 
		i = i + 1;

		flag = 0;
	}
	else {
		var divbg = document.getElementById("a");

		i = i - 1;
		var removeid = "div_value1_" + i;

		divbg.removeChild(document.getElementById(removeid));


		var myDiv = document.createElement("div");
	   	myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var myInput = document.createElement("input"); 
	    myInput.id = "value1_" + i;   

	    myInput.setAttribute('type', 'text');  
	    myInput.setAttribute('required', 'required');
	    myInput.setAttribute('name', myInput.id);
	    myInput.setAttribute('id', myInput.id);

	    div.appendChild(myInput);  
		var br = document.createElement("br");
		div.appendChild(br); 
		i = i + 1;
	}
 }
   if(sltSenior.selectedIndex == 4) {
   	if(flag == 1) {
   		var myDiv = document.createElement("div");
	 	myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i;   

	    mySelect.setAttribute('class', 'sel2'); 
	    mySelect.setAttribute('name', mySelect.id); 
	    mySelect.setAttribute('id', mySelect.id); 

	    div.appendChild(mySelect); 

		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("starring","starring")); 
		obj.options.add(new Option("supporting","supporting"));


		var br = document.createElement("br");
		div.appendChild(br); 

		var myInput = document.createElement("input"); 
	    myInput.id = "value1_" + i + "_1";

	    myInput.setAttribute('type', 'text');  
	    myInput.setAttribute('required', 'required');
	    myInput.setAttribute('name', myInput.id);
	    myInput.setAttribute('id', myInput.id);

	    div.appendChild(myInput);  
		var br = document.createElement("br");
		div.appendChild(br); 
		
		i = i + 1;

		flag = 0;
		}
 
 	else {
 		var divbg = document.getElementById("a");

		i = i - 1;
		var removeid = "div_value1_" + i;

		divbg.removeChild(document.getElementById(removeid));



   		var myDiv = document.createElement("div");
	 	myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value1_" + i; 
	    var div = document.getElementById(myDiv.id);

	    var mySelect = document.createElement("select");  
	    mySelect.id = "value1_" + i + "_0";   

	    mySelect.setAttribute('class', 'sel2'); 
	    mySelect.setAttribute('name', mySelect.id); 
	    mySelect.setAttribute('id', mySelect.id); 

	    div.appendChild(mySelect); 

		var obj=document.getElementById(mySelect.id); 
		obj.options.add(new Option("starring","starring")); 
		obj.options.add(new Option("supporting","supporting"));


		var br = document.createElement("br");
		div.appendChild(br); 


		var myInput = document.createElement("input"); 
	    myInput.id = "value1_" + i + "_1";

	    myInput.setAttribute('type', 'text');  
	    myInput.setAttribute('required', 'required');
	    myInput.setAttribute('name', myInput.id);
	    myInput.setAttribute('id', myInput.id);

	    div.appendChild(myInput);  
		var br = document.createElement("br");
		div.appendChild(br); 

		i = i + 1;

		flag = 0;
		}
	}
}

var j = 1;

    function compreGo() {
    var myDiv = document.createElement("div");
	myDiv.setAttribute('style', 'float:left'); 

	var divbg = document.getElementById("a");
    divbg.appendChild(myDiv); 

    myDiv.id = "div_attribute1_" + j; 
    var div = document.getElementById(myDiv.id);

	var mySelect = document.createElement("select");  
    mySelect.id = "attribute1_" + j;   

    mySelect.setAttribute('class', 'sel1'); 
    mySelect.setAttribute('name', mySelect.id); 
    mySelect.setAttribute('id', mySelect.id); 

	mySelect.addEventListener('change',function(){
	return getSenior.apply(this,[mySelect.id]);
	});

    // mySelect.addEventListener('change', getSenior);
    div.appendChild(mySelect); 
	var obj=document.getElementById(mySelect.id); 
	obj.options.add(new Option("SELECT ELEMENT","0")); 
	obj.options.add(new Option("TIME","1"));
	obj.options.add(new Option("TITLE","2"));
	obj.options.add(new Option("DIRECTOR","3"));
	obj.options.add(new Option("ACTOR","4"));
	obj.options.add(new Option("CATEGORY","5"));

	var br = document.createElement("br");
	div.appendChild(br); 
	j = j + 1;

	flag = 1;
    }


    var j2 = 0;

    function compreGo2() {
    var myDiv = document.createElement("div");
	myDiv.setAttribute('style', 'float:left'); 

	var divbg = document.getElementById("a");
    divbg.appendChild(myDiv); 

    myDiv.id = "div_attribute2_" + j2; 
    var div = document.getElementById(myDiv.id);

	var mySelect = document.createElement("select");  
    mySelect.id = "attribute2_" + j2;   

    mySelect.setAttribute('class', 'sel1'); 
    mySelect.setAttribute('name', mySelect.id); 
    mySelect.setAttribute('id', mySelect.id); 



    // mySelect.addEventListener('change', getSenior);
    div.appendChild(mySelect); 
	var obj=document.getElementById(mySelect.id); 
	obj.options.add(new Option("SELECT ELEMENT","0")); 
	obj.options.add(new Option("Format","Format"));
	obj.options.add(new Option("Edition","Edition"));
	obj.options.add(new Option("Price","Price"));
	obj.options.add(new Option("Rated","Rated"));

	var br = document.createElement("br");
	div.appendChild(br); 




		var myDiv = document.createElement("div");
	   	myDiv.setAttribute('style', 'float:left'); 

		var divbg = document.getElementById("a");
	    divbg.appendChild(myDiv); 

		myDiv.id = "div_value2_" + j2;  
	    var div = document.getElementById(myDiv.id);

	    var myInput = document.createElement("input"); 
	    myInput.id = "value2_" + j2;   

	    myInput.setAttribute('type', 'text');  
	    myInput.setAttribute('required', 'required');
	    myInput.setAttribute('name', myInput.id);
	    myInput.setAttribute('id', myInput.id);

	    div.appendChild(myInput);
		var br = document.createElement("br");
		div.appendChild(br); 


	j2 = j2 + 1;

    }


    function getMonth(vm, vs) {
    // var y = document.getElementById('year').selectedIndex;
    var m = document.getElementById(vm).selectedIndex;
    var vmonth=document.getElementById(vm);
    var s = document.getElementById(vs).selectedIndex;
    // var w = document.getElementById('weakday').selectedIndex;
    // var s = document.getElementById('season').selectedIndex;
    
    if(m != 0) {
    	if(vmonth.length == 13) {
	        document.getElementById(vs).disabled = 'disabled';
	        if(m == 5 || m==4 || m==3) {
	        	document.getElementById(vs).selectedIndex=1;
	        }
	        if(m == 8 || m==7 || m==6) {
	        	document.getElementById(vs).selectedIndex=2;
	        }
	        if(m == 11 || m==10 || m==9) {
	        	document.getElementById(vs).selectedIndex=3;
	        }
	        if(m == 2 || m==1 || m==12) {
	        	document.getElementById(vs).selectedIndex=4;
	        }
	    }
    };
	}

	function getSeason(vm, vs) {
	var m = document.getElementById(vm).selectedIndex;
    var s = document.getElementById(vs).selectedIndex;

	var SeasonMonth=[
	 ["MARCH","APRIL","MAY"],
	 ["JUNE","JULY","AUGUST"],
	 ["SEPTEMBER","OCTOBER","NOVEMBER"],
	 ["DECEMBER","JANUARY","FEBRUARY"]
	 ];
    var vmonth=document.getElementById(vm);
	var smonth=SeasonMonth[s-1];
	vmonth.length=1;
	for(var k = 0; k < 3; k++){
		vmonth[k]=new Option(smonth[k],smonth[k]);
	}
	}
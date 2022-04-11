function PreviewImage() {
    var preview = new FileReader();
    preview.onload = function (e) {
    document.getElementById("user_image").src = e.target.result;
};
preview.readAsDataURL(document.getElementById("user_profile_img").files[0]);
document.getElementById("text1").value='';
document.getElementById("text2").value='';
};

/*function categoryChange(e) {
    var submenu_food = [" ", "b", "c", "d"];
    var submenu_sport = [" ", "f", "g", "h"];
    var submenu_style = [" ", "j", "k", "l", "m"];
    var target = document.getElementById("submenu");
 
    if(e.value == "음식") var d = submenu_food;
    else if(e.value == "운동") var d = submenu_sport;
    else if(e.value == "스타일") var d = submenu_style;
 
    target.options.length = 0;
 
    for (x in d) {
        var opt = document.createElement("option");
        opt.value = d[x];
        opt.innerHTML = d[x];
        target.appendChild(opt);
    }
}
*/

var nextday = new Date();
	var now = new Date()
	var now2 = new Date();
	var next2 = new Date(now2.setDate(now2.getDate()+30));
	var next3 = new Date(now.setDate(now.getDate() + 3));	// 3일뒤
	var dd= nextday.getDate();
	var mm = nextday.getMonth()+1; 
	/* var mm2 = nextday.getMonth()+2; */
	var mm2 = next2.getMonth()+1;
	var yyyy2 = next2.getFullYear();
	var yyyy = nextday.getFullYear();
	/* var yyyy2 = nextday.getFullYear(); */
	var dd3 =next3.getDate();
	var mm3 =next3.getMonth()+1;
	var yyyy3=next3.getFullYear();
 		if(dd<10){
        dd="0"+dd
    } 
    	if(mm<10){
        	mm="0"+mm
    } 
/*     	if(mm2>12){
    		yyyy2=nextday.getFullYear()+1;
    		mm2=nextday.getMonth()+2-12;
    } */
    	if(mm2<10){
    		mm2="0"+mm2
    }
    	if(dd3<10){
    		dd3="0"+dd3
    }
    	if(mm3<10){
    		mm3="0"+mm3
    }
    nextday = yyyy + "-" + mm + "-" + dd;
	nextday1 = yyyy2 + "-" + mm2+"-" + dd
	nextday2 = yyyy3 + "-" + mm3 + "-" + dd3
	/*document.getElementById("nextdate").setAttribute("min", nextday);
	document.getElementById("nextdate").setAttribute("max", nextday1);
	document.getElementById("nextdate").setAttribute("value", nextday2);*/
		
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var mm2 = today.getMonth()+2;
	var yyyy = today.getFullYear();
	var yyyy2 = today.getFullYear();
	 if(dd<10){
	        dd="0"+dd
	    } 
	    if(mm<10){
	        mm="0"+mm
	    } 
	    if(mm2>12){
	    	yyyy2=today.getFullYear()+1;
	    	mm2=today.getMonth()+2-12;
	    }
	    if(mm2<10){
	    	mm2="0"+mm2
	    }
	    
	today = yyyy+"-"+mm+'-'+dd;
	today1 = yyyy2+ "-"+mm2+"-"+dd
	document.getElementById("datefield").setAttribute("min", today);
	document.getElementById("datefield").setAttribute("max", today);
	document.getElementById("datefield").setAttribute("value", today);
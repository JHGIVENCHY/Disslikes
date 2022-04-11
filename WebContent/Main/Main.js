
var idlist=new Array();
var namelist=new Array();
var imgnamelist=new Array();
var imglist=new Array();
var lastimg=new Array();
var lasttitle=new Array();
var lastlike=new Array();
var lastdislike=new Array();
var lastvalue=new Array();

var imgNum=1;
var start=true;

function showImage(){ 
if (imgNum > lastimg.length) {
	imgNum=1;
} ;
	
if (start==true){
document.getElementById("proId1").src=imglist[0];
document.getElementById("proId1").style.background = "url('" + imglist[0] + "')";
document.getElementById("proId1").style.backgroundSize = "500px 500px";
document.getElementById("proId2").src=imglist[0];
document.getElementById("proId2").style.background = "url('" + imglist[0] + "')";
document.getElementById("proId2").style.backgroundSize = "500px 500px";
document.getElementById("proName").innerText = namelist[0];
start=false;
}
var objImg=document.getElementById("intro");
var dots=document.getElementsByClassName("dot");
objImg.src=lastimg[imgNum-1];

document.getElementById("lastTitle").innerText = lasttitle[imgNum-1];
document.getElementById("lastValue").innerText = lastvalue[imgNum-1];

for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
}
dots[imgNum-1].className += " active";

setTimeout(showImage,2000);
imgNum++;
} 

var Num=0;
function leftMove(){
Num--;
if (Num == -1) {
	Num=imglist.length-1;
}
document.getElementById("proId1").src = imglist[Num];
document.getElementById("proId2").src = imglist[Num];
document.getElementById("proId1").style.background = "url('" + imglist[Num] + "')";
document.getElementById("proId2").style.background = "url('" + imglist[Num] + "')";
document.getElementById("proId1").style.backgroundSize = "500px 500px";
document.getElementById("proId2").style.backgroundSize = "500px 500px";
document.getElementById("proName").innerText = namelist[Num];
}
function rightMove(){
Num++;
if (Num == imglist.length) {
	Num=0;
}
document.getElementById("proId1").src = imglist[Num];
document.getElementById("proId2").src = imglist[Num];
document.getElementById("proId1").style.background = "url('" + imglist[Num] + "')";
document.getElementById("proId2").style.background = "url('" + imglist[Num] + "')";
document.getElementById("proId1").style.backgroundSize = "500px 500px";
document.getElementById("proId2").style.backgroundSize = "500px 500px";
document.getElementById("proName").innerText = namelist[Num];

}
function back(out) {
out.src=imglist[Num];
}

function good(on) {
on.src="Main/Picture/good.png"
}

function bad(on) {
on.src="Main/Picture/bad.png"
}


	
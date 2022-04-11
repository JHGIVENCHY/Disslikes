var scripts = document.getElementsByTagName('script');
var lastScript = scripts[scripts.length-1];
var scriptName = lastScript;

var ag_num= scriptName.getAttribute('data-agnum');
var dag_num= scriptName.getAttribute('data-dagnum');
var agwon = scriptName.getAttribute('data-agwon');


if(agwon=="불호"){
	$('.chart_won').css('color', '#ffe845');
} else {
$('.chart_won').css('color', '#455cff');
}

var ctx = document.getElementById("myChart");
var myChart = new Chart(ctx, {
  type: 'doughnut',
  data: { 
	  labels: ['LIKE', 'DISLIKE'],
	  datasets: [{
      data: [ag_num,dag_num],
      backgroundColor: [
        'rgb(255,232,69)',
        'rgb(69,92,255)',
      ],
      borderColor: [
        'rgb(255,255,255)'
      ],
      borderWidth: 10
    }]
  },
  options: {
   	//cutoutPercentage: 40,
    responsive: false,
    plugins: {
	    legend: {
	    	onClick:null,
	    	position:'top',
	    	labels: {
	    		font:{
	    			family:"'Noto Sans KR', sans-serif",
	    			size: 25
	    		},
	    		color:'rgb(33,33,33)'
	    	}
	    	
	    }
    }

  }
});
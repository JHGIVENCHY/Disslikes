<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<canvas id="myChart" width="400" height="400"></canvas>
<script>
var xValues = ["LIKE", "DISLIKE"];
var yValues = [${ iVo1.vt_ag_num }, ${ iVo1.vt_dag_num }];
new Chart("myChart", {
  type: "doughnut",
  data: {
    labels: xValues,
    datasets: [{
    	 data: yValues,
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
	
</script>
</body>
</html>

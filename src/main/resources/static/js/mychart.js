var chartData = JSON.parse(decodeHtml(chartData));

var arrLength = chartData.length;
var numericData = [];
var labelData = [];

for (var i= 0; i<arrLength; i++) {
	numericData[i] = chartData[i].value;
	labelData[i] = chartData[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'Project Status',
            backgroundColor: ["#e39f0e", "#32a852", "#324aa8"],
            data: numericData
        }]
    },
    options: {
    	title: {
    		display: true,
    		text: "Project Status"
    	}
    }
});

function decodeHtml(html) {
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}
$(document).ready(function() {
	loadDropdowns();
	$('#enableChaos').click(
		function() {
			var date = new Date();
			var url = "/enable?tmp="+date.toString();
			$.ajax({
				type : "POST",
				url :  url,
				contentType : 'application/json',
				data : JSON.stringify({
					service : document.getElementById("service").value,
					node : document.getElementById("node").value
				}),
				success:function(data) {
					alert(data);
				}
			}).fail(function(data) {
				console.log(data);
				alert(data.responseText);
			});
		});
	$('#disableChaos').click(
			function() {
				var date = new Date();
				var url = "/disable?tmp="+date.toString();
				$.ajax({
					type : "POST",
					url :  url,
					contentType : 'application/json',
					data : JSON.stringify({
						service : document.getElementById("service").value,
						node : document.getElementById("node").value
					}),
					success:function(data) {
						alert(data);
					}
				}).fail(function(data) {
					console.log(data);
					alert(data.responseText);
				});
			});
	$('#createChaos').click(
			function() {
				var date = new Date();
				var url = "/assaults?tmp="+date.toString();
				$.ajax({
					type : "POST",
					url :  url,
					contentType : 'application/json',
					data : JSON.stringify({
						service : document.getElementById("service").value,
						node : document.getElementById("node").value,
						assaultProperties : {
							level: 1,
							latencyRangeStart: document.getElementById("latencyRangeStart").value,
							latencyRangeEnd: document.getElementById("latencyRangeEnd").value,
							latencyActive: document.getElementById("activateLatency").checked,
							exceptionsActive: document.getElementById("activateException").checked,
							killApplicationActive: document.getElementById("activateKillApp").checked
						}
					}),
					success:function(data) {
						alert(data);
					}
				}).fail(function(data) {
					console.log(data);
					alert(data.responseText);
				});
			});
});


function loadDropdowns() {
	var date = new Date();
//	$("#node").html("<option id=''>Select</option>");
//    $("#service").html('<option id="">Select</option>');
    $.get("/nodes?tmp="+date.toString()).done(function(nodes) {
		console.log(nodes);
		for (var i = 0; i < nodes.length; i++) {
			 $("#node").append('<option id="'+ nodes[i] +'">'+nodes[i]+'</option>');
		}
	});
    $.get("/services?tmp="+date.toString()).done(function(nodes) {
		console.log(nodes);
		for (var i = 0; i < nodes.length; i++) {
			 $("#service").append('<option id="'+ nodes[i] +'">'+nodes[i]+'</option>');
		}
	});
}

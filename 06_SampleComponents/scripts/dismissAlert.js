$(document).ready(function() {
	"use strict"

	$(document).on("click",
		"[data-dismiss-sample='alert']", function(event) {
		event.stopPropagation();
		console.log("dismiss alert", arguments);
	});

	$(document).on("click", function() {
		console.log("all", arguments)
	});
});

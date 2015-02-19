$(document).ready(function() {
	"use strict"

	$(document).on("click",
		"[data-dismiss-sample='alert']", function(event) {
		$(event.target.closest(".alert")).remove();
	});
});

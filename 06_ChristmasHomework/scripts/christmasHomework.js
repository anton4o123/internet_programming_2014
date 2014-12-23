$(document).ready(function() {
	console.log($(".tu").attr("title"));
	console.log($("#col1 p").text());

	$("#menu-top-level-menu").append($("<li/>").append($("<a/>").text("new button")));
	$("div#footer").prepend($("<div/>").attr("id", "dynamiccontent"));
});

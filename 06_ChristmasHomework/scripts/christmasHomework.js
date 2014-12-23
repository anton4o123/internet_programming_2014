$(document).ready(function() {
	console.log($(".tu").attr("title"));
	console.log($("#col1 p").text());

	$("#menu-top-level-menu").append($("<li/>").append($("<a/>").text("new button")));
	$("div#footer").prepend($("<div/>").attr("id", "dynamiccontent"));
	$("div#dynamiccontent").append($("<input/>").attr("id", "textinput"));
	$("div#dynamiccontent").append($("<button/>").attr("id", "addbutton"));
	$("div#dynamiccontent").append($("<ul/>").attr("id", "posts"));
});

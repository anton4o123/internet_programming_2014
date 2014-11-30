$(document).ready(function() {
	"use strict"

	console.log($("body"));
	console.log($(".home"));
	console.log($("#header"));
	console.log($("#header .menu-top-level-menu-container"));
	console.log($("li.menu-item-2912"));
	console.log($("li#menu-item-2914"));
	console.log($("menu-top-level-menu-container #menu-item-2933"))

	var col1 = $("#col1");
	var col2 = $("#col2");
	var col3 = $("#col3");
	var col4 = $("#col4");

	col2.insertBefore(col1);
	col4.insertBefore(col3);
});
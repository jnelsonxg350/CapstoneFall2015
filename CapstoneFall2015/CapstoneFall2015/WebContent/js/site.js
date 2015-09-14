$(document).ready(function(){
	//go to the update form
	$('.btnUpdatePerson').click(function(){
		var id = $(this).data('id');
		window.location = "/CapstoneFall2015/PersonForm?id=" + id;
	});
	//delete the person
	$('.btnDeletePerson').click(function(){
		var id = $(this).data('id');
		$.post( "/CapstoneFall2015/Person/Delete?id=" + id, function(data){
			window.location = "/CapstoneFall2015/PersonList";
		});		
	});
	//Capture submit of form to press the add button
	$( "#personForm" ).submit(function(event) 
	{
		event.preventDefault();
	  	$.post( "/CapstoneFall2015/Person/Add", $( "#personForm" ).serialize())
	  	.done(function(data)
		{
	  		window.location = "/CapstoneFall2015/PersonList";
		});
	});
	
});
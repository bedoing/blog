$().ready(function(){
	addSalarySubmit();
});

var addSalarySubmit = function(){
	$("#_addSalaryBtn").click(function(){
		$.ajax({
			url: PRE_URI + "salary/addSalary",
			data: $("#_salaryAdd").serialize(),
			success: function(res){
				
			}
		});
	});
}
// Function to convert 24 hour times to am/pm
function formatAMPM(date) {
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var ampm = hours >= 12 ? 'pm' : 'am';
	hours = hours % 12;
	hours = hours ? hours : 12; // the hour '0' should be '12'
	minutes = minutes < 10 ? '0'+minutes : minutes;
	var strTime = hours + ':' + minutes + ' ' + ampm;
	
	return strTime;
}

// For non-online classes, convert the 24 hour time period
// stored in the database to am/pm times
function parseTime(begin, end) {
	if(begin != null) {
		var b = new Date("December 12, 1981 " + begin);
		var e = new Date("December 12, 1981 " + end);
		
		return formatAMPM(b) + " - " + formatAMPM(e);
	} else {
		return "N/A";
	}
}

// For non-online classes, convert the booleans representing
// meeting days into a string. For online classes, convert the
// boolean representing online into text
function printDays(mon, tues, wed, thurs, fri, sat, onl) {
	var day_string = "";
	
	if(mon  == true) {day_string += "M";}
	if(tues == true) {day_string += "T";}
	if(wed  == true) {day_string += "W";}
	if(thurs== true) {day_string += "R";}
	if(fri  == true) {day_string += "F";}
	if(sat  == true) {day_string += "S";}
	if(onl  == true) {day_string += "Online";}

	return day_string;
}

function formatClassroom(classroom_info) {
	if(classroom_info != undefined) {
		return classroom_info.building_id.name + " " + classroom_info.num;
	} else {
		return "N/A";
	}
}

function formatInstructor(instructor_info) {
	var instructor_name = "";

	if(instructor_info != null) {
		instructor_name = instructor_info.first_name + " " + instructor_info.last_name;
	} else {
		instructor_name = "TBD";
	}

	return instructor_name;
}

function formatSeats(classroom, num_enrolled) {
	var num_seats_string = "";

	if(classroom != undefined) {
		max_seats = classroom.num_seats;
	} else {
		max_seats = 60;
	}

	var seats_left = max_seats - num_enrolled;

	if(seats_left > 0) {
		num_seats_string = seats_left + " of " + max_seats;					
	} else {
		num_seats_string = "No seats remaining";
	}			
			
	return num_seats_string;
}

function formatClassName(class_name_info) {
	var class_name = "";

	if(class_name_info != undefined) {
		class_name = class_name_info.department_id.code + " " + class_name_info.num;
	}

	return class_name;
}
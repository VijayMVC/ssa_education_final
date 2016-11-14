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
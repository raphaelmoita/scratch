var greeting = 'hey, helloooooo world';

// Java class being instantiated 
var javaClass = Java.type('com.scratch.app.NashornSample');

// 'name' and 'surname' are being bind in Java side
var fullName = name  + " " + surname

// loading external library
load('file:///C://Users//lucasmor//temp//underscore-min.js');
// load('http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore-min.js');

// 'numbers' is being bind in Java side
var odds = _.filter(numbers, function (num) {
    print("num: " + num)
    return num % 2 == 1;
});
print("Odds from " + numbers + " are: " + odds); 

// class scratch_3 that contains a public member called ID
print("Java Object: " + javaObj.ID);

function getMsg() {
	print('calling getMsg ...');
	// calling Java class
	return javaClass.process("Hello " + fullName);
}
// return statement with
getMsg();

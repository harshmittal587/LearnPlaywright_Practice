const browsers = ["chrome", "firefox", "webkit"];
console.log(browsers[0]);          // chrome
console.log(browsers.at(-1));      // webkit  (negative index)
console.log(browsers.length);      // 3


let fruits = [];
console.log(typeof fruits);    // Object

//let browsers = ["chrome", "firefox", "webkit"];
console.log(browsers.length);

// console.log(browsers.at(0));
console.log(browsers[0]);
// console.log(browsers[-1]);

console.log(browsers.at(-1));



let arr = [10,20,30,40];
console.log(arr.length);

console.log(arr[4]);
console.log(arr.at(4));



let testResults = ["pass", "fail", "pass", "skip"];
let mixed = [1, "hello", true, null];


//let browsers = ["Chrome", "Firefox", "Safari"];

let scores = new Array(3);  // creates [empty x 3]
scores[0] = "1"; 

let scores2 = new Array(1, 2, 3);

let numbers = new Array(100, 200, 300, 400);


let test = Array.of(10, 20, 30, 40, 50);
console.log(test.length);

// Array.from()
let chars = Array.from("hello");
// ["h", "e", "l", "l", "o"]
/*  var数据类型的弊端
    - 下述的弊端，在ES6中均被let关键字解决了 
*/

// 1、存在预解析，易造车逻辑混乱
console.log(demo);  // undefined
var demo = 10;

// 2、var可以重复定义一个变量
var demo02 = 10;
var demo02 = 20;
console.log(demo02);    // 20

// 3、造成for循环污染；
// 块中使用var声明的变量，在块外仍能使用，可见var没有块级作用域
for (var i = 0; i < 5; i++)
    console.log("for循环");
console.log(i);     // 5



/* const 的使用
    - const 定义的常量，变量名通常使用大写形式 */
const OBJ = {
    username: "Dino",
    age: 22,
    show: function () {
        console.log("Hello World!");
    }
}
OBJ.username = "Peppa-pig";     // 由于未修改变量所指向的对象，因而无错误
// OBJ = {};   // 此处错误，违反常量无法被修改的原则



/* 解构 */
console.log("\n-----解构-----")
// 1、对象结构
let obj = {
    uname: "Dino",
    age: 22
}
let { uname, age } = obj;
console.log("对象解构:", uname, age)

// 2、数组解构
console.log("数组解构:")
let arr = [1, 2, 3];
let [num1] = arr;
console.log(num1);
let [, , num3] = arr;
console.log(num3);
// 复合解构
let arr2 = [...arr, ['Dino', 'Peppa']];
let [a, b, c, [x, y]] = arr2;
console.log("多维数组的复合解构:", a, b, c, x, y);

// 3、字符串解构
let str = "Hello World!";
let [s1, s2] = str;
console.log("字符串解构:", s1, s2);



/* 
模板字符串的使用
*/
console.log("\n----模板字符串-----")
var userInfo = {
    username: "Dino",
    age: 22
}
console.log(`Hello, Everybody! My name is ${userInfo.username}. I am ${userInfo.age} years old.`);

/* 
函数参数的解构赋值
*/
console.log("\n-----函数参数的解构赋值-----")
obj = {
    uname: "Dino",
    uage: 22
}

function showInfo({ uname, uage } = {}) {       // 为参数设置默认值，防止不传实参时报错
    console.log(uname, uage);
}
// showInfo();     // 在未给参数设置默认值的情况下，该写法错误，应该改为 showInfo({})，即传入一个空对象
showInfo(obj);



/* 
rest 剩余参数
*/
console.log("\n-----arguments、rest的使用-----");
function showData1() {
    console.log("arguments:")
    for (let i = 0; i < arguments.length; i++) {
        console.log(arguments[i]);
    }
}
showData1(1, 2, 3, 4);

function showData2(...rest) {
    console.log("剩余参数rest:")
    for (let i = 0; i < rest.length; i++) {
        console.log(rest[i]);
    }
}
showData2(1, 2, 3, 4);



/* 
扩展运算符
*/
console.log("\n-----扩展运算符-----")
arr = [1, 2, 3, 4]
arr2 = [1, 2]

function showData3(a, b, c) {
    console.log("在参数中的使用:")
    console.log(a, b, c);
}
showData3(...arr);
showData3(...arr2);

console.log("合并数组:", [...arr, ...arr2]);
console.log("合并对象:", { ...{ uname: "Dino" }, ...{ age: 22 } });
console.log("合并对象(assign方法):", Object.assign({ uname: "Dino" }, { age: 22 }));    // 将后续的对象合并到第一个对象中



/* 
箭头函数的使用
*/
console.log("\n-----箭头函数-----")
// 针对只有一个形参且方法体中只有一条代码的箭头函数[简写]写法
var arrowFunction = para => console.log(para);
// 当返回值为对象时，需使用小括号包裹对象；避免对象的中括号{}与方法体的中括号{}混淆
arrowFunction = para => ({ uname: para });
console.log(arrowFunction("Dino").uname);


/* 
箭头函数 this 的指向
*/
console.log("--箭头函数 this 的指向:--")
function Person(uname, age) {
    this.uname = uname;
    this.age = age;
    this.say = function () {
        // console.log(this);   // 此指向对象本身
        console.log("3秒后表诉自己的姓名:");
        // 1、错误写法
        /* setTimeout(function () {
            console.log(this);  // 指向Timeout
        }, 3000); */

        // 2、正确写法
        setTimeout(() => {
            console.log(this.uname)
        }, 3000);
    }
}

new Person("Dino", 22).say();



/* 
Symbol 基本使用
*/
console.log("\n-----Symbol的基本使用-----");
/* 
在新的Symbol类型中，既可以使用Symbol和Symbol.for声明对象
但二者有区别，前者声明的对象使用 === 返回false，后者返回true
*/
let s = Symbol();
let s01 = Symbol("Dino");
let s02 = Symbol("Dino");
console.log("Symbol(\"Dino\") === Symbol(\"Dino\"):", s01 === s02);
let s03 = Symbol.for("Pedro");
let s04 = Symbol.for("Pedro");
console.log("Symbol.for(\"Pedro\") === Symbol.for(\"Pedro\"):", s03 === s04);
console.log("遍历存在Symbol类型成员变量的对象:")
userInfo = {
    uname: "Dino",
    [age]: 22,
    [Symbol('showName')]: function () {
        console.log("My name is " + uname);
    }
}
var sym = Object.getOwnPropertySymbols(userInfo);
console.log("User's information:", userInfo)
console.log("User's", userInfo[sym[0]] = 23);
userInfo[sym[1]]();


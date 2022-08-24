/* 
path 模块的使用
*/
console.log("-----path 模块的使用-----")
const path = require("path");

console.log("__dirname:" + __dirname);     // F:\codeWarehouse\CS&S-Exercise\WebCode\node

console.log("__filename:" + __filename);    // f:\codeWarehouse\CS&S-Exercise\WebCode\node\index.js 包含文件名

console.log("扩展名:" + path.extname(__filename));  // .js

console.log("文件名(包含扩展名):" + path.basename(__filename));     // index.js

console.log("路径字符串对象:");
console.log(path.parse(__filename))

/* 
Buffer 数据对象
*/
console.log("\n----Buffer 数据对象-----")
let buf1 = Buffer.from([65, 66, 67]);
console.log(buf1);
console.log(buf1.toString());

let buf2 = Buffer.alloc(10);
buf2.write("node.js");
console.log(buf2);
console.log(buf2.toString());

/* 
fs 文件系统模块
*/
console.log("\n-----fs 文件系统模块-----")
const fs = require("fs");

console.log("\n\n--同步读取文件信息--");
// fs.readFileSync(文件路径, 编码格式, 回调函数)
var data = fs.readFileSync(path.join(__dirname, "test1.txt"));
console.log(data.toString());

// console.log("--异步读取文件信息--");
var data2 = fs.readFile(path.join(__dirname, "test1.txt"), "UTF-8", (err, data) => {
    if (err) {
        console.log(err);
        return;
    }

    console.log("\n\n由于异步读取，导致读取内容最后打印:\n" + data.toString())
});

// 同步写入数据
fs.writeFileSync(path.join(__dirname, "test2.txt"), "Hello, Node!", "utf-8");
// 异步写入类似，方法为 writeFile();

/* console.log("\n--小案例 为txt文件添加前缀--");
let nameList = fs.readdirSync(__dirname);
nameList.forEach(currFileName => {

    // 为文件名添加前缀
    if (currFileName.endsWith(".txt")) {
        console.log(__dirname);
        fs.renameSync(currFileName, `[day03]${currFileName}`, "utf-8");
    }
});
// 打印修改后的文件名
nameList = fs.readdirSync(__dirname);
console.log(nameList.filter((item) => {
    return item.startsWith("[day03]");
}));

// 去除文件名的前缀
let prefix = "[day03]";
nameList.forEach(currFileName => {
    if (currFileName.startsWith(prefix)) {
        fs.renameSync(path.join(__dirname, currFileName), currFileName.substring(prefix.length));
    }
}); */


/* 
遍历数组 forEach
*/
console.log("\n-----forEach 遍历数组-----");
var arr = ["Dino", "Pedro", "Peppa"];
arr.forEach((val, index, arr) => {
    console.log(val + " - " + index + " - " + arr);
});


/* 
筛选数组 filter
*/
console.log("\n-----filter 筛选数组-----");
var arr = [1, 2, 3, 4, 5, 6];
var newArr = arr.filter(item => {
    return item % 2 === 0;
});
console.log(newArr);

/* 
获取数组中满足条件的元素的值、索引值 find、findIndex
    - some() 方法返回的是Boolean
*/
console.log("\n-----find 与 findIndex-----");
var arr = ["Dino", "Pedro", "Peppa"];
var val = arr.find(item => item === "Dino");
console.log(val);
var index = arr.findIndex((val, index) => index == arr.length - 1);
console.log(index)

/* 
查询数组是否有满足条件的元素 some
如果查找到第一个满足条 件的元素就终止循环
*/
console.log("\n-----some 查询数组是否有满足条件的元素-----");
var arr = ["Pedro", "Peppa", "George"];
var result = arr.some(item => {
    return item.indexOf("P") !== -1;
});
console.log(result);

/* 
对每个元素都调用提供的函数 map
*/
console.log("\n-----map 根据提供的方法操作每个元素-----")
var arr = ["Dino", "Peppa", "Pedro"];
var newArr = arr.map(item => `[test]${item}`);
console.log(newArr)

/* 
启动服务器
*/
console.log("\n-----创建一个服务器-----")
const http = require("http");
const url = require("url");
const querystring = require("querystring");

const server = http.createServer((req, res) => {
    /* // 设置头部，避免中文乱码
    res.setHeader("Content-type", "text/html;charset=utf-8");
    //  获取请求的资源路径
    console.log("请求路径:", req.url);
    // 获取请求的方式（get、post）
    console.log("请求方法:", req.method);
    // 解析get请求的内容
    console.log("GET请求获取到的数据:")
    let obj = url.parse(req.url, true);   // true 返回对象，false 返回字符串
    console.log(obj.query);
    // 获取post请求提交的数据
    console.log("POST请求获取到的数据:")
    req.on('data', (data) => {
        console.log(data.toString());   // 返回内容，如name=Dino
        console.log(querystring.parse(data.toString()));    // [Object: null prototype] { name: 'Pedro', age: '23' }
    });

    res.write("Hello World! 你好世界！");
    res.end(); */

    // res.setHeader("Content-type", "text/html;charset=utf-8");    // 添加此行，会导致外连式css失效
    let content;
    if (req.url == "/" || req.url == "/index.html") {
        content = fs.readFileSync(path.join(__dirname, "assets", "html", "index.html"));
    } else if (req.url == "/login.html") {
        content = fs.readFileSync(path.join(__dirname, "assets", "html", "login.html"));
    } else if (req.url.indexOf(".css") != -1) {
        content = fs.readFileSync(path.join(__dirname, "assets", "css", "index.css"));
    } else if (req.url.indexOf(".js") != -1) {
        content = fs.readFileSync(path.join(__dirname, "assets", "js", "index.js"))
    } else {
        content = "404 Not Found!"
    }
    res.end(content);
});

server.listen(8080, () => {
    console.log("服务器已启动: http://127.0.0.1:8080");
});


/* 
总结：
    - filter 根据提供的方法过滤数组元素，最后返回一个新数组，不改变原数组数据
    - some 根据提供的方法，查看数组是否有满足条件的元素，有则返回true，无则返回false
    - map 根据提供的方法，操作数组中的每个元素，最后返回一个新数组，不改变原数组数据
    - find 根据提供的方法，查询满足条件的第一个元素的值
    - findIndex 根据提供的方法，查询满足条件的第一个元素的索引值
*/
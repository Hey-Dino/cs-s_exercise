// 1. nodejs 里面没有 window全局对象，但是存在一个 gloabal 全局对象。之前使用 console. setTimeout 这些全局的函数都是 global 上面的属性

// console.log(window);    // window is not defined
console.log("全局对象global:\n", global)

// 2. node.js 里面声明的变量，不会被挂载到global全局对象
let test = 20;
console.log("\n", global.test);   // undefined

// 3. 被挂载到global上的变量，任何地方都可以使用
global.test1 = "Node";
console.log("\n", test1 === global.test1);

// 4. 实际上，在 nodejs 里面的this代表的当前这个 js模块（暂且认为 this 代表当前这个js文件）
console.log("\n", this === global)
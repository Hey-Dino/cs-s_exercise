let arr = [1, 2, 3, 4, 2, 3];

// 1、数组去重
var result = [...new Set(arr)];
console.log("数组去重:", result);

// 2、交集
let arr2 = [3, 4, 5, 6];
var result = [...new Set(arr)].filter(item => (new Set(arr2).has(item)));
console.log("交集:", result);

// 3、并集
var result = [...new Set([...arr, ...arr2])];
console.log("并集:", result);

// 4、差集
var result = [...new Set(arr)].filter(item => !(new Set(arr2).has(item)))
console.log("差集:", result)
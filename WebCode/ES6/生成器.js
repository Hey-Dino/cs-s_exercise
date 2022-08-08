console.log("==========")

function* city() {
    yield '北京';
    yield '上海';
    yield '广州';
    yield '深圳';
}
let iterator1 = city();
console.log(iterator1.next());
console.log(iterator1.next());
console.log(iterator1.next());
console.log(iterator1.next());
console.log(iterator1.next());

console.log("-----回调地狱-----")
setTimeout(() => {
    console.log(111);
    setTimeout(() => {
        console.log(222);
        setTimeout(() => {
            console.log(333);
        }, 1000);
    }, 1000);
}, 1000);
// 解决回调地狱
function one() {
    setTimeout(() => {
        console.log(111);
        iterator3.next();
    }, 1000)
}
function two() {
    setTimeout(() => {
        console.log(222);
        iterator3.next();
    }, 1000)
}
function three() {
    setTimeout(() => {
        console.log(333);
        iterator3.next();
    }, 1000)
}
function* gen() {
    yield one();
    yield two();
    yield three();
}
// 调用生成器函数
let iterator3 = gen();
iterator3.next();
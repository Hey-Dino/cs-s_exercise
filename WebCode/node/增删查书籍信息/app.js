const express = require("express");
// 创建 express 服务器实例
const app = express();

// 配置解析表单数据的中间件
app.use(express.urlencoded({ extended: false }));

const cors = require("cors");
app.use(cors());

// app.use(express.static("assets"));

const router = require("./router/book.js");
app.use("/api", router);

app.listen(80, () => {
    console.log("Http Server is running: http://127.0.0.1:80");
});

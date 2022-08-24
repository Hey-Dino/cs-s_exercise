const router = require("express").Router();

// 导入书籍路由处理函数模块
const bookHandler = require("../router_handler/book");

router.get("/getbooks", bookHandler.getBooks);
router.post("/addbook", bookHandler.addBooks);
router.get("/delbook", bookHandler.delBook);

// 导出路由对象
module.exports = router;
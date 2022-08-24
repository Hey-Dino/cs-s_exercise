let data = [
    { "id": 1, "bookname": "西游记", "author": "吴承恩", "publisher": "北京图书出版社" },
    { "id": 2, "bookname": "红楼梦", "author": "曹雪芹", "publisher": "上海图书出版社" },
    { "id": 3, "bookname": "三国演义", "author": "罗贯中", "publisher": "北京图书出版社" }
];

module.exports.getBooks = (req, res) => {
    res.send({
        status: 200,
        msg: "获取图书列表成功",
        data
    });
};

module.exports.addBooks = (req, res) => {
    data.push({
        id: req.body.id,
        bookname: req.body.bookname,
        author: req.body.author,
        publisher: req.body.publisher
    });

    res.send({
        status: 201,
        msg: "添加图书信息成功"
    });
};

module.exports.delBook = (req, res) => {
    // 待删除的图书信息的ID
    let delId = req.query.id;

    data.forEach((val, index) => {
        if (val.id == delId) {
            console.log("index:" + index);
            data.splice(index, 1);
            console.log(data);
            return;
        }
    });

    res.send({
        status: 200,
        msg: "删除图书信息成功"
    });
}
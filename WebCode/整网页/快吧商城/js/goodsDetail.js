window.addEventListener('load', function () {
    var preview_img = document.querySelector('.preview-img');
    var mask = preview_img.querySelector('.mask');
    var big = preview_img.querySelector('.big');
    var bigImg = big.querySelector('.bigImg');

    // 监听鼠标移入操作
    preview_img.addEventListener('mouseover', function (e) {
        mask.style.display = 'block';
        big.style.display = 'block';
    })

    // 监听鼠标移出操作
    preview_img.addEventListener('mouseout', function (e) {
        mask.style.display = 'none';
        big.style.display = 'none';
    })

    preview_img.addEventListener('mousemove', function (e) {
        // 计算鼠标相对preview_img的位置
        var x = e.pageX - this.offsetLeft;
        var y = e.pageY - this.offsetTop;

        // 鼠标位于遮罩中心是，遮罩相对preview_img的位置
        var maskX = x - mask.offsetWidth / 2;
        var maskY = y - mask.offsetHeight / 2;

        // 限制遮罩位置
        var maskMax = this.offsetWidth - mask.offsetWidth;
        if (maskX < 0) {
            maskX = 0;
        } else if (maskX > maskMax) {
            maskX = maskMax - 2;
        }

        if (maskY < 0) {
            maskY = 0;
        } else if (maskY > maskMax) {
            maskY = maskMax - 2;
        }
        mask.style.left = maskX + 'px';
        mask.style.top = maskY + 'px';

        // 设置大图位置跟随遮罩位置变化
        // 大图移动距离 = 遮罩移动距离*（大图最大移动距离 / 遮罩最大移动距离）
        var bigMax = bigImg.offsetWidth - big.offsetWidth;
        var bigX = maskX * bigMax / maskMax;
        var bigY = maskY * bigMax / maskMax;
        bigImg.style.left = -bigX + 'px';
        bigImg.style.top = -bigY + 'px';
    })
})
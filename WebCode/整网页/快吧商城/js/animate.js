function animate(obj, target, callback) {
    clearInterval(obj.timer);

    obj.timer = setInterval(() => {
        // 判断是否移动到目标位置
        if (target == obj.offsetLeft) {
            clearInterval(obj.timer);

            // 判断回调函数是否存在，存在则调用
            if (callback) {
                callback();
            }
        }

        // 若未移动到目标位置，则计算步长后移动obj
        var step = (target - obj.offsetLeft) / 10;
        // 正数则向上取整，负数则向下取整
        step = step > 0 ? Math.ceil(step) : Math.floor(step);
        obj.style.left = obj.offsetLeft + step + 'px';
    }, 15);
}
window.addEventListener('load', function () {
    // 轮播图
    var main = this.document.querySelector('.main');
    var focus = main.querySelector('.focus');
    var arrow_l = focus.querySelector('.arrow-l');
    var arrow_r = focus.querySelector('.arrow-r');
    var ul = focus.querySelector('ul');
    var ol = focus.querySelector('ol');
    var imgWidth = ul.children[0].offsetWidth;

    // 为ol创建子节点li，即创建小圆圈
    for (var i = 0; i < ul.children.length; i++) {
        var li = this.document.createElement('li');
        li.setAttribute('index', i);
        ol.appendChild(li);

        // 控制小圆圈的点击效果
        li.addEventListener('click', function () {
            // 清除其于小圆圈的点击效果
            for (var j = 0; j < ol.children.length; j++) {
                ol.children[j].className = '';
            }
            // 为自身添加提效果
            this.className = 'current';

            // 添加小圆圈实现跳转效果
            var index = this.getAttribute('index');
            // 同步num、circle的值
            num = circle = Number(index);
            // var ulMove = ul.children[index].offsetLeft;
            var ulMove = index * imgWidth;

            animate(ul, -ulMove);
        })
    }
    // 设置第一张图片的类名为current
    ol.firstElementChild.className = 'current';

    // 在ul首部、末尾互相添加对方，为下方无缝切换做准备
    var liFirst = ul.firstElementChild.cloneNode(true);
    var liLast = ul.lastElementChild.cloneNode(true);
    ul.appendChild(liFirst);
    // ul.insertBefore(liLast, ul.firstElementChild);

    // 控制箭头的出现于消失
    focus.addEventListener('mouseenter', function () {
        arrow_l.style.display = 'block';
        arrow_r.style.display = 'block';
        clearInterval(timer);
        timer = null;
    })
    focus.addEventListener('mouseleave', function () {
        arrow_l.style.display = 'none';
        arrow_r.style.display = 'none';
        timer = setInterval(function () {
            // 手动调用点击事件
            arrow_r.click();
        }, 3000);
    })
    // 箭头实现跳转效果
    var num = 0;  // 用于记录当前所展示图片的顺序
    var circle = 0;  // 用于记录小圆圈的顺序
    arrow_l.addEventListener('click', function () {
        // 获取选中状态的小圆圈的index
        // 有缝切换
        // num = ((num - 1) + ol.children.length) % ol.children.length;
        // 无缝切换
        if (num == 0) {
            num = ul.children.length - 1;
            ul.style.left = -num * imgWidth + 'px';
        }
        num--;
        animate(ul, -(imgWidth * num));

        // 更改选中小圆圈
        circle = circle == 0 ? (ol.children.length - 1) : circle - 1;
        for (var i = 0; i < ol.children.length; i++) {
            ol.children[i].className = '';
        }
        ol.children[circle].className = 'current';
    })

    arrow_r.addEventListener('click', function () {
        // 有缝切换
        // num = ((num + 1) + ol.children.length) % ol.children.length;
        // 无缝切换
        if (num == 4) {
            ul.style.left = 0;
            num = 0;
        }
        num++;
        animate(ul, -(imgWidth * num));

        // 若小圆圈处于末尾，则circle赋值为0；否则，circle值加1
        circle = (circle == ol.children.length - 1) ? 0 : circle + 1;
        // 更改选中小圆圈
        for (var i = 0; i < ol.children.length; i++) {
            ol.children[i].className = '';
        }
        ol.children[circle].className = 'current';
    })

    // 自动播放轮播图
    var timer = setInterval(function () {
        // 手动调用点击事件
        arrow_r.click();
    }, 3000);


    /* 
    电梯导航
    */
    var toolTop = $('.fun-area').offset().top;

    // 节流阀
    var flag = true;
    // 控制页面导航的滑入和滑出
    function toggleTool() {
        if ($(document).scrollTop() >= toolTop) {
            $('.fixedTool').stop().slideDown();
        } else {
            $('.fixedTool').stop().slideUp();
        }
    };
    // 避免页面刷新时不显示页面导航
    toggleTool();

    $(window).scroll(function () {
        toggleTool();
        // 页面导航随滚动变化
        if (flag) {
            $('.floor>div').each(function (i, ele) {
                if ($(document).scrollTop() >= $(ele).offset().top) {
                    $('.fixedTool ul li').eq(i).addClass('current').siblings('li').removeClass('current');
                }
            });
        }
    });

    $('.fixedTool ul li').click(function () {
        flag = false;

        var index = $(this).index();
        $(this).addClass('current').siblings('li').removeClass('current');

        $('body, html').stop().animate({
            scrollTop: $('.floor>div').eq(index).offset().top
        }, function () {
            flag = true
        });

        // flag在此处更改是无效的，应该js是先赋指后执行animate函数
        // flag = true;
    });
})
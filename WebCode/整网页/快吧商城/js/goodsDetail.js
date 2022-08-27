window.addEventListener('load', function() {
    // 放大镜
    {
        var preview_img = document.querySelector(".preview-img");
        var mask = document.querySelector(".mask");
        var big = document.querySelector(".big");
        var bigImg = document.querySelector(".bigImg");

        preview_img.addEventListener("mouseover", function() {
            big.style.display = "block";
            mask.style.display = "block";

        })
        preview_img.addEventListener("mouseout", function() {
            big.style.display = "none";
            mask.style.display = "none";
        })

        preview_img.addEventListener("mousemove", function(e) {
            // 在盒子内的坐标
            var x = e.pageX - preview_img.offsetLeft;
            var y = e.pageY - preview_img.offsetTop;

            //mask黄色小盒子移动的距离
            var maskX = x - mask.offsetWidth / 2;
            var maskY = y - mask.offsetHeight / 2;

            //最大移动距离(宽高大小一样)
            var maxMask = preview_img.offsetWidth - mask.offsetWidth;

            if (maskX <= 0) {
                maskX = 0;
            } else if (maskX >= maxMask) {
                maskX = maxMask;
            }
            if (maskY <= 0) {
                maskY = 0;
            } else if (maskY >= maxMask) {
                maskY = maxMask;
            }
            mask.style.left = maskX + "px";
            mask.style.top = maskY + "px";

            // 大盒子的最大移动距离
            var maxMaskBigImg = bigImg.offsetWidth - big.offsetWidth;
            // 移动比值
            var ratio = maxMaskBigImg / maxMask;
            var maskBigX = maskX * ratio;
            var maskBigY = maskY * ratio;

            bigImg.style.left = -maskBigX + "px";
            bigImg.style.top = -maskBigY + "px";
        })
    }
    //商品图片变化 
    {
        // 鼠标经过
        var specImg = document.querySelector(".spec-img");
        var specListUl = document.querySelector(".spec-list ul");
        var index1 = 1;
        for (let i = 0; i < specListUl.children.length; i++) {
            specListUl.children[i].index = i;
            specListUl.children[i].addEventListener("mouseover", function() {
                for (let i = 0; i < specListUl.children.length; i++) {
                    specListUl.children[i].className = "";
                }
                this.className = "spec-list-over";
                index1 = this.index + 1;
                specImg.src = "upload/goodsDetail/p" + index1 + ".jpg.avif";
                bigImg.src = "upload/goodsDetail/pm" + index1 + ".jpg.avif";
            })
        }

        // 左右点击按钮
        var specForward = document.querySelector(".spec-forward");
        var specBackward = document.querySelector(".spec-backward");

        // 左点击
        specForward.addEventListener("click", function() {
            index1--;
            index1 = index1 > 0 ? index1 : (index1 + specListUl.children.length);
            for (let i = 0; i < specListUl.children.length; i++) {
                specListUl.children[i].className = "";
            }
            specListUl.children[index1 - 1].className = "spec-list-over";

            specImg.src = "upload/goodsDetail/p" + index1 + ".jpg.avif";
            bigImg.src = "upload/goodsDetail/pm" + index1 + ".jpg.avif";
        })

        // 右点击
        specBackward.addEventListener("click", function() {
            index1 = index1 % specListUl.children.length;
            for (let i = 0; i < specListUl.children.length; i++) {
                specListUl.children[i].className = "";
            }
            specListUl.children[index1].className = "spec-list-over";
            index1++;
            specImg.src = "upload/goodsDetail/p" + index1 + ".jpg.avif";
            bigImg.src = "upload/goodsDetail/pm" + index1 + ".jpg.avif";
        })

    }

    // 商品属性选择
    {
        var chooseAttrUl1 = document.querySelector(".choose-attr-ul-1");
        for (let i = 0; i < chooseAttrUl1.children.length; i++) {
            chooseAttrUl1.children[i].addEventListener("click", function() {
                for (let i = 0; i < chooseAttrUl1.children.length; i++) {
                    chooseAttrUl1.children[i].className = "";
                }
                this.className = "choose-box";
            })
        }

        var chooseAttrUl2 = document.querySelector(".choose-attr-ul-2");
        for (let i = 0; i < chooseAttrUl2.children.length; i++) {
            chooseAttrUl2.children[i].addEventListener("click", function() {
                for (let i = 0; i < chooseAttrUl2.children.length; i++) {
                    chooseAttrUl2.children[i].className = "";
                }
                this.className = "choose-box";
            })
        }

        var chooseAttrUl3 = document.querySelector(".choose-attr-ul-3");
        for (let i = 0; i < chooseAttrUl3.children.length; i++) {
            chooseAttrUl3.children[i].addEventListener("click", function() {
                for (let i = 0; i < chooseAttrUl3.children.length; i++) {
                    chooseAttrUl3.children[i].className = "";
                }
                this.className = "choose-box";
            })
        }

        var chooseAttrUl4 = document.querySelector(".choose-attr-ul-4");
        for (let i = 0; i < chooseAttrUl4.children.length; i++) {
            chooseAttrUl4.children[i].addEventListener("click", function() {
                for (let i = 0; i < chooseAttrUl4.children.length; i++) {
                    chooseAttrUl4.children[i].className = "";
                }
                this.className = "choose-box";
            })
        }

        var chooseAttrUl5 = document.querySelector(".choose-attr-ul-5");
        for (let i = 0; i < chooseAttrUl5.children.length; i++) {
            chooseAttrUl5.children[i].addEventListener("click", function() {
                for (let i = 0; i < chooseAttrUl5.children.length; i++) {
                    chooseAttrUl5.children[i].className = "";
                }
                this.className = "choose-box";
            })
        }

    }

    // 商品数量增减
    {
        var buyNum = document.querySelector(".buy-num");
        var btnAdd = document.querySelector(".btn-add");
        var btnReduce = document.querySelector(".btn-reduce");

        btnAdd.addEventListener("click", function() {
            if (buyNum.value < 9999) {
                buyNum.value++;
                btnAdd.style.cursor = "pointer";
            }
            if (buyNum.value >= 9999) {
                btnAdd.style.cursor = "not-allowed";
            }
            if (buyNum.value > 1) {
                btnReduce.style.cursor = "pointer";
            }
        })

        btnReduce.addEventListener("click", function() {
            if (buyNum.value > 1) {
                buyNum.value--;
                btnReduce.style.cursor = "pointer";
            }
            if (buyNum.value <= 1) {
                btnReduce.style.cursor = "not-allowed";
            }
            if (buyNum.value < 9999) {
                btnAdd.style.cursor = "pointer";
            }
        })
    }

    // 商品选择
    {
        var suitsUl = document.querySelector("#suits-ul");
        var sumPrice = document.querySelector("#sum-price");
        var sum = parseInt(sumPrice.innerHTML);
        for (let i = 0; i < suitsUl.children.length; i++) {
            suitsUl.children[i].children[2].addEventListener("change", function() {
                if (this.checked == true)
                    sum = sum + parseInt(this.value);
                else
                    sum = sum - parseInt(this.value);
                sumPrice.innerHTML = sum;
            })

        }

    }


    // 商品详情点击
    {
        var dtUl = document.querySelector("#detail-title-ul");
        var detail = document.querySelector(".detail");
        for (let i = 0; i < dtUl.children.length; i++) {
            dtUl.children[i].index = i;
            dtUl.children[i].addEventListener("click", function() {
                for (let i = 0; i < dtUl.children.length; i++) {
                    dtUl.children[i].className = "";
                }
                var index2 = this.index;
                this.className = "bc";

                for (let i = 1; i < detail.children.length; i++) {
                    detail.children[i].style.display = "none";
                }
                detail.children[index2 + 1].style.display = "block";
            })
        }
    }
})
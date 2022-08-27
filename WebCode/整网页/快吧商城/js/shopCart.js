window.addEventListener("load", function () {
    var ipp = document.querySelectorAll('.cart-input-o');
    var adds = document.querySelectorAll('.cart-num-inc');
    var decs = document.querySelectorAll('.cart-num-dec');
    var dels = document.querySelectorAll('.del');
    var movs = document.querySelectorAll('.mov');
    var ulls = document.querySelectorAll('.cart-tbody ul');
    var sum = document.querySelectorAll('.item-item .t-sum');
    var tprice = document.querySelectorAll('.t-price');
    //移到关注按钮
    for(let i = 0; i < movs.length; i++){
        movs[i].onclick = function(){
            if(i<5){
                ulls[0].removeChild(ulls[0].children[i])
            }else{
                ulls[1].removeChild(ulls[1].children[0])
            }
        }
    }
    //列表删除按钮
    for(let i = 0; i< dels.length; i++){
        dels[i].onclick = function(){
            if(i<5){
                ulls[0].removeChild(ulls[0].children[i])
            }else{
                ulls[1].removeChild(ulls[1].children[0])
            }
        }
    }
    //数量增加按钮 价格相对应增加
    for(let i = 0; i< adds.length;i++){
        adds[i].onclick = function(){
        var value = ipp[i].value;
        ipp[i].value = parseInt(value) + 1;
        // console.log( (parseFloat(tprice[i+1].innerHTML) ))
        sum[i].innerHTML= (ipp[i].value * parseFloat(tprice[i+1].innerHTML * 100)) / 100;
        }
    }
    //数量减少按钮 价格相对应减少
    for(let i = 0; i< decs.length;i++){
        decs[i].onclick = function(){
        var value = ipp[i].value;
        if(ipp[i].value <= 1){
            ipp[i].value = 1;
            sum[i].innerHTML = tprice[i+1].innerHTML
          }else{
            ipp[i].value = parseInt(value) - 1;
            sum[i].innerHTML = (sum[i].innerHTML * 100 - parseFloat(tprice[i+1].innerHTML * 100)) / 100;
          }
        }
    }
})
//全选按钮
function checkbox(obj){
    var che = document.querySelectorAll('.ss .t-checkbox input');
    console.log(obj.checked);
    for(let i = 0; i < che.length; i++){
            che[i].checked = obj.checked;
    }
}
//单选
function box(obj){
    var che = document.querySelectorAll('.ss .t-checkbox input');
    var bigbox = document.querySelector('.tt');
    var i = 0;
    che.forEach(item => {
        if(item.checked == true){
            i++
        }
    })
    console.log(i);
    if(i == che.length){
        bigbox.checked = true;
    }else{
        bigbox.checked = false;
    }

}
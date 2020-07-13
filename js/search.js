let btn = document.querySelector('#buttonSearch');
let ans = document.querySelector('.ans');
let val = document.querySelector('#search');

function clk(){
    window.open(`https://namu.wiki/w/${val.value}`, '_blank');
}

function init(){
    btn.addEventListener("click", clk);
}

init();
let R = 0;
function changeR(newR){
    R = newR;
    //form:j_idt21
    for(let i = 0;i<5;i++){
        id = 'form:j_idt2'+(i+2);
        if(i+1 == R)
            document.getElementById(id).style['background-color']='green';
        else
            document.getElementById(id).style['background-color']='red';
    }
}
changeR(0);
document.getElementById("canvas").onclick = (ev) => {
    if (R < 1 || R > 5)
        return -1;
    let rect = document.getElementById("canvas").getBoundingClientRect();
    let x = (ev.clientX-rect.left-150)/100*r.value;
    let y = (150-ev.clientY+rect.top)/100*r.value;
    form.elements.x.value = Math.round(x);
    form.elements.y.value = y;
    if(checkX() && checkY() && checkR())
        document.getElementById("form").submit();
}
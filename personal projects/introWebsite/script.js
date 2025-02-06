let extraInfor = document.getElementById("secretRare");
let infoParagraph = document.getElementById("basicInfo");
let picture = document.getElementById("Pokemon Cards3");
let color = document.getElementById("backColor");
document.getElementById("counter").addEventListener("click", clickCounter);
function changeText(){
  extraInfor.innerHTML = "Information no longer avaliable";
  infoParagraph.innerHTML = "Information no longer avaliable";
}
function linkSite(){
  let link = document.getElementById("link")
  link.innerHTML = "Click here to see the new pokemon cards!"
}
function changePic(){
  picture.src = "https://images.squarespace-cdn.com/content/v1/5cf4cfa4382ac0000123aa1b/1691691434238-EVK8LI0II6O5ZSP6KOLK/sv3_en_223.png?format=300w";
  picture.width = "300"
}
function changeColor(){
  color.style = "background-color:Teal;width:120px;height:20px;padding:40px;"
}
function returnColor(){
  color.style="background-color:#D94A38;width:120px;height:20px;padding:40px;"
}
let x = document.getElementsByTagName("p");
document.getElementById("info2").innerHTML = 'The text in second paragraph (index 1) is: ' + x[1].innerHTML;
let y = document.getElementsByClassName("info")
document.getElementById("basicInfo").innerHTML = 'The first paragraph (index 0) with class="info": ' + y[0].innerHTML;

let c = 0;
function clickCounter(){
  c++
  document.getElementById("counter").innerHTML = "Counter: " + c;
}


function doFirst(){

  $(".list-group-1").click(function(){
    $(".list-group-open1").slideToggle("slow");
  })
  
  $(".list-group-2").click(function(){
    $(".list-group-open2").slideToggle("slow");
  })
 

  // Example starter JavaScript for disabling form submissions if there are invalid fields
// function() {
//   'use strict';
//   window.addEventListener('load', function() {
//     // Fetch all the forms we want to apply custom Bootstrap validation styles to
//     var forms = document.getElementsByClassName('needs-validation');
//     // Loop over them and prevent submission
//     var validation = Array.prototype.filter.call(forms, function(form) {
//       form.addEventListener('submit', function(event) {
//         if (form.checkValidity() === false) {
//           event.preventDefault();
//           event.stopPropagation();
//         }
//         form.classList.add('was-validated');
//       }, false);
//     });
//   }, false);
// })();

  document.getElementById('exampleFormControlFile1').onchange = cov_fileChange;
  document.getElementById('exampleFormControlFile2').onchange = sta_fileChange;

  //找到radioButton(服務區域對應值)
 
  $('input[type=radio]').change(function(){
    alert($(this).val());
  })

}



//顯示上傳圖片預覽
function cov_fileChange() {
  let myFile = document.getElementById('exampleFormControlFile1').files[0];

  
  let readFile = new FileReader();
  readFile.readAsDataURL(myFile);
  readFile.addEventListener("load", function (e) {
    let image  = document.getElementById('cov_img');
    image.src = this.result; //src HTML標籤屬性 直接點就可以
    
    // image.width = 500 ;
    image.style.maxWidth = '200px' ;//css屬性
    image.style.maxHeight = '200px' ;
  });
}
function sta_fileChange() {
  let myFile = document.getElementById('exampleFormControlFile2').files[0];

  
  let readFile = new FileReader();
  readFile.readAsDataURL(myFile);
  readFile.addEventListener("load", function (e) {
    let image  = document.getElementById('sta_img');
    image.src = this.result; //src HTML標籤屬性 直接點就可以
    
    // image.width = 500 ;
    image.style.maxWidth = '400px' ;//css屬性
    image.style.maxHeight = '300px' ;
  });
}
window.addEventListener('load',doFirst);




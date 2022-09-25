const myForm = document.getElementById("myForm");
const inpFile = document.getElementById("myFile");

myForm.addEventListener("submit",e => {
  e.preventDefault();

  const endpoint = 'uploads';// create using servlet 
  const formData = new FormData();

  console.log(inpFile.files);

  formData.append("inpFile",inpFile.files);

  // fetch(endpoint, {
  //   method: "post",
  //   body: formData
  // }).catch(console.error);
});

var check = function() {
  if (document.getElementById('password').value ==
    document.getElementById('confirm_password').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'not matching';
  }
}
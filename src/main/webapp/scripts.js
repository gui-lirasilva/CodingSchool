
function switchStatus(event, categoryId){
    event.preventDefault();
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/alteraVisibilidade?id="+categoryId);
    xhr.addEventListener("load", function (){
        if(xhr.status===204){
            var activeStatus = document.querySelector("#active"+categoryId);
            if(activeStatus.textContent === "true"){
                activeStatus.textContent = "false";
            } else {
                activeStatus.textContent = "true";
            }
        }
    })
    xhr.send();
}
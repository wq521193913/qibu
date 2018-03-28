$(function () {
   var brokerData = JSON.parse(sessionStorage.getItem("brokerData"));

   fullData(brokerData);
});

function fullData(data) {
    var el = $("#EditForm").find("input");

    for(let i = 0; i < el.length; i++){
        console.log(el[i]);
    }
}
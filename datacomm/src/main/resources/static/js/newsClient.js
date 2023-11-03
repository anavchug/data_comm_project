
var request = new XMLHttpRequest();
request.open("GET","http://localhost:8080/news");
request.addEventListener("load",newsData)
request.send();


function newsData(){
  if (this.status == 200) {
    data = JSON.parse(this.responseText);
    let news = document.querySelector('#news');

    data.forEach(obj => {
      if(obj.imageUrl.length != 0 || obj.title.length != 0){
        let articleElement = document.createElement('div');
        let titleElement = document.createElement('h3');
        let imageUrlElement = document.createElement('img');

        let link = document.createElement('a');
        link.setAttribute('href', obj.url);
        link.setAttribute('target',"_blank");
        link.setAttribute('rel',"noopener noreferrer")

        let link2 = document.createElement('a');
        link2.setAttribute('href', obj.url);
        link2.setAttribute('target',"_blank");
        link2.setAttribute('rel',"noopener noreferrer")
        link2.appendChild(titleElement);

        imageUrlElement.setAttribute("src", obj.imageUrl);
        titleElement.textContent = obj.title;
        link.appendChild(imageUrlElement);

        articleElement.appendChild(link);
        articleElement.appendChild(link2);

        news.appendChild(articleElement);
      }
    });
  
  } else {
    console.log("Error: " + xhttp.status);
    console.log("Response Text: " + xhttp.responseText);
  }
}

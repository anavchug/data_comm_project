
var request = new XMLHttpRequest();
request.open("GET","http://localhost:8080/video");
request.addEventListener("load",handleData)
request.send();


var request = new XMLHttpRequest();
request.open("GET","http://localhost:8080/news");
request.addEventListener("load",newsData)
request.send();

document.querySelectorAll('h2 a').forEach(function(link) {
    link.addEventListener('click', function(event) {

        let values = {"entertainment":"24","sports":"17","science":"28","general":"25"};

        event.preventDefault();
        const category = event.target.getAttribute('data-category');
        fetchNewsData(category);
        fetchVideoData(values[category]);


    });
  });


function fetchVideoData(category){

    const request = new XMLHttpRequest();
    request.open("GET", `http://localhost:8080/video?category=${category}`);
    request.addEventListener("load",handleData);
    request.send();

}

function handleData(){

    if(this.status == 200){

        let data = JSON.parse(this.responseText);

        let source = document.getElementById("videos");

        source.textContent = "";

        data.forEach((item) =>{

            let holder = document.createElement("div");
            let title = document.createElement("h3");
            let img = document.createElement('img');

            
            let link = document.createElement('a');
            link.setAttribute('href', item.url);
            link.setAttribute('target',"_blank");
            link.setAttribute('rel',"noopener noreferrer");
            link.style.textDecoration = 'none';
            link.style.color = 'black';

    
            
            let link2 = document.createElement('a');
            link2.setAttribute('href', item.url);
            link2.setAttribute('target',"_blank");
            link2.setAttribute('rel',"noopener noreferrer")
            link2.style.textDecoration = 'none';
            link2.style.color = 'black';
            link2.appendChild(title);

            title.textContent = item.title;
            img.setAttribute("src",item.thumbUrl);
            link.appendChild(img);

            holder.appendChild(link);
            holder.appendChild(link2);
            
            

            source.appendChild(holder);

        })
    }
}



function fetchNewsData(category) {
    const request = new XMLHttpRequest();
    request.open("GET", `http://localhost:8080/news?category=${category}`);
    request.addEventListener("load", newsData);
    request.send();
  }
  
  function newsData(){
    if (this.status == 200) {
      data = JSON.parse(this.responseText);
      let news = document.querySelector('#news');
      news.innerHTML  = "";
  
      data.forEach(obj => {
          console.log(obj.imageUrl);
          let articleElement = document.createElement('div');
          let titleElement = document.createElement('h3');
          let imageUrlElement = document.createElement('img');
  
          let link = document.createElement('a');
          link.setAttribute('href', obj.url);
          link.setAttribute('target',"_blank");
          link.setAttribute('rel',"noopener noreferrer")
          link.style.textDecoration = 'none';
          link.style.color = 'black';
  
          let link2 = document.createElement('a');
          link2.setAttribute('href', obj.url);
          link2.setAttribute('target',"_blank");
          link2.setAttribute('rel',"noopener noreferrer");
          link2.style.textDecoration = 'none';
          link2.style.color = 'black';
          link2.appendChild(titleElement);
  
          imageUrlElement.setAttribute("src", obj.imageUrl);
          titleElement.textContent = obj.title;
          link.appendChild(imageUrlElement);
  
          articleElement.appendChild(link);
          articleElement.appendChild(link2);
  
          news.appendChild(articleElement);
      });
    
    } else {
      console.log("Error: " + xhttp.status);
      console.log("Response Text: " + xhttp.responseText);
    }
  }
  
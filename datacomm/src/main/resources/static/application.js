

var request = new XMLHttpRequest();
request.open("GET","http://localhost:8080/video");
request.addEventListener("load",handleData)
request.send();


function handleData(){

    if(this.status == 200){

        let data = JSON.parse(this.responseText);

        let source = document.getElementById("videos");

        data.forEach((item) =>{

            let holder = document.createElement("div");
            let title = document.createElement("h2");
            let img = document.createElement('img');

            let url = document.createElement("h2");
            let link = document.createElement('a');

            link.setAttribute('href', item.url);
            //link.textContent = "Link";
            //url.appendChild(link);
            

            title.textContent = item.title;
            img.setAttribute("src",item.thumbUrl);
            link.appendChild(img);

            holder.appendChild(title);
            holder.appendChild(link);
            //holder.appendChild(img);
            //holder.appendChild(url);
            

            source.appendChild(holder);

        })
    }
}
Node, Maven and java required to run the project. 

1. git clone the project from repo
    git clone https://github.com/shreyas6969/shorturl.git

2. In the clone location, move to the directory and run. 
   mvn spring-boot:run

3. Swagger URL 
     http://localhost:8080/swagger-ui.html

4. Access the application, the ui react application has a proxy url added so we would be  able access the ui with the below url. 

     http://localhost:8080/

5. Steps to use the appliaction.
   1. Enter a long url and click save the url gets added in the table below.
   2. On click of the url from the table, the number of hits increase and new tab opens up with the long url.
   3. If any valid URL is given , the new tab will have the page open with the long url.
   4. If anything with localhost:8080/testbckbkjdb is given as long url , the count would increase because of the click of short url but would give a 404 error in the newly opened tab.        
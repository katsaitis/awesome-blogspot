# awesome-blogspot
How to run:

1) Open the project in intellij (or your prefer IDE)
2) Enable maven auto import (so all dependencies are downloaded automatically)
3) Run class src/main/java/com/owl/awesomeblogspot/AwesomeBlogspotApplication.java
4) open a web browser in page http://localhost:8080



HTML pages should always live under "resources/templates". Exceptions apply to the admin login page which 
is handled internally by spring security.

Conversely, JS and CSS files should be under "resources/static/css" (for css) 
and "resources/static/js" (for js)

# React and Spring Data Rest tutorial (https://spring.io/guides/tutorials/react-and-spring-data-rest/)

The original tutorial is a <strong>Maven</strong> project that uses <em>frontend-maven-plugin</em> to take care of webpack and all the node.js tools. 
Since I prefer <strong>Gradle</strong>, I turned the tutorial project into a <strong>Gradle</strong> project. 

The current setup of <em>build.gradle</em> takes care of node.js tools and webpack automatically upon a gradle build. Node_modules and bundle.js are automatically generated. There is no need to manually install node, npm or webpack.


* Somehow there is a webpack install error during gradle build on a Windows machine. I haven't found a fix for it yet. The build.gradle works perfectly on a Mac.

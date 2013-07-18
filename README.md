spring-fabric
=============

Conceptual attempted implementation using Java Spring to create an application fabric api

This project is largely based on a frankenstine attempt at integrating a few different Spring projects to conceptualize a web-application that would _eventually_ allow a user to use a web-based IDE to build and store source-code, and than build applications that would run on remote-resources via a simple command/control web-app.

###So far:

* Spring Security for some parts of the very non-functional web-app
* A simple API that allows a user to request an "authentication token" that should be included with each request to an API call within the secured "relm"
* Spring Integration to queue messages (think: eventually a scheduler for creating "jobs", which will run user implemented methods, applications, etc.)
* An attempt at creating a 'resource monitor', to keep track of an individuals use of system resources on a 'meter' basis (this hasn't really worked so far)

Useful code for others might be the _token authenticator/generator_ which took a while to get right.

Once the application is up and running, get a new authentication token from the webservice by posting credentials to the server:

<code>
$.get('http://localhost:8080/spring-mvc-setup/api/authenticate?username=user&password=demo',function(response){ console.log(response); });
</code>

Obviously, they are in plain-text which isn't very secure, so a nice upgrade would be to MD5 hash them or some such and decode them server-side

Additionally, this token can now be passed in the header with each API request to authenticate the calls:

<code>
$.ajax({
  url: "http://localhost:8080/spring-mvc-setup/schedule",
  data: {},
  headers: { token : '...token from service...' }
});
</code>

Should return some JSON like:

<code>
	{"methodName":"testingSpringIntegration","status":"success"}
</code>

***

I thought this project might be a good idea for _starting a conversation_ about application fabric should be implemented in the cloud, and the idea of idea of web-based IDEs, remote application compilation and execution, as well as debugging, and resource usage.

Any input please contact me.
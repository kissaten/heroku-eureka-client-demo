## Netflix OSS on Heroku Demo: Eureka Client

This project demonstrates the use of a Netflix OSS with Spring Cloud on Heroku. 
It defines a trivial service and registers that service with a Eureka server.

Before using this project, you must have a [Eureka Server](https://github.com/kissaten/heroku-eureka-server-demo) deployed.

## Quickstart

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

Once it's deployed, you will need to define `$EUREKA_URL` and `$DOMAIN_NAME` config variables as described below.

## Deployment

If you have already deploy the Eureka Server to Heroku, then you should already have a Heroku account and
toolbelt installed.

Once the Eureka Server is running, clone this project (the client) and move into it's root directory.
                                   
```
$ git clone git@github.com:kissaten/heroku-eureka-client-demo.git
$ cd heroku-eureka-demo/
```

Then create a Heroku application for the client by running this command:

````sh-session
$ heroku create
Creating fast-beach-5250... done, stack is cedar-14
https://fast-beach-5250.herokuapp.com/ | https://git.heroku.com/fast-beach-5250.git
Git remote heroku added
```

Now create a configuration variable to set the URL of the Eureka server.
Run this command, but substitute the URL for `<URL>` in the form `https://user:password@<appname>.herokuapp.com`:

```
$ heroku config:set EUREKA_URL=<URL>
```

Also create a configuration variable for the domain name of your service -- this is the domain name that can be used
to consume your service. By default it will be `<appname>.herokuapp.com`. You can set it like this:

```
$ heroku config:set DOMAIN_NAME="<appname>.herokuapp.com"
```

You're ready to deploy. There are two methods you can choose from: Git deployment and
Maven deployment. The former compiles the application remotely, while the latter
uses locally compiled artifacts and pushes them to Heroku.

### Deploying with Git

With you're application prepared (as describe above), simply run this command to
deploy via Git:

```sh-session
$ git push heroku master
```

Your code will be pushed to the remote Git repository, and the Maven process
will execute on the Heroku servers.

### Deploying with Maven

With you're application prepared, simply run this command to
deploy (but replace `<appname>`  with the name of the Heroku application you created):

```sh-session
$ mvn -Dheroku.appName=<appname> heroku:deploy
...
[INFO] ---> Packaging application...
[INFO]      - app: <appname>
[INFO]      - including: ./target/eureka-client-demo-0.0.1-SNAPSHOT.jar
[INFO]      - installing: OpenJDK 1.8
[INFO] ---> Creating slug...
[INFO]      - file: ./target/heroku/slug.tgz
[INFO]      - size: 79MB
[INFO] ---> Uploading slug...
[INFO]      - stack: cedar-14
[INFO]      - process types: [web]
[INFO] ---> Releasing...
[INFO]      - version: 4
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 01:29 min
[INFO] Finished at: 2015-02-14T11:38:11-06:00
[INFO] Final Memory: 27M/579M
[INFO] ------------------------------------------------------------------------
```

## Viewing Your Application

When your chosen deployment method is finished, run this command to view
your application:

```
$ heroku open
```

After about 30 seconds, you can check the service was registered with the Eureka server. Log into the server, and
you'll see "MY-SERVICE" under the section titled "Instances currently registered with Eureka".

## Further Reading

+  [Spring Cloud Netflix documentation](http://projects.spring.io/spring-cloud/spring-cloud.html#_spring_cloud_netflix)
+  [Netflix Eureka](https://github.com/netflix/eureka)
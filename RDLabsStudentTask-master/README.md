# RD Labs Student Task Project
__How to start and what you need to do?__

* Create your own account in https://github.com/
* If you already have it - relax and check first step as passed :)
* Fork this project. What this mean and how to do it read here http://gearmobile.github.io/git/fork-github/
* Clone forked repository on local PC using Git bash and $git clone command
* Open project in IDEA and install following plugins:
1. Gherkin
2. JBehave Syntax Support
3. Lombok
4. Pipe Table Formatter
5. Dark Purple Theme (not necessary - but nice theme for IDEA)
* Restart IDEA. All settings completed :wink:

# What next?
In this project you will have several tasks:

:one: You need to fix all failured test cases.

:two: You need to implement new test scenarious (you will get file with manual test cases).

:three: You need to add serenity reporting to project.

:four: And finally you need to run test in Jenkins.

# How to run tests?

__In IDEA:__ add meta filter __@debug__ to test which you want to run, and then run file __DebugRunner.java__

__From command line:__ add meta filter @debug to test which you want to run and use command: __mvn clean verify -DSUITE=DebugRunner__

To run all test cases which already implemented use __RegressionRunner.java__

:point_up: __For new tests__, please create __new runner__ with name __StudentsRunner__ with meta filter __@newTask__. Add this meta filter to all new test cases which you implements.

There are some usefull links: :closed_book:

:link: http://thucydides.info/docs/serenity-staging/ - official documentation Serenity BDD

:link: https://jbehave.org/reference/stable/index.html - official documentation JBhave

:link: https://joel-costigliola.github.io/assertj/ - - official documentation AssertJ

:warning: Don't make any other actions that not provided in test cases (don't delete, modify, move, change, etc any data in application)

# spring-playground

Demo project in spring boot to learn basics with simple connection on DB (postgres) and defined APIs.


## Prerequisites

-   Java 1.8
-   Intellij Idea, Eclipse, Notepad or any other IDE
-   PostgreSQL server
-   Maven (not mandatory, since Idea has its own integrated Maven)

## Description / tutorial steps

1.  Create new project as Spring Initializr / Spring assistant (in Idea 2019.2 +)
    -   Sets mandatory application profile for DB connection
2.  Create entities to map DB tables 
    -   correct annotations on fields / getters
    -   some sample on various settings for hibernate to change default settings
3.  Create Repository for our entities
4.  Create Resource for API 
    -   example of each simple type of VERB in REST 
5.  Set up spring security with basic authentication
    -   create simple html with login, error, home pages to customize spring security
    -   all POSTMAN request needs now Basic Auth with user / pass from application.properties


## KeyCloak integration
- To enable keycloack authentication
    - lookup settings for server and realm in application.properties
- SecurityConfig.class takes places instead of WebSecurityConfig.class 
    - extending different Adapter, set extra beans for keycloak
- Add @PreAuthorize - sets role to specify access on endpoint
    - this can be done also with commented section in application.properties (but only for entire app, not on specific endpoint)
    - to enable this functionality, additional annotation needs to be placed in DemoApplication.java
        - *EnableGlobalMethodSecurity*

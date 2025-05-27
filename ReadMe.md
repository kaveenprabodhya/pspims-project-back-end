### To use docker configuration
```
If you are using docker remember to change the mysql path 
otherwise use the localhost connection for mysql server url.
```


### For production, update the 'applications.properties' 
```
1. Use Environment Variables for Sensitive Info
    spring.datasource.username=${DB_UNAME}
    spring.datasource.password=${MYSQL_PWD}
    jwt.secret=${JWT_SECRET}
    jwt.expiration=${JWT_EXPIRATION}
2. Do Not Use ddl-auto=update
    In production, never use ddl-auto=update, as it can drop/change your schema unintentionally.
    spring.jpa.hibernate.ddl-auto=none
3. Update the DB Host if Using Docker or Cloud
    spring.datasource.url=jdbc:mysql://mysql-container:3306/pspims
4. Set Profiles Properly
    spring.profiles.active=prod
5. Logging Configuration
    logging.level.org.springframework=INFO
    logging.file.name=logs/pspims.log
    logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
6. HTTPS & Security Headers (via reverse proxy or config)
    server.ssl.enabled=true
    server.ssl.key-store=classpath:keystore.p12
    server.ssl.key-store-password=${SSL_KEYSTORE_PASSWORD}
    server.ssl.key-store-type=PKCS12
    server.port=8443
7. Disable Spring Boot Actuator Endpoints (if enabled)
    management.endpoints.web.exposure.include=health,info
    management.endpoint.health.show-details=never
```

### To access api-docs in dev
    [api-docs](http://localhost:8080/api-docs)

### To access swagger-ui
    [swagger-ui](http://localhost:8080/swagger-ui/index.html)

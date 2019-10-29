# authorization-server
 Quite good implementation of Spring Security OAuth2 Authorization Server using external database

1. Deploy docker-internal in swarm.
2. Create table user_entity in database after that create user, password could be ($2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu) decoding base64 it's just "password".
3. Run authorization server.
4. Run resource server.
5. Go to the "http://localhost:8080/oauth/authorize?response_type=code&client_id=client", enter the credentials, afterwards copy authorization code from URI.
6. Try: curl -X POST \
  'http://localhost:8080/oauth/token?code=YOUR_AUTHORIZATION_CODE&grant_type=authorization_code&client_id=client&client_secret=password'
7. Get access token and try to able resources from api of resource server.
8. The goal was extend user details migrated between secured microservices in context. Enjoy

// Better documentation soon

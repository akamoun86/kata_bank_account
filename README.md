# kata_bank_account

The provided kata is implemented as a spring boot application

To run the application:
1) go to the project folder
2) run mvn spring-boot:run

To test the application, please use a REST client. You can perform operations as follows:

PUT: http://localhost:8090/deposit/100.0
PUT: http://localhost:8090/withdraw/20.0
GET: http://localhost:8090/history

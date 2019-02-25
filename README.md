# kata_bank_account

The provided kata is implemented as a spring boot applciation

To run the application:
1) go to the prject folder
2) run mvn spring-boot:run

To test the application, please use a REST client. You can test it as follows:
GET: http://localhost:8090/history
PUT: http://localhost:8090/deposit/100.0
PUT: http://localhost:8090/withdraw/20.0

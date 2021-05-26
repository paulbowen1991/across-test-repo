# across-test-repo


To Run you need a valid API key for currencyLayer and replace in code (Would make configurable through a file but time constraints)
Username: admin
Password: password
Would have added token based OAuth2 but that required making an account, etc.

Sample Request: http://localhost:8080/auction?price_floor=100&currency=EUR

Configurable Auction Sample: http://localhost:8080/custom-auction?price_floor=100&toCurrency=EUR&fromCurrency=USD

Could have made the parameters part of the body but there was no specific requirement.


I added a controller advice to handle global errors but it does not seem to be executing. That is how resliency would be solved.

Load testing performed : Ran 100 transactions of each endpoint in postman, average response time was 127ms which ensures I did not add 200 ms extra

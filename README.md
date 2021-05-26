# across-test-repo
To Run you need a valid API key for currencyLayer and replace in code (Would make configurable through a file but time constraints)

I added a controller advice to handle global errors but it does not seem to be executing. That is how resliency would be solved.

Load testing performed : Ran 100 transactions of each endpoint in postman, average response time was 127ms which ensures I did not add 200 ms extra

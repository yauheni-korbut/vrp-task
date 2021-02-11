# vrp-task

This is the test automation framework to execute TCs on Saleforce trial org. 
Saleforce security policy require email verification with code after each signIn. The only workaround I was able to find is to add my IP to trusted IP adresses. 
So if you want to execute TCs on the current trial org you can just write me. Otherwise you can use your own trial org.

To run TCs execute the next maven command:

`mvn clean test`

or

`mvn clean test -DbrowserName=firefox`

The default browser is chrome. You can check the test execution results in the folder:

`/vrp-task/salesforce-automation/target/cucumber-reports/cucumber-html-reports/`

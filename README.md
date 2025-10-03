
# single-customer-account-performance-tests
Performance test suite for the `Single Customer Account`, using [performance-test-runner](https://github.com/hmrc/performance-test-runner) under the hood.


## Prerequisites

Prior to executing the tests ensure you have:

* Installed/configured service manager

#### To run the performance tests locally

* Run the following command to start the service locally:
```
sm2 --start SCA_FUTURES_ALL -r --wait 100
```
Using the `--wait 100` argument ensures a health check is run on all the services started as part of the profile. `100` refers to the given number of seconds to wait for services to pass health checks.

* Run the following command to run tests on local environment:
```
./run-local.sh
```
* Run the following command to run tests on staging environment:
```
./run-staging.sh
```  

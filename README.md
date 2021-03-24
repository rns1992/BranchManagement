## Branch Management Service.

#### Operation Supported
- Get list of all branches
- Get list of all available vaccines per branch
- Get specific availability of Vaccine by branch
- Get available time for a branch

#### API:

- Get list of all branches
curl --location --request GET 'http://localhost:9090/v1/branch'

- Get list of all available vaccines per branch
curl --location --request GET 'http://localhost:9090/v1/branch/vaccines'

- Get available time for a branch
curl --location --request GET 'http://localhost:9090/v1/branchAvailability'

- Get specific availability of Vaccine by branch
curl --location --request GET 'http://localhost:9090//v1/vaccineByBranch'


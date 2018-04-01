# Cloud-based E-commerce shopping application

## Task to tackle
In our project, our goal is to develop cloud native e-commerce application that can be easily scaled and handle large number of user requests. To achieve this, our e-commerce application will use micro-service architecture and deployed with container deployment and orchestration technique known as Docker Swarm on top of AWS.

### Functionalities
* Login service for User as well as Seller
* Email service for User/Seller
* Inventory service by sellers
* Searching products for a user from multiple sellers.
* Customer Review for Products.
* Checkout and Past Shopping History data for users.

## Solution Design

### Planned
For implementing the application as micro-service architecture, each component will be deployed and ran in a separate container. Each component has its own database to store data and will communicate via RESTful API. To handle the surge of incoming requests, we plan to use message queue service as a bridge to hold and dispatch the request. We plan to use a load balancer to distribute requests to multiple web servers. To cope with many requests, cause a heavy load to a single node, we will deploy with container orchestration technique such as Docker Swarm to scale a number of containers and manage a large numberof containers. We plan to design our application using Java Spring Boot and database using MongoDB.

### Implementation
We designed our e-commerce application with components such as customer service, product service, email service, review service and each service provides RESTful API for communication. To overcome the complexity and logic business between front-end and back-end, gateway service was implemented. All the services are implemented as containers. Instead of using different database containers for all services, we use same MongoDB setup which has 3 MongoDB database containers set up in a replica mode. We use docker swarm on AWS for deploying our application. Our swarm is setup with 6 EC2 instances. 3 EC2 as managers and 3 EC2 as worker nodes. We use multiple managers nodes for redundancy purpose. We have an ELB setup on our swarm with a DNS. Whenever a request to this URL is made, ELB will route the request to different containers to distribute the load.

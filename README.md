# Automated Web Application Deployment
## This project demonstrates the automation of infrastructure provisioning, application deployment, and continuous integration/continuous deployment (CI/CD) processes using popular DevOps tools. The project showcases how to deploy a simple web application to AWS with Jenkins, Docker, Terraform, and more.

## Project Overview
### This project serves as a practical example of setting up a complete CI/CD pipeline to automate the deployment of a simple web application. It covers the following key areas:

#### Infrastructure Provisioning: 
>> Use Terraform to define and provision AWS infrastructure, including EC2 instances, VPC, security groups, and key pairs.

#### Application Dockerization: 
>> Containerize the web application using Docker, allowing for consistency and portability.

#### Setting Up Jenkins: 
>> * Configure Jenkins, a popular CI/CD tool, either on an EC2 instance or within a Docker container.
>> * Ensure Jenkins is set up with necessary plugins for Git integration, Docker, and AWS.

### CI/CD Pipeline: 
>> * Create a Jenkins pipeline that automates the build and deployment process.
>> * The pipeline connects to your source code repository, builds the Docker image, pushes it to a container registry, and deploys the updated container to an AWS EC2 instance.

### Testing and Monitoring: 
>> * Implement automated testing scripts to ensure the application functions correctly.
>> * Set up basic monitoring and logging to track application health and performance.

## **Prerequisites**
Before starting, make sure you have the following prerequisites in place:

- AWS account with necessary IAM permissions.
- Terraform installed on your local machine.
- Docker installed on your local machine.
- A Git repository for your web application code.
- Jenkins server up and running with required plugins (Git, Docker, AWS).

### Project Structure
The project directory structure is organized as follows:
```
/
|-- infrastructure/          # Terraform scripts for infrastructure provisioning
|-- web-app/                # Your web application code
|-- Jenkinsfile             # Jenkins pipeline configuration
|-- Dockerfile              # Docker image configuration
|-- README.md               # Project documentation
```
## Getting Started
Follow the steps below to set up and execute the project:

### Infrastructure Provisioning
* Navigate to the infrastructure/ directory.
* Configure your AWS credentials using aws configure if not already done.
```
aws configure
```
* Run terraform init and terraform apply to provision the infrastructure.
```
terraform init
```
```
terraform apply
```
### Application Dockerization
* Create a Dockerfile in the root directory for your web application. Refer to the provided example for guidance.
* Build the Docker image using docker build -t my-web-app-image .
```
docker build -t my-web-app-image .
```
```
docker images
```
```
docker run -d -p 8080:80 my-web-app-image
```
* When you're done testing your Docker container, you can stop and remove it:
```
docker stop <container_id> #enter the your docker container_id
```
```
docker rm <container_id> #enter the your docker container_id
```
### Setting Up Jenkins
* Run Jenkins either on an EC2 instance or in a Docker container as described in the project documentation.
```
docker run -d -u root -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home --name jenkins jenkins/jenkins:lts
```
* Configure Jenkins with the necessary plugins (Git, Docker, AWS).
* Set up credentials in Jenkins for Docker Hub and AWS as required.

### CI/CD Pipeline
* Create a Jenkins pipeline job in the Jenkins web interface.
  >> - In the Jenkins web interface, click on "New Item" to create a new pipeline job.
  >> - Enter a name for your pipeline job and choose the "Pipeline" option.
  >> - Click "OK" to create the job.
* Configure the pipeline source to connect to your Git repository.
  >> - In the pipeline configuration, scroll down to the "Pipeline" section.
  >> -  Choose the "Pipeline script from SCM" option.
  >> -  Select your source code management system (e.g., Git).
  >> - Provide the repository URL and credentials if required.
  >> - Specify the branch to build (e.g., main or master).
* Define the pipeline stages as described in the project documentation, and adjust the Jenkinsfile accordingly.


#### Conclusion 
+ The automated Process to Deploy a Simple Website.
  

# Running Spring Boot apps using AWS Elastic Beanstalk

This repository demonstrates what should be done in order to run Spring Boot apps using AWS Elastic Beanstalk. 

In common, nothing special is required on the Java side - if it's necessary to use AWS services, it's necessary to include required dependencies into the `pom.xml` files. 

For example, in this tutorial connectors for AWS SQS and AWS DynamoDB are used so that the following dependencies are added to the `pom.xml`:

```xml
<dependency>
    <groupId>software.amazon.awssdk</groupId>
    <artifactId>dynamodb</artifactId>
</dependency>
<dependency>
    <groupId>software.amazon.awssdk</groupId>
    <artifactId>sqs</artifactId>
</dependency>
```

The main magic is happening on the AWS side. 

# Bird-eye overview

On a very high level, the following app's structure is used: 

![Bird-eye overview](./docs/images/Bird%20Eye%20Overview.png)

There are two environment involved: 

* Web environment which receives requests from end users on port `80`, and
* Worker environment which is not available for end users and processes messages by getting the from the SQS queue. 

Both environments are possibly groups of EC2 instances (at least one instance in the group). Every instance hosts a few components: 

* Host manager - the component which is responsible for managing Elastic Beanstalk infrastructure on he instance. 
* Application itself which processes requests (running on port `5000`). 
* HTTP proxy (nginx or Apache HTTPd) which receives requests on port `80` and next forwards them to port `5000`. 

![Environment Internals](./docs/images/Environment%20Internals.png)

In order worker and web environments have access to DynamoDB table and SQS, first, these resources should be created. Resources should be created using AWS CloudFormation by using the template in [aws-resources folder](./aws-resources/template.yaml).

This template creates the following resources: 

* DynamoDB table with name `invoices` to store records. 
* SQS queue to be a pipeline between web and worker environments. 
* IAM roles and EC2 instance profiles to provide environments with access to the resources. 

# Building Bundles for AWS Elastic Beanstalk

In order to deploy an application's version, it's necessary to upload the version to S3 and make it available for AWS Elastic Beanstalk. In case of Java, app version's bundle may be a plain `jar` file or a `zip` file which contains: 

* `jar` or `war` (in case of Tomcat environment) file. 
* `env.yaml` for configuring the environment. 
* `cron.yaml` for configuring the Cron jobs. 
* Any other configuration files in the `.ebextenstions` folder. 

To build these bundles Apache Maven AntRun plugin is used. This plugin is bounded to the `package` phase and create `zip` archives with all necessary files inside the `dist` folder of the app modules.
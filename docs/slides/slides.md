---
marp: true
paginate: true
footer: EPAM 2022, UK Engineering Community
header: Running Spring Boot apps in AWS Elastic Beanstalk
---

<style>
    * {
        font-family: "Trebuchet MS"
    }
</style>

<!-- _backgroundColor: #1a1a1a -->
<!-- _color: white -->
![bg right](./images//pexels-oleg-magni-1837591.jpg)

# Running Spring Boot apps in AWS Elastic Beanstalk
Aleksandr Barmin
March 2022

---

<!-- _backgroundColor: #1a1a1a -->
<!-- _color: white -->
![bg fit right](./images/aleksandr_barmin.jpg)

# Aleksandr Barmin

* Chief Software Engineer I
* AWS Solution Architect Associate
* AWS Developer Associate
* Aleksandr_Barmin@epam.com

---

![bg right](./images/pexels-pixabay-163037.jpg)
# Agenda

* Compute options available in AWS
* Use cases for VMs
* Demo part

---

# AWS Serverless

* AWS Lambda
* AWS Fargate
* AWS S3 & DynamoDB
* AWS Aurora Serverless

---

# Containers in AWS

* AWS Elastic Container Service
* AWS Elastic Kubernetes Service

---

# AWS Elastic Compute Cloud - EC2

Actually, this is just a virtual machine (VM). 

---

# Use cases for virtual machines

* List and shift migration
* High-performance computing
* Running and development of apps for Apple ecosystem
* Machine learning and other compute-heavy workloads

---

<!-- header: EC2 Instance Types -->
# EC2 Instance Types

* General purpose
* Compute optimized
* Memory optimized
* Storage optimized
* Accelerated computing

---

# General purpose EC2 instances

* Platforms: x86, Mac, Arm
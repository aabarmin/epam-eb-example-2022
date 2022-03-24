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

![bg right](./images/pexels-daria-shevtsova-698172.jpg)
# General purpose EC2 instances

**Platforms:** x86, Mac, Arm
**Use cases:**
* General workloads
* Low-latency interactive applications
* Small and medium databases
* Virtual desktops
* Business-critical apps

---

![bg right](./images/pexels-yoss-traore-2564153.jpg)
# Compute optimized EC2 instances

**Use cases:**
* Batch processing
* Media transcoding
* High-performance web services
* High-performance computing
* Scientific modelling
* Machine learning
* Other compute-intensive workloads

---

![bg right](./images/pexels-anna-urlapova-3035122.jpg)
# Memory optimized EC2 instances

Designed to deliver high performance for workloads that process large data sets in memory.

**Use cases:**
* Open-source databases
* In-memory caches
* Real-time big data analytics

---

![bg right](./images/pexels-jess-buckle-10706720.jpg)
# Storage optimized

Designed for workloads that require high, sequential read and write access to very large data sets on local storage. 

**Use cases:**
* Relational and non-relational database
* Search engines
* Data analytic workloads

---

![bg right](./images/pexels-gashif-rheza-3262573.jpg)
# Accelerated computing

GPU-based computing. 

**Use cases:**
* Machine learning
* Fluid dynamics
* Computational finance
* Seismic analysis
* Speech recognition
* Autonomous vehicles
* Drug discovery

---

# EC2 instance features
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

- Chief Software Engineer I
- AWS Solution Architect Associate
- AWS Developer Associate

Aleksandr_Barmin@epam.com

---

![bg right](./images/pexels-pixabay-163037.jpg)

# Agenda

- Compute options in AWS
- Not so deep dive into EC2
- Use cases for VMs
- AWS Elastic Beanstalk intro
- Demo part

---

![bg right](./images/pexels-oleg-magni-1837603.jpg)

# AWS Serverless

- AWS Lambda
- AWS Fargate
- AWS S3 & DynamoDB
- AWS Aurora Serverless

---

![bg right](./images/pexels-pixabay-460635.jpg)

# Containers in AWS

- AWS Elastic Container Service
- AWS Elastic Kubernetes Service

---

![bg right](./images/pexels-pierre-blach%C3%A9-2834219.jpg)

# AWS Elastic Compute Cloud - EC2

Actually, this is just a virtual machine (VM).

---

![bg right](./images/pexels-anthony-133614.jpg)

# Use cases for virtual machines

- Lift and shift migration
- High-performance computing
- Running and development of apps for Apple ecosystem
- Machine learning and other compute-heavy workloads

---

![bg right](./images/pexels-pixabay-415585.jpg)

<!-- header: EC2 Instance Types -->

# EC2 Instance Types

- General purpose
- Compute optimized
- Memory optimized
- Storage optimized
- Accelerated computing

---

![bg right](./images/pexels-daria-shevtsova-698172.jpg)

# General purpose EC2 instances

**Platforms:** x86, Mac, Arm
**Use cases:**

- General workloads
- Low-latency interactive applications
- Small and medium databases
- Virtual desktops
- Business-critical apps

---

![bg right](./images/pexels-yoss-traore-2564153.jpg)

# Compute optimized EC2 instances

**Use cases:**

- Batch processing
- Media transcoding
- High-performance web services
- High-performance computing
- Scientific modelling
- Machine learning
- Other compute-intensive workloads

---

![bg right](./images/pexels-anna-urlapova-3035122.jpg)

# Memory optimized EC2 instances

Designed to deliver high performance for workloads that process large data sets in memory.

**Use cases:**

- Open-source databases
- In-memory caches
- Real-time big data analytics

---

![bg right](./images/pexels-jess-buckle-10706720.jpg)

# Storage optimized

Designed for workloads that require high, sequential read and write access to very large data sets on local storage.

**Use cases:**

- Relational and non-relational database
- Search engines
- Data analytic workloads

---

![bg right](./images/pexels-gashif-rheza-3262573.jpg)

# Accelerated computing

GPU-based computing.

**Use cases:**

- Machine learning
- Fluid dynamics
- Computational finance
- Seismic analysis
- Speech recognition
- Autonomous vehicles
- Drug discovery

---

![bg right](./images/pexels-jackson-jorvan-605494.jpg)

# EC2 instance features

- Instances with burastable performance
- Different storage options
- Placement options

---

![bg right](./images/pexels-dapurmelodi-699422.jpg)

# Burstable Performance Instances

Bustable instances provide a baseline level of CPU performance with an ability to burst above baseline.

- Fixed performance - M6, C6, R6
- Burstable - T3

---

![bg right](./images/pexels-eberhard-grossgasteiger-2437289.jpg)

# EC2 Storage Options

EC2 instances are backed by EBS (elastic block storage) volumes.

EBS volume types:

- General purpose SSD
- Provisioned IOPS
- Magnetic

---

![bg right](./images/pexels-pixabay-158179.jpg)

# Why don't we use EC2 everywhere?

- Need to manage infrastructure
- Need to manage hosts and install updates
- Complicated release process of app to avoid downtimes

---

![bg right](./images/pexels-pixabay-161097.jpg)

# How does AWS Elastic Beanstalk help?

- No need to know underlying infrastructure
- Beanstalk is responsible for installing updates and performing releases
- Observability is out of the box
- Available via UI and CLI

---

<!-- header: AWS Elastic Beanstalk -->

![bg right](./images/pexels-achim-bongard-289327.jpg)

# AWS Elastic Beanstalk

Easy-to-use service for deploying and scaling web applications and services developed with Java, .Net, PHP, Python, Ruby, Go and Docker.

You write the code, AWS Elastic Beanstalk will handle the deployment, from capacity provisioning to health monitoring.

---

![bg right](./images/pexels-s-migaj-746386.jpg)

# Beanstalk Concepts

- Application
- Application Version
- Environment
- Environment Tier
- Environment Configuration
- Saved Configuration
- Platform

---

![bg fit right](./images/Web-environment-overview.png)

# Web Environment

Infrastructure + host manager

- Deploying the application
- Collecting events and metrics
- Generating instance-level events
- Monitoring logs for critical events
- Monitoring app server
- Patching the instance
- Log rotation

---

![bg height 75%](./images/worker-environment-overview.png)

---

![bg right](./images/pexels-s-migaj-1402850.jpg)

# Building and Running Apps

- `Buildfile` - for short-running jobs, EB is not monitoring them
- `Procfile` - for long-running jobs, restarted if failed
- Platform hooks - configure the deployment process.

---

![bg right](./images/pexels-pixabay-235725.jpg)

# Running Java apps

- Supported platform - Java SE & Tomcat
- Can run multiple apps - declare in `Procfile` or deploy multiple `war` in Tomcat
- Can add RDS
  - Snapshot
  - Delete
  - Retain

---

![bg right](./images/pexels-pixabay-371662.jpg)

# Deployment Options

- All at once
- Rolling
- Rolling with additional batch
- Immutable
- Traffic splitting

---

![bg right fit](../images/Environment%20Internals.png)

# Web Environment

- Request is received by nginx or Apache HTTPd on port `80`
- Static content can be served by nginx and Apache HTTPd
- Application receives requests on port `5000`, can send messages to SQS to be processed by the worker environment

---

![bg right fit](../images/worker-environment-overview.png)

# Worker Environment

- SQS Daemon reads messages from the SQS Queue and sends them to the HTTP endpoint (nginx -> app)
- Cron daemon sends requests to the HTTP endpoint (nginx -> app)
- Cron and FIFO queues aren't working together

---

<!-- header: Demo time -->

# Demo time

---

![bg height 80%](../images/Bird%20Eye%20Overview.png)

---

<!-- header: Summary -->

![bg right](./images/IMG_6476.jpeg)

# Summary

- AWS Elastic Beanstalk simplifies running apps on EC2 instances
- AWS Elastic Beanstalk manages the infrastructure, responsible for installing updates and patcher, performing releases
- Web and worker envs allow to separate responsibilities and make app responsive

https://github.com/aabarmin/epam-eb-example-2022

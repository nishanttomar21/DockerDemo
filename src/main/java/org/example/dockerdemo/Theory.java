/**
 1. TODO [Runtime environment]:
     It refers to the set of resources, conditions, and systems that support the execution of a program while it's running.
         Key functions:
            - Memory allocation and management
            - Input/output operations
            - Error and exception handling
            - Security features
            - Garbage collection (in languages like Java)

         Examples:
            - Java Runtime Environment (JRE) for Java programs
            - Node.js runtime for JavaScript on the server
            - Python interpreter for Python scripts

 2. TODO [Virtualization]:
     It is a technology that creates virtual versions of computer hardware, operating systems, storage devices, or network resources.
     The process of creating a virtual (rather than physical) version of something
    
     Types of virtualization:
         - Hardware virtualization (e.g., virtual machines)
         - Operating system virtualization (e.g., containers)
         - Network virtualization
         - Storage virtualization
    
     Key components:
         - Hypervisor: Software that manages virtual machines
         - Virtual Machine (VM): An emulation of a computer system

 3. TODO [Containerization]:
     It is a lightweight form of virtualization that packages an application and its dependencies together in a container.
     A method of OS-level virtualization for running applications in isolated environments
    
     Popular tools:
         - Docker: The most widely used containerization platform
         - Kubernetes: For orchestrating and managing containers at scale
    
     Comparison to VMs:
         - Containers are more lightweight and boot faster
         - VMs provide stronger isolation but use more resources
 
 4. TODO [Docker]:
     It is a platform for developing, shipping, and running applications in containers. Docker only runs on Linux OS

     1. Core concept:
        - Containerization: Packaging an application with all its dependencies into a standardized unit (container) for software development and deployment
     2. Key components:
         - Docker Engine: The runtime that runs and manages containers
         - Docker Images: Templates used to create containers
         - Docker Containers: Runnable instances of Docker images
         - Dockerfile: A script of instructions to build a Docker image
         - Docker Hub: A registry service for sharing and finding Docker images
     3. Main benefits:
         - Consistency: "It works on my machine" problem solved
         - Isolation: Applications and resources are isolated from each other
         - Portability: Run the same container across different environments
         - Efficiency: Lightweight compared to traditional virtual machines
         - Scalability: Easy to scale applications horizontally
     4. How it works:
         - Utilizes OS-level virtualization
         - Shares the host system's kernel
         - Uses a layered filesystem for efficient storage and transfer
     5. Use cases:
         - Microservices architecture
         - Continuous Integration/Continuous Deployment (CI/CD) pipelines
         - Development environments
         - Cloud deployments


 5. TODO [Docker on different OS]:
     1. Docker's native environment:
        - Docker was originally designed for Linux and runs natively on Linux systems
     - It uses Linux-specific features like cgroups and namespaces
     2. Docker on non-Linux systems:
        - Docker can run on Windows and macOS as well
        - On these systems, Docker uses a lightweight virtual machine to provide a Linux environment
     3. Windows support:
        - Docker can run Windows containers natively on Windows 10 and Windows Server 2016 or later
        - Windows containers use Windows-specific isolation technologies
     4. Docker Desktop:
        - Available for Windows and macOS
         - Provides an easy-to-use interface for running Docker on these operating systems
         - Uses virtualization to run a Linux VM behind the scenes (on Intel chips)
     5. Docker on ARM-based Macs:
         - Docker Desktop for Apple Silicon runs natively without emulation
     6. Linux subsystem for Windows:
        - Windows Subsystem for Linux 2 (WSL2) allows running Linux containers on Windows more efficiently
     7. Cloud platforms:
        - Docker can run on various cloud platforms, regardless of the underlying OS

    So while Docker's core technology is based on Linux, it has been adapted to work across different operating systems, making it a versatile tool for developers and operations teams on various platforms.

 6. TODO [Steps to Build and Run the Docker Container]:
     1. Build Your Spring Boot Application: Use Maven to package your application into a JAR file.         mvn clean package
     2. Create the Docker Image: Run the following command in your terminal from the project root directory (where your Dockerfile is located).        docker build -t username/image:version .
     3. Run the Docker Container: After building the image, you can run it using:        docker run -d -p 8080:8080 spring-boot-docker-example 

 7. TODO [Docker Hub]: similar to GitHub
     It is a cloud-based repository service provided by Docker for finding, sharing, and managing container images. It is essentially a public registry where developers can upload their Docker images for public or private use. Docker Hub is the default registry used by Docker, which means when you run a docker pull or docker push command without specifying a registry, Docker interacts with Docker Hub.

     Dockerfile ------------> Docker Image ---------------> Docker Container ---------------------------------> Docker Hub (Registry)
     (Configurations)		(Adding all dependencies)	(Running docker image instantiation, can be multiple)

 8. TODO [Docker Compose]:
     It is a powerful tool designed to simplify the management of multi-container Docker applications. It allows you to define and run applications using a single YAML configuration file, making it easier to orchestrate complex setups.

     Key Features of Docker Compose:
         - Multi-Container Management: Docker Compose enables you to define multiple services (containers) in a single file, which can be started or stopped together.
         - YAML Configuration: The configuration is done through a docker-compose.yml file, where you specify services, networks, and volumes.
         - Single Command Operations: You can start all services defined in the YAML file with one command (docker-compose up) and stop them with another (docker-compose down).

     docker-compose.yml file:

 9. TODO [Kubernetes]:
     Kubernetes, often abbreviated as K8s, is an open-source container orchestration platform designed to automate the deployment, scaling, and management of containerized applications. Originally developed by Google, it is now maintained by the Cloud Native Computing Foundation (CNCF) and has become a cornerstone of modern cloud infrastructure.

     Key Features of Kubernetes:
         1. Container Orchestration: Kubernetes manages the lifecycle of containers across a cluster of machines, ensuring that they are deployed, scaled, and maintained efficiently.
         2. Scaling: It allows for horizontal scaling of applications, enabling users to increase or decrease the number of container instances based on demand.
         3. Self-Healing: Kubernetes can automatically restart failed containers, replace and reschedule them when nodes die, and kill containers that do not respond to health checks.
         4. Service Discovery and Load Balancing: It provides built-in service discovery for containers and can load balance traffic across them.
         5. Storage Orchestration: Kubernetes can automatically mount storage systems of various types, whether local or from cloud providers.

 10. TODO [Kubernetes Pods]:
     A pod is a group of one or more containers, with shared storage and network resources

     1. Key characteristics:
         - Atomic unit of scheduling in Kubernetes
         - Always run on a single node
         - Have a unique IP address within the cluster
     2. Components:
         - One or more containers
         - Shared storage volumes
         - Shared network namespace
     3. Lifecycle:
         - Created, scheduled, and managed by Kubernetes
         - Ephemeral - they don't survive scheduling failures, node failures, or other evictions
     4. Use cases:
         - Running a single container application
         - Running tightly coupled containers that need to share resources
     5. Networking:
         - Containers within a pod can communicate via localhost
         - Each pod has its own IP address
     6. Storage:
        - Can define shared volumes accessible by all containers in the pod
     7. Scaling:
        - Kubernetes scales by creating or removing pod instances, not by adding containers to existing pods
     8. Relation to containers:
        - Pods can be thought of as a wrapper around one or more containers

     Generally, it's better to have single-container pods unless there's a compelling reason for multiple containers. This aligns with microservices principles and allows for more granular scaling and management.

 11. TODO [Control Manager and Worker Nodes]:
     1. Control Manager Nodes (Control Plane):
         Control manager nodes, also known as the control plane, are responsible for managing the overall state of the Kubernetes cluster. They make global decisions about the cluster and detect and respond to cluster events.

         Key components of the control plane include:
             - kube-apiserver: The API server that exposes the Kubernetes API.
             - etcd: A distributed key-value store that stores all cluster data (database to store clusters metadata).
             - kube-scheduler: Assigns newly created pods to nodes.
             - kube-controller-manager: Runs controller processes (e.g., node controller, replication controller).
             - cloud-controller-manager: Interacts with the underlying cloud provider's API.

     2. Worker Nodes:
         Worker nodes, also called compute nodes, are the machines that run the actual applications and workloads. They host the Pods, which are the smallest deployable units in Kubernetes.

         Key components of worker nodes include:
             - kubelet: An agent that runs on each node, ensuring containers are running in a Pod.
             - kube-proxy: Maintains network rules on nodes, enabling communication to Pods from network sessions.
             - Container runtime: The software responsible for running containers (e.g., Docker, containerd).

     The main differences are:
         - Function: Control plane nodes manage the cluster, while worker nodes run the workloads.
         - Scalability: Typically, you have fewer control plane nodes (often 3-5 for high availability) and many more worker nodes that can scale based on workload demands.
         - Resource usage: Control plane nodes often require more CPU and memory for cluster management tasks, while worker nodes' resources are primarily used by the deployed applications.

 12. TODO [Deployment configuration vs Service configuration]
     A. Deployment Configuration:
         1. Purpose:
            - Manages the deployment and scaling of a set of Pods
         2. Key features:
             - Defines the desired state for Pods
             - Supports rolling updates and rollbacks
             - Ensures a specified number of Pod replicas are running
         3. Main components:
             - Pod template
             - Replica count
             - Update strategy
         4. Use cases:
             - Deploying stateless applications
             - Managing application versions
             - Scaling applications
         5. Example fields:
             - replicas
             - selector
             - template (contains Pod spec)
             - strategy (for updates)

    B. Service Configuration:
         1. Purpose:
            - Exposes an application running on a set of Pods as a network service
         2. Key features:
             - Provides stable network endpoint for Pods
             - Load balances traffic across Pods
             - Enables service discovery within the cluster
         3. Main components:
             - Selector (to target Pods)
             - Port definitions
             - Type (e.g., ClusterIP, NodePort, LoadBalancer)
         4. Use cases:
             - Exposing applications to other parts of the cluster
             - Load balancing incoming traffic
             - Providing stable DNS names for Pods
         5. Example fields:
             - selector
             - ports
             - type

    Key Differences:
         1. Scope:
             - Deployment: Manages Pod lifecycle and updates
             - Service: Handles networking and exposure of Pods
         2. Stability:
             - Deployment: Pods can be ephemeral
             - Service: Provides stable endpoint even as Pods change
         3. Scaling:
             - Deployment: Directly controls number of Pod replicas
             - Service: Automatically adapts to changes in Pod count
         4. Updates:
             - Deployment: Manages rolling updates of Pods
             - Service: Typically remains stable during Pod updates

 13. TODO [Notes]:
     1. OpenJDK Docker image, it typically includes a minimal base Linux operating system, such as Debian or Alpine and also Java. So, no need to include OS and java differently in Dockerfile, just use import openjdk
     2. JAR file (Java ARchive) is a packaged file format in Java that aggregates multiple files into a single compressed file, similar to a ZIP file. It typically contains Java class files, metadata, and other resources like images or configuration files that are needed for running Java programs.
     3. Alternate of docker is Podman
 */
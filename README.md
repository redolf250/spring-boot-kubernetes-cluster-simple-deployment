# Spring Boot Application Deployed to Minikube Kubernetes Cluster

This is a simple Spring Boot application that has been deployed to a Minikube Kubernetes cluster running on Ubuntu. The application provides several endpoints, each serving GET requests. These endpoints include `/`, `/login`, `/logout`, and `/{name}`.

## Prerequisites

Before you begin, make sure you have the following components installed:

- [Minikube](https://minikube.sigs.k8s.io/docs/start/)
- [Docker](https://docs.docker.com/get-docker/)
- [kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)

## Deployment

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/redolf250/spring-boot-kubernetes-cluster-simple-deployment.git
   ```

2. Change to the project directory:

   ```bash
   cd spring-boot-minikube
   ```

3. Build the Docker image for the Spring Boot application:

   ```bash
   docker build -t spring-boot-app .
   ```

4. Start Minikube:

   ```bash
   minikube start
   ```

5. Deploy the application to the Minikube cluster:

   ```bash
   kubectl apply -f k8s-deployment.yaml
   ```

6. Check the status of the deployment:

   ```bash
   kubectl get pods
   ```

   Wait until the pod is in the `Running` state.

## Accessing Endpoints

You can access the following endpoints from your browser or using tools like `curl`:

- `/` - Home page
- `/login` - Login page
- `/logout` - Logout page
- `/{name}` - Replace `{name}` with your desired name to see a personalized greeting.

Example:
- To access the home page, open your browser and navigate to `http://<minikube-ip>:<node-port>/`.
- To access the login page, navigate to `http://<minikube-ip>:<node-port>/login`.
- To access the logout page, navigate to `http://<minikube-ip>:<node-port>/logout`.
- To access a personalized greeting, replace `{name}` with your desired name, e.g., `http://<minikube-ip>:<node-port>/John`.

## Cleaning Up

To remove the deployed Spring Boot application and the Minikube cluster, run the following commands:

```bash
kubectl delete -f k8s-deployment.yaml
minikube stop
minikube delete
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the Spring Boot and Kubernetes communities for their excellent documentation and resources.

Feel free to contribute to this project or report any issues you encounter. Happy coding!

## WorkFlow with Jenkins
![Workflow](https://github.com/redolf250/spring-boot-kubernetes-cluster-simple-deployment/blob/master/org.png)

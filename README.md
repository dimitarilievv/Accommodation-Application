# DevOps project - Accommodation Application

## Overview

This project is a multi-service accommodation booking application consisting of:

- **Frontend**: React + Vite  
- **Backend**: Java Spring Boot REST API  
- **Database**: PostgreSQL  

The project demonstrates full DevOps practices including containerization, orchestration, and CI/CD pipeline automation.

---

## Project Features

- Public Git repository with full source code
- Dockerized frontend, backend, and database services
- Local orchestration using Docker Compose for easy development
- Kubernetes manifests for Deployment, Service, StatefulSet, ConfigMaps, Secrets, and Ingress
- Dedicated Kubernetes namespace for isolation (`accommodation-app`)
- CI/CD pipeline using GitHub Actions:
  - Automatically builds and pushes Docker images on git push
  - Deploys updated services to Render.com cloud platform
- Environment variables and secrets securely managed via Kubernetes ConfigMaps and Secrets
- CORS configured to allow frontend-backend communication in different environments
- Application accessible locally via Kubernetes Ingress and remotely via Render URLs

---

Author: Dimitar Iliev

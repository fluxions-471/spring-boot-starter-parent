pipeline {
    agent{
        label "jenkins-agent"
    }
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }
    environment {
        APP_NAME = "spring-boot-starter-parent"
        RELEASE = "1.0.0"
        DOCKER_USER = "priajiabror"
        DOCKER_PASS = credentials('dockerhub')
        DOCKER_PASS2 = 'dockerlogin'
        IMAGE_NAME = "${DOCKER_USER}/${APP_NAME}"
        IMAGE_TAGE = "${RELEASE}-${BUILD_NUMBER}"
    }
    stages {
        stage("Build And Push Docker Image"){
            steps {
                script {
                    def modules = ["api-gateway", "inventory-service", "notification-service", "order-service", "product-service", "frontend"]
                    def commitMessage = sh(script: "git log --pretty=format:\"%h %s\" | head -n 1", returnStdout: true).trim()
                    for (module in modules) {
                        if (commitMessage.contains(module)) {
                            echo "Changes detected in module: ${module}"
                            dir("${module}") {
                                docker.withRegistry('', DOCKER_PASS2) {
                                    if(module=="frontend"){
                                        docker_image = docker.build "${DOCKER_USER}/${module}"
                                        docker_image.push("${IMAGE_TAG}")
                                    } else {
                                        sh 'mvn spring-boot:build-image -DskipTests -DdockerPassword=${DOCKER_PASS}'
                                    }
                                }
                            }
                        } else {
                            echo "No Changes in module: ${module}"
                        }
                    }
                }
            }
        }
    }
}
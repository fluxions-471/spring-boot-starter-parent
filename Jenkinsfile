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
        RELEASE = "0.0.1"
        DOCKER_USER = "priajiabror"
        DOCKER_PASS = credentials('dockerhub')
        IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
        IMAGE_TAGE = "${RELEASE}-${BUILD_NUMBER}"
    }
    stages {
        stage("Test Application"){
            steps {
                sh "mvn test"
            }
        }
        stage("Build And Push Docker Image"){
            steps {
                sh "mvn spring-boot:build-image -DskipTests -DdockerPassword=${DOCKER_PASS}"
            }
        }
    }
}
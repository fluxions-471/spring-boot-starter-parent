pipeline {
    agent{
        label "jenkins-agent"
    }
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }
    stages {
        stage("Cleanup Ws"){
            steps {
                cleanupWs()
            }
        }
        stage("Build Application"){
            steps {
                sh "mvn package -Dmaven.test.skip"
            }
        }
    }
}
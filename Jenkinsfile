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
                cleanWs()
            }
        }
        stage("Build Application"){
            steps {
                sh "ls -al"
            }
        }
    }
}
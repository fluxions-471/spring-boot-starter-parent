pipeline {
    agent{
        label "jenkins-agent"
    }
    tools {
        jdk 'Java17'
        maven 'Maven3'
    }
    stages {
        stage("Build Application"){
            steps {
                sh "mvn package -Dmaven.test.skip"
            }
        }
    }
}
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean'
                // bat 'mvn install'
            }
        }
        stage('package'){
            steps{
            bat 'mvn package'
            }
        }
        stage('test'){
            steps {
                bat 'mvn test'
            }
        }
        stage('static code analysis'){
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'sonar-api-key') {
                    bat 'mvn clean package sonar:sonar'
                }
                }
            }
        }
        stage('Quality Gate status'){
            steps{
                script{
                    timeout(time:1,unit:'HOURS'){
                        waitForQualityGate abortPipeline: false, credentialsId: 'sonar-api-key'
                    }
                }
            }
        }
        stage('deploy'){
            steps{
                echo 'deploy'
            }
        }
    }
}

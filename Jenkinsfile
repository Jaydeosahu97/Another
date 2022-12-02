pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('test'){
            steps {
                bat 'mvn test'
            }
        }
        stage('package'){
            steps{
            bat 'mvn package'
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
                        waitForQualityGate abortPipeline: false, credentialsId: 'sonar-api-key'
            }
        }
        stage('deploy'){
            steps{
                echo 'deploy'
            }
        }
    }
}
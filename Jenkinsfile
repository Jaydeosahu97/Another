pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean'
                bat 'mvn install'
            }
        }
        stage('package'){
            steps{
            bat 'mvn package'
            }
        }
        stage('mvn test'){
            steps {
                bat 'mvn test'
            }
        }
        stage('deploy'){
            steps{
                echo 'deploy'
            }
        }
    }
}
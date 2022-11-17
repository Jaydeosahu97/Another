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
        stage('deploy'){
            steps{
                bat 'java -jar loginmicroservice-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}

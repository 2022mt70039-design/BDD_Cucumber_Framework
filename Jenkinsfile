pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

        stage('Checkout Source') {
            steps {
                checkout scm
            }
        }

        stage('Clean Project') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Compile Project') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Execute Automation Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Test Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**/*', fingerprint: true
            }
        }

    }

    post {

        success {
            echo 'Automation Test Execution Successful'
        }

        failure {
            echo 'Automation Test Execution Failed'
        }

        always {
            echo 'Pipeline Finished'
        }

    }

}
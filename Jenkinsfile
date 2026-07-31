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
    }

    post {

        always {

            archiveArtifacts artifacts: 'target/**/*', fingerprint: true

            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/extent-report',
                reportFiles: 'AutomationExecutionReport.html',
                reportName: 'Automation Execution Dashboard'
            ])

            echo 'Pipeline Finished'
        }

        success {
            echo 'Automation Test Execution Successful'
        }

        failure {
            echo 'Automation Test Execution Failed'
        }
    }
}
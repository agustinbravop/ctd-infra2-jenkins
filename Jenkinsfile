pipeline {
    agent any
    
    tools {
        maven "maven-nodo-principal"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                dir ('proyecto-maven') {
                    sh 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                dir ('proyecto-maven') {
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    post {
        success {
            dir ('proyecto-maven') {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}

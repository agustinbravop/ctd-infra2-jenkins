pipeline {
    agent any
    
    tools {
        maven "maven-nodo-principal"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                dir (‘maven-adderapp’) {
                    sh 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
    post {
        success {
            dir (‘maven-adderapp’) {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}

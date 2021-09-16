pipeline {
    agent any
    
    tools {
        maven "maven-nodo-principal"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                dir ('maven-adderapp') {
                    sh 'mvn -B -DskipTests clean package'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                dir ('maven-adderapp') {
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
        always {
            dir('maven-adderapp') {
                junit 'target/surefire-reports/*.xml'
            }
        }
        success {
            dir ('maven-adderapp') {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}

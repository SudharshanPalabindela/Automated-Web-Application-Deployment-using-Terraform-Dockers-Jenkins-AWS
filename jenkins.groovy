pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'docker build -t my-web-app-image .'
            }
        }
        
        stage('Push to Registry') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DOCKER_REGISTRY_CREDS', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                    sh 'docker tag my-web-app-image:latest your-docker-repository/my-web-app:latest'
                    sh 'docker push your-docker-repository/my-web-app:latest'
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                withAWS(credentials: 'AWS_CREDS', region: 'us-east-1') {
                    sh 'aws ecs update-service --cluster your-ecs-cluster --service your-ecs-service --force-new-deployment'
                }
            }
        }
    }

    post {
        failure {
            echo 'Pipeline failed, notifying team...'
        }
    }
}

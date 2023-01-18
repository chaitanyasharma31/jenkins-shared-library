#!/usr/bin/env groovy

import com.example.Docker

def call() {
                    echo "building the docker image..."
                   withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t cshrma/demo-app:jma1.1 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push cshrma/demo-app:jma1.1'
    }
} 

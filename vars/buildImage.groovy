#!/usr/bin/env groovy

import com.example.Docker

def call(String imageName) {
    return new docker(this).buildDockerImage(imageName)
                     echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                         sh "docker build -t $imageName ."
                      sh "echo $PASS | docker login -u $USER --password-stdin"
                         sh "docker push $imageName"
    
} 

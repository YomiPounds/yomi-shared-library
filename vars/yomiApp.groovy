def call(String repoUrl){
pipeline{
    agent any 
    tools{
        maven 'maven'
    }
    stages{
        stage('tools initialisation'){
            steps{
                sh 'mvm --version'
                sh 'java -version'
            }
        }
        stage('checkout code'){
            steps{
                git branch: 'main',
                       url: "${repoUrl}"
            }
        }
        stage('maven-test'){
            steps{
                sh 'mvn -v'
            }
        }
    }
}
}

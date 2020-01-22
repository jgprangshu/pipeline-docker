pipeline {
   
agent any
    environment {
        def values = readProperties file: 'extra.properties'
        ip = "${values.IP}"
    }
    tools{
        maven 'Maven'
    }

    stages {
        stage('Get ENV Values'){
            steps{
                echo "VALUES ARE ${ip}"
            }
        }
       stage('Testing'){
            steps{
                 sh 'mvn clean test'
            }
        }
       stage('Creating JAR'){
           steps{
               sh 'mvn clean install'
           }
       }
    }
}

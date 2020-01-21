pipeline {
   
agent any
    environment {
        def values = readProperties file: 'extra.properties'
        ip = "${values.IP}"
    }

    stages {
        stage('Get env values'){
            steps{
                echo "VALUES ARE ${ip}"
            }
        }
    }
}

pipeline {
    agent any
    environment{
        jfrogVersion= "$JFROG_VERSION"
            def MY_KEY = credentials("${ENVIRONMENT == "dev" ? "sshid" : "nopay"}")
	        username ="${MY_KEY_USR}"
	        password = "${MY_KEY_PSW}"
    }
    
    stages {
        stage('Welcome') {
            steps {
                script{
                    echo 'Hello World'
                    echo "${env.jfrogVersion}"
                    echo "$MY_KEY"
                    echo "$username"
                    echo "$password"
                    echo "$ACTIVE_CHOICE[1]"
                }
            }
        }
        stage('Pushing to Artifactory') {
            when {
                expression { params.CHOICE != 'BUILD FROM ARTIFACTORY' }
            }
            steps {
                echo 'Pushing'
                echo 'Pushed Successfully'
            }
            
        }
        
        stage('Deploy the new image'){
             when {
                expression { params.CHOICE != 'BUILD FROM ARTIFACTORY' }
            }
            steps{
                echo 'Deploying the latest image'
            }
        }
        
         stage('Deploy the exsisting image'){
             when {
                expression { params.CHOICE ==  'BUILD FROM ARTIFACTORY' }
            }
            steps{
                script{
                    echo "${env.jfrogVersion}"
                    echo "Deploying the jfrog '${env.jfrogVersion}' version image" 
                }
            }
        }
        
        stage('Ansible Init') {
            steps {
                script {
                   def tfHome = tool name: 'Ansible-1.0'
                   sh 'ansible --version'
                    ansiblePlaybook( 
                        playbook: 'playbook.yml',
                        inventory: 'inventory.ini', 
                        credentialsId: 'sshid',
                        ) 
                }
            }
        }
        
        stage('End'){
            steps{
               echo 'Pipeline Exit' 
            }
            
        }
    }
}
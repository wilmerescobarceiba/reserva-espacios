pipeline {
  agent {
    label 'Slave_Induccion'
  }
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	    disableConcurrentBuilds()
  }

  environment {
        PROJECT_PATH_BACK = './reserva-espacios/'
	}

  
  tools {
    jdk 'JDK8_Centos'
    gradle 'Gradle5.0_Centos'
  }
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
            $class: 'GitSCM', 
            branches: [[name: '*/master']], 
            doGenerateSubmoduleConfigurations: false, 
            extensions: [], 
            gitTool: 'Default', 
            submoduleCfg: [], 
            userRemoteConfigs: [[
                credentialsId: '99ea0565-e329-483d-a070-c7f37cb9121e', 
                url:'https://github.com/wilmerescobarceiba/reserva-espacios.git'
            ]]
        ])

      }
    }
    
    stage('Compile & Unit Tests') {
      steps{
        dir("${PROJECT_PATH_BACK}")
        {
          sh 'chmod +x gradlew'
          sh './gradlew --b ./build.gradle test'
        }        
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
            sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=reserva-espacios/sonar-project.properties"
        }
       }
    }

    stage('Build') {
      steps {
        dir("${PROJECT_PATH_BACK}")
        {
          sh 'gradle build -x test'
        }
      }
    }  

  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      mail (to: 'wilmer.escobar@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")

    }
    failure {
      failure {
      echo 'This will run only if failed'
      mail (to: 'wilmer.escobar@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")

      }

    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}
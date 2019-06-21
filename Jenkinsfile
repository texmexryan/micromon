void theProcess(folder,image){
  def app
  script {
    stage("permissions") {
      dir(folder){
        sh "chmod 711 ./mvnw"
      }
    }
    stage("install"){
      dir(folder){
        sh "./mvnw -T 1C install -DskipTests"
      }
    }
    stage("build"){
      dir(folder){
        app = docker.build("texmexryan/"+image)
      }
    }
    stage("deploy"){
      dir(folder){
        docker.withRegistry("https://registry.hub.docker.com","docker-hub-credentials") {
          app.push("${env.BUILD_NUMBER}")
          app.push("latest")
        }
      }
    }
  }
}
pipeline {
  agent any 
  stages {
    stage("automation") {
      parallel {
        stage("AdminServer") {
          steps {
            theProcess("AdminServer","admin-server")
          }
        }
        stage("DiscoveryServer") {
          steps {
            theProcess("DiscoveryServer","discovery-server")
          }
        }
        stage("PokemonService") {
          steps {
            theProcess("PokemonService","pokemon-service")
          }
        }
        stage("TrainerService") {
          steps {
            theProcess("TrainerService","trainer-service")
          }
        }
      }
    }
  }  
}
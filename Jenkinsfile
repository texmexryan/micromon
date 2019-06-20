node {
  def app

  stage("Clone repository") {
    /* clone the repository */
    checkout scm    
  }

  stage("Permissions") {
    /* change directory */
    dir("AdminServer"){
      /* set maven wrapper permissions */
      sh "chmod 711 ./mvnw"
    }
  }

  stage("Test") {
    dir("AdminServer"){
      /* runt tests */
      sh "./mvnw test"
    }
  }

  stage("Build Project") {
    dir("AdminServer"){
      /* build the project */ 
      sh "./mvnw clean install"
    }
  }

  stage("Build Image") {
    dir("AdminServer"){
      app = docker.build("texmexryan/admin-server")
    }
  }

  stage("Push Image") {
/* push the image to docker hub */
dir("AdminServer"){
docker.withRegistry("http://registry.hub.docker.com", "docker-hub-credentials"){
app.push("${env.BUILD_NUMBER}")
app.push("latest")
}
}
}

}
node {

    def app

    stage("Clone Repository"){
        /* Clone the repository */
        checkout scm

    }

    stage("Permissions"){

        /* change directory   */
        dir("AdminServer"){

        sh "cd AdminServer"
        }
        /* set maven wrapper permissions */
        // sh "cd AdminServer && chmod 711 ./mvnw"

    }
    stage("Test"){
        /* run tests */
        sh "./mvnw test"

    }
    stage("Build project"){
        /* build the project */
        sh "./mvnw clean install"
    }
    stage("Build image"){
        /*   */
    app = docker.build("texmexryan/admin-server")
    }
    stage("Push image"){
        /* push the image to dockerhub */
        sh "echo TODO"

    }

}
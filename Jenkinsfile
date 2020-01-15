node {


    stage('Git pull'){
    git 'https://github.com/uasm1le/messenger.git'
    echo 'Git update success!'
    }

    stage('Maven Package'){

      withMaven(){
        if(currentBuild.changeSets.size() > 0) {
            sh "mvn clean package"
        }
    }}
    stage('[Docker] Build Image'){
           IMAGE = readMavenPom().getArtifactId()
           NAME = readMavenPom().getName()
           VERSION = readMavenPom().getVersion()

            sh "docker build -t ${IMAGE}:${VERSION} ."
    }

   stage('[Docker] Remove old container '){
       try{
        sh "docker rm -f ${NAME}"
       }catch(err)
       {echo "error: ${err}"}
    finally{
       currentBuild.result = 'SUCCESS'
    }

    }


    stage('[Docker] Run container'){

            echo "IMAGE: ${IMAGE}"
            echo "VERSION: ${VERSION}"
            echo "NAME: ${NAME}"

        sh "docker run --rm --name ${NAME}  -d -p 6060:8080 ${IMAGE}:${VERSION} "

    }


}


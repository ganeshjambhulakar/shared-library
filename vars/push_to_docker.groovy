def call(String credentialsId ,String image ){
 echo 'Push To Docker Hub'
                withCredentials([
                    usernamePassword(
                        'credentialsId':"${credentialsId}",
                        passwordVariable:"password",
                        usernameVariable:"username"
                        
                        )
                    ]){
                        sh "docker login -u ${env.username} -p ${env.password}" 
                        sh "docker image tag ${image} ${env.username}/${image} "
                        sh "docker push ${env.username}/${image} "
                    }
}

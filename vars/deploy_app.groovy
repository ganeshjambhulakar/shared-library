def call(String image,String port){
   echo "Deploying code"
   sh "docker run -d -t ${port}:${port} ${image}"
    echo "Code Deploy Successfull"
}

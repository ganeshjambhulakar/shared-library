def call(String image){
      echo "Building Docker image: ${image}"
      sh "docker build -t ${image} ."
}

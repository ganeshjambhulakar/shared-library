def call(String image, String port) {
    echo "Deploying Docker container from image: ${image} on port: ${port}"
    sh "docker run -d -p ${port}:${port} ${image}"

}

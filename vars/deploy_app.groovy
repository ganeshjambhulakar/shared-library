def call(String image, String port) {
    echo "Deploying Docker container from image: ${image} on port: ${port}"

    try {
        // Stop and remove any existing container with the same name (if any)
        sh "docker rm -f ${image} || true"
        
        // Run the Docker container in detached mode with the specified port mapping
        def runOutput = sh(script: "docker run -d -p ${port}:${port} --name ${image} ${image}", returnStdout: true).trim()

        // Output container run details for debugging
        echo "Docker run output: ${runOutput}"

        // Capture logs of the container to ensure it started correctly
        def containerLogs = sh(script: "docker logs ${image}", returnStdout: true).trim()
        echo "Container logs: ${containerLogs}"

        // Check if the container is running
        def containerStatus = sh(script: "docker ps -q --filter 'name=${image}'", returnStatus: true)
        if (containerStatus != 0) {
            error("Container did not start correctly. Check logs for more details.")
        }

        echo "Code deployed successfully on port ${port}"
    } catch (Exception e) {
        // Catch any error and print the error message
        echo "Deployment failed: ${e.getMessage()}"
        error("Docker deployment failed.")
    }
}

def call(String url, String branch) {
    echo "Code cloning started"
    git url: "${url}", branch: "${branch}"
    echo "Code cloning successful"
}

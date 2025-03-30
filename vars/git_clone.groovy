def call(String url,string branch){
  echo "code cloning strted "
  git url: url, branch: branch
  echo "Code cloning successfull"
}

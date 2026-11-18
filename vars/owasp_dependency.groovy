// def call(){
//   dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
//   dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
// }

def call(){
    withCredentials([string(credentialsId: 'nvd-api-key', variable: 'NVD_API_KEY')]) {
        dependencyCheck additionalArguments: "--scan ./ --nvdApiKey ${env.NVD_API_KEY} --format XML --format HTML", odcInstallation: 'OWASP'
    }
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}

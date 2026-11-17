// def call(){
//   dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
//   dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
// }

// This is modified strictly for our eco-footprintX project, for other scnarios consider the above commented code.
// def call() {
//         dependencyCheck additionalArguments: '--scan ./backend --scan ./frontend', odcInstallation: 'OWASP'
//         dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
// }

def call(){
    // Install dependencies across root, backend, and frontend
    sh 'npm run installer'
    
    // Run scan on root and explicitly output the XML file
    dependencyCheck additionalArguments: '--scan ./ --format XML --format HTML --out .', odcInstallation: 'OWASP'
    
    // Publish the generated report
    dependencyCheckPublisher pattern: 'dependency-check-report.xml'
}

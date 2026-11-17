// def call(){
//   dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
//   dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
// }

// This is modified strictly for our eco-footprintX project, for other scnarios consider the above commented code.
def call() {
        dependencyCheck additionalArguments: '--scan ./backend --scan ./frontend', odcInstallation: 'OWASP'
        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}

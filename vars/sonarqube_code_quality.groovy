// def call(){
//   timeout(time: 1, unit: "MINUTES"){
//       waitForQualityGate abortPipeline: false
//   }
// }

// Below code modified only for eco footprintX project
def call(){
    timeout(time: 5, unit: 'MINUTES') {
        waitForQualityGate abortPipeline: true
    }
}

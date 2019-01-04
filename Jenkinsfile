pipeline {
    agent any
    tools {
        jdk 'Oracle JDK 8u181'
        maven 'Maven 3.5.4'
    }
    // From https://medium.com/@MichaKutz/create-a-declarative-pipeline-jenkinsfile-for-maven-releasing-1d43c896880c
    parameters {
        booleanParam(name: "RELEASE",
                description: "Build a release from current commit.",
                defaultValue: false)
    }
    stages {
        stage('Build') {
            steps {
                script {
                    sh "mvn clean compile"
                }
            }
        }
        stage('Publish snapshot') {
            when {
                branch 'develop'
            }
            steps {
                script {
                    sh "mvn deploy"
                }
            }
        }
        stage('Publish release') {
            when {
                allOf {
                    branch 'develop'
                    expression { params.RELEASE }
                }
            }
            steps {
                script {
                    sh "mvn -B jgitflow:release-start jgitflow:release-finish"
                }
            }
        }
    }
    post {
        always {
            /* clean up our workspace */
            deleteDir()
        }
        success {
            slackSend(color: '#30A452', message: "SUCCESS: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>")
        }
        unstable {
            slackSend(color: '#DD9F3D', message: "UNSTABLE: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>")
        }
        failure {
            slackSend(color: '#D41519', message: "FAILED: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>")
        }
    }
}

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
                branch 'pureport/develop'
            }
            steps {
                withCredentials([usernamePassword(credentialsId: 'nexus_credentials', usernameVariable: 'SONATYPE_USERNAME', passwordVariable: 'SONATYPE_PASSWORD')]) {
                    script {
                        sh "mvn --settings $WORKSPACE/distribution/settings.xml deploy"
                    }
                }
            }
        }
        stage('Publish release') {
            when {
                allOf {
                    branch 'pureport/develop'
                    expression { params.RELEASE }
                }
            }
            steps {
                withCredentials([
                        sshUserPrivateKey(credentialsId: '0bb1d30a-b150-4fc8-aee5-5c76bc3ad64b', keyFileVariable: 'SSH_KEY'),
                        usernamePassword(credentialsId: 'nexus_credentials', usernameVariable: 'SONATYPE_USERNAME', passwordVariable: 'SONATYPE_PASSWORD')
                ]){
                    sh "ssh-agent bash -c 'ssh-add ${SSH_KEY}; mvn -B gitflow:release-start gitflow:release-finish -DpostReleaseGoals=deploy -DargLine=\"--settings $WORKSPACE/distribution/settings.xml\"'"
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

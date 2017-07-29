pipeline {
    agent any
    options {
        gitLabConnection('gitlab')
        gitlabCommitStatus(name: 'jenkins')
    }
    triggers {
        gitlab(triggerOnPush: true, triggerOnMergeRequest: true, branchFilterType: 'All')
    }
    tools {
        maven 'Maven'
    }
    stages {
        stage('Test') {
            steps {
                configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn -s $MAVEN_SETTINGS test'
                }
            }
        }
        stage('Deploy') {
            steps {
                configFileProvider([configFile(fileId: 'maven-settings', variable: 'MAVEN_SETTINGS')]) {
                    sh 'mvn -s $MAVEN_SETTINGS deploy -Dmaven.test.skip=true'
                }
            }
        }
    }
}

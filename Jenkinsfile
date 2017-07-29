pipeline {
    agent any
    options {
        gitLabConnection('gitlab')
        gitlabCommitStatus(name: 'jenkins')
    }
    triggers {
        gitlab(triggerOnPush: true, triggerOnMergeRequest: true, branchFilterType: 'All')
    }
    stages {
        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
    }
}

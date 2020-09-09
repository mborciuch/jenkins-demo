pipelineJob('pipelineJob') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}
pipelineJob('theme-park-job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/misiek001/SpringBootJenkins.git'
                    }
                    branch 'mymaster'
                }
            }
        }
    }
}

pipelineJob('theme-park-job-docker') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/misiek001/spring-boot-api-example.git'
                    }
                    branch 'mymaster'
                    scriptPath('Jenkinsfile-docker')
                }
            }
        }
    }
}
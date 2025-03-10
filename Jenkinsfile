pipeline {
    agent any
    environment {
        MAVEN_HOME = 'C:\\Program Files\\maven\\apache-maven-3.9.9'  // Update this path for Windows Maven installation on personal laptop
        //MAVEN_HOME = 'E:\\apache-maven-3.8.8'  // Update this path for Windows Maven installation on Office laptop
        PATH = "${MAVEN_HOME}\\bin;${env.PATH}"
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git branch: 'main', url: 'https://github.com/manojpapneja/CICD_Training.git'
        
            }
        }
        stage('Build') {
            steps {
                // Use Maven to package the project
                bat 'mvn clean package'
            }
        }
              stage('Deploy') {
    steps {
        script {
            // Set Tomcat path - Update if Tomcat is installed in a different location
             def TOMCAT_HOME = 'C:\\Program Files\\apache-tomcat-9.0.98' // Update this path for Windows Maven installation on personal laptop
            // def TOMCAT_HOME = 'C:\\Projects\\Smart_Recorder\\apache-tomcat-10.1.16'  // Update this path for Windows Maven installation on Office laptop
            // Ensure the target WAR file exists before copying
            bat """
                if exist target\\UserAuthWeb-1.0-SNAPSHOT.war (
                    echo Deploying WAR file...
                    xcopy /Y target\\UserAuthWeb-1.0-SNAPSHOT.war \"${TOMCAT_HOME}\\webapps\"
                ) else (
                    echo WAR file not found! Build may have failed.
                    exit /b 1
                )
            """

            // Set CATALINA_HOME and Start Tomcat
            bat """
                set CATALINA_HOME=${TOMCAT_HOME}
                echo CATALINA_HOME set to %CATALINA_HOME%
                "%CATALINA_HOME%\\bin\\startup.bat"
            """
        }
    }
}
        
       
        stage('Send Email') {
            steps {
                script {
                    // Email notification
                    emailext(
                        subject: 'Deployment Report',
                        body: '''
                            Hi Team, Please find the attached emailable report for details of the deployment.
                            Regards,
                            Jenkins
                        ''',
                        attachLog: true,
                        attachmentsPattern: '**\\target\\surefire-reports\\emailable-report.html',
                        to: 'manojpapneja@gmail.com',
                        from: 'jenkinsreport@gmail.com'
                    )
                }
            }
        }
    }
    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.1"

project {

    vcsRoot(VcsRootWithPasswordWithoutCustomEnc)

    buildType(TestConfigDefaultEncription)
}

object TestConfigDefaultEncription : BuildType({
    name = "test config default encription"

    vcs {
        root(VcsRootWithPasswordWithoutCustomEnc)
    }
})

object VcsRootWithPasswordWithoutCustomEnc : GitVcsRoot({
    name = "vcs root with password without custom enc"
    url = "https://github.com/achubatova/composite"
    authMethod = password {
        userName = "user_nocustom"
        password = "credentialsJSON:d1b36129-1a23-417e-9f45-b64954422b07"
    }
})

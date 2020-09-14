import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.dockerECRRegistry
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.dockerRegistry
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

    vcsRoot(Vcsroottemplate)
    vcsRoot(Hdhdhdgdghdgh)
    vcsRoot(VcsRootWithPasswordWithoutCustomEnc)

    buildType(TestConfigDefaultEncription)
    buildType(ConfigFromTemplate)

    template(ConfigTeamplate)

    features {
        dockerRegistry {
            id = "PROJECT_EXT_2"
            name = "Docker Registry"
            url = "https://docker.io"
            userName = "asd"
            password = "credentialsJSON:aa66e271-6324-4c92-ac1c-23391bab0ecb"
        }
        dockerECRRegistry {
            id = "PROJECT_EXT_3"
            displayName = "Amazon ECR connection"
            registryId = "913206223978"
            credentialsProvider = accessKey {
                accessKeyId = "AKIA5JH2VERVHVMPJQJI"
                secretAccessKey = "credentialsJSON:e6886fb2-01ab-4459-b001-d5c6cc9655b3"
            }
            regionCode = "eu-central-1"
            credentialsType = accessKeys()
        }
    }
}

object ConfigFromTemplate : BuildType({
    templates(ConfigTeamplate)
    name = "configFromTemplate"

    params {
        password("fg", "credentialsJSON:c3c7b7c7-4b19-4878-8409-1d7b7c218093")
        password("parNewEnc", "credentialsJSON:fa4d8cf5-2afb-4a23-b8de-5e40df9670b1")
    }

    vcs {
        root(Hdhdhdgdghdgh)
    }
})

object TestConfigDefaultEncription : BuildType({
    name = "test config default encription"

    vcs {
        root(VcsRootWithPasswordWithoutCustomEnc)
    }
})

object ConfigTeamplate : Template({
    name = "configTeamplate"

    vcs {
        root(Vcsroottemplate)
    }
})

object Hdhdhdgdghdgh : GitVcsRoot({
    name = "hdhdhdgdghdgh"
    url = "afdadf"
    authMethod = password {
        userName = "fgdfg"
        password = "credentialsJSON:2e94afa4-daf7-44e2-9997-9dd00c42bca0"
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

object Vcsroottemplate : GitVcsRoot({
    name = "vcsroottemplate"
    url = "https://sdfkjlskdfj"
    authMethod = password {
        userName = "blablaba"
        password = "credentialsJSON:94dc7066-2533-4dff-bdac-d73984821d04"
    }
})

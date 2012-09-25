# Backlog4j

backlog4j is a Java library for Backlog API.

## How to install

### maven

    mvn install -DskipTests

### gradle

    gradle install

## How to use

### Part1. Set up configuration

    BacklogConfigure configure =
        new BacklogConfigureBuilder()
        .setSpaceId("yuorSpaceId")
        .setUsername("yourUsername")
        .setPassword("yourPassword")
        .buildBacklogConfigure();

### Part2. Create client

    BacklogClient backlogClient = new BacklogClientFactory(configure).newBacklogClient();

### Conclusion

Get the API object from the BacklogClient and Call "execute" method.
Enjoy Backlog API!

    GetProject getProject = backlogClient.getProject().setProjectKey("PROJECT-KEY");

    Project project = getProject.execute();

## Documents

* javadoc
    * http://hakurai.github.com/backlog4j/javadoc/

## License

MIT License

* http://www.opensource.org/licenses/mit-license.php
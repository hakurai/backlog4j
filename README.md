# Backlog4j

backlog4j is a Java library for Backlog API.

## How to install

### maven

    <dependency>
      <groupId>org.backlog4j</groupId>
      <artifactId>backlog4j</artifactId>
      <version>1.0.2</version>
    </dependency>

### gradle

    'org.backlog4j:backlog4j:1.0.2'

## How to use

    BacklogClient backlogClient = BacklogClientFactory.createBacklogClient("yuorSpaceId", "yourUsername", "yourPassword");

or

    BacklogConfigure configure =
        new BacklogConfigureBuilder()
        .setSpaceId("yuorSpaceId")
        .setUsername("yourUsername")
        .setPassword("yourPassword")
        .buildBacklogConfigure();

    BacklogClient backlogClient = new BacklogClientFactory(configure).newBacklogClient();

### Conclusion

Get the API object from the BacklogClient and Call "execute" method.
Enjoy Backlog API!

    GetProject getProject = backlogClient.getProject();
    getProject.setProjectKey("PROJECT-KEY");

    Project project = getProject.execute();

## Documents

* javadoc
    * http://hakurai.github.com/backlog4j/javadoc/

## License

MIT License

* http://www.opensource.org/licenses/mit-license.php

# Getting Started

### How to build and run the unit tests

The app has two test files (TransformerBattleUtilTest.java and TransformerServiceTest.java)
containing several unit tests, to run the test open de project with any IDE
that supports Gradle, do right click on the file, and then click "run {fileName}"

### How to run the app

1- Check out /clone the GitHub project from: https://github.com/deam31/transformer

2- Open a command line console, go to the cloned directory, run: gradle clean build (we're assuming Gradle is installed in your computer)
Note: You could also open the project with any IDE that supports Gradle, and run "clean build" in the IDE user interface.

3- Go to relative directory: transformer\build\libs\

3- Run: java -jar transformer-0.0.1-SNAPSHOT.jar

4- If transformer-0.0.1-SNAPSHOT.jar is not present, run command "gradle clean build"
(we are assuming gradle is installed in the computer) and do step 2.

5- Once the console shows "Tomcat started on port(s): 8000", open a Web browser and access:
http://localhost:8000/swagger-ui/index.html?docExpansion=list#/

5- At this point you should see the UI to interact with the app "Backend Developer Technical Test"


### How to list all transformers

1- The app in memory database has a set of transformers by default. To see those click in "getAll",
then click the button "Try it out", then in the blue button "Execute".
http://localhost:8000/swagger-ui/index.html?docExpansion=list#/transformer-resource/getAllUsingGET

2- Once that, below the text "Response body" you should see the list transformers
available in the in memory database.

Note: this are the example (JSON) payloads required by the assessment.

### How to create a transformer

1- Click in "Create transformer" then click the button "Try it out".
http://localhost:8000/swagger-ui/index.html?docExpansion=list#/transformer-resource/createTransformerUsingPOST

2- Fill the json object with the considered values, then click "Execute".

3- You can use the "getAll" endpoint to validate is successfully created.

### How to update a transformer

1- Click in "Update transformer" then click the button "Try it out".

2- Fill the json object with the considered values, specially the attribute "id",
which should match the transformer to be updated. Then click "Execute".

3- You can use the "getAll" endpoint to validate is successfully updated.

### How to delete a transformer

1- Click in "Delete transformer" then click the button "Try it out".

2- Set the field "id" with the id of the transformer to be deleted.

3- You can use the "getAll" endpoint to validate is successfully deleted.

### Given a list of Transformer IDs, determine the winning team

1- Click in "battle" then click the button "Try it out".

2- Click the "Add item" button to add the id of the transformer to
include in the battle. Repeat this step for every transformer id
to be part of the battle.

3- The result will be shown in the box "Response body" in "human-readable" format.
Note: Some text will appear regardless is not necessary.
e.g. The text "Survivors from the losing team" will be seen even there are no survivors.
Please focus on the dynamic values shown, not in the fixed text.


### Assumptions

"skill" and "overall rating" are different attributes. The skill value can be set
by the user. The overall rating is a calculated value: (Strength +
Intelligence + Speed + Endurance + Firepower).

HackerNews Application

 To run the application:
	1. Make sure you have JRE installed.
	2. Open a cmd console.
	3. Go to the target folder in the code directory
	4. Run this command: java HackerNews --posts n
  
 Application input arguments:
	1. posts; how many posts to print. A positive integer <= 100
			
 Libraries used:
	1. springframework for dependency injection
	2. gson for converting from json to POJO
	3. junit for unit testing
	4. mockito for mocking dependencies
	5. jankroken for parsing command line arguments